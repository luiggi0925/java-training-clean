package edu.globant.day3.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.globant.utils.ThreadUtils;

public class RaceConditionList {

	private static final int MAX_ITERATIONS = 10;

	private static final String[] RANDOM_DATA = {
		"Hello",
		"Aloha",
		"What's up?",
		"Hi",
		"Good!",
		"Bad!",
		"Goodbye!",
		"Sayonara",
		"Adios",
		"Au revoir",
		"Salut!",
		"Yeah, science!",
		"Testing purposes...",
		"Phone call",
		"Busy",
		"Very busy",
		"Programming",
		"Compiling",
		"Deploying",
		"Packaging",
		"Running",
		"Shut down"
	};

	public static String getRandomString() {
		Random r = new Random();
		return RANDOM_DATA[r.nextInt(RANDOM_DATA.length)];
	}

	public static void main(String[] args) {
		tryRaceCondition(new ArrayList<>());
		System.out.println("---------------------------------------------------------");
		tryRaceCondition(Collections.synchronizedList(new ArrayList<>()));
	}

	public static void tryRaceCondition(List<String> list) {
		try {
//			list.add(getRandomString());
			Runnable adderTask = ThreadUtils.newLoopRunnable(() -> list.add(getRandomString()), MAX_ITERATIONS );
			Runnable removerTask = ThreadUtils.newLoopRunnable(() -> System.out.println(list.remove(0)), MAX_ITERATIONS );
			ThreadUtils.executeTasksInThreadsAndWait(adderTask, removerTask);
		} catch (Exception e) {
			System.out.println("A problem occured while executing this method.");
			e.printStackTrace(System.out);
		}
	}
}
