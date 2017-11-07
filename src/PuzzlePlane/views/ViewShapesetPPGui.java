/*
 * author: cheng zhu
 */

package PuzzlePlane.views;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.controllers.windowJump.ExitViewShapesetController;

public class ViewShapesetPPGui extends JPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4858060950773618051L;
	
	public Application plane;
	public JLabel label;

	public void reset() {
		if(label != null) this.remove(label);
		this.draw();
	}

	public ViewShapesetPPGui(Application plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
		setLayout(null);
		this.setSize(500, 500);
		draw();
	}
	
	public void drawLabel() {
		String shapesetName = this.plane.getShapesetName();
		if(shapesetName == null) return;
		String path = FilePathConfig.getShapesetIconPath(shapesetName);
		if(path != null) {
			this.label = new JLabel(new ImageIcon(path));
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
