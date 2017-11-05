package PuzzlePlane.controllers;

import java.awt.Point;
import java.awt.Polygon;


public class ComparePointShape {
	Polygon shape;
	Point point;
	
	public ComparePointShape(Polygon s, Point p){
		this.shape = s;
		this.point = p;
	}
	
	public boolean isCoincided() {
		int numPoints = this.shape.npoints;
		boolean isCo = true;
		for (int i=0; i < numPoints; i++) {
			Point p0 = new Point(this.shape.xpoints[i], this.shape.ypoints[i]);
			if (new ComparePoints(5, p0, this.point).isCoincided() == false) {
				isCo = false;
			}
		}
		return isCo;
	}
}