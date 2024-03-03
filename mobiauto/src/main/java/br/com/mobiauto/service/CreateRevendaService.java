package br.com.mobiauto.service;
import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;


public interface CreateRevendaService {
	void save(RevendaDTO revenda) throws CNPJExistException, CNPJInvalidException;

}
