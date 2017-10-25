package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Board {
	
	Puzzle puzzle;

	ArrayList<PlacedShape> shapes;
	ArrayList<Point> shapePosition;//Fixed Positions
	int order;
	int selectedOrder;
	int orderOffset_x = 0, orderOffset_y=0;
	int selectedShapeSet = 0;
	
	public void init() {
		shapes = new ArrayList<PlacedShape>();
		shapePosition = new ArrayList<Point>();
		this.order = 0;
	}
	public int getSelectedShapeSet() {
		return selectedShapeSet;
	}

	public void setSelectedShapeSet(int selectedShapeSet) {
		this.selectedShapeSet = selectedShapeSet;
	}
	
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	public Board() {
		//TODO: change puzzle to "public Board(Puzzle puzzle)"
		
	/*	Point firstPos = new Point();
		firstPos.setLocation(20.0, 50.0);
		Point sPos = new Point();
		sPos.setLocation(120.0, 50.0);
		Point sPos1 = new Point();
		sPos1.setLocation(180.0, 50.0);
		Point sPos2 = new Point();
		sPos2.setLocation(240.0, 50.0);
		Point sPos3 = new Point();
		sPos3.setLocation(300.0, 50.0);
		Point sPos4 = new Point();
		sPos3.setLocation(330.0, 50.0);
		Point sPos5 = new Point();
		sPos3.setLocation(360.0, 50.0);
		Point sPos6 = new Point();
		sPos3.setLocation(380.0, 50.0);
		this.shapePosition.add(firstPos);
		this.shapePosition.add(sPos);
		this.shapePosition.add(sPos1);
		this.shapePosition.add(sPos2);
		this.shapePosition.add(sPos3);
		this.shapePosition.add(sPos4);
		this.shapePosition.add(sPos5);
		this.shapePosition.add(sPos6);*/
		this.order = 0;
	}
	
	public void setPosition(int x, int y, int o) {
		this.getShape(o).setPosition(x, y);
	}
	
	public void initialAddShape(ArrayList<Point> points, Color color) {
		this.shapePosition.add(new Point(points.get(0)));
		this.orderOffset_x = this.shapePosition.get(this.order).x;
		this.orderOffset_y = this.shapePosition.get(this.order).y;
		PlacedShape placedShape = new PlacedShape(new Point(this.orderOffset_x, this.orderOffset_y), false, false, 0, this.order, true, false, color);
		//System.out.println("points:"+points.size());
		for (Point point:points) {
			placedShape.addPoint(point.x, point.y);
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
	
	public void setShapes(ArrayList<PlacedShape> shapes) {
		//System.out.println("shapes:"+shapes.size());
		this.init();
		for(PlacedShape shape : shapes) {
			ArrayList<Point> list = new ArrayList<>();
			for(int i = 0; i < shape.npoints; i++) {
				list.add(new Point(shape.xpoints[i], shape.ypoints[i]));
			}
			this.initialAddShape(list, shape.color);
		}
	}
	
	public ArrayList<PlacedShape> getShapes() {
		return this.shapes;
	}
	
	public Point getShapePosition(int o) {
		return this.shapePosition.get(o);
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
}