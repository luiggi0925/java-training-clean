package edu.globant.day2.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class UsingSetForList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(5);
		list.add(8);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(2);
		System.out.println(list);

//		list.sort(Integer::compare);
//		List<Integer> newResults = new ArrayList<>();
//		for (Integer i : list) {
//			if (!newResults.contains(i)) {
//				newResults.add(i);
//			}
//		}
//		list = new ArrayList<>(new TreeSet<>(list));
//		doWork(list);
		doWork(new TreeSet<>(list));
	}

	public static void doWork(Collection<Integer> list) {
		System.out.println(list);
	}
}
