package com.sgr.bussines.security;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgr.entities.APOD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SecurityGoogleTokenVerifier {
	private SecurityGoogleTokenVerifier() {
	}
	private static final String GOOGLE = "https://oauth2.googleapis.com/tokeninfo?access_token=";
	private static final String GOOGLE_USR= "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=";
	public static APOD verificar(String token) {
		ObjectMapper mapper = new ObjectMapper();
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(GOOGLE+token.trim());
			return client.execute(request,httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(), APOD.class));
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}
	public static String googleUserInfo(String token) {
		String output="";
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpURLConnection conn = (HttpURLConnection) new URL(GOOGLE_USR+token).openConnection();
			conn.setRequestProperty("Content-Type","application/json");
			conn.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response = new StringBuilder();
			while ((output = in.readLine()) != null) {
				response.append(output);
			}
			in.close();
			return response.toString();
		} catch (Exception e) {
			return null;
		}

	}
}
