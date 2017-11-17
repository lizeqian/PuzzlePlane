package plane.utils;

import java.awt.Color;

/**
 * Define utility methods to operate java,awt.Color class.
 * @author cheng zhu 
 *
 */
public class ColorUtils {
	
	/**
	 * Returns a copy of a java.awt.Color
	 * @param color the color
	 * @return the copy of the color
	 */
	public static Color copy(Color color) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue());
	}

}
