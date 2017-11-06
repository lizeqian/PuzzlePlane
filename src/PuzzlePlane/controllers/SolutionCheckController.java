package PuzzlePlane.controllers;

import java.util.ArrayList;

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
		ArrayList<PlacedShape> puzzleShapes = new ArrayList<PlacedShape>();
		for (PlacedShape shape: puzzle.getPuzzleShape()) {
			puzzleShapes.add(shape);
		}
		boolean isCo = true;
		for(PlacedShape shapeA: this.board.getShapes()) {
			for(PlacedShape shapeB :puzzleShapes) {
				if (new CompareShapeShape(shapeA.getChangedPolygon(), shapeB.getOriginalPolygon()).compare()==false) {
					isCo = false;
				}
				else {
					System.out.println(puzzleShapes.size());
					puzzleShapes.remove(shapeB);
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