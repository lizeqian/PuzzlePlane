/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers.actions;

import java.awt.event.ActionEvent;

import PuzzlePlane.controllers.AbstractAction;
import PuzzlePlane.controllers.Move;
import PuzzlePlane.controllers.SolutionCheckController;
import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeVerticalFlipController extends AbstractAction{

	public ShapeVerticalFlipController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.vFlip();
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}

}
