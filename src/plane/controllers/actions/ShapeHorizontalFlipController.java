/***********
 * @author cheng zhu
 */
package plane.controllers.actions;

import java.awt.event.ActionEvent;

import plane.controllers.AbstractAction;
import plane.controllers.Move;
import plane.controllers.SolutionCheckController;
import plane.models.Board;
import plane.views.PuzzleSolvingView;

public class ShapeHorizontalFlipController extends AbstractAction{

	public ShapeHorizontalFlipController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.hFlip();
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}
}