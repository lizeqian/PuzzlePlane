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
	//Polygon initial;
	
	
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
	
	public int getLeftX() {
		int ret = 10000000;
		for(int i=0;i<this.xpoints.length;i++) {
			if ( ret > this.xpoints[i] ) {
				ret = this.xpoints[i];
			}
		}
		return ret;
	}
	
	public int getRightX() {
		int ret = -1;
		for(int i=0;i<this.xpoints.length;i++) {
			if ( ret < this.xpoints[i] ) {
				ret = this.xpoints[i];
			}
		}
		return ret;
	}
	
	public int getTopY() {
		int ret = 10000000;
		for(int i=0;i<this.ypoints.length;i++) {
			if ( ret > this.ypoints[i] ) {
				ret = this.ypoints[i];
			}
		}
		return ret;
	}
	
	public int getBottomY() {
		int ret = -1;
		for(int i=0;i<this.ypoints.length;i++) {
			if ( ret < this.ypoints[i] ) {
				ret = this.ypoints[i];
			}
		}
		return ret;
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