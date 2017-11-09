package plane.models;

import java.awt.Color;

import junit.framework.TestCase;

public class TestShapeStatus extends TestCase {
	
	public void testColorConstructor() {
		try {
			Color color = new Color(255, 0, 0);
			ShapeStatus shapeStatus = new ShapeStatus(color);
			assertEquals(shapeStatus.toString(), "angle: 0\n" 
												+ "onPalette: true\n" 
												+ "selected: false\n"
												+ "red: 255\n"
												+ "green: 0\n"
												+ "blue: 0\n"
												+ "verticalFlipped: false\n"
												+ "horizontalFlipped: false\n"
												+ "x: 0\n"
												+ "y: 0\n");
			
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
