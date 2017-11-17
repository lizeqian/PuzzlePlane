/*
 * author: cheng zhu
 */

package plane.views;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import plane.config.FilePathConfig;
import plane.controllers.windowJump.ExitViewShapesetController;
import plane.models.Board;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewShapesetPPGui. 
 * This is the view to show the current selected shapeset when player is playing a puzzle.
 */
public class ViewShapesetPPGui extends JPanel{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4858060950773618051L;
	
	/** The plane. */
	public Application plane;
	
	/** The label. */
	public JLabel label;
	
	/** The board reference. */
	public Board board;
	
	/**
	 * Reset.
	 */
	public void reset() {
		if(label != null) this.remove(label);
		this.draw();
	}

	/**
	 * Instantiates a new view shapeset PuzzlePlane gui.
	 *
	 * @param b the board
	 * @param plane the plane
	 */
	public ViewShapesetPPGui(Board b, Application plane) {
		// TODO Auto-generated constructor stub
		this.plane = plane;
		this.board = b;
		setLayout(null);
		this.setSize(500, 500);
		//draw();
	}
	
	/**
	 * Draw label.
	 */
	public void drawLabel() {
		String shapesetName = this.board.getShapeset().getName();
		if(shapesetName == null) return;
		String path = FilePathConfig.getShapesetIconPath(shapesetName);
		if(path != null) {
			this.label = new JLabel(new ImageIcon(path));
			label.setBounds(30, 10, 436, 440);
			add(label);
		}
	}
	
	/**
	 * Add button for return.
	 * The current shapeset view will be closed and the system only displays the puzzle solving view.
	 */
	public void draw() {
		this.drawLabel();
		ExitViewShapesetController exitViewShapesetControl = new ExitViewShapesetController(plane);
		JButton buttonExit = new JButton("Return");
		buttonExit.setBounds(215, 450, 90, 30);
		buttonExit.addActionListener(exitViewShapesetControl);
		add(buttonExit);
	}

}
