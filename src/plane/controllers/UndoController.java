package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plane.models.Board;
import plane.views.Application;
import plane.views.PuzzleSolvingView;

public class UndoController implements ActionListener{
	public Board board;
	public PuzzleSolvingView plane;
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public PuzzleSolvingView getPlane() {
		return plane;
	}

	public void setPlane(PuzzleSolvingView plane) {
		this.plane = plane;
	}

	public UndoController(Board b, PuzzleSolvingView puzzleSolvingView) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.plane = puzzleSolvingView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.board.undo();
		this.plane.repaint();
	}

}
