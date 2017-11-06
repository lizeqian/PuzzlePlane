package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ExitPuzzleSolvingController implements ActionListener{
	Applicatoin puzzlePlaneGui;
	Board board;
	
	public ExitPuzzleSolvingController(Board b, Applicatoin p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}
}