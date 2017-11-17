package plane.utils;

import java.awt.Point;

/**
 * Define methods to operate java.awt.Point class.
 * @author cheng zhu
 *
 */
public class PointUtils {
	/** The THRESHOLD for equality method */
	public final static int THRESHOLD = 5;
	
	/**
	 * Returns true if two Points are equal within the THRESHOLD range.
	 * @param pointA the first Point
	 * @param pointB the second Point
	 * @return true if two Points are equal
	 */
	public static boolean equals(Point pointA, Point pointB) {
		return (Math.abs(pointA.x-pointB.x)<=THRESHOLD) && (Math.abs(pointA.y-pointB.y)<=THRESHOLD);
	}
	
	/**
	 * Returns a String representing the coordinates of the Point
	 * @param p the Point
	 * @return a String representing the coordinates of the Point
	 */
	public static String toString(Point p) {
		return "x: " + (int)p.getX() + ", y: " + (int)p.getY();
	}
}
