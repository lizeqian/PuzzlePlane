package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PuzzlePlane.views.Applicatoin;

public class ExitViewShapesetController implements ActionListener{
	
	Applicatoin plane;
	
	public ExitViewShapesetController(Applicatoin plane) {
		// TODO Auto-generated constructor stub
		this.plane= plane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p3");
	}

}
