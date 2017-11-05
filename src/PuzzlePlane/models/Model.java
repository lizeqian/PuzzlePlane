package PuzzlePlane.models;

import java.util.Stack;

import PuzzlePlane.controllers.Move;

public class Model {
	
	Board board;
	PlacedShape selectedShape;
	Stack<Move> moves;
	Stack<Move> redoStack;
	
	public Model() {
		// TODO Auto-generated constructor stub
		this(new Board());
	}
	
	public Model(Board b) {
		this.board = b;
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
	
	public PlacedShape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(PlacedShape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
}
