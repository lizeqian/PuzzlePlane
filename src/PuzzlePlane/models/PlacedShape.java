package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;

public class PlacedShape{
	Point position;
	Polygon originalPolygon;
	Polygon changedPolygon;
	boolean verticalFlipped;
	boolean horizontalFlipped;
	int angle;
	int order;
	boolean onPalette;
	boolean selected;
	Color color;
	
	public void init() {
		this.position = new Point(0, 0);
		this.verticalFlipped = false;
		this.horizontalFlipped = false;
		this.angle = 0;
		this.onPalette = true;
		this.selected = false;
	}
	
	public PlacedShape(int order, Color color) {
		this.init();
		this.originalPolygon = new Polygon();
		this.setChangedPolygon(new Polygon());
		this.order = order;
		this.color = color;
	}
	
	public void resetPos(){
		int numPoints = this.originalPolygon.npoints;
		this.changedPolygon.reset();
		for (int i = 0; i < numPoints; i++) {
			this.changedPolygon.addPoint(this.originalPolygon.xpoints[i], this.originalPolygon.ypoints[i]);
		}
		this.init();
	}
	
	public void addPoint(int x, int y) {
		this.originalPolygon.addPoint(x, y);
		this.update();
	}
	
	public void selectShape() {
		this.selected = !this.selected;
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
		int numPoints = this.getChangedPolygon().npoints;
		for(int i=0;i < numPoints;i++) {
			if ( ret > this.getChangedPolygon().xpoints[i]) {
				ret = this.getChangedPolygon().xpoints[i];
			}
		}
		return ret;
	}
	
	public int getRightX() {
		int ret = -1;
		int numPoints = this.getChangedPolygon().npoints;
		for(int i = 0; i < numPoints; i++) {
			if ( ret < this.getChangedPolygon().xpoints[i] ) {
				ret = this.getChangedPolygon().xpoints[i];
			}
		}
		return ret;
	}
	
	public int getTopY() {
		int ret = 10000000;
		int numPoints = this.getChangedPolygon().npoints;
		for(int i = 0; i < numPoints; i++) {
			if ( ret > this.getChangedPolygon().ypoints[i] ) {
				ret = this.getChangedPolygon().ypoints[i];
			}
		}
		return ret;
	}
	
	public int getBottomY() {
		int ret = -1;
		int numPoints = this.getChangedPolygon().npoints;
		for(int i = 0 ;i < numPoints; i++) {
			if ( ret < this.getChangedPolygon().ypoints[i] ) {
				ret = this.getChangedPolygon().ypoints[i];
			}
		}
		return ret;
	}
	
	public Point getCenterPosition() {
		int numPoints = this.originalPolygon.npoints;
		Point ret = new Point(0, 0);
		for(int i = 0; i < numPoints; i++) {
			ret.x += this.originalPolygon.xpoints[i];
			ret.y += this.originalPolygon.ypoints[i];
		}
		ret.x /= numPoints;
		ret.y /= numPoints;
		return ret;
	}
	
	public void setPosition(int x, int y) {
		this.position.setLocation(x, y);
		this.update();
	}
	
	public void rotate(int angle) {
		this.angle += angle;
		this.update();
	}
	
	public void vFlip() {
		this.verticalFlipped = !this.verticalFlipped;
		this.update();
	}
	
	public void hFlip() {
		this.horizontalFlipped = !this.horizontalFlipped;
		this.update();
	}
	
	public void update() {
		this.changedPolygon.reset();
		for(int i = 0; i < this.originalPolygon.npoints; i++) {
			int x = this.originalPolygon.xpoints[i];
			int y = this.originalPolygon.ypoints[i];
			Point center = this.getCenterPosition();
			
			//Move
			x += this.position.x;
			y += this.position.y;
			center.x += this.position.x;
			center.y += this.position.y;
			
			//Rotate
			double angle = (this.angle*1.0/180.0)*Math.PI;
			double cosAngle = Math.cos(angle);
			double sinAngle = Math.sin(angle);
			double dx = x - center.x;
			double dy = y - center.y;
			
			x = center.x + (int)(dx * cosAngle - dy * sinAngle);
			y = center.y + (int)(dx * sinAngle + dy * cosAngle);
			
			//vFlip
			if(this.verticalFlipped) x = center.x - (x - center.x);
			
			//hFlip
			if(this.horizontalFlipped) y = center.y - (y - center.y);
			
			this.changedPolygon.addPoint(x, y);
		}
	}

	public Polygon getChangedPolygon() {
		return changedPolygon;
	}

	public void setChangedPolygon(Polygon changedPolygon) {
		this.changedPolygon = changedPolygon;
	}
}