package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public class ExitPuzzleSolvingController implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	
	public ExitPuzzleSolvingController(Board b, PuzzlePlaneGui p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}
}