package edu.globant.day2.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.globant.utils.FileUtils;

public class MultipleExceptionHandling {

	public static void info(String s) {
		System.out.println("INFO. " + s);
	}

	public static void warn(Exception e) {
		System.out.println("WARN. Something odd happened.");
		e.printStackTrace(System.out);
	}

	public static void unexpected(Exception e) {
		System.out.println("ERROR. Unexpected situation. Must check immediately.");
		e.printStackTrace(System.out);
	}

	public static void main(String[] args) {
		try(BufferedReader reader = new BufferedReader(new FileReader(FileUtils.getLocalResource("/edu/globant/day2/classNames.txt")))) {
			String line;
			while ( (line = reader.readLine()) != null) {
				try {
					info(String.format("Loading %s class", line));
					Class<?> clazz = Class.forName(line);
					info(String.format("Creating a new instance of %s class ", line));
					clazz.newInstance();
					info(String.format("A new instance of %s was created.", clazz.getName()));
				} catch (ClassNotFoundException | InstantiationException e) {
					warn(e);
				}

				System.out.println("--------------------------------------------------------------------------------------");
			}
		} catch (IOException e) {
			warn(e);
		} catch (Exception e) {
			unexpected(e);
		}
	}

}
