package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ExitPuzzleSolving implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	
	public ExitPuzzleSolving(Board b, PuzzlePlaneGui p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}
}