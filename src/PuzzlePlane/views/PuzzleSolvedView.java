package PuzzlePlane.views;

import java.awt.Font;

import javax.swing.JPanel;

import PuzzlePlane.controllers.StatusFileOperator;
import PuzzlePlane.controllers.windowJump.*;
import PuzzlePlane.models.Board;

import javax.swing.JLabel;

import javax.swing.JButton;

public class PuzzleSolvedView extends JPanel {


	private static final long serialVersionUID = -8871562550953938083L;



	/**
	 * Create the frame.
	 */
	public PuzzleSolvedView(Board b, Application p ,StatusFileOperator s) {
		setLayout(null);
		
		
		ExitInfoBoardController exitInfoBoardController = new ExitInfoBoardController(b, p, s);
		JButton buttonContinue = new JButton("Continue");
		buttonContinue.addActionListener(exitInfoBoardController);
		buttonContinue.setBounds(450, 600, 100, 30);
		this.add(buttonContinue);
		
		JLabel jlabel = new JLabel("Congratulations! Puzzle Completed!");
	    jlabel.setFont(new Font("Verdana",1,20));
	    jlabel.setBounds(300, 200, 400, 30);
	    this.add(jlabel);
	}

}
