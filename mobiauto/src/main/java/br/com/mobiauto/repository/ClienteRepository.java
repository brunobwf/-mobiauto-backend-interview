package br.com.mobiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobiauto.model.Cliente;
import br.com.mobiauto.model.Perfil;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
