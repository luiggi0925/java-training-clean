package edu.globant.day11.memory;

public class StringIntern {

	public static void main(String[] args) {
		String hello = new String("Hello world");
//		System.out.println(hello == "Hello world");
//		System.out.println(hello.equals("Hello world"));

		String world = new String("Hello world");
		System.out.println(hello == world);

		hello = hello + "!";
		world = world + "!";
		System.out.println(hello == world);
		System.out.println(hello.equals(world));
		System.out.println(hello.intern() == world.intern());
		StringBuilder sb = new StringBuilder();
		sb.append("hello").append("world");
		System.out.println(sb.toString() == sb.toString());
		System.out.println(sb.toString().intern() == sb.toString().intern());
	}
}
