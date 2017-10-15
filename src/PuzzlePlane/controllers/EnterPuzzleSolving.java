package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class EnterPuzzleSolving implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	
	public EnterPuzzleSolving(PuzzlePlaneGui p, Board b) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}