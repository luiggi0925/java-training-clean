package edu.globant.day1.designpatterns;

import java.util.Scanner;

abstract class Photo {

	private String resolution;
	private String format;

	public Photo(String resolution, String format) {
		this.resolution = resolution;
		this.format = format;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return String.format("Resolution: '%s'. Format: '%s'.", resolution, format);
	}
}

class LowResolutionPhoto extends Photo {
	public LowResolutionPhoto(String resolution, String format) {
		super(resolution, format);
	}
}

class HighResolutionPhoto extends Photo {
	public HighResolutionPhoto(String resolution, String format) {
		super(resolution, format);
	}
}

interface PhotoEditor {
	Photo createPhoto(String format);
}

class LowResolutionPhotoEditor implements PhotoEditor {
	@Override
	public Photo createPhoto(String format) {
		return new LowResolutionPhoto("360p", format);
	}
}

class HighResolutionPhotoEditor implements PhotoEditor {
	@Override
	public Photo createPhoto(String format) {
		return new LowResolutionPhoto("1080p", format);
	}
}

public class FactoryMethodPattern {

	public static void main(String[] args) {
//		PhotoEditor photoEditor = getPhotoEditor(0);
//		System.out.println(photoEditor.createPhoto("PNG"));
		System.out.print("Choose photo quality: (0) Low, (1) High: ");
		try (Scanner scanner = new Scanner(System.in)) {
			PhotoEditor anotherPhotoEditor = getPhotoEditor(scanner.nextInt());
			System.out.println(anotherPhotoEditor.createPhoto("PNG"));
		} catch (Exception e) {

		}
	}

	public static PhotoEditor getPhotoEditor(int type) {
		return type == 0 ? new LowResolutionPhotoEditor() : new HighResolutionPhotoEditor();
	}
}
