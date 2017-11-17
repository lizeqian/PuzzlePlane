package plane.utils;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * The Class TestColorUtils.
 * @author cheng zhu
 */
public class TestColorUtils extends TestCase {
	
	/** The color. */
	public Color color;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test copy method.
	 */
	public void testCopy() {
		color = Color.cyan;
		assertEquals(ColorUtils.copy(color).toString(), color.toString());
	}
}
