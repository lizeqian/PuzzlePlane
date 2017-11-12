package plane.controllers.windowJump;

import plane.controllers.PuzzleStatusChecker;
import plane.models.*;
import plane.views.*;

import java.awt.event.*;

public class ExitInfoBoardController implements ActionListener {
	Application puzzlePlaneGui;
	Board board;
	
	public ExitInfoBoardController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.setSolvedPuzzleNames((new PuzzleStatusChecker(this.board, this.puzzlePlaneGui)).getSolvedPuzzleNames());
		this.puzzlePlaneGui.jumpPage("p2");
	}

	public Application getPuzzlePlaneGui() {
		return puzzlePlaneGui;
	}

	public Board getBoard() {
		return board;
	}
}
