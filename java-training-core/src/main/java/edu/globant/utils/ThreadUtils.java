package edu.globant.utils;

import java.util.stream.IntStream;

public class ThreadUtils {

	public static Runnable newLoopRunnable(Runnable runnable, int times) {
		return () -> IntStream.rangeClosed(1, times).forEach(x -> runnable.run());
	}

	public static void executeTasksInThreadsAndWait(Runnable ... tasks) {
		Thread[] threadArray = new Thread[tasks.length];
		int i = 1;
		for (Runnable task : tasks) {
			threadArray[i-1] = new Thread(task, "Thread " + i);
			i++;
		}
		for (Thread t : threadArray) {
			t.start();
		}
		for (Thread t : threadArray) {
			try {
				t.join();
			} catch (InterruptedException e) {
				//silent...
			}
		}
	}
}
