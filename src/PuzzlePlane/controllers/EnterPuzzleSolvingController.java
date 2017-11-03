package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class EnterPuzzleSolvingController implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	
	public EnterPuzzleSolvingController(PuzzlePlaneGui p, Board b) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}