package edu.globant.day3.multithreading;

import java.util.concurrent.atomic.AtomicLong;

import edu.globant.utils.ThreadUtils;

interface Seeder {
	long getNewSeed();
}

class BasicSeeder implements Seeder {
	private long x = 1;

	@Override
	public long getNewSeed() {
		return x++;
	}
}

class AtomicSeeder implements Seeder {

	private AtomicLong x = new AtomicLong(1);

	public long getNewSeed() {
		return x.getAndIncrement();
	}

}

public class RaceConditionAtomic {
	static final int MAX_ITERATIONS = 100;

	public static void main(String[] args) {
//		generateAndCheckSeeds(new BasicSeeder());
//		System.out.println("---------------------------------------------------------------");
		generateAndCheckSeeds(new AtomicSeeder());
	}

	public static void generateAndCheckSeeds(Seeder seeder) {
		Runnable seedGeneration = ThreadUtils.newLoopRunnable(() -> System.out.println(String.format("New seed: %d.", seeder.getNewSeed())), MAX_ITERATIONS);
		ThreadUtils.executeTasksInThreadsAndWait(seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration, seedGeneration);
	}
}
