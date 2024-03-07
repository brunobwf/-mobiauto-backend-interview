package br.com.mobiauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobiauto.dto.OportunidadeDTO;
import br.com.mobiauto.dto.OportunidadeNovaDTO;
import br.com.mobiauto.dto.OportunidadeRequestUpdateDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;
import br.com.mobiauto.service.DeleteUsuarioService;
import br.com.mobiauto.service.impl.CreateOportunidadeServiceImpl;
import br.com.mobiauto.service.impl.CreateUsuarioServiceImpl;
import br.com.mobiauto.service.impl.DeleteOportunidadeServiceImpl;
import br.com.mobiauto.service.impl.DeleteUsuarioServiceImpl;
import br.com.mobiauto.service.impl.RetrieveOportunidadeServiceImpl;
import br.com.mobiauto.service.impl.RetrieveUsuarioServiceImpl;
import br.com.mobiauto.service.impl.UpdateOportunidadeServiceImpl;
import br.com.mobiauto.service.impl.UpdateUsuarioServiceImpl;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeController {
	
	@Autowired
	private CreateOportunidadeServiceImpl createOportunidadeService;

	@Autowired
	private RetrieveOportunidadeServiceImpl retrieveOportunidadeService;
	
	
	@Autowired
	private UpdateOportunidadeServiceImpl updateOportunidadeService;
	
	@Autowired
	private DeleteOportunidadeServiceImpl deleteOportunidadeService;
	
	
	@GetMapping
	public ResponseEntity<List<OportunidadeDTO>> getOportunidades(){
		return ResponseEntity.status(HttpStatus.OK).body(retrieveOportunidadeService.findAll());
	}
	
	//Optei por retornar somente o 201(CREATED) sem retorno de um body por não haver necessidade de um retorno.
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody OportunidadeNovaDTO oportunidadeNovaDTO) throws NotFoundException, Exception {
		createOportunidadeService.save(oportunidadeNovaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<OportunidadeDTO> getOportunidadeById(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(retrieveOportunidadeService.findById(id));
	}
	
	@PatchMapping("/transferir/{id}")
	public ResponseEntity<Void> transferirResponsavel(@RequestBody OportunidadeRequestUpdateDTO oportunidadeDTO, @PathVariable Long id) throws NotFoundException{
		updateOportunidadeService.transferirOportunidade(oportunidadeDTO, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PatchMapping("/mudarStatus/{id}")
	public ResponseEntity<Void> mudarStatusOportunidade(@RequestBody OportunidadeRequestUpdateDTO oportunidadeDTO, @PathVariable Long id) throws SpecificException, NotFoundException{
		updateOportunidadeService.mudarStatusOportunidade(oportunidadeDTO, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOportunidade(@PathVariable Long id) throws NotFoundException{
		deleteOportunidadeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
