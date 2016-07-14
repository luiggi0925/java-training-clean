package edu.globant.day1.interfaces;

public interface BasicInterface {

	int X = 5;
	static final int Y = 10;
	public final int Z = 50;

	public static void main(String[] args) {
		//uncomment line below to see the compilation error
		//BasicInterface.X = 2;
		System.out.println("X: " + BasicInterface.X);
		System.out.println("Y: " + BasicInterface.Y);
		System.out.println("Z: " + BasicInterface.Z);
	}
}
