package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;


public class Palette {
	ShapeSet shapeSet;
	
	ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
	ArrayList<Point> shapePos = new ArrayList<Point>(); //Fixed Positions
	int order;
	
	public Palette( ) {
		Point firstPos = new Point();
		firstPos.setLocation(20.0, 50.0);
		this.shapePos.add(firstPos);
		this.order = 0;
	}
	
	public void addPlacedShape(PolyShape s) {
		PlacedShape placedShape = new PlacedShape(this.shapePos.get(0), s, false, false, 0);
		this.shapes.add(placedShape);
	}
	
	public ArrayList<PlacedShape> getShapes() {
		return this.shapes;
	}
	
	public void removeShape() {
		
	}
}