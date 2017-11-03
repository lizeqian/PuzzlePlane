package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ShapeOperation implements ActionListener{
	PuzzleSolvingView puzzleSolvingView;
	Board board;
	int operation;
	
	public final static int LEFT_ROTATE = 345;
	public final static int RIGHT_ROTATE = 15;
	
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
			this.board.rotate(LEFT_ROTATE);
			break;
		case Operation.RIGHT_ROTATE:
			this.board.rotate(RIGHT_ROTATE);
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