package edu.globant.day2.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		performTasks(new HashMap<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new LinkedHashMap<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new TreeMap<>());
	}

	public static void performTasks(Map<String, Object> map) {
		map.put("key01", "Hello");
		map.put("key02", "world");
		map.put("key05", "Yoda talking");
		map.put("key04", "a Java Course");
		map.put("key03", "This is");
		System.out.println(map);
		map.put("key01", "Bye");
		System.out.println(map);
		map.putIfAbsent("key01", "Goodbye");
		System.out.println(map);
		Object old = map.remove("key01");
		System.out.println(old);
		System.out.println(map);
		map.putIfAbsent("key01", "Goodbye");
		System.out.println(map);
		System.out.println(map.get("key05"));
	}

}
