package PuzzlePlane.models;

import java.util.Stack;

import PuzzlePlane.controllers.Move;

public class Model {
	Board board;
	Stack<Move> moves = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

}
