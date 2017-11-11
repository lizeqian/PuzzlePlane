package plane.utils;

import junit.framework.TestCase;

public class TestArrayUtils extends TestCase {
	
	int[] arr = {32,10,3,2,10,1000};
	int[] arr2 = {};
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testMin() {
		assertEquals(ArrayUtils.min(arr, arr.length), 2);
		assertEquals(ArrayUtils.min(arr2, arr2.length), 0);
	}
	
	public void testMax() {
		assertEquals(ArrayUtils.max(arr, arr.length), 1000);
		assertEquals(ArrayUtils.max(arr2, arr2.length), 0);
	}
	
	public void testAvg() {
		assertEquals(ArrayUtils.avg(arr, arr.length), 176);
		assertEquals(ArrayUtils.avg(arr2, arr2.length), 0);
	}

}
