package PuzzlePlane.config;

import java.util.*;

public class NameConfig {
	
	public final static List<String> shapesetNames;
	static {
		shapesetNames = new ArrayList<>();
		shapesetNames.add("traditional");
		shapesetNames.add("nontraditional");
	}
	
	public final static Map<String, List<String>> puzzleNames;
	static {
		puzzleNames = new HashMap<>();
		puzzleNames.put("traditional", Arrays.asList("fox", "bird", "rabbit", "cristal", "fish", "duck", "dontknow", "turtle","house", "dog"));
		puzzleNames.put("nontraditional", Arrays.asList("fox", "bird", "rabbit", "cristal", "fish", "duck", "dontknow", "turtle","house", "dog"));	
	}
	
	public static List<String> getPuzzles(String shapesetName) {
		return puzzleNames.get(shapesetName);
	}
}
