package plane.models;

import java.util.List;

public class Puzzle{

	List<PlacedShape> puzzleShape;
	List<PlacedShape> lastSolution;
	public List<PlacedShape> getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(List<PlacedShape> lastSolution) {
		this.lastSolution = lastSolution;
	}

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