package PuzzlePlane.models;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import PuzzlePlane.utils.ArrayUtils;

public class Puzzle{

	List<PlacedShape> puzzleShape;
//	PlacedShape puzzleShape;
	
	PlacedShape lastSolution;
	boolean isSolved;
	
	public Puzzle(List<PlacedShape> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	public Puzzle() {
	}
	
	public void setShape(List<PlacedShape> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	public List<PlacedShape> getPuzzleShape() {
		return this.puzzleShape;
	}

}