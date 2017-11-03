package PuzzlePlane.models;

import java.util.List;
import PuzzlePlane.controllers.*;

public class ShapeSet{
	List<Puzzle> puzzles;
	List<PlacedShape> shapes;
	
	public ShapeSet(String path) {
		shapes = (new ShapesetLoader(path)).load();
	}
	
	public void addShape() {
		
	}
	
	public void addPuzzle() {
		
	}
}