package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class ShapeOperation implements ActionListener{
	PuzzleSolvingView puzzleSolvingView;
	Board board;
	int operation; // 0 :no action, 1: left rotate, 2: right rotate, 3: v flip, 4: h flip
	
	public ShapeOperation (Board b, PuzzleSolvingView p, int op) {
		this.puzzleSolvingView = p;
		this.board = b;
		this.operation = op;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(this.operation) {
		case 0:
			break;
		case 1:
			this.board.rotate(345);
			break;
		case 2:
			this.board.rotate(15);
			break;
		case 3:
			this.board.vFlip();
			break;
		case 4:
			this.board.hFlip();
			break;
		default:
			break;
		}
		this.puzzleSolvingView.repaint();
	}
}