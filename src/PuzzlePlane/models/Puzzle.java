package PuzzlePlane.models;

public class Puzzle{
	PlacedShape puzzleShape;
	PlacedShape lastSolution;
	boolean isSolved;
	
	public Puzzle(PlacedShape puzzleShape) {
		this.puzzleShape = new PlacedShape(puzzleShape);
	}
	
	public PlacedShape getPuzzleShape() {
		return this.puzzleShape;
	}
	
	public void setPuzzleShape(PlacedShape puzzleShape) {
		this.puzzleShape = new PlacedShape(puzzleShape);
		//TODO: set puzzleShape, avoid shallow copy.
	}
}