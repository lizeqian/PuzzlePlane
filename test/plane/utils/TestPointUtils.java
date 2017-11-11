package plane.utils;

import java.awt.Point;

import junit.framework.TestCase;

public class TestPointUtils extends TestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testEquals() {
		Point p1 = new Point(30, 30);
		Point p2 = new Point(33, 27);
		Point p3 = new Point(1, 50);
		Point p4 = new Point(21, 50);
		Point p5 = new Point(50, 21);
		assertTrue(PointUtils.equals(p1, p2));
		assertFalse(PointUtils.equals(p1, p3));
		assertFalse(PointUtils.equals(p1, p4));
		assertFalse(PointUtils.equals(p1, p5));
	}

}
