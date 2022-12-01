package com.sgr.bussines.security;


import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.interfaces.impl.UsuarioServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.sgr.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Slf4j
public class SecurityBussines {

	private SecurityBussines(){
	}
	@Autowired
	private static UsuarioServiceImplement usuarioServiceImplement;
	private static final String PREFIX = "Bearer";
	private static final String HEADER = "Authorization";
	private static final String SECRET = "sgrsoft2022";
	public static boolean existeJWTToken(HttpServletRequest request) {
		String authenticationHeader = request.getHeader(HEADER);
		return authenticationHeader != null && authenticationHeader.startsWith(PREFIX);
	}
	/**
	 * Metodo para autenticarnos dentro del flujo de Spring
	 * 
	 * @param username
	 */
	public static void setUpSpringAuthentication(Claims username) {

		@SuppressWarnings("unchecked")
		List<String> authorities = (List) username.get("authorities");
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username.getSubject(), null,

				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	public static String getJWTToken(String email, Usuario usuario) {

		String secretKey = SECRET;

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
		String token = Jwts.builder().setId(UUID.randomUUID().toString()).setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("Email", usuario.getEmail())
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	public static Boolean chekTockenExp(String oldToken){
		String[] parts = oldToken.split("\\.");
		JsonObject payloadJson = new Gson().fromJson(decode(parts[1]), JsonObject.class);
		int exp = payloadJson.get("exp").getAsInt();
		return exp > (System.currentTimeMillis() / 1000);
	}
	public static String getTockenUsr(String oldToken){
		String[] parts = oldToken.split("\\.");
		JsonObject payloadJson = new Gson().fromJson(decode(parts[1]), JsonObject.class);
		return payloadJson.get("sub").getAsString();
	}

	private static String decode(String encodedString) {
		return new String(Base64.getUrlDecoder().decode(encodedString));
	}

}
