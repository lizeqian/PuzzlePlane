package plane.models;

import java.util.List;

public class Puzzle{

	public List<PlacedShape> puzzleShape;
	public String name;

	public String toString() {
		String ret = "";
		for(PlacedShape shape : puzzleShape) {
			ret += shape.toString() + "\n";
		}
		return ret;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Puzzle(String name) {
		this.name = name;
	}
	
	public void setShape(List<PlacedShape> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	public List<PlacedShape> getPuzzleShape() {
		return this.puzzleShape;
	}

}