package br.com.mobiauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobiauto.dto.PerfilDTO;

import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.service.impl.RetrievePerfilServiceImpl;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	
	@Autowired
	private RetrievePerfilServiceImpl retrievePerfilService;

	
	@GetMapping
	public ResponseEntity<List<PerfilDTO>> getUsuarios(){
		return ResponseEntity.status(HttpStatus.OK).body(retrievePerfilService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PerfilDTO> getUsuarioById(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(retrievePerfilService.findById(id));
	}
	
}
