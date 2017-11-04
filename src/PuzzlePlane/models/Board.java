package PuzzlePlane.models;

import java.awt.Point;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import PuzzlePlane.controllers.Move;
import PuzzlePlane.controllers.moves.HorizontalFlipMove;
import PuzzlePlane.controllers.moves.PositionMove;
import PuzzlePlane.controllers.moves.RotateMove;
import PuzzlePlane.controllers.moves.VerticalFlipMove;

public class Board {
	
	Puzzle puzzle;
	List<PlacedShape> shapes;
	PlacedShape selectedShape;
	
	Stack<Move> moves;
	Stack<Move> redoStack;
	
	public void undo() {
		if(!moves.isEmpty()) {
			Move m = moves.pop();
			m.undo();
		}
	}
	
	public void redo() {
		
	}
	
	public void init() {
		this.shapes = new LinkedList<PlacedShape>();
		this.moves = new Stack<Move>();
		this.redoStack = new Stack<Move>();
	}
	
	public PlacedShape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(PlacedShape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	public Board() {
	}
	
	public void resetAllShapePosition() {
		for(PlacedShape shape: this.shapes) {
			shape.resetPos();
		}
	}
	
	public void setPosition(int x, int y) {
		if(this.selectedShape != null) {
			this.selectedShape.setPosition(x, y);
		}
	}
	
	public void pushDrag(Point before) {
		if(this.selectedShape != null) {
			Point after = this.selectedShape.getPosition();
			this.moves.push(new PositionMove(this.selectedShape, before, after));
		}
	}
	
	public void rotate(int angle) {
		if(this.selectedShape != null) {
			this.moves.push(new RotateMove(this.selectedShape, angle));
			this.selectedShape.rotate(angle);
		}
	}
	
	public void vFlip() {
		if(this.selectedShape != null) {
			this.moves.push(new VerticalFlipMove(this.selectedShape));
			this.selectedShape.vFlip();
		}
	}
	
	public void hFlip() {
		if(this.selectedShape != null) {
			this.moves.push(new HorizontalFlipMove(this.selectedShape));
			this.selectedShape.hFlip();
		}
	}
	
	public boolean selectShape(int x, int y) {
		ListIterator<PlacedShape> iterator = shapes.listIterator(shapes.size());
		while(iterator.hasPrevious()){
			PlacedShape shape = iterator.previous();
			Polygon polygon = shape.getChangedPolygon();
			if(polygon.contains(x, y)) {
				if(this.selectedShape != null) {
					this.selectedShape.selectShape();
				}
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
		this.shapes.add(this.selectedShape);
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