package plane.utils;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class TestArrayUtils.
 */
public class TestArrayUtils extends TestCase {
	
	/** The arr. */
	int[] arr = {32,10,3,2,10,1000};
	
	/** The arr 2. */
	int[] arr2 = {};
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test min.
	 */
	public void testMin() {
		assertEquals(ArrayUtils.min(arr, arr.length), 2);
		assertEquals(ArrayUtils.min(arr2, arr2.length), 0);
	}
	
	/**
	 * Test max.
	 */
	public void testMax() {
		assertEquals(ArrayUtils.max(arr, arr.length), 1000);
		assertEquals(ArrayUtils.max(arr2, arr2.length), 0);
	}
	
	/**
	 * Test avg.
	 */
	public void testAvg() {
		assertEquals(ArrayUtils.avg(arr, arr.length), 176);
		assertEquals(ArrayUtils.avg(arr2, arr2.length), 0);
	}

}
