package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

public class SelectPuzzleController implements ActionListener{
	Board board;
	Application plane;
	String puzzleName;
	
	public SelectPuzzleController (Board b, Application p, String puzzleName) {
		this.board = b;
		this.plane = p;
		this.puzzleName = puzzleName;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.plane.setPuzzleName(this.puzzleName);
		List<PlacedShape> puzzleShapes;
		puzzleShapes = (new ShapeLoader(FilePathConfig.getPuzzlePath(this.plane.getShapesetName(), this.puzzleName))).load();
		
		
		String shapesetName = this.plane.getShapesetName();
		Set<String> solvedPuzzleNames = this.plane.getSolvedPuzzleNames();
		if(solvedPuzzleNames != null && solvedPuzzleNames.contains(this.puzzleName)) {
			ShapeLoader loader = new ShapeLoader(FilePathConfig.getPuzzleSolutionPath(shapesetName, this.puzzleName));
			this.board.setShapes(loader.load());
		} else {
			ShapeLoader loader = new ShapeLoader(FilePathConfig.getShapesetPath(shapesetName));
			this.board.setShapes(loader.load());
		}
		
		this.board.setPuzzle(new Puzzle(puzzleShapes));
		this.plane.jumpPage("p3");
	}
}
