package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Board {
	
	ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
	ArrayList<Point> shapePosition = new ArrayList<Point>(); //Fixed Positions
	int order;
	int selectedOrder;
	int orderOffset_x = 0, orderOffset_y=0;
	
	
	public Board() {
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
		//System.out.println("size:"+points.size()+",order:"+this.order);
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
	
	public Point getShapePosition(int o) {
		return this.shapePosition.get(o);
	}
	
}