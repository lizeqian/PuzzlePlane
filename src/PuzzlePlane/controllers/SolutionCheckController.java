package PuzzlePlane.controllers;

import java.awt.Polygon;
import java.util.ArrayList;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import PuzzlePlane.utils.Compare;

public class SolutionCheckController{
	
	Board board;
	PuzzlePlaneGui puzzlePlaneGui;
	
	
	public SolutionCheckController(Board b, PuzzlePlaneGui p) {
		this.board = b;
		this.puzzlePlaneGui = p;
	}
	
	public boolean SolutionCheck() {
		Puzzle puzzle = this.board.getPuzzle();
		ArrayList<Polygon> puzzleShapes = new ArrayList<Polygon>();
		for (PlacedShape shape: puzzle.getPuzzleShape()) {
			puzzleShapes.add(shape.getOriginalPolygon());
		}
		boolean isCo = true;
		for(PlacedShape shapeA: this.board.getShapes()) {
			if (!Compare.contains(puzzleShapes, shapeA.getChangedPolygon())) {
				isCo = false;
			}
		}
		
		if (isCo) {
			//TODO store current solution
			this.board.createMemento();
			this.puzzlePlaneGui.jumpPage("p4");
		}
		return isCo;
	}
	
	
}