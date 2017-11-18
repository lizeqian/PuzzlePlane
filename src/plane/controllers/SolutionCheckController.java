package plane.controllers;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import plane.models.*;
import plane.utils.PolygonUtils;
import plane.views.*;

/**
 * The Class SolutionCheckController.
 * @author Zeqian Li
 */
public class SolutionCheckController{
	
	/** The board. */
	public Board board;
	
	/** The puzzle plane gui. */
	public Application puzzlePlaneGui;
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Gets the puzzle plane gui.
	 *
	 * @return the puzzle plane gui
	 */
	public Application getPuzzlePlaneGui() {
		return puzzlePlaneGui;
	}

	/**
	 * Instantiates a new solution check controller.
	 *
	 * @param b the b
	 * @param p the p
	 */
	public SolutionCheckController(Board b, Application p) {
		this.board = b;
		this.puzzlePlaneGui = p;
	}
	
	/**
	 * Check.
	 *
	 * @return true, if successful
	 */
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