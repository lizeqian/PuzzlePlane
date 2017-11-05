package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;

import PuzzlePlane.utils.ColorUtils;

public class ShapeStatus {

	int angle;
	boolean onPalette;
	boolean selected;
	Color color;
	boolean verticalFlipped;
	boolean horizontalFlipped;
	Point position;
	
	public void reset() {
		this.position = new Point(0, 0);
		this.verticalFlipped = false;
		this.horizontalFlipped = false;
		this.angle = 0;
		this.onPalette = true;
		this.selected = false;
	}
	
	public void init(Color color) {
		this.reset();
		this.color = ColorUtils.copy(color);
	}
	
	public ShapeStatus(Color color) {
		// TODO Auto-generated constructor stub
		this.init(color);
	}
	
	public ShapeStatus(ShapeStatus status) {
		this.angle = status.getAngle();
		this.onPalette = status.isOnPalette();
		this.selected = status.isSelected();
		this.color = ColorUtils.copy(status.getColor());
		this.verticalFlipped = status.isVerticalFlipped();
		this.horizontalFlipped = status.isHorizontalFlipped();
		this.position = new Point(status.getPosition());
	}
	
	public ShapeStatus copy() {
		return new ShapeStatus(this);
	}
	
	public int getAngle() {
		return angle;
	}

	public void rotate(int angle) {
		this.angle += angle;
	}

	public boolean isOnPalette() {
		return onPalette;
	}

	public void setOnPalette(boolean onPalette) {
		this.onPalette = onPalette;
	}

	public boolean isSelected() {
		return selected;
	}

	public void select(){
		this.selected = !this.selected;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isVerticalFlipped() {
		return verticalFlipped;
	}

	public void vFlip() {
		this.verticalFlipped = !this.verticalFlipped;
	}

	public boolean isHorizontalFlipped() {
		return horizontalFlipped;
	}

	public void hFlip() {
		this.horizontalFlipped = !this.horizontalFlipped;
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position.setLocation(x, y);
	}
}
