package com.sgr.bussines;

import com.google.gson.Gson;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.List;
import com.sgr.entities.Usuario;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class Utils {
	private Utils(){
	}
	
	//Parsea una clase en un objeto Json
	public static Document genJsonDocs(Object o) {
		Gson gson = new Gson();
		return Document.parse(gson.toJson(o));
	}
	public static Long intToLong(int l){
		return Long.parseLong(String.valueOf(l));
	}

	public static int longToInt(Long l){
		return Integer.parseInt(String.valueOf(l));
	}
	
	public static Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	public static List<List<Object>> filtrarMeses(List<Usuario> lista) {
		return List.of(
				List.of("Enero",	lista.stream().filter(c -> getMonth(c.get_id()) ==0).count()),
				List.of("Febrero", 	lista.stream().filter(c -> getMonth(c.get_id()) ==1).count()),
				List.of("Marzo", 	lista.stream().filter(c -> getMonth(c.get_id()) ==2).count()),
				List.of("Abril", 	lista.stream().filter(c -> getMonth(c.get_id()) ==3).count()),
				List.of("Mayo", 	lista.stream().filter(c -> getMonth(c.get_id()) ==4).count()),
				List.of("Junio", 	lista.stream().filter(c -> getMonth(c.get_id()) ==5).count()),
				List.of("Julio", 	lista.stream().filter(c -> getMonth(c.get_id()) ==6).count()),
				List.of("Agosto",	lista.stream().filter(c -> getMonth(c.get_id()) ==7).count()),
				List.of("Setiembre", lista.stream().filter(c -> getMonth(c.get_id()) ==8).count()),
				List.of("Octubre", 	lista.stream().filter(c -> getMonth(c.get_id()) ==9).count()),
				List.of("Noviembre", lista.stream().filter(c -> getMonth(c.get_id()) ==10).count()),
				List.of("Diciembre", lista.stream().filter(c -> getMonth(c.get_id()) ==11).count())
		);
	}
	public static List<List<LocalDateTime>> filtrarAnios(List<Usuario> lista) {
		List<List<LocalDateTime>> groupedDates = lista.stream()
				.map(dateInMilliseconds -> LocalDateTime.ofInstant(Instant.ofEpochMilli(dateInMilliseconds.get_id()), ZoneId.systemDefault()))
				.collect(Collectors.groupingBy(LocalDateTime::getYear))
				.values().stream().collect(Collectors.toList());
		
		return groupedDates;
	}

	public static int getMonth(long c){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(c));
		int month = cal.get(Calendar.MONTH);
		return month;
	}
	public static int getYear(long c){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(c));
		int y = cal.get(Calendar.YEAR);
		return y;
	}
	public static boolean validarEmail(String email) throws AddressException{
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
			return true;
		} catch (AddressException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Messages.EMAIL_INVALID);
		}
	}

}
