package plane.models;

import java.util.List;

public class Puzzle{
	
	public String name;
	public ShapeSet shapeset;
	public List<PlacedShape> puzzleShape;
	public List<PlacedShape> lastSolution;
	public boolean isSolved;
	
	public List<PlacedShape> getLastSolution() {
		return lastSolution;
	}

	public void setLastSolution(List<PlacedShape> lastSolution) {
		this.lastSolution = lastSolution;
	}
	
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