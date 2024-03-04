package br.com.mobiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobiauto.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
