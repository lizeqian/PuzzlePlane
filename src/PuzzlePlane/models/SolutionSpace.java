package PuzzlePlane.models;

import java.util.ArrayList;

public class SolutionSpace {
	ShapeSet shapeSet;
	ArrayList<PlacedShape> shapes = new ArrayList<PlacedShape>();
	Puzzle puzzle;
	boolean success;
	int selectedOrder;
	
	public SolutionSpace() {
	}
	
	public void setPosition(int x, int y, int o) {
		this.getShape(o).setPosition(x, y);
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
	
	public void setShapeSet(ShapeSet s) {
		this.shapeSet = s;
	}
	
	public PlacedShape getShape(int o) {
		for(PlacedShape shape: this.shapes) {
			if (shape.getOrder() == o) {
				return shape;
			}
		}
		return null;
	}
	
	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
	}
	
	public void addPlacedShape(PlacedShape s) {
		this.shapes.add(s);
	}
	
	public void removePlacedShape(PlacedShape s) {
		this.shapes.remove(s);
	}
	
	public ArrayList<PlacedShape> getShapes() {
		return this.shapes;
	}
	
	public void selectShape( ) {
		
	}

	
	public void removeShape() {
		
	}
}