package PuzzlePlane.models;

import java.util.Stack;

import PuzzlePlane.controllers.Move;

public class Model {
	Board board;
	Stack<Move> moves = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	
	public Model() {
		// TODO Auto-generated constructor stub
		this(new Board());
	}
	
	public Model(Board b) {
		this.board = b;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void recordMove(Move move) {
		moves.add(move);
		redoStack.clear();
	}
	
	public void recordRedoableMove(Move move) {
		redoStack.push(move);
	}
	
	public Move removeRedoMove() {
		if (redoStack.isEmpty()) return null;
		return redoStack.pop();
	}
	
	public void recordRedoneMove(Move m) {
		moves.push(m);
	}
	
	public Move removeLastMove() {
		return null;
	}
}
