/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeRightRotateController extends ShapeOperationController {

	public ShapeRightRotateController(Board b, PuzzleSolvingView p) {
		// TODO Auto-generated constructor stub
		super(b, p);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.rotate(RIGHT_ROTATE);
		this.puzzleSolvingView.repaint();
	}
}
