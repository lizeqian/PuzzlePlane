/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers.actions;

import java.awt.event.ActionEvent;

import PuzzlePlane.controllers.AbstractAction;
import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeLeftRotateController extends AbstractAction{

	public ShapeLeftRotateController(Board b, PuzzleSolvingView p) {
		// TODO Auto-generated constructor stub
		super(b, p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		this.board.rotate(LEFT_ROTATE);
		this.afterStatus.rotate(LEFT_ROTATE);
		this.puzzleSolvingView.repaint();
	}
}
