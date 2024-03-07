package br.com.mobiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobiauto.model.Status;
import java.util.List;
import java.util.Optional;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
	
	Optional<Status> findByNome(String nome);
}
