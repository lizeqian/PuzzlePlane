package plane.utils;

import java.awt.Point;

import junit.framework.TestCase;


/**
 * The Class TestPointUtils.
 */
public class TestPointUtils extends TestCase {
	
	/** The page 1, which is the shapeset selection view. */
	Point p1;
	
	/** The page 2, which is the. */
	Point p2;
	
	/** The page 3. */
	Point p3;
	
	/** The page 4. */
	Point p4;
	
	/** The page 5. */
	Point p5;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 * set up Points to test
	 */
	protected void setUp() throws Exception {
		super.setUp();
		p1 = new Point(30, 30);
		p2 = new Point(33, 27);
		p3 = new Point(1, 50);
		p4 = new Point(21, 50);
		p5 = new Point(50, 21);
	}
	
	/**
	 * Test equals.
	 */
	public void testEquals() {
		assertTrue(PointUtils.equals(p1, p2));
		assertFalse(PointUtils.equals(p1, p3));
		assertFalse(PointUtils.equals(p1, p4));
		assertFalse(PointUtils.equals(p1, p5));
	}
	
	/**
	 * Test toString.
	 */
	public void testToString() {
		assertEquals(PointUtils.toString(p1), "x: 30, y: 30");
		assertEquals(PointUtils.toString(p4), "x: 21, y: 50");
	}

}
