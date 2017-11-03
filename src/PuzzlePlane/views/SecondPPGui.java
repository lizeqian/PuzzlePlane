package PuzzlePlane.views;


import javax.swing.JPanel;

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
	String puzzleFolderName;
	
	/**
	 * Create the frame.
	 */
	public SecondPPGui(Board b, PuzzlePlaneGui p) {

		setLayout(null);
		
		this.puzzleFolderName = p.puzzleFolerName;
		
		JButton traditionalPuzzle1Button = new JButton("fox");
		traditionalPuzzle1Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/9fox100.jpeg")));
		traditionalPuzzle1Button.setBounds(199, 155, 95, 101);
		traditionalPuzzle1Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/traditional/0.txt"));
		add(traditionalPuzzle1Button);

		
		JButton traditionalPuzzle2Button = new JButton("bird");
		traditionalPuzzle2Button.setBounds(349, 155, 95, 101);
		traditionalPuzzle2Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/1bird100.jpg")));
		traditionalPuzzle2Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/1.txt"));
		add(traditionalPuzzle2Button);
		
		JButton traditionalPuzzle3Button = new JButton("rabbit");
		traditionalPuzzle3Button.setBounds(501, 155, 95, 101);
		traditionalPuzzle3Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/2rabbit.jpeg")));
		traditionalPuzzle3Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/2.txt"));
	    add(traditionalPuzzle3Button);
		
		JButton traditionalPuzzle4Button = new JButton("cristal");
		traditionalPuzzle4Button.setBounds(656, 155, 95, 101);
		traditionalPuzzle4Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/3cristal.jpeg")));
		traditionalPuzzle4Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/3.txt"));
		add(traditionalPuzzle4Button);
		
		JButton traditionalPuzzle5Button = new JButton("fish");
		traditionalPuzzle5Button.setBounds(199, 317, 95, 101);
		traditionalPuzzle5Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/4fish.jpeg")));
		traditionalPuzzle5Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/4.txt"));
		add(traditionalPuzzle5Button);
		
		JButton traditionalPuzzle6Button = new JButton("duck");
		traditionalPuzzle6Button.setBounds(349, 317, 95, 101);
		traditionalPuzzle6Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/5duck.jpeg")));
		traditionalPuzzle6Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/5.txt"));
		add(traditionalPuzzle6Button);
		
		JButton traditionalPuzzle7Button = new JButton("dontknow");
		traditionalPuzzle7Button.setBounds(501, 317, 95, 101);
		traditionalPuzzle7Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/6dontknow.jpeg")));
		traditionalPuzzle7Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/6.txt"));
		add(traditionalPuzzle7Button);
		
		JButton traditionalPuzzle8Button = new JButton("turtle");
		traditionalPuzzle8Button.setBounds(656, 317, 95, 101);
		traditionalPuzzle8Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/7turtle.jpeg")));
		traditionalPuzzle8Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/7.txt"));
		add(traditionalPuzzle8Button);
		
		JButton traditionalPuzzle9Button = new JButton("house");
		traditionalPuzzle9Button.setBounds(199, 483, 95, 101);
		traditionalPuzzle9Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/8house100.jpg")));
		traditionalPuzzle9Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/8.txt"));
		add(traditionalPuzzle9Button);
		
		JButton traditionalPuzzle10Button = new JButton("dog");
		traditionalPuzzle10Button.setBounds(349, 483, 95, 101);
		traditionalPuzzle10Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/10dog100.jpeg")));
		traditionalPuzzle10Button.addActionListener(new SelectPuzzleController(b, p, "puzzle/" + puzzleFolderName + "/9.txt"));
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
