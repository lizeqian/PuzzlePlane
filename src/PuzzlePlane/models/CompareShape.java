package PuzzlePlane.models;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

public class CompareShape{
	List<Point> solution;
	List<PlacedShape> shapes;
	
	public void PuzzleSolution(List<Point> points, List<PlacedShape> shapes) {
		this.solution = new ArrayList<Point> ();
		this.shapes = new ArrayList<PlacedShape>();
		this.solution = points;
		this.shapes = shapes;
	}
	
	public void PuzzleSolution() {
		this.solution = new ArrayList<Point> ();
		this.shapes = new ArrayList<PlacedShape>();
	}
	
	public void addPoint(Point p) {
		this.solution.add(p);
	}
	
	public void addShape(PlacedShape p) {
		this.shapes.add(p);
	}
	 
}