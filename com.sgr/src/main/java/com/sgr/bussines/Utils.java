package com.sgr.bussines;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;

import org.bson.Document;

public class Utils {
	
	//Parsea una clase en un objeto Json
	public static Document genJsonDocs(Object o) {
		Gson gson = new Gson();
		Document document = Document.parse(gson.toJson(o));
		return document;

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

}
