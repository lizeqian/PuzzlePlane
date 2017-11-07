package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.views.*;
import java.awt.event.*;

public class BacktoShapesetController implements ActionListener{
	Application puzzlePlaneGui;
	
	public BacktoShapesetController(Application p) {
		this.puzzlePlaneGui = p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}