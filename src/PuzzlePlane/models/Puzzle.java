package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;

import PuzzlePlane.controllers.PuzzleShapeLoader;

public class Puzzle{
	PlacedShape puzzleShape;
	PlacedShape solution;
	PlacedShape lastSolution;
	boolean isSolved;
	int order;
	
	//TODO: change the file path of puzzleShape
	static String puzzleShapePath = "puzzleShape.txt";
	
	public void init() {
		//TODO: change puzzleShape into "public Puzzle(PlacedShape puzzleShape)";
		puzzleShape = (new PuzzleShapeLoader(Puzzle.puzzleShapePath)).load();
	}
	
	public Puzzle() {
		init();
	}
	
	public PlacedShape getPuzzleShape() {
		return this.puzzleShape;
	}
	
	public void setPuzzleShape(PlacedShape puzzleShape) {
		//TODO: set puzzleShape, avoid shallow copy.
	}
}