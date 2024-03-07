package br.com.mobiauto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private SecurityFilter securityFilter;
	
	/**
	* Método responsavel pela validação dos usuários para rotas onde devem existir permissões especificas.
	*/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
       .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) //Configuração para resolver problemas de frames do H2 (Visualização do banco, sem isto ocorre erro de localhost bloqueado ao conectar no BD)
       .cors(cors -> cors.disable())
       .csrf(csrf -> csrf.disable())
       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       //Acesso do h2 liberado para visualização das informações e estrutura do banco de dados
       .authorizeHttpRequests(authorize-> authorize.requestMatchers("/h2-console/**").permitAll())
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.POST,"/auth/login").permitAll())
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.POST,"/usuario").hasAnyRole("ADMIN","GERENTE","PROPRIETARIO"))
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.PATCH,"/usuario").hasAnyRole("ADMIN","PROPRIETARIO"))	   
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.DELETE,"/usuario").hasRole("ADMIN"))
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.POST,"/revenda").hasRole("ADMIN"))
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.PATCH,"/revenda").hasRole("ADMIN"))
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.DELETE,"/revenda").hasRole("ADMIN"))
       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.PATCH,"/oportunidade/transferir/**").hasAnyRole("GERENTE","PROPRIETARIO")	         

       .anyRequest().authenticated())
       .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
       .build();
    
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
