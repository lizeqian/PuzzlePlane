package plane.views;

import java.awt.Font;

import javax.swing.JPanel;

import plane.controllers.windowJump.*;
import plane.models.Board;

import javax.swing.JLabel;

import javax.swing.JButton;

/**
 * The Class PuzzleSolvedView.
 * @author Zeqian Li，yinkai ma,Li Zhang
 */
public class PuzzleSolvedView extends JPanel {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8871562550953938083L;



	/** Create the panel.
	 * @param b the board.
	 * @param p the application.
	 */
	public PuzzleSolvedView(Board b, Application p) {
		setLayout(null);
		
		/** Add a button to confirm the congratulation notice. */
		ExitInfoBoardController exitInfoBoardController = new ExitInfoBoardController(b, p);
		JButton buttonContinue = new JButton("Continue");
		buttonContinue.addActionListener(exitInfoBoardController);
		buttonContinue.setBounds(450, 600, 100, 30);
		this.add(buttonContinue);
		/** Add a JLabel to display the congratulation notice on the page. */
		JLabel jlabel = new JLabel("Congratulations! Puzzle Completed!");
	    jlabel.setFont(new Font("Verdana",1,20));
	    jlabel.setBounds(300, 200, 400, 30);
	    this.add(jlabel);
	}

}
