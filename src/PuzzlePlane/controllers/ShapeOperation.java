package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class ShapeOperation implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	int operation; // 0 :no actoin, 1: left rotate, 2: right rotate, 3: v flip, 4: h flip
	int angle;
	
	public ShapeOperation (Board b, PuzzlePlaneGui p, int op, int a) {
		this.puzzlePlaneGui = p;
		this.board = b;
		this.operation = op;
		this.angle = a;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}
}