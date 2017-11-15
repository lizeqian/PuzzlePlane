package plane.config;

import java.util.*;

/**
 * The class NameConfig
 */

public class NameConfig {

	/**
	 * Create the the name of config
	 */
	
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
		puzzleNames.put("nontraditional", Arrays.asList("house", "snake", "windmill", "human", "tree", "diamond", "fish1", "horse","table", "fish2"));	
	}
	
	public static List<String> getPuzzles(String shapesetName) {
		return puzzleNames.get(shapesetName);
	}
}
