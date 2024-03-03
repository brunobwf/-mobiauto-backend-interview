package br.com.mobiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobiauto.model.Revenda;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda,Long> {
	
	public Revenda findByCnpjRevenda(String cnpjRevenda);

}
