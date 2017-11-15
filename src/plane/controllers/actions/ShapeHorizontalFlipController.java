/***********
 * @author cheng zhu
 */
package plane.controllers.actions;

import java.awt.event.ActionEvent;

import plane.controllers.AbstractAction;
import plane.controllers.SolutionCheckController;
import plane.models.Board;
import plane.models.Move;
import plane.views.PuzzleSolvingView;

// TODO: Auto-generated Javadoc
/**
 * The Class ShapeHorizontalFlipController.
 */
public class ShapeHorizontalFlipController extends AbstractAction{

	/**
	 * Instantiates a new shape horizontal flip controller.
	 *
	 * @param b the b
	 * @param p the p
	 * @param s the s
	 */
	public ShapeHorizontalFlipController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.hFlip();
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}
}
