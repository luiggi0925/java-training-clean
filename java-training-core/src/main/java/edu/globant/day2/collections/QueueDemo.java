package edu.globant.day2.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		performTasks(new LinkedList<>());
		System.out.println("----------------------------------------------------------");
		performTasks(new PriorityQueue<>());
	}

	public static void performTasks(Queue<Object> queue) {
		queue.offer(2384);
		queue.offer(1623);
		queue.offer(5392);
		queue.offer(4328);
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
