package PuzzlePlane.models;

import java.awt.*;
import java.util.ArrayList;


public class Palette {
	ShapeSet shapeSet;
	
	ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
	ArrayList<Point> shapePosition = new ArrayList<Point>(); //Fixed Positions
	int order;
	int selectedOrder;
	int orderOffset_x = 0, orderOffset_y=0;
	
	public Palette( ) {
		Point firstPos = new Point();
		firstPos.setLocation(20.0, 50.0);
		Point sPos = new Point();
		sPos.setLocation(120.0, 50.0);
		this.shapePosition.add(firstPos);
		this.shapePosition.add(sPos);
		this.order = 0;
	}
	
	public void setPosition(int x, int y, int o) {
		this.getShape(o).setPosition(x, y);
	}
	
	public void initialAddShape(ArrayList<Point> points, Color color) {
		this.orderOffset_x = this.shapePosition.get(this.order).x;
		this.orderOffset_y = this.shapePosition.get(this.order).y;
		PlacedShape placedShape = new PlacedShape(new Point(this.orderOffset_x, this.orderOffset_y), false, false, 0, this.order, true, false, color);
		for (Point point:points) {
			placedShape.addPoint(point.x+this.orderOffset_x, point.y+this.orderOffset_y);
		}
		this.shapes.add(placedShape);
		this.order += 1;
	}
	
	public boolean selectShape(int x, int y) {
		for (PlacedShape shape: this.shapes) {
			if (shape.contains(x, y)) {
				this.selectedOrder = shape.getOrder();
				shape.setSelected(true);
				return true;
			}
		}
		return false;
	}
	
	public int getSelectedOrder () {
		return this.selectedOrder;
	}
	
	public void addPlacedShape(PlacedShape s) {
		int order = s.getOrder();
		int delta_x = s.xpoints[0];
		int delta_y = s.ypoints[0];
		Point origin = this.shapePosition.get(order);
		s.setPosition(origin.x, origin.y);
		System.out.println(s.xpoints[0]);
		s.translate(origin.x-delta_x, origin.y-delta_y);
		System.out.println(s.xpoints[0]);
		this.shapes.add(s);
		
	}
	
	public void debug0 () {
		//System.out.println(this.getShape(0).xpoints[0]);
	}
	
	public void removePlacedShape(int o) {
		PlacedShape s = null;
		for(PlacedShape shape: this.shapes) {
			if (shape.getOrder() == o) {
				s = shape;
				break;
			}
		}
		this.shapes.remove(s);
	}
	
	public PlacedShape getShape(int o) {
		for(PlacedShape shape: this.shapes) {
			if (shape.getOrder() == o) {
				return shape;
			}
		}
		return null;
	}
	
	public ArrayList<PlacedShape> getShapes() {
		return this.shapes;
	}
}