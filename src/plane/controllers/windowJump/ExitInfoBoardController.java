package plane.controllers.windowJump;

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
		((SecondPPGui)this.puzzlePlaneGui.p_2).reset();
		this.puzzlePlaneGui.jumpPage("p2");
	}

	public Application getPuzzlePlaneGui() {
		return puzzlePlaneGui;
	}

	public Board getBoard() {
		return board;
	}
}
