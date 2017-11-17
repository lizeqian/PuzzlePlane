package plane.utils;

import java.awt.Color;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class TestColorUtils.
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
	 * Test copy.
	 */
	public void testCopy() {
		color = Color.cyan;
		assertEquals(ColorUtils.copy(color).toString(), color.toString());
	}
}
