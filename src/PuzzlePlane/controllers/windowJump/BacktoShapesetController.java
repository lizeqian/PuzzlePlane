package PuzzlePlane.controllers.windowJump;

import PuzzlePlane.views.*;
import java.awt.event.*;

public class BacktoShapesetController implements ActionListener{
	Applicatoin puzzlePlaneGui;
	
	public BacktoShapesetController(Applicatoin p) {
		this.puzzlePlaneGui = p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}