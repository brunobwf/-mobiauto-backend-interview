package br.com.mobiauto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mobiauto.dto.PerfilDTO;
import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.dto.StatusDTO;
import br.com.mobiauto.dto.UsuarioDTO;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.model.Status;
import br.com.mobiauto.service.CreatePerfilService;
import br.com.mobiauto.service.CreateRevendaService;
import br.com.mobiauto.service.CreateStatusService;
import br.com.mobiauto.service.CreateUsuarioService;

@SpringBootApplication
public class MobiautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobiautoApplication.class, args);
	}
	
	
//	//Inserindo informações iniciais no banco de dados
	@Bean
	public CommandLineRunner demo(CreateRevendaService revendaService, CreatePerfilService perfilService, CreateUsuarioService usuarioService, CreateStatusService statusService) {
		return (args) -> {
			RevendaDTO revenda = new RevendaDTO();
			revenda.setCnpjRevenda("12345678912312");
			revenda.setNomeSocial("Revenda 1");
			revendaService.save(revenda);
			
			RevendaDTO revenda2 = new RevendaDTO();
			revenda2.setCnpjRevenda("56367575668123");
			revenda2.setNomeSocial("Revenda 2");
			revendaService.save(revenda2);
			
			RevendaDTO revenda3 = new RevendaDTO();
			revenda3.setCnpjRevenda("64667475841234");
			revenda3.setNomeSocial("Revenda 3");
			revendaService.save(revenda3);
			
			//Criando os perfis padrões para funcionamento da aplicação.
			
			PerfilDTO perfil = new PerfilDTO();
			perfil.setNome("ADMNISTRADOR");
			perfilService.save(perfil);
			
			PerfilDTO perfil2 = new PerfilDTO();
			perfil2.setNome("PROPRIETARIO");
			perfilService.save(perfil2);
			
			PerfilDTO perfil3 = new PerfilDTO();
			perfil3.setNome("GERENTE");
			perfilService.save(perfil3);
			
			PerfilDTO perfil4 = new PerfilDTO();
			perfil4.setNome("ASSISTENTE");
			perfilService.save(perfil4);
			
			
			//Criando usuário para cada perfil
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setEmail("admin@email.com");
			usuario.setNome("Bruno");
			usuario.setSenha("123");
			usuario.setIdPerfil(1L);
			usuarioService.save(usuario);
			
			UsuarioDTO usuario2 = new UsuarioDTO();
			usuario2.setEmail("prop@email.com");
			usuario2.setNome("Proprietario");
			usuario2.setSenha("123");
			usuario2.setIdPerfil(2L);
			usuario2.setIdRevenda(1L);
			usuarioService.save(usuario2);
			
			UsuarioDTO usuario3 = new UsuarioDTO();
			usuario3.setEmail("gerente@email.com");
			usuario3.setNome("Gerente");
			usuario3.setSenha("123");
			usuario3.setIdPerfil(3L);
			usuario3.setIdRevenda(1L);
			usuarioService.save(usuario3);
			
			UsuarioDTO usuario4 = new UsuarioDTO();
			usuario4.setEmail("assist@email.com");
			usuario4.setNome("Assistente");
			usuario4.setSenha("123");
			usuario4.setIdPerfil(4L);
			usuario4.setIdRevenda(1L);
			usuarioService.save(usuario4);
			
			UsuarioDTO usuario5 = new UsuarioDTO();
			usuario5.setEmail("assist2@email.com");
			usuario5.setNome("Assistente 2");
			usuario5.setSenha("123");
			usuario5.setIdPerfil(4L);
			usuario5.setIdRevenda(2L);
			usuarioService.save(usuario5);
			
			StatusDTO status = new StatusDTO();
			status.setNome("NOVO");
			statusService.save(status);
			
			StatusDTO status2 = new StatusDTO();
			status2.setNome("EM ATENDIMENTO");
			statusService.save(status2);

			StatusDTO status3 = new StatusDTO();
			status3.setNome("CONCLUÍDO");
			statusService.save(status3);
			
		};
	}
}
