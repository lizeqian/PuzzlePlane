package PuzzlePlane.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PuzzlePlane.controllers.windowJump.*;
import PuzzlePlane.models.Board;

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
	public PuzzleSolvedView(Board b, PuzzlePlaneGui p) {
		ExitInfoBoardController exitInfoBoardController = new ExitInfoBoardController(b, p);
		JButton buttonContinue = new JButton("Continue");
		buttonContinue.addActionListener(exitInfoBoardController);
		this.add(buttonContinue);
	}

}
