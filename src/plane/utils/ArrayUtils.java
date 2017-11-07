package plane.utils;

public class ArrayUtils {

	public ArrayUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static int min(int[] arr, int len) {
		if(len == 0) return 0;
		int ret = arr[0];
		for(int i = 1; i < len; i++) {
			if(arr[i] < ret) ret = arr[i];
		}
		return ret;
	}
	
	public static int max(int[] arr, int len) {
		if(len == 0) return 0;
		int ret = arr[0];
		for(int i = 1; i < len; i++) {
			if(arr[i] > ret) ret = arr[i];
		}
		return ret;
	}
	
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
