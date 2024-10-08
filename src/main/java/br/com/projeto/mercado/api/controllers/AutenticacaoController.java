package br.com.projeto.mercado.api.controllers;

import br.com.projeto.mercado.api.dto.JwtDto;
import br.com.projeto.mercado.api.dto.LoginDto;
import br.com.projeto.mercado.api.dto.UserDto;
import br.com.projeto.mercado.api.response.UsuarioResponse;
import br.com.projeto.mercado.security.jwt.JwtProvider;
import br.com.projeto.mercado.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Log4j2
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    private final AuthenticationManager authenticationManager;

    private final UsuarioService usuarioService;

    @PostMapping("/signup")
    public ResponseEntity<UsuarioResponse> registerUser(@RequestParam String tipoUsuario, @RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(tipoUsuario, userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> authenticateUser(@Valid @RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwt(authentication);
        return ResponseEntity.ok(new JwtDto(jwt));
    }

    @GetMapping("/resetpassword/{email}")
    public ResponseEntity<UsuarioResponse> resetPassword(@PathVariable("email") String email) {
        return ResponseEntity.ok(usuarioService.resetPassword(email));
    }
}
