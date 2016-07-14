package edu.globant.day3.functional;

import static java.util.Arrays.asList;

import java.util.List;

public class LambdaMethodReferences {

	public static void show(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		List<String> list = asList("Pedro", "Mario", "Luis", "Andrea", "Rocío");
		list.forEach(s -> System.out.println(s));
		System.out.println("----------------------------------------------------------");
		list.forEach(LambdaMethodReferences::show);
		System.out.println("----------------------------------------------------------");
		list.forEach(System.out::println);
	}
}
