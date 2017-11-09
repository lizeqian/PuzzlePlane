package plane.utils;

import java.awt.Color;

public class ColorUtils {

	public static Color copy(Color color) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue());
	}

}
