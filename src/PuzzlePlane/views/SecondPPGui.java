package PuzzlePlane.views;


import javax.swing.JPanel;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.config.NameConfig;
import PuzzlePlane.controllers.SelectPuzzleController;
import PuzzlePlane.controllers.windowJump.BacktoShapesetController;
import PuzzlePlane.models.Board;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.SwingConstants;

public class SecondPPGui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5157226398944441626L;
	
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
	
	Board board;
	Application plane;
	List<JButton> buttons;
	
	/**
	 * Create the frame.
	 */
	public SecondPPGui(Board b, Application p) {
		setLayout(null);
		this.board = b;
		this.plane = p;
		buttons = new ArrayList<>();
		draw();
	}
	
	public void reset() {
		for(JButton button : buttons) {
			this.remove(button);
		}
		drawButtons();
	}
	
	public void drawButtons() {
		String shapesetName = this.plane.getShapesetName();
		if (shapesetName == null) return;
		List<String> puzzleNames = NameConfig.getPuzzles(shapesetName);
		Set<String> solvedPuzzleNames = this.plane.getSolvedPuzzleNames();
		
		for(int i = 0; i < puzzleNames.size(); i++) {
			String puzzleName = puzzleNames.get(i);
			Rectangle rect = SecondPPGui.bounds.get(i);
			
			JButton button = new JButton(puzzleName);
			if (solvedPuzzleNames == null || !solvedPuzzleNames.contains(puzzleName)) {
				button.setIcon(new ImageIcon(FilePathConfig.getPuzzleIconPath(shapesetName, puzzleName)));
			} else {
				button.setIcon(new ImageIcon(FilePathConfig.getSolvedPuzzleIconPath(shapesetName, puzzleName)));
			}
			button.setBounds(rect);
			button.addActionListener(new SelectPuzzleController(board, plane, puzzleName));
			
			add(button);
			this.buttons.add(button);
		}
	}
	
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
