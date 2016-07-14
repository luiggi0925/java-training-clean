package edu.globant.day2.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		performTasks(new HashSet<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new LinkedHashSet<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new TreeSet<>());
	}

	public static void performTasks(Set<String> set) {
		set.add("key01");
		set.add("key02");
		set.add("key05");
		set.add("key04");
		set.add("key03");
		System.out.println(set);
		set.add("key01");
		System.out.println(set.contains("key03"));
		System.out.println(set.contains("key09"));
		set.remove("key04");
		System.out.println(set);
	}
}
