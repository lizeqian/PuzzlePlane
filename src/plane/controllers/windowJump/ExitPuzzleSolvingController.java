package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

public class ExitPuzzleSolvingController implements ActionListener{
	Application puzzlePlaneGui;
	Board board;
	
	public ExitPuzzleSolvingController(Board b, Application p) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.board.resetAllShapePosition();
		this.puzzlePlaneGui.jumpPage("p2");
	}

	public Application getPuzzlePlaneGui() {
		return puzzlePlaneGui;
	}

	public Board getBoard() {
		return board;
	}
}