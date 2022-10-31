package com.sgr.bussines.security;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sgr.entities.APOD;

public class GoogleSecurityTokenVerifier {

	public static String verificar(String token) {
		ObjectMapper mapper = new ObjectMapper();

		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet request = new HttpGet("https://oauth2.googleapis.com/tokeninfo?access_token=" + token);
			APOD response = client.execute(request,
					httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(), APOD.class));
			return new Gson().toJson(response);
		} catch (Exception e) {
			return null;
		}
	}
}