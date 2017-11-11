package plane.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

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
		Polygon rotatePolygon = PolygonUtils.copy(polygon);
		PolygonUtils.rotate(rotatePolygon, 90);
		
		Polygon correct = new Polygon();
		correct.addPoint(10, 2);
		correct.addPoint(0, 12);
		correct.addPoint(0, 2);
		correct.addPoint(10, 2);
		assertEquals(rotatePolygon.npoints, correct.npoints);
		for(int i = 0; i < correct.npoints; i++) {
			assertTrue(Math.abs(rotatePolygon.xpoints[i] - correct.xpoints[i]) < 2);
			assertTrue(Math.abs(rotatePolygon.ypoints[i] - correct.ypoints[i]) < 2);
		}
	}
	
	public void testHFlip() {
		Polygon h = PolygonUtils.copy(polygon);
		PolygonUtils.hFlip(h);
		
		Polygon correct = new Polygon();
		correct.addPoint(6, 0);
		correct.addPoint(-4, 10);
		correct.addPoint(6, 10);
		correct.addPoint(6, 0);
		assertEquals(PolygonUtils.toString(h), PolygonUtils.toString(correct));
	}
	
	public void testVFlip() {
		Polygon v = PolygonUtils.copy(polygon);
		PolygonUtils.vFlip(v);
		
		Polygon correct = new Polygon();
		correct.addPoint(0, 12);
		correct.addPoint(10, 2);
		correct.addPoint(0, 2);
		correct.addPoint(0, 12);
		assertEquals(PolygonUtils.toString(v), PolygonUtils.toString(correct));
	}
	
	public void testContains() {
		assertTrue(PolygonUtils.contains(polygon, new Point(1, 4)));
		assertFalse(PolygonUtils.contains(polygon, new Point(2, 30)));
		
		List<Polygon> list = new ArrayList<>();
		
		Polygon another = new Polygon();
		another.addPoint(100, 100);
		another.addPoint(100, 120);
		another.addPoint(100, 130);
		another.addPoint(100, 100);
		
		assertFalse(PolygonUtils.contains(list, polygon));
		list.add(another);
		list.add(PolygonUtils.copy(polygon));
		assertTrue(PolygonUtils.contains(list, polygon));
	}
	
	public void testEquals() {
		assertFalse(PolygonUtils.equals(polygon, emptyPolygon));
		assertTrue(PolygonUtils.equals(polygon, PolygonUtils.copy(polygon)));
		assertTrue(PolygonUtils.equals(polygon, polygon));
	}
	
}
