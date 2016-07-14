package edu.globant.day11.memory;

import java.util.ArrayList;
import java.util.List;

public class MemoryBlown {

	public static void main(String[] args) throws Exception {
		outOfMemoryExample();
//		stackOverflowExample();
	}

	static List<Object> list = new ArrayList<>();

	static void outOfMemoryExample() {
		while (true) {
			list.add(new Object());
		}
	}

	static void stackOverflowExample() {
		stackOverflowExample();
	}

	static void foo(List<Object> list) {
		list.add(new Object());
	}
}
