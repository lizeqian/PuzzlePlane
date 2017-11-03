package PuzzlePlane.models;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import PuzzlePlane.utils.ArrayUtils;

public class Puzzle{
<<<<<<< HEAD
	List<PlacedShape> puzzleShape;
//	PlacedShape puzzleShape;
=======
	List<Polygon> puzzleShape;
>>>>>>> branch 'master' of https://github.com/lizeqian/PuzzlePlane.git
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
<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/lizeqian/PuzzlePlane.git
}