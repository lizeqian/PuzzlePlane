package PuzzlePlane.models;

import java.awt.*;

public class PlacedShape extends Polygon{
	Point position;
	boolean verticalFlipped;
	boolean horizontalFlipped;
	int angle;
	int order;
	boolean onPalette;
	boolean selected;
	Color color;
	Polygon initial;
	
	//Random 
	
	public PlacedShape(Point position, boolean verticalFlipped,boolean horizontalFlipped,int angle, int order, boolean onPalette, boolean selected, Color color) {
		this.position = position;
		this.verticalFlipped = verticalFlipped;
		this.horizontalFlipped = horizontalFlipped;
		this.angle = angle;
		this.order = order;
		this.onPalette = onPalette;
		this.selected = selected;
		this.color = color;
	}
	
	public PlacedShape(int order) {
	//	this(new Point(), false, false, 0, order, false, false, )
	}
	
	public void setPosition(int x, int y) {
		this.translate(x-this.position.x, y-this.position.y);
		this.position.setLocation(x, y);
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	
	public Point getPosition() {
		return this.position;
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public boolean getSelected() {
		return this.selected;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void leftRotateShape( ) {
		
	}
	
	public void rightRotateShape( ) {
		
	}
	
	public void verticalFlipShape( ) {
		
	}
	
	public void horizontalFlipShape( ) {
		
	}
	
	public void moveShape () {
		
	}
	
}