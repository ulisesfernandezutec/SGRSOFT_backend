package com.sgr.bussines.security;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sgr.api.UsuarioController;
import com.sgr.api.UsuarioServiceImplement;
import io.jsonwebtoken.Jwt;
import lombok.extern.java.Log;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sgr.api.interfaces.UsuarioRepository;
import com.sgr.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import static org.apache.tomcat.util.security.MD5Encoder.encode;

public class SecurityBussines {
	@Autowired
	private static UsuarioServiceImplement usuarioServiceImplement;
	private final static String PREFIX = "Bearer";
	private final static String HEADER = "Authorization";
	private final static String SECRET = "sgrsoft2022";
	public static boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
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
		Boolean valid = exp > (System.currentTimeMillis() / 1000);
		return valid;
	}
	public static String getTockenUsr(String oldToken){
		String[] parts = oldToken.split("\\.");
		JsonObject payloadJson = new Gson().fromJson(decode(parts[1]), JsonObject.class);
		String usr = payloadJson.get("sub").getAsString();

		return usr;
	}
	private String hmacSha512(String data, String secret) {
		try {
			byte[] hash = secret.getBytes(StandardCharsets.UTF_8);
			Mac HS512 = Mac.getInstance("HS512");
			SecretKeySpec secretKey = new SecretKeySpec(hash, "HS512");
			HS512.init(secretKey);
			byte[] signedBytes = HS512.doFinal(data.getBytes(StandardCharsets.UTF_8));
			return encode(signedBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException ex) {
			//Log.getLogger(JWebToken.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	private static String decode(String encodedString) {
		return new String(Base64.getUrlDecoder().decode(encodedString));
	}

}
