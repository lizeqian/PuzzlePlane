package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.views.Applicatoin;

public class ViewShapesetController implements ActionListener{

	public Applicatoin plane;
	
	public ViewShapesetController(Applicatoin plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p5");
	}

}
