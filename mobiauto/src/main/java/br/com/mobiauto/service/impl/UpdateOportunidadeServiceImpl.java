package br.com.mobiauto.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.mobiauto.dto.OportunidadeDTO;
import br.com.mobiauto.dto.OportunidadeRequestUpdateDTO;
import br.com.mobiauto.exception.NotFoundException;
import br.com.mobiauto.exception.SpecificException;
import br.com.mobiauto.model.Oportunidade;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.model.Usuario;
import br.com.mobiauto.repository.OportunidadeRepository;
import br.com.mobiauto.repository.RevendaRepository;
import br.com.mobiauto.repository.StatusRepository;
import br.com.mobiauto.repository.UsuarioRepository;
import br.com.mobiauto.service.UpdateOportunidadeService;

@Service
public class UpdateOportunidadeServiceImpl implements UpdateOportunidadeService {

	
	@Autowired
	private OportunidadeRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private RevendaRepository revendaRepository;
	
	@Override
	public void transferirOportunidade(OportunidadeRequestUpdateDTO oportunidadeDTO, Long id) throws NotFoundException {
		Oportunidade oportunidade = repository.findById(id).orElseThrow(()-> new NotFoundException());
		Usuario usuario = usuarioRepository.findById(oportunidadeDTO.getIdUsuarioResponsavel()).orElseThrow(()-> new NotFoundException("User not found in database"));
		LocalDate now = LocalDate.now();
		oportunidade.setDataAtrib(now);
		
		usuario.getRevenda().getOportunidades().remove(oportunidade);
		usuario = usuarioRepository.save(usuario);
		
		oportunidade.setUsuario(usuario);
		
		Revenda revenda = usuario.getRevenda();
		repository.save(oportunidade);
		revendaRepository.save(revenda);
		
	}

	@Override
	public void mudarStatusOportunidade(OportunidadeRequestUpdateDTO oportunidadeDTO, Long id) throws SpecificException, NotFoundException {
		Oportunidade oportunidade = repository.findById(id).orElseThrow(()-> new NotFoundException());
		Status status = statusRepository.findById(oportunidadeDTO.getStatus()).orElseThrow(()-> new NotFoundException("Status not found in database"));
 		oportunidade.setStatus(status);
		if(status.getNome() == "CONCLUÍDO") {
			if(oportunidadeDTO.getMotivoConclusao() == null) {
				throw new SpecificException("You must enter the reason for completing the opportunity", HttpStatus.BAD_REQUEST);
			}
			else {
				oportunidade.setMotivoConclusao(oportunidadeDTO.getMotivoConclusao());
				LocalDate now = LocalDate.now();
				oportunidade.setDataConclusao(now);
			}
		}
		repository.save(oportunidade);
	}
}
