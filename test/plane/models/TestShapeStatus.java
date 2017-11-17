package plane.models;

import java.awt.Color;

import junit.framework.TestCase;


/**
 * The Class TestShapeStatus.
 */
public class TestShapeStatus extends TestCase {
	
	/**
	 * Test color constructor.
	 */
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
	
	/**
	 * Test shape status constructor.
	 */
	public void testShapeStatusConstructor() {
		try {
			ShapeStatus shapeStatus = null;
			ShapeStatus status = new ShapeStatus(shapeStatus);
		} catch (RuntimeException e) {
			
		}
	}
	
	/**
	 * Test reset.
	 */
	public void testReset() {
		ShapeStatus status = new ShapeStatus(new Color(200, 1, 1));
		status.setOnPalette(false);
		status.setPosition(10, 20);
		status.hFlip();
		status.vFlip();
		status.select();
		status.rotate(30);
		assertEquals(status.toString(), "angle: 30\n" 
										+ "onPalette: false\n" 
										+ "selected: true\n"
										+ "red: 200\n"
										+ "green: 1\n"
										+ "blue: 1\n"
										+ "verticalFlipped: true\n"
										+ "horizontalFlipped: true\n"
										+ "x: 10\n"
										+ "y: 20\n");
		
		status.reset();
		
		assertEquals(status.toString(), "angle: 0\n" 
										+ "onPalette: true\n" 
										+ "selected: false\n"
										+ "red: 200\n"
										+ "green: 1\n"
										+ "blue: 1\n"
										+ "verticalFlipped: false\n"
										+ "horizontalFlipped: false\n"
										+ "x: 0\n"
										+ "y: 0\n");
	}
	
	/**
	 * Test copy.
	 */
	public void testCopy() {
		ShapeStatus status = new ShapeStatus(new Color(200, 1, 1));
		status.setOnPalette(false);
		status.setPosition(105, 20);
		status.hFlip();
		status.rotate(60);
		
		ShapeStatus copy = status.copy();
		assertEquals(status.toString(), copy.toString());
	}
	
	/**
	 * Test flip.
	 */
	public void testFlip() {
		ShapeStatus status = new ShapeStatus(new Color(100, 100, 100));
		status.vFlip();
		status.vFlip();
		status.hFlip();
		status.hFlip();
		
		assertEquals(status.toString(), "angle: 0\n" 
											+ "onPalette: true\n" 
											+ "selected: false\n"
											+ "red: 100\n"
											+ "green: 100\n"
											+ "blue: 100\n"
											+ "verticalFlipped: false\n"
											+ "horizontalFlipped: false\n"
											+ "x: 0\n"
											+ "y: 0\n");
	}
	
}
