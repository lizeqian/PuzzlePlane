package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;

public class PlacedShape extends Polygon{
	Point position;
	boolean verticalFlipped;
	boolean horizontalFlipped;
	int angle;
	int order;
	boolean onPalette;
	boolean selected;
	Color color;
	Polygon rotateOffset = new Polygon();
	Polygon originalPos = new Polygon();
	//Polygon initial;
	
	public PlacedShape(Point position, boolean verticalFlipped,boolean horizontalFlipped,int angle, int order, boolean onPalette, boolean selected, Color color) {
		super();
		this.position = position;
		this.verticalFlipped = verticalFlipped;
		this.horizontalFlipped = horizontalFlipped;
		this.angle = angle;
		this.order = order;
		this.onPalette = onPalette;
		this.selected = selected;
		this.color = color;
	}
	
	public void resetPos(){
		this.reset();
		int numPoints = this.originalPos.npoints;
		for (int i = 0; i < numPoints; i++) {
			int x = this.originalPos.xpoints[i];
			int y = this.originalPos.ypoints[i];
			this.addPoint(x, y);
		}
		this.angle = 0;
		this.horizontalFlipped = false;
		this.verticalFlipped = false;
	}
	
	public void setPosition(int x, int y) {
		//System.out.println("set position");
		this.translate(x-this.position.x, y-this.position.y);
		this.position.setLocation(x, y);
		//System.out.println(this.xpoints[0]);
		this.storeRotateOffset();
	}
	
	public void storeRotateOffset() {
		this.rotateOffset.reset();
		for (int i =0; i< this.npoints;i++) {
			int xp = this.xpoints[i];
			int yp = this.ypoints[i];
			this.rotateOffset.addPoint(xp, yp);
		}
		this.angle = 0;
	}
	public void setOriginalPos() {
		for (int i =0; i< this.npoints;i++) {
			int xp = this.xpoints[i];
			int yp = this.ypoints[i];
			this.originalPos.addPoint(xp, yp);
		}
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
		//System.out.println("npoints:"+this.npoints);
		for(int i=0;i<this.npoints;i++) {
			if ( ret > this.xpoints[i] ) {
				ret = this.xpoints[i];
			}
		}
		return ret;
	}
	
	public int getRightX() {
		int ret = -1;
		for(int i=0;i<this.npoints;i++) {
			if ( ret < this.xpoints[i] ) {
				ret = this.xpoints[i];
			}
		}
		return ret;
	}
	
	public int getTopY() {
		int ret = 10000000;
		for(int i=0;i<this.npoints;i++) {
			if ( ret > this.ypoints[i] ) {
				ret = this.ypoints[i];
			}
		}
		return ret;
	}
	
	public int getBottomY() {
		int ret = -1;
		for(int i=0;i<this.npoints;i++) {
			if ( ret < this.ypoints[i] ) {
				ret = this.ypoints[i];
			}
		}
		return ret;
	}
	
	public Point getCentroid() {
		Point p= new Point();
		double x = 0;
		double y = 0;
		int pointCount = this.rotateOffset.npoints;
		//System.out.println(pointCount);
		for (int i = 0; i < pointCount - 1; i++) {
			x += this.rotateOffset.xpoints[i];
			y += this.rotateOffset.ypoints[i];
		}
		x = x/(pointCount-1);
		y = y/(pointCount-1);
		p.setLocation((int)x, (int)y);
		return p;
	}
	
	public Point getThisCentroid() {
		Point p= new Point();
		double x = 0;
		double y = 0;
		int pointCount = this.npoints;
		//System.out.println(pointCount);
		for (int i = 0; i < pointCount - 1; i++) {
			x += this.xpoints[i];
			y += this.ypoints[i];
		}
		x = x/(pointCount-1);
		y = y/(pointCount-1);
		p.setLocation((int)x, (int)y);
		return p;
	}
	
	public void rotate(int angle) {
		//System.out.println(angle);
		//System.out.println(this.rotateOffset.xpoints[0]);

		this.angle+=angle;
		
		
		double delta_x = 0, delta_y = 0;
		if (this.angle>=360) {
			this.angle -= 360;
		}
		ArrayList<Point> rotatePoint = new ArrayList<Point>();		
		
		double x_c = this.getCentroid().x;
		double y_c = this.getCentroid().y;
		double angleInRadian = Math.toRadians(this.angle);
		for (int i = 0; i < this.npoints; i++) {
			delta_x = this.rotateOffset.xpoints[i]-x_c;
			delta_y = this.rotateOffset.ypoints[i]-y_c;
			double x = Math.cos(angleInRadian)*(delta_x)-Math.sin(angleInRadian)*(delta_y)+x_c;
			double y = Math.sin(angleInRadian)*(delta_x)+Math.cos(angleInRadian)*(delta_y)+y_c;
			Point e = new Point((int)x, (int)y);
			rotatePoint.add(e);
		}
		this.reset();
		for (Point point:rotatePoint) {
			this.addPoint(point.x, point.y);
		}

	}
	
	public void vFlip() {

		this.verticalFlipped = !this.verticalFlipped;
		double y_c = this.getThisCentroid().getY();
		double delta_y = 0;
		ArrayList<Point> flipPoint = new ArrayList<Point>();
		for (int i = 0; i < this.npoints; i++) {
			delta_y = this.ypoints[i]-y_c;
			double y = y_c - delta_y;
			double x = this.xpoints[i];
			Point e = new Point((int)x, (int)y);
			flipPoint.add(e);
		}
		this.reset();
		for (Point point:flipPoint) {
			this.addPoint(point.x, point.y);
		}
		this.storeRotateOffset();
	}
	
	public void hFlip() {
		this.horizontalFlipped = !this.horizontalFlipped;
		double x_c = this.getThisCentroid().getX();
		double delta_x = 0;
		ArrayList<Point> flipPoint = new ArrayList<Point>();
		for (int i = 0; i < this.npoints; i++) {
			delta_x = this.xpoints[i]-x_c;
			double x = x_c - delta_x;
			double y = this.ypoints[i];
			Point e = new Point((int)x, (int)y);
			flipPoint.add(e);
		}
		

		this.reset();
		for (Point point:flipPoint) {
			this.addPoint(point.x, point.y);
		}
		this.storeRotateOffset();
	}
	
}