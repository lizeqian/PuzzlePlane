package plane.utils;

/**
 * Define utility methods for arrays
 * @author cheng zhu
 *
 */
public class ArrayUtils {
	
	/**
	 * Returns the smallest integer in an integer array.
	 * 
	 * @param arr the integer array
	 * @param len the length of the array
	 * @return the smallest integer in the array
	 */
	public static int min(int[] arr, int len) {
		if(len == 0) return 0;
		int ret = arr[0];
		for(int i = 1; i < len; i++) {
			if(arr[i] < ret) ret = arr[i];
		}
		return ret;
	}
	
	/**
	 * Return the biggest integer in an integer array
	 * @param arr the integer array
	 * @param len the length of the array
	 * @return the biggest integer in the array
	 */
	public static int max(int[] arr, int len) {
		if(len == 0) return 0;
		int ret = arr[0];
		for(int i = 1; i < len; i++) {
			if(arr[i] > ret) ret = arr[i];
		}
		return ret;
	}
	
	/**
	 * Returns the average value of an integer array
	 * @param arr the integer array
	 * @param len the length of the array
	 * @return an integer representing the average value of the array
	 */
	public static int avg(int[] arr, int len) {
		if(len == 0) return 0;
		int ret = 0;
		for(int i = 0; i < len; i++) {
			ret += arr[i];
		}
		ret /= len;
		return ret;
	}
}
