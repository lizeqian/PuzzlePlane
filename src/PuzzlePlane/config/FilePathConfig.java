package PuzzlePlane.config;

import java.util.HashMap;
import java.util.Map;

public class FilePathConfig {
	public final static String traditionalImgPath = "/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.00.14 PM.png";
	public final static String nontraditionalImgPath = "/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.10.55 PM.png";
	
	public final static String traditionalShapesetPath = "shapeset.txt";
	public final static String nontraditionalShapesetPath = "shapeset.txt";
	
	public final static String traditionalPuzzleFolder = "puzzle/traditional";
	public final static String nontraditionalPuzzleFolder = "puzzle/nontraditional";
	
	public final static String traditionalSolutionFolder = "solution/traditional";
	public final static String nontraditionalSolutionFolder = "solution/nontraditional";
	
	public final static Map<String, String> puzzleName;
	static {
		puzzleName = new HashMap<>();
		puzzleName.put("fox", "/0.txt");
		puzzleName.put("bird", "/1.txt");
		puzzleName.put("rabbit", "/2.txt");
		puzzleName.put("cristal", "/3.txt");
		puzzleName.put("fish", "/4.txt");
		puzzleName.put("duck", "/5.txt");
		puzzleName.put("dontknow", "/6.txt");
		puzzleName.put("turtle", "/7.txt");
		puzzleName.put("house", "/8.txt");
		puzzleName.put("dog", "/9.txt");
	}
	
	public final static Map<String, String> puzzleImgPath;
	static {
		puzzleImgPath = new HashMap<>();
		puzzleImgPath.put("fox", "/PuzzlePlane/resources/9fox100.jpeg");
		puzzleImgPath.put("bird", "/PuzzlePlane/resources/1bird100.jpg");
		puzzleImgPath.put("rabbit", "/PuzzlePlane/resources/2rabbit.jpeg");
		puzzleImgPath.put("cristal", "/PuzzlePlane/resources/3cristal.jpeg");
		puzzleImgPath.put("fish", "/PuzzlePlane/resources/4fish.jpeg");
		puzzleImgPath.put("duck", "/PuzzlePlane/resources/5duck.jpeg");
		puzzleImgPath.put("dontknow", "/PuzzlePlane/resources/6dontknow.jpeg");
		puzzleImgPath.put("turtle", "/PuzzlePlane/resources/7turtle.jpeg");
		puzzleImgPath.put("house", "/PuzzlePlane/resources/8house100.jpg");
		puzzleImgPath.put("dog", "/PuzzlePlane/resources/10dog100.jpeg");
	}
}
