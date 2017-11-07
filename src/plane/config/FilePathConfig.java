package plane.config;

public class FilePathConfig {
	
	public static String getSolvedPuzzleIconPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/solvedPuzzleIcon.jpg";
	}
	
	public static String getShapesetPath(String shapesetName) {
		return  shapesetName + "/shapeset.txt";
	}
	
	public static String getShapesetIconPath(String shapesetName) {
		return shapesetName + "/icon.png";
	}
	
	public static String getPuzzlePath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/puzzle.txt";
	}
	
	public static String getPuzzleIconPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/icon.jpeg";
	}
	
	public static String getPuzzleSolutionPath(String shapesetName, String puzzleName) {
		return shapesetName + "/" + puzzleName + "/solution.txt";
	}
}
