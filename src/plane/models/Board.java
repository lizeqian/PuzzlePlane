package plane.models;

import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Board {
	public Puzzle puzzle;
	public Shapeset shapeset;

	public List<PlacedShape> shapes;
	public PlacedShape selectedShape;
	
	public Stack<Move> moves;
	public Stack<Move> redoStack;
	
	public Shapeset getShapeset() {
		return shapeset;
	}

	public void setShapeset(Shapeset shapeset) {
		this.shapeset = shapeset;
	}
	
	public Stack<Move> getMoves() {
		return moves;
	}

	public void setMoves(Stack<Move> moves) {
		this.moves = moves;
	}

	public Stack<Move> getRedoStack() {
		return redoStack;
	}

	public void setRedoStack(Stack<Move> redoStack) {
		this.redoStack = redoStack;
	}

	public Board() {
	}
	
	public BoardMemento createMemento() {
		return new BoardMemento(this);
	}
	
	public void undo() {
		if(!moves.isEmpty()) {
			Move m = moves.pop();
			m.undo();
			redoStack.push(m);
		}
	}
	
	public void redo() {
		if(!redoStack.isEmpty()) {
			Move m = redoStack.pop();
			m.redo();
			moves.push(m);
		}
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
	
	public void pushDrag(PlacedShape before) {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	public void rotate(int angle) {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.rotate(angle);
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	public void vFlip() {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.vFlip();
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	public void hFlip() {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.hFlip();
			this.moves.push(new Move(this.selectedShape, before));
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
			PlacedShape newShape = shape.copy();
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