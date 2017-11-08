package plane.models;

import junit.framework.TestCase;

public class TestShapeSet extends TestCase {
	public void testGetName() {
		ShapeSet s = new ShapeSet("testShapeSet");
		String setName = "setName";
		s.setName(setName);
		assertEquals(setName, s.getName());
		
	}
}
