package plane.models;

import java.util.List;

import junit.framework.TestCase;

public class TestShapeset extends TestCase {
	
	Shapeset shapeset;
	String[] names = {"bird", "cristal", "dog", "dontknow", "duck", "fish", "fox", "house", "rabbit", "turtle"};
	
	protected void setUp() throws Exception {
		super.setUp();
		shapeset = new Shapeset("traditional");
	}
	
	public void testAll() {
		assertEquals(shapeset.toString(), "name: traditional\npuzzles: 10\n");
	}

}
