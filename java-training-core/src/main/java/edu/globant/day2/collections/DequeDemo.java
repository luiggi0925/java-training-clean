package edu.globant.day2.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

	public static void main(String[] args) {
		performTasks(new LinkedList<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new ArrayDeque<>());
	}

	public static void performTasks(Deque<Object> deque) {
		deque.offer(15);
		deque.offer(47);
		deque.offer(28);
		deque.offer(90);
		System.out.println(deque);
		System.out.println(deque.peekLast());
		System.out.println(deque.pollLast());
		System.out.println(deque);
		deque.push(76);
		deque.push(32);
		System.out.println(deque);
		System.out.println(deque.peekFirst());
		System.out.println(deque.pollFirst());
		System.out.println(deque);
	}
}
