package edu.globant.day3.multithreading;

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 1; i <= 50; i++) {
				System.out.println(i);
			}
		});
		t.start();
//		Thread.sleep(10);
		System.out.println("This message should be printed anywhere between the other thread output.");
		t.join();
		System.out.println("This message is always printed when the other thread has finished.");
	}
}
