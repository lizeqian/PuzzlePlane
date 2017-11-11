package plane.utils;

import java.awt.Color;

import junit.framework.TestCase;

public class TestColorUtils extends TestCase {
	
	public Color color;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testCopy() {
		color = Color.cyan;
		assertEquals(ColorUtils.copy(color).toString(), color.toString());
	}
}
