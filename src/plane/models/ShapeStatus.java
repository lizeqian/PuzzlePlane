package plane.models;

import java.awt.Color;
import java.awt.Point;

import plane.utils.ColorUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ShapeStatus.
 */
public class ShapeStatus {

	/** The angle. */
	int angle;
	
	/** The on palette. */
	boolean onPalette;
	
	/** The selected. */
	boolean selected;
	
	/** The color. */
	Color color;
	
	/** The vertical flipped. */
	boolean verticalFlipped;
	
	/** The horizontal flipped. */
	boolean horizontalFlipped;
	
	/** The position. */
	Point position;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String ret = "";
		ret += "angle: " + angle + "\n";
		ret += "onPalette: " + onPalette + "\n";
		ret += "selected: " + selected + "\n";
		ret += "red: " + color.getRed() + "\ngreen: " + color.getGreen() + "\nblue: " + color.getBlue() + "\n";
		ret += "verticalFlipped: " + verticalFlipped + "\n";
		ret += "horizontalFlipped: " + horizontalFlipped + "\n";
		ret += "x: " + (int)position.getX() + "\ny: " + (int)position.getY() + "\n";
		return ret;
	}
	
	/**
	 * Reset.
	 */
	public void reset() {
		this.position = new Point(0, 0);
		this.verticalFlipped = false;
		this.horizontalFlipped = false;
		this.angle = 0;
		this.onPalette = true;
		this.selected = false;
	}
	
	/**
	 * Inits the.
	 *
	 * @param color the color
	 */
	public void init(Color color) {
		this.reset();
		this.color = ColorUtils.copy(color);
	}
	
	/**
	 * Instantiates a new shape status.
	 *
	 * @param color the color
	 */
	public ShapeStatus(Color color) {
		// TODO Auto-generated constructor stub
		this.init(color);
	}
	
	/**
	 * Instantiates a new shape status.
	 *
	 * @param status the status
	 */
	public ShapeStatus(ShapeStatus status) {
		this.angle = status.getAngle();
		this.onPalette = status.isOnPalette();
		this.selected = status.isSelected();
		this.color = ColorUtils.copy(status.getColor());
		this.verticalFlipped = status.isVerticalFlipped();
		this.horizontalFlipped = status.isHorizontalFlipped();
		this.position = new Point(status.getPosition());
	}
	
	/**
	 * Copy.
	 *
	 * @return the shape status
	 */
	public ShapeStatus copy() {
		return new ShapeStatus(this);
	}
	
	/**
	 * Gets the angle.
	 *
	 * @return the angle
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Rotate.
	 *
	 * @param angle the angle
	 */
	public void rotate(int angle) {
		this.angle += angle;
	}

	/**
	 * Checks if is on palette.
	 *
	 * @return true, if is on palette
	 */
	public boolean isOnPalette() {
		return onPalette;
	}

	/**
	 * Sets the on palette.
	 *
	 * @param onPalette the new on palette
	 */
	public void setOnPalette(boolean onPalette) {
		this.onPalette = onPalette;
	}

	/**
	 * Checks if is selected.
	 *
	 * @return true, if is selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Select.
	 */
	public void select(){
		this.selected = !this.selected;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Checks if is vertical flipped.
	 *
	 * @return true, if is vertical flipped
	 */
	public boolean isVerticalFlipped() {
		return verticalFlipped;
	}

	/**
	 * V flip.
	 */
	public void vFlip() {
		this.verticalFlipped = !this.verticalFlipped;
	}

	/**
	 * Checks if is horizontal flipped.
	 *
	 * @return true, if is horizontal flipped
	 */
	public boolean isHorizontalFlipped() {
		return horizontalFlipped;
	}

	/**
	 * H flip.
	 */
	public void hFlip() {
		this.horizontalFlipped = !this.horizontalFlipped;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(int x, int y) {
		this.position.setLocation(x, y);
	}
}
