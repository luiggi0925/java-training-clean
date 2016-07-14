package edu.globant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

	public static final String BASE_PATTERN = "yyyy-MM-dd";

	public static Date parseDate(String date) {
		return parseDate(date, BASE_PATTERN);
	}

	public static Date parseDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date result = null;
		try {
			result = sdf.parse(date);
		} catch (ParseException e) {
			System.out.println("Something happened when parsing the date.");
			e.printStackTrace(System.out);
		}
		return result;
	}

	public static String formatDate(Date date) {
		return formatDate(date, BASE_PATTERN);
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static java.sql.Date toSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
}
