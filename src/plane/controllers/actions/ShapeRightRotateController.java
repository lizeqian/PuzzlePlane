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

public class ShapeRightRotateController extends AbstractAction{

	public ShapeRightRotateController(Board b, PuzzleSolvingView p, SolutionCheckController s) {
		// TODO Auto-generated constructor stub
		super(b, p, s);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.rotate(RIGHT_ROTATE);
		this.puzzleSolvingView.repaint();
		this.solutionCheckController.check();
	}
}
