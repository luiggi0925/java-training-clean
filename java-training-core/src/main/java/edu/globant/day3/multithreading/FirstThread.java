package edu.globant.day3.multithreading;

public class FirstThread extends Thread {

	public static final int LIMIT = 300;
	public FirstThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for (int i = 1; i <= LIMIT; i++) {
			System.out.println(String.format("Thread: %s. Data: %d", this.getName(), i));
		}
	}
	public static void main(String[] args) {
//		showNoPriority();
		showPriority(Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);
	}

	public static void showNoPriority() {
		showPriority(Thread.NORM_PRIORITY, Thread.NORM_PRIORITY);
	}

	public static void showPriority(int priorityT1, int priorityT2) {
		Thread t1 = new FirstThread("Thread 1");
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= LIMIT; i++) {
				System.out.println(String.format("Thread: %s. Data: %d", Thread.currentThread().getName(), i));
			}
		}, "Thread 2");
		t1.setPriority(priorityT1);
		t2.setPriority(priorityT2);
		t1.start();
		t2.start();
	}
}
