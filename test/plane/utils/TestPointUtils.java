package plane.utils;

import java.awt.Point;

import junit.framework.TestCase;

public class TestPointUtils extends TestCase {
	
	Point p1;
	Point p2;
	Point p3;
	Point p4;
	Point p5;
	
	protected void setUp() throws Exception {
		super.setUp();
		p1 = new Point(30, 30);
		p2 = new Point(33, 27);
		p3 = new Point(1, 50);
		p4 = new Point(21, 50);
		p5 = new Point(50, 21);
	}
	
	public void testEquals() {
		assertTrue(PointUtils.equals(p1, p2));
		assertFalse(PointUtils.equals(p1, p3));
		assertFalse(PointUtils.equals(p1, p4));
		assertFalse(PointUtils.equals(p1, p5));
	}
	
	public void testToString() {
		assertEquals(PointUtils.toString(p1), "x: 30, y: 30");
		assertEquals(PointUtils.toString(p4), "x: 21, y: 50");
	}

}
