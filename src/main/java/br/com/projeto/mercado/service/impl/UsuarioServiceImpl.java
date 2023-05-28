package br.com.projeto.mercado.service.impl;


import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.filter.UsuarioFiltro;
import br.com.projeto.mercado.models.Grupo;
import br.com.projeto.mercado.models.Usuario;
import br.com.projeto.mercado.models.enums.TipoGrupo;
import br.com.projeto.mercado.models.exceptions.ConflictException;
import br.com.projeto.mercado.models.exceptions.EntityInUseException;
import br.com.projeto.mercado.models.exceptions.EntityNotFoundException;
import br.com.projeto.mercado.models.mapper.UsuarioMapper;
import br.com.projeto.mercado.repositories.UsuarioRepository;
import br.com.projeto.mercado.repositories.specs.UsuarioSpecification;
import br.com.projeto.mercado.service.GrupoService;
import br.com.projeto.mercado.service.UsuarioService;
import br.com.projeto.mercado.service.email.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private static final String MSG_USUARIO_EM_USO
            = "Usuário de código %d não pode ser removida, pois está em uso";

    private final UsuarioRepository usuarioRepository;
    private final GrupoService grupoService;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        log.debug("POST registerUser userDto received {} ", userDto.toString());
        if (existsByUsername(userDto.getUsername())) {
            log.warn("Username {} is Already Taken ", userDto.getUsername());
            throw new ConflictException(
                    String.format("Error: Username is Already Taken! %s ", userDto.getUsername()));
        }
        if (existsByEmail(userDto.getEmail())) {
            log.warn("Email {} is Already Taken ", userDto.getEmail());
            throw new ConflictException(
                    String.format("\"Error: Email is Already Taken! %s ", userDto.getEmail()));
        }

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Grupo grupo = grupoService.findByRoleName(TipoGrupo.ROLE_VENDOR);

        Usuario usuario = usuarioMapper.toEntity(userDto);
        usuario.getGrupos().add(grupo);
        usuario = usuarioRepository.save(usuario);
        log.debug("POST registerUser userId saved {} ", usuario.getId());
        log.info("User saved successfully userId {} ", usuario.getId());

        return usuarioMapper.toModel(usuario);

    }

    public Usuario buscarOuFalharPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Não existe um cadastro de usuário com email %s", email)));
    }

    @Override
    public UserDto resetPassword(String email) {

        Usuario usuario = buscarOuFalharPorEmail(email);
        String password = UUID.randomUUID().toString();
        usuario.setPassword(encodePassword(password));
        usuario = usuarioRepository.save(usuario);
        log.info("New user password: " + password);

        emailService.sendNewPasswordEmail(usuario);
        log.info("Mail send successfully new password: " + password);

        return usuarioMapper.toModel(usuario);
    }

    @Override
    public Page<UserDto> search(UsuarioFiltro filter, Pageable pageable) {
        log.debug("GET UserFilter filter received {} ", filter.toString());
        return usuarioRepository.findAll(new UsuarioSpecification(filter), pageable).map(usuarioMapper::toModel);

    }

    @Override
    public void delete(Long usuarioId) {
        try {
            usuarioRepository.deleteById(usuarioId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(usuarioId);

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(
                    String.format(MSG_USUARIO_EM_USO, usuarioId));
        }
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
