
package plane.controllers.actions;

import java.awt.event.ActionEvent;

import plane.controllers.AbstractAction;
import plane.controllers.SolutionCheckController;
import plane.models.Board;
import plane.models.Move;
import plane.views.PuzzleSolvingView;

/**
 * The Class ShapeLeftRotateController.
 */
public class ShapeLeftRotateController extends AbstractAction{

	/**
	 * Instantiates a new shape left rotate controller.
	 *
	 * @param b the b
	 * @param p the p
	 * @param s the s
	 */
	public ShapeLeftRotateController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.board.rotate(LEFT_ROTATE);
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}
}
