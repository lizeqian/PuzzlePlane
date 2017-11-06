package PuzzlePlane.controllers;

import java.awt.Polygon;
import java.util.List;

public class CompareShapeInList {
	List<Polygon> shapes;
	Polygon shape;
	
	public CompareShapeInList(List<Polygon> shapes, Polygon shape) {
		this.shape = shape;
		this.shapes = shapes;
	}
	
	public boolean compare() {
		boolean isIn = false;
		Polygon hitShape = new Polygon();
		for (Polygon s:this.shapes) {
			if(new CompareShapeShape(this.shape, s).compare()) {
				isIn = true;
				hitShape = s;
				break;
			}
		}
		this.shapes.remove(hitShape);
		return isIn;
	}
}
