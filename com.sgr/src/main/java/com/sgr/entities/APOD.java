package com.sgr.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class APOD {

	private final String scope;
	private final String azp;
	private final String aud;
	private final String sub;
	private final String hd;
	private final String email;
	private final String iat;
	private final String emailVerified;
	private final String atHash;
	private final String exp;
	private final String alg;
	private final String kid;
	private final String typ;
	private final String expiresIn;
	private final String accessType;
	private final String error;
	private final String errorDescription;
	private String sgrToken;
	private Usuario usuario;

	public APOD(@JsonProperty("azp") String azp,
				@JsonProperty("aud") String aud,
				@JsonProperty("sub") String sub,
				@JsonProperty("hd") String hd,
				@JsonProperty("iat") String iat,
				@JsonProperty("email_verified") String emailVerified,
				@JsonProperty("at_hash") String atHash,
				@JsonProperty("alg") String alg,
				@JsonProperty("kid") String kid,
				@JsonProperty("typ") String typ,
				@JsonProperty("email") String email,
				@JsonProperty("scope") String scope,
				@JsonProperty("exp") String exp,
				@JsonProperty("expires_in") String expiresIn,
				@JsonProperty("access_type") String accessType,
				@JsonProperty("error") String error,
				@JsonProperty("error_description") String errorDescription,
				@JsonProperty("sgrToken") String sgrToken,
				@JsonProperty("usuario") Usuario usuario)
		{
		this.azp = azp;
		this.hd = hd;
		this.sub = sub;
		this.aud = aud;
		this.iat = iat;
		this.emailVerified = emailVerified;
		this.atHash = atHash;
		this.alg = alg;
		this.typ = typ;
		this.kid = kid;
		this.email = email;
		this.scope = scope;
		this.exp = exp;
		this.expiresIn = expiresIn;
		this.accessType = accessType;
		this.error = error;
		this.errorDescription = errorDescription;
		this.sgrToken = sgrToken;
		this.usuario = usuario;
	}
}