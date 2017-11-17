package plane.models;

import java.awt.Polygon;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * The Class Board
 * Entry Point into the Entity domain space.
 * @author cheng zhu
 */
public class Board {
	
	/** The puzzle. */
	public Puzzle puzzle;
	
	/** The shapeset. */
	public Shapeset shapeset;

	/** The shapes. */
	public List<PlacedShape> shapes;
	
	/** The selected shape. */
	public PlacedShape selectedShape;
	
	/** The moves. */
	public Stack<Move> moves;
	
	/** The redo stack. */
	public Stack<Move> redoStack;
	
	/**
	 * Gets the shapeset.
	 *
	 * @return the shapeset
	 */
	public Shapeset getShapeset() {
		return shapeset;
	}

	/**
	 * Sets the shapeset.
	 *
	 * @param shapeset the new shapeset
	 */
	public void setShapeset(Shapeset shapeset) {
		this.shapeset = shapeset;
	}
	
	/**
	 * Gets the moves.
	 *
	 * @return the moves
	 */
	public Stack<Move> getMoves() {
		return moves;
	}

	/**
	 * Sets the moves.
	 *
	 * @param moves the new moves
	 */
	public void setMoves(Stack<Move> moves) {
		this.moves = moves;
	}

	/**
	 * Gets the redo stack.
	 *
	 * @return the redo stack
	 */
	public Stack<Move> getRedoStack() {
		return redoStack;
	}

	/**
	 * Sets the redo stack.
	 *
	 * @param redoStack the new redo stack
	 */
	public void setRedoStack(Stack<Move> redoStack) {
		this.redoStack = redoStack;
	}

	/**
	 * Instantiates a new board.
	 */
	public Board() {
	}
	
	/**
	 * Creates the memento.
	 *
	 * @return the board memento
	 */
	public BoardMemento createMemento() {
		return new BoardMemento(this);
	}
	
	/**
	 * Undo the last move by user
	 */
	public void undo() {
		if(!moves.isEmpty()) {
			Move m = moves.pop();
			m.undo();
			redoStack.push(m);
		}
	}
	
	/**
	 * Redo the last undo move by user
	 */
	public void redo() {
		if(!redoStack.isEmpty()) {
			Move m = redoStack.pop();
			m.redo();
			moves.push(m);
		}
	}
	
	/**
	 * Initialization method for Board.
	 */
	public void init() {
		this.shapes = new LinkedList<PlacedShape>();
		this.moves = new Stack<Move>();
		this.redoStack = new Stack<Move>();
	}
	
	/**
	 * Gets the selected shape.
	 *
	 * @return the selected shape
	 */
	public PlacedShape getSelectedShape() {
		return selectedShape;
	}

	/**
	 * Sets the selected shape.
	 *
	 * @param selectedShape the new selected shape
	 */
	public void setSelectedShape(PlacedShape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	/**
	 * Sets the puzzle.
	 *
	 * @param puzzle the new puzzle
	 */
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	/**
	 * Reset all shape position.
	 */
	public void resetAllShapePosition() {
		for(PlacedShape shape: this.shapes) {
			shape.resetPos();
		}
	}
	
	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(int x, int y) {
		if(this.selectedShape != null) {
			this.selectedShape.setPosition(x, y);
		}
	}
	
	/**
	 * Push drag.
	 *
	 * @param before the before
	 */
	public void pushDrag(PlacedShape before) {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	/**
	 * Rotate.
	 *
	 * @param angle the rotating angle
	 */
	public void rotate(int angle) {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.rotate(angle);
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	/**
	 * Vertically flip the selected shape.
	 */
	public void vFlip() {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.vFlip();
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	/**
	 * Horizontally flip the selectedShape.
	 */
	public void hFlip() {
		if(this.selectedShape != null) {
			this.redoStack.clear();
			PlacedShape before = this.selectedShape.copy();
			this.selectedShape.hFlip();
			this.moves.push(new Move(this.selectedShape, before));
		}
	}
	
	/**
	 * Select shape.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if successful
	 */
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
	
	/**
	 * Reorder the selectedShape to the top.
	 */
	public void reorder() {
		this.shapes.remove(this.selectedShape);
		this.shapes.add(this.selectedShape);
	}
	
	/**
	 * Sets the shapes.
	 *
	 * @param shapes the new shapes
	 */
	public void setShapes(List<PlacedShape> shapes) {
		this.init();
		for(PlacedShape shape : shapes) {
			PlacedShape newShape = shape.copy();
			this.shapes.add(newShape);
		}
	}
	
	/**
	 * Gets the shapes.
	 *
	 * @return the shapes
	 */
	public List<PlacedShape> getShapes() {
		return this.shapes;
	}
	
	/**
	 * Gets the puzzle.
	 *
	 * @return the puzzle
	 */
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
}