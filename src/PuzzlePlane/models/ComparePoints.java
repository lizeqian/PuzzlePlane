package PuzzlePlane.models;

import java.awt.Point;
import java.lang.*;

public class ComparePoints {
	Point pointA;
	Point pointB;
	int threshold;
	
	public void ComparePoints(){
		this.threshold = 5;
	}
	
	public void setPoints(Point a, Point b) {
		this.pointA = a;
		this.pointB = b;
	}
	
	public void setThreshold(int t) {
		this.threshold = t;
	}
	
	public boolean isCoincided() {
		return (Math.abs(this.pointA.x-this.pointB.x)<=this.threshold) && (Math.abs(this.pointA.y-this.pointB.y)<=this.threshold);
	}
}