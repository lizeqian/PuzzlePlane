package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.controllers.PuzzleStatusChecker;
import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ExitInfoBoardController implements ActionListener {
	Application puzzlePlaneGui;
	Board board;
	//StatusFileOperator statusFileOperator;
	
	public ExitInfoBoardController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.setSolvedPuzzleNames((new PuzzleStatusChecker(this.board, this.puzzlePlaneGui)).getSolvedPuzzleNames());
		this.puzzlePlaneGui.jumpPage("p2");
		//this.statusFileOperator.writeFile(this.board.getIsSolved());
	}
}
