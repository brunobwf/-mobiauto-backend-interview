package br.com.mobiauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobiauto.dto.AuthResponseDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.security.TokenService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private TokenService tokenService;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/**
	* Método responsavel pelo login de um usuário e retorno de um token
	*/
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login (@RequestBody UsuarioDTO usuarioDTO) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		return ResponseEntity.status(HttpStatus.OK).body(new AuthResponseDTO(token));
	}	
}
