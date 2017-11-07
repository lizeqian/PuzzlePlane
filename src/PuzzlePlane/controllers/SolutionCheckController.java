package PuzzlePlane.controllers;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import PuzzlePlane.utils.PolygonUtils;

public class SolutionCheckController{
	
	Board board;
	Applicatoin puzzlePlaneGui;
	
	
	public SolutionCheckController(Board b, Applicatoin p) {
		this.board = b;
		this.puzzlePlaneGui = p;
	}
	
	public boolean check() {
		Puzzle puzzle = this.board.getPuzzle();
		List<Polygon> puzzleShapes = new ArrayList<Polygon>();
		for (PlacedShape shape: puzzle.getPuzzleShape()) {
			puzzleShapes.add(shape.getOriginalPolygon());
		}
		boolean isCo = true;
		for(PlacedShape shape : this.board.getShapes()) {
			if (!PolygonUtils.contains(puzzleShapes, shape.getChangedPolygon())) {
				isCo = false;
			}
		}
		
		if (isCo) {
			//TODO store current solution
			(new SaveSolutionController(this.puzzlePlaneGui, this.board.createMemento())).save();
			this.puzzlePlaneGui.jumpPage("p4");
		}
		return isCo;
	}
}