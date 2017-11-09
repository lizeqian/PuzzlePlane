package plane.models;

import java.awt.Color;

import junit.framework.TestCase;

public class TestShapeStatus extends TestCase {
	public void testColorConstructor() {
		try {
			Color color = new Color(255, 0, 0);
			ShapeStatus shapeStatus = new ShapeStatus(color);
			assertEquals(shapeStatus.toString(), "123");
			
			color = null;
			shapeStatus = new ShapeStatus(color);
			fail("Should not construct with a null Color");
			
		} catch (RuntimeException e) {
			
		}
	}
	
	public void testShapeStatusConstructor() {
		try {
			ShapeStatus shapeStatus = null;
			ShapeStatus status = new ShapeStatus(shapeStatus);
		} catch (RuntimeException e) {
			
		}
	}
	
	public void testReset() {
	}
	
}
