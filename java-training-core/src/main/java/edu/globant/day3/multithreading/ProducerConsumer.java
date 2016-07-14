package edu.globant.day3.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.globant.utils.ThreadUtils;

class Producer {
	private Queue<Integer> queue;
	private Random r;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
		r = new Random();
	}

	public void produce() {
		int val = r.nextInt(100);
		System.out.println(String.format("Offerring %d. %s.", val, queue.offer(val) ? "Done" : "Failed"));
	}
}

class Consumer {
	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void consume() {
		System.out.println(String.format("Consumed: %d.", queue.poll()));
	}
}

class BlockingProducer {

	private BlockingQueue<Integer> queue;
	private Random r;

	public BlockingProducer(BlockingQueue<Integer> queue) {
		this.queue = queue;
		r = new Random();
	}

	public void produce() {
		int val = r.nextInt(100);
		System.out.println(String.format("Offerring %d.", val));
		try {
			queue.put(val);
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
	}
}

class BlockingConsumer {
	private BlockingQueue<Integer> queue;

	public BlockingConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void consume() {
		try {
			System.out.println(String.format("Consumed: %d.", queue.take()));
		} catch (InterruptedException e) {
			e.printStackTrace(System.out);
		}
	}
}

public class ProducerConsumer {

	static final int MAX_ITERATIONS = 10;

	public static void main(String[] args) {
		execute(new LinkedList<>());
		System.out.println("--------------------------------------------------------------------------------------------");
		execute(new LinkedBlockingQueue<>());
	}

	public static void execute(Queue<Integer> queue) {
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		Runnable producerTask = ThreadUtils.newLoopRunnable(() -> producer.produce(), MAX_ITERATIONS);
		Runnable consumerTask = ThreadUtils.newLoopRunnable(() -> consumer.consume(), MAX_ITERATIONS);
		ThreadUtils.executeTasksInThreadsAndWait(producerTask, consumerTask);
		System.out.println(String.format("Items in queue: %s", queue));
	}

	public static void execute(BlockingQueue<Integer> queue) {
		BlockingProducer producer = new BlockingProducer(queue);
		BlockingConsumer consumer = new BlockingConsumer(queue);
		Runnable producerTask = ThreadUtils.newLoopRunnable(() -> producer.produce(), MAX_ITERATIONS);
		Runnable consumerTask = ThreadUtils.newLoopRunnable(() -> consumer.consume(), MAX_ITERATIONS);
		ThreadUtils.executeTasksInThreadsAndWait(consumerTask, producerTask);
		System.out.println(String.format("Items in queue: %s", queue));
	}
}
