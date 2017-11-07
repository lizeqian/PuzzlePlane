package plane.controllers;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import plane.models.*;
import plane.utils.PolygonUtils;
import plane.views.*;

public class SolutionCheckController{
	
	Board board;
	Application puzzlePlaneGui;
	
	
	public SolutionCheckController(Board b, Application p) {
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
		
		return isCo;
	}
}