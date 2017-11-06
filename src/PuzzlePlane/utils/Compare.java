package PuzzlePlane.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;


public class Compare {
	public Compare( ) {
		
	}
	
	public static boolean compare(int thrd, Point pointA, Point pointB) {
		return (Math.abs(pointA.x-pointB.x)<=thrd) && (Math.abs(pointA.y-pointB.y)<=thrd);
	}
	
	public static boolean contains(Polygon shape, Point point){
		int numPoints = shape.npoints;
		boolean isCo = false;
		for (int i=0; i < numPoints; i++) {
			Point p0 = new Point(shape.xpoints[i], shape.ypoints[i]);
			if (compare(5, p0, point)) {
			isCo = true;
			break;
			}
		}
		return isCo;
	}
	
	public static boolean compare (Polygon shapeA, Polygon shapeB) {
		boolean isCo = true;
		int numPointA = shapeA.npoints;
		for(int i=0;i<numPointA;i++) {
			Point p = new Point(shapeA.xpoints[i], shapeA.ypoints[i]);
			if (contains(shapeB, p) == false) {
				isCo = false;
			}
		}		
		return isCo;
	}
	
	public static boolean contains(List<Polygon> shapes, Polygon shape) {
		boolean isIn = false;
		Polygon hitShape = new Polygon();
		for (Polygon s : shapes) {
			if(compare(shape, s)) {
				isIn = true;
				hitShape = s;
				break;
			}
		}
		shapes.remove(hitShape);
		return isIn;
		
	}
}
