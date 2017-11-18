package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.models.*;
import plane.views.*;
/**
 * Respond to selection events in the Puzzle Plane, which has been configured to only 
 * allow individual rows to be selected.
 * @author cheng zhu
 */
public class SelectPuzzleController implements ActionListener{
	/** Needs board to be able to select elements. */
	Board board;
	/** Needs panel so it can redraw the board. */
	Application plane;
	/** Needs puzzleName */
	String puzzleName;
	
	/**
	 * Controller constructed with board (entity) and panel (boundary) and puzzleName. 
	 * @param b the Board reference
	 * @param p the Application reference
	 * @param puzzleName the puzzle name
	 * 
	 */
	public SelectPuzzleController (Board b, Application p, String puzzleName) {
		this.board = b;
		this.plane = p;
		this.puzzleName = puzzleName;
	}
	/**
	 * Selection event occurred; if activate is true, then selection starting, otherwise selection ending
	 * 
	 * ActionEvent which element from the model was selected
	 * activate whether selecting or un-selecting
	 */
	
	public void actionPerformed(ActionEvent e) {
		Puzzle p = new Puzzle(this.puzzleName);
		
		List<PlacedShape> puzzleShapes;
		puzzleShapes = (new ShapeLoader(FilePathConfig.getPuzzlePath(this.board.getShapeset().getName(), this.puzzleName))).load();
		p.setShape(puzzleShapes);
		
		
		String shapesetName = this.board.getShapeset().getName();
		ShapeLoader loader;
		if(PuzzleChecker.check(shapesetName, this.puzzleName)) {
			loader = new ShapeLoader(FilePathConfig.getPuzzleSolutionPath(shapesetName, this.puzzleName));
		} else {
			loader = new ShapeLoader(FilePathConfig.getShapesetPath(shapesetName));
		}
		
		this.board.setShapes(loader.load());
		this.board.setPuzzle(p);
		
		this.plane.jumpPage("p3");
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the plane.
	 *
	 * @return the plane
	 */
	public Application getPlane() {
		return plane;
	}

	/**
	 * Gets the puzzle name.
	 *
	 * @return the puzzle name
	 */
	public String getPuzzleName() {
		return puzzleName;
	}
}
