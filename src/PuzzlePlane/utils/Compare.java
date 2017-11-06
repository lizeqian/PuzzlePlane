package PuzzlePlane.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;


public class Compare {
	public Compare( ) {
		
	}
	
	public static boolean comparePoints(int thrd, Point pointA, Point pointB) {
		return (Math.abs(pointA.x-pointB.x)<=thrd) && (Math.abs(pointA.y-pointB.y)<=thrd);
	}
	
	public static boolean comparePointShape(Polygon shape, Point point){
		int numPoints = shape.npoints;
		boolean isCo = false;
		for (int i=0; i < numPoints; i++) {
			Point p0 = new Point(shape.xpoints[i], shape.ypoints[i]);
			if (comparePoints(5, p0, point)) {
			isCo = true;
			break;
			}
		}
		return isCo;
	}
	
	public static boolean compareShapeShape (Polygon shapeA, Polygon shapeB) {
		boolean isCo = true;
		int numPointA = shapeA.npoints;
		for(int i=0;i<numPointA;i++) {
			Point p = new Point(shapeA.xpoints[i], shapeA.ypoints[i]);
			if (comparePointShape(shapeB, p) == false) {
				isCo = false;
			}
		}		
		return isCo;
	}
	
	public static boolean compareShapeInList(List<Polygon> shapes, Polygon shape) {
		boolean isIn = false;
		Polygon hitShape = new Polygon();
		for (Polygon s:shapes) {
			if(compareShapeShape(shape, s)) {
				isIn = true;
				hitShape = s;
				break;
			}
		}
		shapes.remove(hitShape);
		return isIn;
		
	}
}
