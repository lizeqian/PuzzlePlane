package plane.controllers;
/** 
 * Class RedoController
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.models.Board;
import plane.views.PuzzleSolvingView;

public class RedoController implements ActionListener{
	public Board board;
	public PuzzleSolvingView plane;
	
	public RedoController(Board b, PuzzleSolvingView puzzleSolvingView) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.plane = puzzleSolvingView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.redo();
		this.plane.repaint();
	}

	public Board getBoard() {
		return board;
	}

	public PuzzleSolvingView getPlane() {
		return plane;
	}
}
