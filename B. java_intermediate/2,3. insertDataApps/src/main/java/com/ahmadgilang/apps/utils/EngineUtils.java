package com.ahmadgilang.apps.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EngineUtils {

	public static String getPathFile(String fileName){
		return System.getProperty("user.dir") + "/data/" + fileName;
	}
	
	public static List<String> getDataList(String fileName){
		String fullPath = getPathFile(fileName);
		
		try (Stream<String> stream = Files.lines(Paths.get(fullPath))) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
