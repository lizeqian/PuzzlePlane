package plane.config;

import java.util.*;

/**
 * The class NameConfig
 * Define names of shapesets and corresponding puzzles.
 * shapeset names include: ["traditional", "nontraditional"]
 * puzzle names for "traditional" shapeset: ["fox", "bird", "rabbit", "cristal", "fish", "duck", "dontknow", "turtle","house", "dog"]
 * puzzle names for "nontraditonal" shapeset: ["house", "snake", "windmill", "human", "tree", "diamond", "fish1", "horse","table", "fish2"]
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
	
	/** The Constant puzzleNames. */
	public final static Map<String, List<String>> puzzleNames;
	static {
		puzzleNames = new HashMap<>();
		puzzleNames.put("traditional", Arrays.asList("fox", "bird", "rabbit", "cristal", "fish", "duck", "dontknow", "turtle","house", "dog"));
		puzzleNames.put("nontraditional", Arrays.asList("house", "snake", "windmill", "human", "tree", "diamond", "fish1", "horse","table", "fish2"));	
	}
	
	/**
	 * Gets the puzzles.
	 *
	 * @param shapesetName the shapeset name
	 * @return A list of puzzle names for the shapeset
	 */
	public static List<String> getPuzzles(String shapesetName) {
		return puzzleNames.get(shapesetName);
	}
}
