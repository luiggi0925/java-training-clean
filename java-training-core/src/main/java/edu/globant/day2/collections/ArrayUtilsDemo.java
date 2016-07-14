package edu.globant.day2.collections;

import java.util.Arrays;

class IntegerHolder implements Comparable<IntegerHolder> {
	private final int x;

	public IntegerHolder(int x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return Integer.toString(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegerHolder other = (IntegerHolder) obj;
		if (x != other.x)
			return false;
		return true;
	}
	@Override
	public int compareTo(IntegerHolder o) {
		return Integer.compare(this.x, o.x);
	}
}

public class ArrayUtilsDemo {

	public static void main(String[] args) {
		performTasks(new int[] { 5, 15, 7, 19, 12 });
		System.out.println("----------------------------------------------------------");
		performTasks(new IntegerHolder[] {
				new IntegerHolder(5),
				new IntegerHolder(15),
				new IntegerHolder(7),
				new IntegerHolder(19),
				new IntegerHolder(12)
			},
			new IntegerHolder[] {
				new IntegerHolder(5),
				new IntegerHolder(7),
				new IntegerHolder(12),
				new IntegerHolder(15),
				new IntegerHolder(19)
			});
	}

	public static void performTasks(int[] array) {
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.binarySearch(array, 7));
		System.out.println(Arrays.binarySearch(array, 10));
		System.out.println(Arrays.equals(array, new int[] { 5, 7, 12, 15, 19 }));
	}

	public static void performTasks(Object[] array, Object[] arrayToCompareWith) {
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.binarySearch(array, new IntegerHolder(7)));
		System.out.println(Arrays.binarySearch(array, new IntegerHolder(10)));
		System.out.println(Arrays.equals(array, arrayToCompareWith));
	}
}
