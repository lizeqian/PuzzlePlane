package plane.controllers;

import java.io.File;
import plane.config.FilePathConfig;

/**
 * The Class PuzzleChecker .
 */

public class PuzzleChecker {
	
	/**
	 * Check.
	 *
	 * @param shapesetName the shapeset name
	 * @param puzzleName the puzzle name
	 * @return true, if successful
	 */
	public static boolean check(String shapesetName, String puzzleName) {
		File file = new File(FilePathConfig.getPuzzleSolutionPath(shapesetName, puzzleName));
		return file.exists();
	}
}
