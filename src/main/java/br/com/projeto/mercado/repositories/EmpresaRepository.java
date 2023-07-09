package br.com.projeto.mercado.repositories;

import br.com.projeto.mercado.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
