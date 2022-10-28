package com.sgr.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APOD {

	public final String azp;
	public final String date;
	public final String scope;
	public final String exp;
	public final String aud;
	public final String expires_in;
	public final String access_type;

	public APOD(@JsonProperty("azp") String azp,
			@JsonProperty("aud") String aud, 
			@JsonProperty("date") String date,
			@JsonProperty("scope") String scope,
			@JsonProperty("exp") String exp,
			@JsonProperty("expires_in") String expires_in,
			@JsonProperty("access_type") String access_type) {
		this.azp = azp;
		this.aud = aud;
		this.date = date;
		this.scope = scope;
		this.exp = exp;
		this.expires_in = expires_in;
		this.access_type = access_type;
	}

	@Override
	public String toString() {
		return "APOD [azp=" + azp + ", date=" + date + ", scope=" + scope + ", exp=" + exp + ", aud=" + aud
				+ ", expires_in=" + expires_in + ", access_type=" + access_type + "]";
	}
	
	
}