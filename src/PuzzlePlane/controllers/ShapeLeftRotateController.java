/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeLeftRotateController extends ShapeOperation{

	public ShapeLeftRotateController(Board b, PuzzleSolvingView p) {
		// TODO Auto-generated constructor stub
		super(b, p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.board.rotate(LEFT_ROTATE);
		this.puzzleSolvingView.repaint();
	}
}
