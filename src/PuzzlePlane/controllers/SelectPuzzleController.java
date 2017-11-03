package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

public class SelectPuzzleController implements ActionListener{
	Board board;
	PuzzlePlaneGui puzzlePlaneGui;
	int buttonOrder;
	String puzzleShapePath;
	
	public SelectPuzzleController (Board b, PuzzlePlaneGui p, String s) {
		this.board = b;
		this.puzzlePlaneGui = p;
		this.puzzleShapePath = s;
	}
	
	public void actionPerformed(ActionEvent e) {	
		PlacedShape puzzleShape = (new PuzzleShapeLoader(puzzleShapePath)).load();
		this.board.setPuzzle(new Puzzle(puzzleShape));
		this.puzzlePlaneGui.jumpPage("p3");
	}
}
