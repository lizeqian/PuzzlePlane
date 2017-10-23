package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;

public class Puzzle{
	PlacedShape puzzleShape;
	PlacedShape solution;
	PlacedShape lastSolution;
	boolean isSolved;
	int order;
	
	public void init() {
		//TODO: change puzzleShape into "public Puzzle(PlacedShape puzzleShape)";
		puzzleShape = new PlacedShape(new Point(), false, false, 0, -1, false, false, Color.black);
		
		int offset_x = 200;
		int offset_y = 200;
		
		puzzleShape.addPoint(offset_x, offset_y);
		puzzleShape.addPoint(offset_x + 300, offset_y);
		puzzleShape.addPoint(offset_x + 300, offset_y + 300);
		puzzleShape.addPoint(offset_x, offset_y + 300);
		puzzleShape.addPoint(offset_x, offset_y);
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