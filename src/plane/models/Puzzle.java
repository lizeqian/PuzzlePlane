package plane.models;

import java.util.List;

public class Puzzle{

	public List<PlacedShape> puzzleShape;

	public String toString() {
		String ret = "";
		for(PlacedShape shape : puzzleShape) {
			ret += shape.toString() + "\n";
		}
		return ret;
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