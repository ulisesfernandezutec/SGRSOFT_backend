package com.sgr.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class APOD {

	public final String scope;
	public final String azp;
	public final String aud;
	public final String sub;
	public final String hd;
	public final String email;
	public final String iat;
	public final String emailVerified;
	public final String atHash;
	public final String exp;
	public final String alg;
	public final String kid;
	public final String typ;
	public final String expiresIn;
	public final String accessType;
	public final String error;
	public final String errorDescription;
	public String sgrToken;

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
				@JsonProperty("sgrToken") String sgrToken){
				
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
	}
}