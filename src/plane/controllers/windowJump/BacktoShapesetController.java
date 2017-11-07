package plane.controllers.windowJump;

import java.awt.event.*;

import plane.views.*;

public class BacktoShapesetController implements ActionListener{
	Application puzzlePlaneGui;
	
	public BacktoShapesetController(Application p) {
		this.puzzlePlaneGui = p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}