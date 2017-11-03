package PuzzlePlane.models;

import java.awt.*;
import PuzzlePlane.utils.*;

public class PlacedShape{
	Polygon originalPolygon;
	Polygon changedPolygon;
	ShapeStatus status;
	
	public ShapeStatus getStatus() {
		return status;
	}

	public void setStatus(ShapeStatus status) {
		this.status = status;
	}

	public Polygon getOriginalPolygon() {
		return originalPolygon;
	}

	public void setOriginalPolygon(Polygon originalPolygon) {
		this.originalPolygon = originalPolygon;
	}
	
	public PlacedShape(Color color) {
		this.status = new ShapeStatus(color);
		this.originalPolygon = new Polygon();
		this.setChangedPolygon(new Polygon());
	}
	
	public PlacedShape(PlacedShape shape) {
		Polygon originalPolygon = shape.getOriginalPolygon();
		this.originalPolygon = new Polygon(originalPolygon.xpoints, originalPolygon.ypoints, originalPolygon.npoints);
		Polygon changedPolygon = shape.getChangedPolygon();
		this.changedPolygon = new Polygon(changedPolygon.xpoints, changedPolygon.ypoints, changedPolygon.npoints);
		this.status = new ShapeStatus(shape.getStatus());
	}
	
	public void resetPos(){
		int numPoints = this.originalPolygon.npoints;
		this.changedPolygon.reset();
		for (int i = 0; i < numPoints; i++) {
			this.changedPolygon.addPoint(this.originalPolygon.xpoints[i], this.originalPolygon.ypoints[i]);
		}
		this.status.reset();
	}
	
	public void addPoint(int x, int y) {
		this.originalPolygon.addPoint(x, y);
		this.update();
	}
	
	public void selectShape() {
		this.status.select();
	}
	
	public Point getPosition() {
		return this.status.getPosition();
	}
	
	public boolean isSelected() {
		return this.status.isSelected();
	}
	
	public Color getColor() {
		return this.status.getColor();
	}
	
	public int getLeftX() {
		return ArrayUtils.min(this.changedPolygon.xpoints, this.changedPolygon.npoints);
	}
	
	public int getRightX() {
		return ArrayUtils.max(this.changedPolygon.xpoints, this.changedPolygon.npoints);
	}
	
	public int getTopY() {
		return ArrayUtils.min(this.changedPolygon.ypoints, this.changedPolygon.npoints);
	}
	
	public int getBottomY() {
		return ArrayUtils.max(this.changedPolygon.ypoints, this.changedPolygon.npoints);
	}
	
	public Point getCenterPosition() {
		return new Point(ArrayUtils.avg(this.originalPolygon.xpoints, this.originalPolygon.npoints),
				ArrayUtils.avg(this.originalPolygon.ypoints, this.originalPolygon.npoints));
	}
	
	public void setPosition(int x, int y) {
		this.status.setPosition(x, y);
		this.update();
	}
	
	public void rotate(int angle) {
		this.status.rotate(angle);
		this.update();
	}
	
	public void vFlip() {
		this.status.vFlip();
		this.update();
	}
	
	public void hFlip() {
		this.status.hFlip();
		this.update();
	}
	
	public void update() {
		this.changedPolygon.reset();
		for(int i = 0; i < this.originalPolygon.npoints; i++) {
			int x = this.originalPolygon.xpoints[i];
			int y = this.originalPolygon.ypoints[i];
			Point center = this.getCenterPosition();
			
			//Move
			ShapeStatus status = this.status;
			x += (int)status.getPosition().getX();
			y += (int)status.getPosition().getY();
			center.x += (int)status.getPosition().getX();
			center.y += (int)status.getPosition().getY();
			
			//Rotate
			double angle = (status.getAngle()*1.0/180.0)*Math.PI;
			double cosAngle = Math.cos(angle);
			double sinAngle = Math.sin(angle);
			double dx = x - center.x;
			double dy = y - center.y;
			
			x = center.x + (int)(dx * cosAngle - dy * sinAngle);
			y = center.y + (int)(dx * sinAngle + dy * cosAngle);
			
			//vFlip
			if(status.isVerticalFlipped()) x = center.x - (x - center.x);
			
			//hFlip
			if(status.isHorizontalFlipped()) y = center.y - (y - center.y);
			
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