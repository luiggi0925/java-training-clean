package edu.globant.utils;

import java.io.File;

public class FileUtils {

	public static String getLocalResourcePath(String resourcePath) {
		return FileUtils.class.getResource(resourcePath).getFile();
	}

	public static File getLocalResource(String resourcePath) {
		return new File(getLocalResourcePath(resourcePath));
	}
}
