/*
 * author: cheng zhu
 */

package PuzzlePlane.views;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PuzzlePlane.controllers.windowJump.ExitViewShapesetController;

public class ViewShapesetPPGui extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4858060950773618051L;
	
	public PuzzlePlaneGui plane;
	public JLabel label;

	public void reset() {
		if(label != null) this.remove(label);
		if(this.plane.getShapesetImgPath() != null) {
			this.draw();
		}
	}

	public ViewShapesetPPGui(PuzzlePlaneGui plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
		setLayout(null);
		this.setSize(500, 500);
		draw();
	}
	
	public void drawLabel() {
		String path = this.plane.getShapesetImgPath();
		if(path != null) {
			URL shapesetURL = this.getClass().getResource(path);
			this.label = new JLabel(new ImageIcon(shapesetURL));
			label.setBounds(30, 10, 436, 440);
			add(label);
		}
	}
	
	public void draw() {
		this.drawLabel();
		ExitViewShapesetController exitViewShapesetControl = new ExitViewShapesetController(plane);
		JButton buttonExit = new JButton("Return");
		buttonExit.setBounds(215, 450, 90, 30);
		buttonExit.addActionListener(exitViewShapesetControl);
		add(buttonExit);
	}

}
