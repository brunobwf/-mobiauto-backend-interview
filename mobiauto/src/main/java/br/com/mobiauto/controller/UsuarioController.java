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

import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.dto.UsuarioResponseDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.service.DeleteUsuarioService;
import br.com.mobiauto.service.impl.CreateUsuarioServiceImpl;
import br.com.mobiauto.service.impl.DeleteUsuarioServiceImpl;
import br.com.mobiauto.service.impl.RetrieveUsuarioServiceImpl;
import br.com.mobiauto.service.impl.UpdateUsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private CreateUsuarioServiceImpl createUsuarioService;

	@Autowired
	private RetrieveUsuarioServiceImpl retrieveUsuarioService;
	
	@Autowired
	private UpdateUsuarioServiceImpl updateUsuarioService;
	
	@Autowired
	private DeleteUsuarioServiceImpl deleteUsuarioService;
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> getUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(retrieveUsuarioService.findAll());
	}
	
	//Optei por retornar somente o 201(CREATED) sem retorno de um body por não haver necessidade de um retorno.
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UsuarioDTO usuarioDTO) throws NotFoundException, EmailInvalidException, EmailAlreadyExistException {
		createUsuarioService.save(usuarioDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(retrieveUsuarioService.findById(id));
	}
	
	
	//Optei por utilizar NO CONTENT(204) como resposta pois neste cenário não teria necessidade do retorno dos valores atualizados pelo próprio usuário.
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updateUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) throws EmailInvalidException, EmailAlreadyExistException, NotFoundException{
		updateUsuarioService.updateUsuario(usuarioDTO, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) throws NotFoundException{
		deleteUsuarioService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
