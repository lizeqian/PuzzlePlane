package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ShapeOperation implements ActionListener{
	PuzzleSolvingView puzzleSolvingView;
	Board board;
	int operation;
	
	public ShapeOperation (Board b, PuzzleSolvingView p, int op) {
		this.puzzleSolvingView = p;
		this.board = b;
		this.operation = op;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(this.operation) {
		case Operation.NO_ACTION:
			break;
		case Operation.LEFT_ROTATE:
			this.board.rotate(345);
			break;
		case Operation.RIGHT_ROTATE:
			this.board.rotate(15);
			break;
		case Operation.VFLIP:
			this.board.vFlip();
			break;
		case Operation.HFLIP:
			this.board.hFlip();
			break;
		default:
			break;
		}
		this.puzzleSolvingView.repaint();
	}
}