package plane.views;


import javax.swing.JPanel;

import plane.config.FilePathConfig;
import plane.config.NameConfig;
import plane.controllers.PuzzleChecker;
import plane.controllers.SelectPuzzleController;
import plane.controllers.windowJump.BacktoShapesetController;
import plane.models.Board;
import plane.models.Puzzle;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingConstants;

/**
 * The Class SecondPPGui. This is a panel that displays the puzzle selection view.
 * @author cheng zhu, yinkai ma
 */
public class SecondPPGui extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5157226398944441626L;
	
	/** The Constant bounds. */
	public static final List<Rectangle> bounds;
	
	static {
		bounds = new ArrayList<Rectangle>();
		bounds.add(new Rectangle(199, 155, 95, 101));
		bounds.add(new Rectangle(349, 155, 95, 101));
		bounds.add(new Rectangle(501, 155, 95, 101));
		bounds.add(new Rectangle(656, 155, 95, 101));
		bounds.add(new Rectangle(199, 317, 95, 101));
		bounds.add(new Rectangle(349, 317, 95, 101));
		bounds.add(new Rectangle(501, 317, 95, 101));
		bounds.add(new Rectangle(656, 317, 95, 101));
		bounds.add(new Rectangle(199, 483, 95, 101));
		bounds.add(new Rectangle(349, 483, 95, 101));
	}
	
	/** The board. */
	Board board;
	
	/** The plane. */
	Application plane;
	
	/** The buttons. */
	List<JButton> buttons;
	
	/** Create the panel.
	 * @param b the board.
	 * @param p the application.
	 */
	public SecondPPGui(Board b, Application p) {
		setLayout(null);
		this.board = b;
		this.plane = p;
		buttons = new ArrayList<>();
	}
	
	/** Reset. */
	public void reset() {
		for(JButton button : buttons) {
			this.remove(button);
		}
		draw();
	}
	
	/** Draw buttons. */
	public void drawButtons() {
		String shapesetName = this.board.getShapeset().getName();
		if (shapesetName == null) return;
		List<Puzzle> puzzles = this.board.getShapeset().getPuzzles();
		
		for(int i = 0; i < puzzles.size(); i++) {
			Puzzle puzzle = puzzles.get(i);
			Rectangle rect = SecondPPGui.bounds.get(i);
			
			JButton button = new JButton(puzzle.getName());
			if (!PuzzleChecker.check(shapesetName, puzzle.getName())) {
				button.setIcon(new ImageIcon(FilePathConfig.getPuzzleIconPath(shapesetName, puzzle.getName())));
			} else {
				button.setIcon(new ImageIcon(FilePathConfig.getSolvedPuzzleIconPath(shapesetName, puzzle.getName())));
			}
			button.setBounds(rect);
			button.addActionListener(new SelectPuzzleController(board, plane, puzzle.getName()));
			
			add(button);
			this.buttons.add(button);
		}
	}
	
	/**
	 * Add JLabel to display the title of the page
	 * Add "Back to Shapeset" Button to go back to shpeset selection page.
	 */
	public void draw() {
		this.drawButtons();
		
		JLabel chooseAPuzzleTitle = new JLabel("Choose a Puzzle");
		chooseAPuzzleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAPuzzleTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseAPuzzleTitle.setBounds(375, 90, 221, 25);
		add(chooseAPuzzleTitle);
		
		JButton btnBacktoShapeset = new JButton("Back to Shapeset");
		btnBacktoShapeset.setBounds(544, 550, 187, 34);
		btnBacktoShapeset.addActionListener(new BacktoShapesetController(plane));
		add(btnBacktoShapeset);
	}
}
