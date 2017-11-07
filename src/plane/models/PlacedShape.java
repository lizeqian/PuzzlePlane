package plane.models;

import java.awt.*;

import plane.utils.*;

public class PlacedShape{
	Polygon originalPolygon;
	Polygon changedPolygon;
	ShapeStatus status;
	
	public String toString() {
		String ret = "";
		Color color = this.status.getColor();
		//System.out.println(color.getRed() + " " + color.getGreen() + " " + color.getBlue());
		ret += color.getRed() + " " + color.getGreen() + " " + color.getBlue();
		for(int i = 0; i < this.changedPolygon.npoints; i++) {
			ret += " " + this.changedPolygon.xpoints[i] + " " + this.changedPolygon.ypoints[i];
		}
		return ret;
	}
	
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
		this.changedPolygon = new Polygon();
	}
	
	public PlacedShape(PlacedShape shape) {
		this.originalPolygon = PolygonUtils.copy(shape.getOriginalPolygon());
		this.changedPolygon = PolygonUtils.copy(shape.getChangedPolygon());
		this.status = shape.getStatus().copy();
	}
	
	public PlacedShape copy() {
		return new PlacedShape(this);
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
		this.changedPolygon.addPoint(x, y);
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
		Point p = this.getPosition();
		this.changedPolygon.translate(x - p.x, y - p.y);
		this.status.setPosition(x, y);
	}
	
	public void rotate(int angle) {
		this.status.rotate(angle);
		PolygonUtils.rotate(this.changedPolygon, angle);
	}
	
	public void vFlip() {
		this.status.vFlip();
		PolygonUtils.vFlip(this.changedPolygon);
	}
	
	public void hFlip() {
		this.status.hFlip();
		PolygonUtils.hFlip(this.changedPolygon);
	}

	public Polygon getChangedPolygon() {
		return changedPolygon;
	}

	public void setChangedPolygon(Polygon changedPolygon) {
		this.changedPolygon = changedPolygon;
	}
}