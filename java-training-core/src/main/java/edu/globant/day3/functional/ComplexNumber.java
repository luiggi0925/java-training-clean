package edu.globant.day3.functional;

public class ComplexNumber {

	private final double real;
	private final double imaginary;

	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public ComplexNumber add(double real, double imaginary) {
		return new ComplexNumber(this.real + real, this.imaginary + imaginary);
	}

	@Override
	public String toString() {
		return String.format("%.2f %c %.2fi.", real, imaginary > 0 ? '+' : '\0', imaginary);
	}

	public static void main(String[] args) {
		ComplexNumber complex1 = new ComplexNumber(5, 4);
		System.out.println(complex1);
		ComplexNumber complex2 = complex1.add(0, 1);
		System.out.println(complex2);
		System.out.println(complex1);
		complex1 = complex1.add(0, 1);
		System.out.println(complex1);
	}
}
