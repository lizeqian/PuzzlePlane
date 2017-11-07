package plane.controllers.windowJump;

import plane.models.*;
import plane.views.*;

import java.awt.event.*;

public class EnterPuzzleSolvingController implements ActionListener{
	Application puzzlePlaneGui;
	Board board;
	
	public EnterPuzzleSolvingController(Application p, Board b) {
		this.puzzlePlaneGui = p;
		this.board = b;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}