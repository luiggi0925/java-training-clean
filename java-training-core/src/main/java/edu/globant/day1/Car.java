package edu.globant.day1;

/**
 * Class that shows how multiple constructors work.
 * @author Luiggi Mendoza
 *
 */
public class Car {

	private String brand;
	private int wheels;
	private int doors;

	public Car(String brand) {
		this(brand, 4);
	}

	public Car(String brand, int wheels) {
		this(brand, wheels, 4);
	}

	public Car(String brand, int wheels, int doors) {
		this.brand = brand;
		this.wheels = wheels;
		this.doors = doors;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}
}
