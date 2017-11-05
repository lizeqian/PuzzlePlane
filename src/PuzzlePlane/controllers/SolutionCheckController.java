package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

public class SolutionCheckController{
	
	Board board;
	
	
	public SolutionCheckController(Board b) {
		this.board = b;
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

		//System.out.println(isCo);
		return isCo;
	}
	
	
}