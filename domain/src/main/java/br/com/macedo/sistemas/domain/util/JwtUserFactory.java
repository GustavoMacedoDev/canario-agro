package br.com.macedo.sistemas.domain.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.macedo.sistemas.domain.aggregate.Usuario;
import br.com.macedo.sistemas.domain.enums.PerfilEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionario.
	 * 
	 * @param funcionario
	 * @return JwtUser
	 */
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities(usuario.getPerfilEnum()));
	}
	
	/**
	 * Converte o perfil do usuario para o formato utilizado pelo Spring Security.
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

}
