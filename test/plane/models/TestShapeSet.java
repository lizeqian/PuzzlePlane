package plane.models;

import junit.framework.TestCase;

public class TestShapeSet extends TestCase {
	public void testConstructor() {
		String setName = "setName";
		ShapeSet s = new ShapeSet(setName);
		assertEquals(s.name, setName);
	}
	
	public void testGetName() {
		ShapeSet s = new ShapeSet("testShapeSet");
		String setName = "setName";
		s.setName(setName);
		assertEquals(setName, s.getName());
		
	}
}
