package edu.globant.day2.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilsDemo {

	public static void main(String[] args) {
		unmodifiableCollectionDemo(new ArrayList<>(Arrays.asList(5, 8, 10)));
		System.out.println("----------------------------------------------------------");
		checkedAtRuntime(new ArrayList<>(Arrays.asList(5, 8, 10)), Integer.class, 10);
		checkedAtRuntime(new ArrayList<>(Arrays.asList(5, 8, 10)), Integer.class, "boom");
	}

	public static void unmodifiableCollectionDemo(List<Object> list) {
		System.out.println(list);
		List<Object> tryToTouchMe = Collections.unmodifiableList(list);
		System.out.println(tryToTouchMe);
//		list.set(0, "ha ha ha");
		try {
			tryToTouchMe.set(0, "ha ha ha");
		} catch (UnsupportedOperationException e) {
			System.out.println("can't touch this");
		}
		System.out.println(list);
		System.out.println(tryToTouchMe);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void checkedAtRuntime(List<T> list, Class<T> clazz, Object data) {
		List tryToAddNotTStuff = Collections.checkedList(list, clazz);
		try {
			tryToAddNotTStuff.add(data);
		} catch (ClassCastException e) {
			System.out.println("can't add data different that expected");
		}
		System.out.println(tryToAddNotTStuff);
	}
}
