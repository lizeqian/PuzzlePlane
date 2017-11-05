package PuzzlePlane.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class PuzzleSolvedView extends JPanel {


	private static final long serialVersionUID = -8871562550953938083L;



	/**
	 * Create the frame.
	 */
	public PuzzleSolvedView() {
		JButton buttonContinue = new JButton("Continue");
		this.add(buttonContinue);
	}

}
