package plane.models;

import java.util.List;

import junit.framework.TestCase;


/**
 * The Class TestShapeset.
 */
public class TestShapeset extends TestCase {
	
	/** The shapeset. */
	Shapeset shapeset;
	
	/** The names of the puzzles. */
	String[] names = {"bird", "cristal", "dog", "dontknow", "duck", "fish", "fox", "house", "rabbit", "turtle"};
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		shapeset = new Shapeset("traditional");
	}
	
	/**
	 * Test all.
	 */
	public void testAll() {
		assertEquals(shapeset.toString(), "name: traditional\npuzzles: 10\n");
	}

}
