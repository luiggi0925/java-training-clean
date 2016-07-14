package edu.globant.day2.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		performTasks(new ArrayList<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new LinkedList<>());
	}

	public static void performTasks(List<Object> list) {
		addData(list);
		System.out.println(list);
		removeData(list);
		System.out.println(list);
		List<Object> subList = list.subList(3, 7);
		System.out.println(subList);
		System.out.println(String.format("%s %s %s", list.get(0), list.get(5), list.get(7)));
		list.add(0, "bye");
		list.set(4, 4);
		list.set(6, 2);
		list.set(8, 0);
		System.out.println(list);
	}

	public static void addData(List<Object> list) {
		list.add("Hello");
		list.add("world");
		list.add("Adding a few numbers");
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add("It supports duplicated data");
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
	}

	public static void removeData(List<Object> list) {
		list.remove(0);
		list.remove(1);
		list.remove(2);
		list.remove(3);
		list.remove(4);
		list.remove(5);
	}
}
