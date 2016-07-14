package edu.globant.day8;

public class Calculator {

	public double sum(double a, double b) {
		return a + b;
	}

	public double difference(double a, double b) {
		return a - b;
	}

	public double times(double a, double b) {
		return a * b;
	}

	public double division(double a, double b) {
		return a / b;
	}

	public double abs(double a) {
		return a <= 0 ? -a : a;
	}
}
