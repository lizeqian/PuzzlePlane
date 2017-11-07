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
	Applicatoin puzzlePlaneGui;
	int buttonOrder;
	String puzzleShapePath;
	String puzzleName;
	
	public SelectPuzzleController (Board b, Applicatoin p, String name) {
		this.board = b;
		this.puzzlePlaneGui = p;
		this.puzzleShapePath = p.getPuzzleFolderPath() + name;
		this.puzzleName = name;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.setSolutionPath(this.puzzlePlaneGui.getSolutionFolderPath() + this.puzzleName);
		List<PlacedShape> puzzleShapes = new ArrayList<PlacedShape>();
		puzzleShapes = (new ShapeLoader(puzzleShapePath)).load();
		this.board.setPuzzle(new Puzzle(puzzleShapes));
		this.puzzlePlaneGui.jumpPage("p3");
	}
}
