package PuzzlePlane.controllers;

import java.util.List;

import PuzzlePlane.models.PlacedShape;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class CompareShape{
	Polygon shapeA;
	Polygon shapeB;
	
	public CompareShape() {
	}
	
	public CompareShape(Polygon a, Polygon b) {
		this.shapeA = a;
		this.shapeB = b;
	}
	
	public void setShape(Polygon a, Polygon b) {
		this.shapeA = a;
		this.shapeB = b;
	}
	
	public boolean compare() {
		int pointA = this.shapeA.npoints;
		int pointB = this.shapeB.npoints;
		boolean isCo = true;
		
		if (pointA != pointB) {
			return false;
		}
		
		for(int i=0; i<pointA;i++) {
			Point p = new Point(this.shapeA.xpoints[i], this.shapeA.ypoints[i]);
			isCo = new ComparePointShape(this.shapeB, p).isCoincided();
		}
		return isCo;
		
	}
	 
}