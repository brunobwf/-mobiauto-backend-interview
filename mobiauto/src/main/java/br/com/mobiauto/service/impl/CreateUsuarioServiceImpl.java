package br.com.mobiauto.service.impl;

import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.mobiauto.dto.UserLoggedDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.exception.EmailAlreadyExistException;
import br.com.mobiauto.exception.EmailInvalidException;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;
import br.com.mobiauto.mapper.UsuarioMapper;
import br.com.mobiauto.model.Perfil;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.PerfilRepository;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.CreateUsuarioService;
import br.com.mobiauto.utils.EmailValidatorUtil;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CreateUsuarioServiceImpl implements CreateUsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private RevendaRepository revendaRepository;

	@Autowired
	private UsuarioMapper mapper;
	
	
	/**
	* Método responsavel pela criação/ registro de um usuario
	*
	* 
	*/
	@Override
	public void save(UsuarioDTO usuarioDTO, Map<String, String> headers)
			throws NotFoundException, EmailInvalidException, EmailAlreadyExistException, SpecificException {

		boolean isAdmin = false;
		
		String usuarioEmail = usuarioDTO.getEmail();
		EmailValidatorUtil.isValid(usuarioEmail);

		UserDetails userDetails = repository.findByEmail(usuarioEmail);

		if (userDetails != null) {
			throw new EmailAlreadyExistException();
		}
		
		
		/**
		* Valida o usuário logado e verifica se este é da mesma loja/revenda que o usuário a ser cadastrado (Caso seja admin não é obrigatório)
		*
		* 
		*/
		String authorization = null;
		if (headers != null) {
			authorization = headers.get("authorization");
			String[] chunks = authorization.split("\\.");
			Base64.Decoder decoder = Base64.getUrlDecoder();
			String payloadToken = new String(decoder.decode(chunks[1]));
			Gson gson = new Gson();
			UserLoggedDTO userLogged = gson.fromJson(payloadToken, UserLoggedDTO.class);
			Usuario userDetailsLogged = repository.procurarPorEmail(userLogged.getSub());

		    if (userDetails != null && userDetails.getAuthorities().stream()
		      .anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
		        isAdmin = true;
		    }
		    
			if (!isAdmin && userDetailsLogged.getRevenda() != null) {
				if (userDetailsLogged.getRevenda().getId() != usuarioDTO.getIdRevenda()) {
					throw new SpecificException("YOU CAN ONLY REGISTER USERS IN YOUR STORE", HttpStatus.FORBIDDEN);
				}
			}

		}


 		Usuario usuario = mapper.dTOToUsuario(usuarioDTO);
		Revenda revenda = null;
		Perfil perfil = null;

		String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setSenha(encryptedPassword);
		
		/**
		* Validações para ver se a Revenda o Perfil preenchido existe
		*
		* 
		*/

		// 

		if (usuarioDTO.getIdPerfil() != null) {
			perfil = perfilRepository.findById(usuarioDTO.getIdPerfil())
					.orElseThrow(() -> new NotFoundException("Perfil not exist in database"));
		}

		if (usuarioDTO.getIdRevenda() != null) {
			revenda = revendaRepository.findById(usuarioDTO.getIdRevenda())
					.orElseThrow(() -> new NotFoundException("Store not exist in database"));
		}

		usuario.setPerfil(perfil);
		usuario.setRevenda(revenda);

		repository.save(usuario);

	}

}
