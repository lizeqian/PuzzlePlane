package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;

public class PolyShape{
	ArrayList<Point> points = new ArrayList<Point>();
	Color color;
	
	public PolyShape ( ) {
		
	}
	
	public void addPoint (Point p) {
		this.points.add(p);
	}
}