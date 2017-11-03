package PuzzlePlane.models;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import PuzzlePlane.utils.ArrayUtils;

public class Puzzle{
	List<Polygon> puzzleShape;
	PlacedShape lastSolution;
	boolean isSolved;
	
	public Puzzle(List<Polygon> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	public Puzzle() {
	}
	
	public void setShape(List<Polygon> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	public List<Polygon> getPuzzleShape() {
		return this.puzzleShape;
	}
	
}