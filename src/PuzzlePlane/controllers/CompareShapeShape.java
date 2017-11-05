package PuzzlePlane.controllers;

import java.awt.Point;
import java.awt.Polygon;


class CompareShapeShape {
	Polygon shapeA;
	Polygon shapeB;
	
	public CompareShapeShape(Polygon a, Polygon b) {
		this.shapeA = a;
		this.shapeB = b;
	}
	
	public boolean compare() {
		boolean isCo = true;
		int numPointA = this.shapeA.npoints;
		for(int i=0;i<numPointA;i++) {
			Point p = new Point(this.shapeA.xpoints[i], this.shapeA.ypoints[i]);
			if (new ComparePointShape(this.shapeB, p).isCoincided() == false) {
				isCo = false;
			}
		}		
		return isCo;
	}
}
