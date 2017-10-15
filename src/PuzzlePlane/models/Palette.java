package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;


public class Palette {
	ShapeSet shapeSet;
	
	ArrayList<PolyShape> Shapes = new ArrayList<PolyShape>();
	Point shapePos_1;
	
	public Palette( ) {
		this.shapePos_1.setLocation(10.0, 10.0);
	}
	
	public void addPlacedShape( ) {
		
	}
	
	public void addShape(PolyShape s) {
		this.Shapes.add(s);		
	}
	
	public void removeShape() {
		
	}
}