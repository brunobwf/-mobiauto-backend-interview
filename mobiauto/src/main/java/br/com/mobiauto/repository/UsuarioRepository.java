package br.com.mobiauto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.mobiauto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	UserDetails findByEmail(String email);
	
	@Query("SELECT u FROM usuarios u WHERE u.email = :email")
	Usuario procurarPorEmail(String email);
}
