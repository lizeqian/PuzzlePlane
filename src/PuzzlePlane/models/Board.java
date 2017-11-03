package PuzzlePlane.models;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Board {
	
	Puzzle puzzle;

	List<PlacedShape> shapes;
	PlacedShape selectedShape;
	int selectedShapeSet;
	
	public void init() {
		this.shapes = new LinkedList<PlacedShape>();
	}
	
	public PlacedShape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(PlacedShape selectedShape) {
		this.selectedShape = selectedShape;
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
	}
	
	public void resetAllShapePosition() {
		for(PlacedShape shape: this.shapes) {
			shape.resetPos();
		}
	}
	
	public void setPosition(int x, int y) {
		this.selectedShape.setPosition(x, y);
	}
	
	public void rotate(int angle) {
		this.selectedShape.rotate(angle);
	}
	
	public void vFlip() {
		this.selectedShape.vFlip();
	}
	
	public void hFlip() {
		this.selectedShape.hFlip();
	}
	
	public boolean selectShape(int x, int y) {
		for(PlacedShape shape : shapes) {
			Polygon polygon = shape.getChangedPolygon();
			if(polygon.contains(x, y)) {
				shape.selectShape();
				this.selectedShape = shape;
				this.reorder();
				return true;
			}
		}
		return false;
	}
	
	public void reorder() {
		this.shapes.remove(this.selectedShape);
		((LinkedList<PlacedShape>) this.shapes).addFirst(this.selectedShape);
	}
	
	public void setShapes(List<PlacedShape> shapes) {
		this.init();
		for(PlacedShape shape : shapes) {
			PlacedShape newShape = new PlacedShape(shape);
			this.shapes.add(newShape);
		}
	}
	
	public List<PlacedShape> getShapes() {
		return this.shapes;
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
}