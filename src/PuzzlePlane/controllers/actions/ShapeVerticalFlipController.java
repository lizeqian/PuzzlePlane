/***********
 * @author cheng zhu
 */
package PuzzlePlane.controllers.actions;

import java.awt.event.ActionEvent;

import PuzzlePlane.controllers.AbstractAction;
import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzleSolvingView;

public class ShapeVerticalFlipController extends AbstractAction implements Move{

	public ShapeVerticalFlipController(Board b, PuzzleSolvingView p) {
		// TODO Auto-generated constructor stub
		super(b, p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.vFlip();
		this.puzzleSolvingView.repaint();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
