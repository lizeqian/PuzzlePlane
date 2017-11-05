package PuzzlePlane.utils;

import java.awt.Point;
import java.awt.Polygon;

public class PolygonUtils {
	
	public static Polygon copy(Polygon polygon) {
		if(polygon == null) return null;
		return new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
	}
	
	public static Point getCenter(Polygon polygon) {
		if(polygon.npoints == 0) return new Point(0, 0);
		int x = 0, y = 0;
		for(int i = 0; i < polygon.npoints; i++) {
			x += polygon.xpoints[i];
			y += polygon.ypoints[i];
		}
		x /= polygon.npoints;
		y /= polygon.npoints;
		return new Point(x, y);
	}
	
	public static void rotate(Polygon polygon, int angle) {
		Point center = PolygonUtils.getCenter(polygon);
		double ang = (angle * 1.0 / 180.0) * Math.PI;
		double cosAngle = Math.cos(ang);
		double sinAngle = Math.sin(ang);
		
		for(int i = 0; i < polygon.npoints; i++) {
			double dx = polygon.xpoints[i] - center.x;
			double dy = polygon.ypoints[i] - center.y;
		
			polygon.xpoints[i] = center.x + (int)Math.round(dx * cosAngle - dy * sinAngle);
			polygon.ypoints[i] = center.y + (int)Math.round(dx * sinAngle + dy * cosAngle);
		}
	}
	
	public static void vFlip(Polygon polygon) {
		Point center = PolygonUtils.getCenter(polygon);
		for(int i = 0; i < polygon.npoints; i++) {
			polygon.ypoints[i] = 2 * center.y - polygon.ypoints[i];
		}
	}
	
	public static void hFlip(Polygon polygon) {
		Point center = PolygonUtils.getCenter(polygon);
		for(int i = 0; i < polygon.npoints; i++) {
			polygon.xpoints[i] = 2 * center.x - polygon.xpoints[i];
		}
	}
}
