package PuzzlePlane.models;

import java.util.ArrayList;

public class SolutionSpace {
	ShapeSet shapeSet;
	ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
	Puzzle puzzle;
	boolean success;
	
	public SolutionSpace() {
	}
	
	public void setShapeSet(ShapeSet s) {
		this.shapeSet = s;
	}
	
	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
	}
	
	public void addPlacedShape(PlacedShape s) {
		this.shapes.add(s);
	}
	
	public void removePlacedShape(PlacedShape s) {
		this.shapes.remove(s);
	}
	
	public void selectShape( ) {
		
	}
	
	public void addShape() {
		
	}
	
	public void removeShape() {
		
	}
}