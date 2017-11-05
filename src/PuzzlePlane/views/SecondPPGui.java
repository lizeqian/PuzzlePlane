package PuzzlePlane.views;


import javax.swing.JPanel;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.controllers.SelectPuzzleController;
import PuzzlePlane.controllers.windowJump.BacktoShapesetController;
import PuzzlePlane.models.Board;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SecondPPGui extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5157226398944441626L;
	
	Board board;
	PuzzlePlaneGui plane;
	
	/**
	 * Create the frame.
	 */
	public SecondPPGui(Board b, PuzzlePlaneGui p) {

		setLayout(null);
		
		JButton traditionalPuzzle1Button = new JButton("fox");
		traditionalPuzzle1Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("fox"))));
		traditionalPuzzle1Button.setBounds(199, 155, 95, 101);
		traditionalPuzzle1Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("fox")));
		add(traditionalPuzzle1Button);

		
		JButton traditionalPuzzle2Button = new JButton("bird");
		traditionalPuzzle2Button.setBounds(349, 155, 95, 101);
		traditionalPuzzle2Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("bird"))));
		traditionalPuzzle2Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("bird")));
		add(traditionalPuzzle2Button);
		
		JButton traditionalPuzzle3Button = new JButton("rabbit");
		traditionalPuzzle3Button.setBounds(501, 155, 95, 101);
		traditionalPuzzle3Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("rabbit"))));
		traditionalPuzzle3Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("rabbit")));
	    add(traditionalPuzzle3Button);
		
		JButton traditionalPuzzle4Button = new JButton("cristal");
		traditionalPuzzle4Button.setBounds(656, 155, 95, 101);
		traditionalPuzzle4Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("cristal"))));
		traditionalPuzzle4Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("cristal")));
		add(traditionalPuzzle4Button);
		
		JButton traditionalPuzzle5Button = new JButton("fish");
		traditionalPuzzle5Button.setBounds(199, 317, 95, 101);
		traditionalPuzzle5Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("fish"))));
		traditionalPuzzle5Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("fish")));
		add(traditionalPuzzle5Button);
		
		JButton traditionalPuzzle6Button = new JButton("duck");
		traditionalPuzzle6Button.setBounds(349, 317, 95, 101);
		traditionalPuzzle6Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("duck"))));
		traditionalPuzzle6Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("duck")));
		add(traditionalPuzzle6Button);
		
		JButton traditionalPuzzle7Button = new JButton("dontknow");
		traditionalPuzzle7Button.setBounds(501, 317, 95, 101);
		traditionalPuzzle7Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("dontknow"))));
		traditionalPuzzle7Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath()+ FilePathConfig.puzzleName.get("dontknow")));
		add(traditionalPuzzle7Button);
		
		JButton traditionalPuzzle8Button = new JButton("turtle");
		traditionalPuzzle8Button.setBounds(656, 317, 95, 101);
		traditionalPuzzle8Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("turtle"))));
		traditionalPuzzle8Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("turtle")));
		add(traditionalPuzzle8Button);
		
		JButton traditionalPuzzle9Button = new JButton("house");
		traditionalPuzzle9Button.setBounds(199, 483, 95, 101);
		traditionalPuzzle9Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("house"))));
		traditionalPuzzle9Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("house")));
		add(traditionalPuzzle9Button);
		
		JButton traditionalPuzzle10Button = new JButton("dog");
		traditionalPuzzle10Button.setBounds(349, 483, 95, 101);
		traditionalPuzzle10Button.setIcon(new ImageIcon(SecondPPGui.class.getResource(FilePathConfig.puzzleImgPath.get("dog"))));
		traditionalPuzzle10Button.addActionListener(new SelectPuzzleController(b, p, p.getPuzzleFolderPath() + FilePathConfig.puzzleName.get("dog")));
		add(traditionalPuzzle10Button);
		
		
		JLabel chooseAPuzzleTitle = new JLabel("Choose a Puzzle");
		chooseAPuzzleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAPuzzleTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseAPuzzleTitle.setBounds(375, 90, 221, 25);
		add(chooseAPuzzleTitle);
		
		JButton btnBacktoShapeset = new JButton("Back to Shapeset");
		btnBacktoShapeset.setBounds(544, 550, 187, 34);
		btnBacktoShapeset.addActionListener(new BacktoShapesetController(p));
		add(btnBacktoShapeset);
	}
}
