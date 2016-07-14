package edu.globant.day8;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	public static final int DEFAULT_MAX_WEIGHT_CAPACITY = 900;

	private final List<Integer> peopleWeightList;
	private final int weightCapacity;

	public Elevator() {
		this(DEFAULT_MAX_WEIGHT_CAPACITY);
	}

	public Elevator(int weightCapacity) {
		peopleWeightList = new ArrayList<>();
		this.weightCapacity = weightCapacity;
	}

	public int getWeightCapacity() {
		return weightCapacity;
	}

	public List<Integer> getPeopleWeightList() {
		return unmodifiableList(peopleWeightList);
	}

	public boolean comesIn(Integer weight) {
		boolean result = false;
		if (result = (weightCapacity - weight > 0)) {
			peopleWeightList.add(weight);
		}
		return result;
	}

	public boolean goesOut(Integer weight) {
		return peopleWeightList.remove(weight);
	}
}
