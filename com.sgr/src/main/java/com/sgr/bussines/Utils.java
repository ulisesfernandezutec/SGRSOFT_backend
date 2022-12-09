package com.sgr.bussines;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.sgr.entities.Usuario;
import org.bson.Document;

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
				List.of("Enero",	lista.stream().filter(c -> getMonth(c.get_id()) ==1).count()),
				List.of("Febrero", 	lista.stream().filter(c -> getMonth(c.get_id()) ==2).count()),
				List.of("Marzo", 	lista.stream().filter(c -> getMonth(c.get_id()) ==3).count()),
				List.of("Abril", 	lista.stream().filter(c -> getMonth(c.get_id()) ==4).count()),
				List.of("Mayo", 	lista.stream().filter(c -> getMonth(c.get_id()) ==5).count()),
				List.of("Junio", 	lista.stream().filter(c -> getMonth(c.get_id()) ==6).count()),
				List.of("Julio", 	lista.stream().filter(c -> getMonth(c.get_id()) ==7).count()),
				List.of("Agosto",	lista.stream().filter(c -> getMonth(c.get_id()) ==8).count()),
				List.of("Setiembre", lista.stream().filter(c -> getMonth(c.get_id()) ==9).count()),
				List.of("Octubre", 	lista.stream().filter(c -> getMonth(c.get_id()) ==10).count()),
				List.of("Noviembre", lista.stream().filter(c -> getMonth(c.get_id()) ==11).count()),
				List.of("Diciembre", lista.stream().filter(c -> getMonth(c.get_id()) ==12).count())
		);
	}
	public static int getMonth(long c){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(c);
		int month = calendar.get(Calendar.MONTH);
		return month;
	}

}
