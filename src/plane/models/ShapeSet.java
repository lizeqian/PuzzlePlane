package plane.models;

import java.util.List;

public class ShapeSet{
	public String name;
	public List<Puzzle> puzzles;
	
	public List<Puzzle> getPuzzles() {
		return puzzles;
	}

	public ShapeSet(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}