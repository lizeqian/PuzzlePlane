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
	
	
	public void setPosition(int x, int y) {
		this.translate(x-this.position.x, y-this.position.y);
		this.position.setLocation(x, y);
	}
	
	public void setSelected(boolean b) {
		this.selected = b;
	}
	
	
	public Point getPosition() {
		//System.out.println(this.position.x);
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
	
/*	public boolean shapeContain(int x, int y) {
		return this.shape.contains(x, y);
	}*/
	
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