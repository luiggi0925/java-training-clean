package edu.globant.day1;

import edu.globant.day1.interfaces.Canvas;
import edu.globant.day1.interfaces.Wall;

public class RoomWall implements Canvas, Wall {

	@Override
	public void draw(String s) {
		Canvas.super.draw(s);
//		Wall.super.draw(s);
//		System.out.println(String.format("Writing \"%s\" in the room wall.", s));
	}

	public static void main(String[] args) {
		new RoomWall().draw("Have fun!");
	}
}
