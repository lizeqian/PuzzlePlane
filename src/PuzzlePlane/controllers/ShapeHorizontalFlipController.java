/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeHorizontalFlipController extends ShapeOperation{

	public ShapeHorizontalFlipController(Board b, PuzzleSolvingView p) {
		// TODO Auto-generated constructor stub
		super(b, p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.hFlip();
		this.puzzleSolvingView.repaint();
	}
}
