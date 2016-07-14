package edu.globant.day3.multithreading;

public class DaemonThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			int x = 1;
			while (true) {
				System.out.println(x++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
//		t.setDaemon(true);
		t.start();
		System.out.println("I don't care any thread. I will just finish after 10 seconds approx.");
		Thread.sleep(10000);
		System.out.println("Bye");
		System.exit(0);
	}
}
