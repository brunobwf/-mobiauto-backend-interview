package br.com.mobiauto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
       .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) //Configuração para resolver problemas de frames do H2 (Visualização do banco, sem isto ocorre erro de localhost bloqueado ao conectar no BD)
       .cors(cors -> cors.disable())
       .csrf(csrf -> csrf.disable())
       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//       .authorizeHttpRequests(authorize-> authorize.requestMatchers(HttpMethod.POST,"/revendas").hasRole("ADMIN")
//       .anyRequest().authenticated())
       .build();
    
	}
}
