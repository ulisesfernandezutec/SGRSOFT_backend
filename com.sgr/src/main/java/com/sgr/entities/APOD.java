package com.sgr.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class APOD {

	public final String scope;
	public final String azp;
	public final String aud;
	public final String sub;
	public final String hd;
	public final String email;
	public final String iat;
	public final String email_verified;
	public final String at_hash;
	public final String exp;
	public final String alg;
	public final String kid;
	public final String typ;
	public final String expires_in;
	public final String access_type;
	public final String error;
	public final String error_description;
	public String sgrToken;

	public APOD(@JsonProperty("azp") String azp,
				@JsonProperty("aud") String aud,
				@JsonProperty("sub") String sub,
				@JsonProperty("hd") String hd,
				@JsonProperty("iat") String iat,
				@JsonProperty("email_verified") String email_verified,
				@JsonProperty("at_hash") String at_hash,
				@JsonProperty("alg") String alg,
				@JsonProperty("kid") String kid,
				@JsonProperty("typ") String typ,
				@JsonProperty("email") String email,
				@JsonProperty("date") String date,
				@JsonProperty("scope") String scope,
				@JsonProperty("exp") String exp,
				@JsonProperty("expires_in") String expires_in,
				@JsonProperty("access_type") String access_type,
				@JsonProperty("error") String error,
				@JsonProperty("error_description") String error_description,
				@JsonProperty("sgrToken") String sgrToken){
				
		this.azp = azp;
		this.hd = hd;
		this.sub = sub;
		this.aud = aud;
		this.iat = iat;
		this.email_verified = email_verified;
		this.at_hash = at_hash;
		this.alg = alg;
		this.typ = typ;
		this.kid = kid;
		this.email = email;
		this.scope = scope;
		this.exp = exp;
		this.expires_in = expires_in;
		this.access_type = access_type;
		this.error = error;
		this.error_description = error_description;
		this.sgrToken = sgrToken;
	}
}