package br.com.mobiauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.exception.CNPJExistException;
import br.com.mobiauto.exception.CNPJInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.service.impl.CreateRevendaServiceImpl;
import br.com.mobiauto.service.impl.DeleteRevendaServiceImpl;
import br.com.mobiauto.service.impl.RetrieveRevendaServiceImpl;
import br.com.mobiauto.service.impl.UpdateRevendaServiceImpl;


@RestController
@RequestMapping("/revenda")
public class RevendaController {
	
	@Autowired
	private CreateRevendaServiceImpl createRevendaService;
	
	@Autowired
	private RetrieveRevendaServiceImpl retrieveRevendaService;
	
	@Autowired
	private UpdateRevendaServiceImpl updateRevendaService;
	
	@Autowired
	private DeleteRevendaServiceImpl deleteRevendaService;
	

	@GetMapping
	public ResponseEntity<Page<Revenda>> getRevendas(@RequestParam (defaultValue= "0" , required = false) Integer pageNumber , @RequestParam (defaultValue= "2" , required = false) Integer pageSize, @RequestParam (required = false) String sort){
		Page<Revenda> pageRevenda = retrieveRevendaService.findAllPagination(pageNumber, pageSize, sort);
		return ResponseEntity.status(HttpStatus.OK).body(pageRevenda);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RevendaDTO> getRevenda(@PathVariable Long id) throws NotFoundException{
		RevendaDTO revendaDTO = retrieveRevendaService.findRevenda(id);
		return ResponseEntity.status(HttpStatus.OK).body(revendaDTO);
	}
	
	//Optei por retornar somente o 201(CREATED) sem retorno de um body por não haver necessidade de um retorno.
	@PostMapping
	public ResponseEntity<RevendaDTO> save(@RequestBody RevendaDTO revendaDTO) throws CNPJExistException, CNPJInvalidException {
		createRevendaService.save(revendaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}	
	
	//Optei por utilizar NO CONTENT(204) como resposta pois neste cenário não teria necessidade do retorno dos valores atualizados pelo próprio usuário.
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updateRevenda(@RequestBody RevendaDTO revendaDTO, @PathVariable Long id) throws NotFoundException, CNPJInvalidException, CNPJExistException{
		updateRevendaService.updateRevenda(revendaDTO, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteRevenda(@PathVariable Long id) throws NotFoundException{
		deleteRevendaService.deleteRevenda(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	

}
