package PuzzlePlane.controllers.windowJump;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;

import PuzzlePlane.views.ViewShapesetPPGui;

public class ViewShapesetController implements ActionListener{

	public String shapesetPath;
	public JFrame viewShapesetFrame;
	
	public ViewShapesetController(String path) {
		// TODO Auto-generated constructor stub
		this.shapesetPath = path;
		this.viewShapesetFrame = new ViewShapesetPPGui(shapesetPath);
		this.viewShapesetFrame.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.viewShapesetFrame.setVisible(true);
	}

}
