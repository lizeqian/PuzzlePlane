package plane.utils;

import java.awt.Point;
import java.awt.Polygon;

import junit.framework.TestCase;

public class TestPolygonUtils extends TestCase {
	
	Polygon polygon;
	Polygon emptyPolygon;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		emptyPolygon = new Polygon();
		polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 10);
		polygon.addPoint(0, 10);
		polygon.addPoint(0, 0);
	}
	
	public void testToString() {
		assertEquals(PolygonUtils.toString(emptyPolygon), "npoints: 0\n");
		assertEquals(PolygonUtils.toString(polygon), "npoints: 4\n"
										+ "x: 0, y: 0\n"
										+ "x: 10, y: 10\n"
										+ "x: 0, y: 10\n"
										+ "x: 0, y: 0\n");
	}
	
	public void testCopy() {
		assertEquals(PolygonUtils.copy(null), null);
		assertEquals(PolygonUtils.toString(PolygonUtils.copy(emptyPolygon)), PolygonUtils.toString(emptyPolygon));
		assertEquals(PolygonUtils.toString(PolygonUtils.copy(polygon)), PolygonUtils.toString(polygon));
	}
	
	public void testGetCenter() {
		assertEquals(PointUtils.toString(PolygonUtils.getCenter(emptyPolygon)), PointUtils.toString(new Point(0, 0)));
		assertEquals(PointUtils.toString(PolygonUtils.getCenter(polygon)), PointUtils.toString(new Point(3, 6)));
	}
	
	public void testRotate() {
		
	}

}
