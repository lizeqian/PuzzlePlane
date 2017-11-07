package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.views.Application;

public class ViewShapesetController implements ActionListener{

	public Application plane;
	
	public ViewShapesetController(Application plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p5");
	}

}
