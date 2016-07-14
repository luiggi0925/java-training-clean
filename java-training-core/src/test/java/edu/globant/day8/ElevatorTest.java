package edu.globant.day8;

import static edu.globant.day8.Elevator.DEFAULT_MAX_WEIGHT_CAPACITY;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ElevatorTest {

	Elevator elevator;
	Integer weight;

	@Before
	public void init() {
		elevator = new Elevator();
		weight = 90;
	}

	@Test
	public void createElevatorDefaultState() {
		assertThat(elevator.getWeightCapacity(), equalTo(DEFAULT_MAX_WEIGHT_CAPACITY));
		assertThat(elevator.getPeopleWeightList(), is(emptyList()));
	}

	@Test
	public void createElevatorWithArgument() {
		int ourWeight = 100;
		elevator = new Elevator(ourWeight);
		assertThat(elevator.getWeightCapacity(), equalTo(ourWeight));
		assertThat(elevator.getPeopleWeightList(), is(emptyList()));
	}

	@Test
	public void shouldComeIn() {
		assertThat(elevator.comesIn(weight), is(true));
		assertThat(elevator.getPeopleWeightList(), allOf(not(emptyList()), hasItem(weight)));
	}

	@Test
	public void shouldNotComeIn() {
		weight += DEFAULT_MAX_WEIGHT_CAPACITY;
		assertThat(elevator.comesIn(weight), is(false));
		assertThat(elevator.getPeopleWeightList(), is(emptyList()));
	}

	@Test
	public void shouldComeInTwoValues() {
		assertThat(elevator.comesIn(weight), is(true));
		final Integer anotherWeight = 75;
		assertThat(elevator.comesIn(anotherWeight), is(true));
		assertThat(elevator.getPeopleWeightList(), allOf(not(emptyList()), hasItems(weight, anotherWeight)));
	}

	@Test
	public void shouldGoOut() {
		elevator.comesIn(weight);
		assertThat(elevator.goesOut(weight), is(true));
		assertThat(elevator.getPeopleWeightList(), is(emptyList()));
	}

	@Test
	public void shouldNotGoOutBecauseEmpty() {
		assertThat(elevator.goesOut(weight), is(false));
		assertThat(elevator.getPeopleWeightList(), is(emptyList()));
	}

	@Test
	public void shouldNotGoOutBecauseNotThere() {
		elevator.comesIn(weight);
		final Integer anotherWeight = 75;
		assertThat(elevator.goesOut(anotherWeight), is(false));
		assertThat(elevator.getPeopleWeightList(), allOf(not(emptyList()), hasItems(weight)));
	}
}
