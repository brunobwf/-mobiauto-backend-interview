package br.com.mobiauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.service.impl.RetrieveStatusServiceImpl;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	
	@Autowired
	private RetrieveStatusServiceImpl retrieveStatusService;

	
	@GetMapping
	public ResponseEntity<List<StatusDTO>> getStatus(){
		return ResponseEntity.status(HttpStatus.OK).body(retrieveStatusService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StatusDTO> getStatusById(@PathVariable Long id) throws NotFoundException{
		return ResponseEntity.status(HttpStatus.OK).body(retrieveStatusService.findById(id));
	}
	
}
