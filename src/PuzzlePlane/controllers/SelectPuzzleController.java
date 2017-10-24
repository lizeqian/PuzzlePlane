package PuzzlePlane.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

public class SelectPuzzleController implements ActionListener{
	Board board;
	PuzzlePlaneGui puzzlePlaneGui;
	int buttonOrder;
	String puzzlePath = "puzzle/";
	
	public SelectPuzzleController (Board b, PuzzlePlaneGui p) {
		this.board = b;
		this.puzzlePlaneGui = p;
		//this.buttonOrder = i;
		

	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePath = "puzzleShape.txt";
		//System.out.println(this.puzzlePath);
		
		//PuzzleShapeLoader puzzleShapeLoader = new PuzzleShapeLoader(this.puzzlePath);
		//PlacedShape puzzleShape = puzzleShapeLoader.load();
		
		//Puzzle puzzle = this.board.getPuzzle();
		this.board.setPuzzle(new Puzzle(puzzlePath));
		//System.out.println(puzzle.getPuzzleShape().npoints);
		
		this.puzzlePlaneGui.jumpPage("p3");
		
	}
}
