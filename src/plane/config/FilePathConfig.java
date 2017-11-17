package plane.config;

/**
 * the config of files path
 * Define methods to get image icon files and shape files for puzzles, shapesets, and solutions.
 * @author cheng zhu
 */

public class FilePathConfig {
	

	/**
	 * Create the path
	 */
	public static String getSolvedPuzzleIconPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/solvedPuzzleIcon.jpg";
	}
	
	/**
	 * Gets the shapeset path.
	 *
	 * @param shapesetName the shapeset name
	 * @return the shapeset path
	 */
	public static String getShapesetPath(String shapesetName) {
		return  shapesetName + "/shapeset.txt";
	}
	
	/**
	 * Gets the shapeset icon path.
	 *
	 * @param shapesetName the shapeset name
	 * @return the shapeset icon path
	 */
	public static String getShapesetIconPath(String shapesetName) {
		return shapesetName + "/icon.png";
	}
	
	/**
	 * Gets the puzzle path.
	 *
	 * @param shapesetName the shapeset name
	 * @param puzzleName the puzzle name
	 * @return the puzzle path
	 */
	public static String getPuzzlePath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/puzzle.txt";
	}
	
	/**
	 * Gets the puzzle icon path.
	 *
	 * @param shapesetName the shapeset name
	 * @param puzzleName the puzzle name
	 * @return the puzzle icon path
	 */
	public static String getPuzzleIconPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/icon.jpeg";
	}
	
	/**
	 * Gets the puzzle solution path.
	 *
	 * @param shapesetName the shapeset name
	 * @param puzzleName the puzzle name
	 * @return the puzzle solution path
	 */
	public static String getPuzzleSolutionPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/solution.txt";
	}
}
