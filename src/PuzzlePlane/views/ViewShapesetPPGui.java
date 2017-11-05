/*
 * author: cheng zhu
 */

package PuzzlePlane.views;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import PuzzlePlane.controllers.windowJump.ExitViewShapesetController;

public class ViewShapesetPPGui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4381446148073635689L;

	public ViewShapesetPPGui(String path) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		this.setSize(500, 500);
		this.setTitle("Shapeset");
		URL shapesetURL = this.getClass().getResource(path);
		JLabel label = new JLabel(new ImageIcon(shapesetURL));
		label.setBounds(30, 10, 436, 440);
		add(label);
		
		ExitViewShapesetController exitViewShapesetControl = new ExitViewShapesetController(this);
		JButton buttonExit = new JButton("Exit");
		buttonExit.setBounds(215, 450, 90, 30);
		buttonExit.addActionListener(exitViewShapesetControl);
		add(buttonExit);
	}

}
