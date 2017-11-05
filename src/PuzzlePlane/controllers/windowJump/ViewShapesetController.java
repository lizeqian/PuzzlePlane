package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.views.PuzzlePlaneGui;

public class ViewShapesetController implements ActionListener{

	public PuzzlePlaneGui plane;
	
	public ViewShapesetController(PuzzlePlaneGui plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p5");
	}

}
