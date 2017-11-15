package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import plane.config.FilePathConfig;
import plane.models.Board;
import plane.models.Shapeset;
import plane.views.Application;
import plane.views.SecondPPGui;
import plane.views.ViewShapesetPPGui;
/**
 * The class SelectShapesetController
 * Respond to selection events in the Puzzle Plane, which has been configured to only 
 * allow individual rows to be selected.
 */

public class SelectShapesetController implements ActionListener{
	/** Needs board to be able to select elements. */
	public Board board;
	/** Needs panel so it can redraw the board. */
	public Application plane;
	/** Needs shapesetName*/
	public String shapesetName;
	
	public Board getBoard() {
		return board;
	}

	public Application getPlane() {
		return plane;
	}
	
	public String getShapesetName() {
		return shapesetName;
	}

	public void setShapesetName(String shapesetName) {
		this.shapesetName = shapesetName;
	}
	/** Controller constructed with board (entity) and panel (boundary) and shapesetName. */
	
	public SelectShapesetController(Application p, Board board, String shapesetName) {
		// TODO Auto-generated constructor stub
		this.plane = p;
		this.board = board;
		this.shapesetName = shapesetName;
	}

	@Override
	/**
	 * Selection event occurred; if activate is true, then selection starting, otherwise selection ending
	 * 
	 * ActionEvent which element from the model was selected
	 * activate whether selecting or un-selecting
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.setShapeset(new Shapeset(this.shapesetName));
		((SecondPPGui)(this.plane.p_2)).reset();
		((ViewShapesetPPGui)(this.plane.p_5)).reset();
		this.plane.jumpPage("p2");
	}

}
