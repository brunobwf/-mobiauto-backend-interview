package br.com.mobiauto.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 150, nullable = false, unique= true)
	private String email;

	@Column(length = 150, nullable = false)
	private String senha;

	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = false)
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "id_revenda")
	private Revenda revenda;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.perfil.getNome() == "ADMNISTRADOR") {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
