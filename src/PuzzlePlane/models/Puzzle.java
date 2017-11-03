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
	String puzzleShapePath;
	
	public Puzzle(String path) {
		puzzleShapePath = path;
		puzzleShape = (new PuzzleShapeLoader(puzzleShapePath)).load();
	}
	
	public PlacedShape getPuzzleShape() {
		return this.puzzleShape;
	}
	
	public void setPuzzleShape(PlacedShape puzzleShape) {
		this.puzzleShape = puzzleShape;
		//TODO: set puzzleShape, avoid shallow copy.
	}

	public String getPath() {
		return this.puzzleShapePath;
	}
	
	public void setPath(String puzzlePath) {
		this.puzzleShapePath = puzzlePath;
	}
}