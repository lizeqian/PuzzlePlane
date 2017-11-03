package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

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
		List<PlacedShape> puzzleShapes = new ArrayList<PlacedShape>();
		puzzleShapes = (new ShapeLoader(puzzleShapePath)).load();
		this.board.setPuzzle(new Puzzle(puzzleShapes));
		this.puzzlePlaneGui.jumpPage("p3");
	}
}
