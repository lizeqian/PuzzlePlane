package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ExitViewShapesetController implements ActionListener{
	
	JFrame viewShapesetFrame;
	
	public ExitViewShapesetController(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.viewShapesetFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.viewShapesetFrame.setVisible(false);
	}

}
