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

public class ShapeLeftRotateController extends AbstractAction{

	public ShapeLeftRotateController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.board.rotate(LEFT_ROTATE);
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}
}
