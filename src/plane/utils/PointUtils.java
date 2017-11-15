package plane.utils;

import java.awt.Point;

public class PointUtils {
	public final static int THRESHOLD = 5;
	
	public static boolean equals(Point pointA, Point pointB) {
		return (Math.abs(pointA.x-pointB.x)<=THRESHOLD) && (Math.abs(pointA.y-pointB.y)<=THRESHOLD);
	}
	
	public static String toString(Point p) {
		return "x: " + (int)p.getX() + ", y: " + (int)p.getY();
	}
}
