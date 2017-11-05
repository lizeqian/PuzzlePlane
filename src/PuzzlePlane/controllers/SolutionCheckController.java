package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

public class SolutionCheckController{
	
	Board board;
	PuzzlePlaneGui puzzlePlaneGui;
	
	
	public SolutionCheckController(Board b, PuzzlePlaneGui p) {
		this.board = b;
		this.puzzlePlaneGui = p;
	}
	
	public boolean SolutionCheck() {
		Puzzle puzzle = this.board.getPuzzle();
		boolean isCo = true;
		for(PlacedShape shapeA: this.board.getShapes()) {
			for(PlacedShape shapeB :puzzle.getPuzzleShape()) {
				if (new CompareShapeShape(shapeA.getChangedPolygon(), shapeB.getOriginalPolygon()).compare()==false) {
					isCo = false;
				}
			}
		}
		
		if (isCo) {
			//TODO store current solution
			this.puzzlePlaneGui.jumpPage("p4");
		}
		//System.out.println(isCo);
		return isCo;
	}
	
	
}