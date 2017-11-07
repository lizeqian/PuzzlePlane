package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.controllers.StatusFileOperator;
import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ExitInfoBoardController implements ActionListener {
	Application puzzlePlaneGui;
	Board board;
	StatusFileOperator statusFileOperator;
	
	public ExitInfoBoardController(Board b, Application p, StatusFileOperator s) {
		this.puzzlePlaneGui = p;
		this.board = b;
		this.statusFileOperator = s;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
		//this.board.setPuzzleSolved();
		this.statusFileOperator.writeFile(this.board.getIsSolved());
	}
}
