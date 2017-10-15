package PuzzlePlane.models;

import java.awt.Point;

public class PlacedShape{
	Point position;
	PolyShape shape;
	boolean verticalFlipped;
	boolean horizontalFlipped;
	int angle;
	
	public PlacedShape(Point position,PolyShape shape,boolean verticalFlipped,boolean horizontalFlipped,int angle) {
		this.position = position;
		this.shape = shape;
		this.verticalFlipped = verticalFlipped;
		this.horizontalFlipped = horizontalFlipped;
		this.angle = angle;
	}
	
	public void setPosition(int x, int y) {
		this.position.setLocation(x, y);
	}
	
	public PolyShape getShape() {
		return this.shape;
	}
	
	public Point getPosition() {
		return this.position;
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