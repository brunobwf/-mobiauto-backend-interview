package br.com.mobiauto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mobiauto.dto.RevendaDTO;
import br.com.mobiauto.model.Revenda;
import br.com.mobiauto.service.CreateRevendaService;

@SpringBootApplication
public class MobiautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobiautoApplication.class, args);
	}
	
	
//	//Inserindo informações iniciais no banco de dados
	@Bean
	public CommandLineRunner demo(CreateRevendaService revendaService) {
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
		};
	}
}
