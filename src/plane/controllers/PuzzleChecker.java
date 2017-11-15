package plane.controllers;

import java.io.File;


import plane.config.FilePathConfig;
/**
 * The Class PuzzleChecker .
 */

public class PuzzleChecker {
	public static boolean check(String shapesetName, String puzzleName) {
		File file = new File(FilePathConfig.getPuzzleSolutionPath(shapesetName, puzzleName));
		return file.exists();
	}
}
