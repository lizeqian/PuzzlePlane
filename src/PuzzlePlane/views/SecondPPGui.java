package PuzzlePlane.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PuzzlePlane.controllers.SelectPuzzleController;
import PuzzlePlane.controllers.SelectShapesetController;
import PuzzlePlane.controllers.BacktoShapeset;
import PuzzlePlane.models.Board;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SecondPPGui extends JPanel {
	Board board;
	PuzzlePlaneGui plane;
	
	/**
	 * Create the frame.
	 */
	public SecondPPGui(Board b, PuzzlePlaneGui p) {
		/*
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 806);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		*/
		setLayout(null);
		
		JButton traditionalPuzzle1Button = new JButton("New button");
		traditionalPuzzle1Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/9fox100.jpeg")));
		traditionalPuzzle1Button.setBounds(199, 155, 95, 101);
		traditionalPuzzle1Button.addActionListener(new SelectPuzzleController(b, p));
		add(traditionalPuzzle1Button);

		
		JButton traditionalPuzzle2Button = new JButton("New button");
		traditionalPuzzle2Button.setBounds(349, 155, 95, 101);
		traditionalPuzzle2Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/1bird100.jpg")));
		add(traditionalPuzzle2Button);
		
		JButton traditionalPuzzle3Button = new JButton("New button");
		traditionalPuzzle3Button.setBounds(501, 155, 95, 101);
		traditionalPuzzle3Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/2rabbit.jpeg")));
	    add(traditionalPuzzle3Button);
		
		JButton traditionalPuzzle4Button = new JButton("New button");
		traditionalPuzzle4Button.setBounds(656, 155, 95, 101);
		traditionalPuzzle4Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/3cristal.jpeg")));
		add(traditionalPuzzle4Button);
		
		JButton traditionalPuzzle5Button = new JButton("New button");
		traditionalPuzzle5Button.setBounds(199, 317, 95, 101);
		traditionalPuzzle5Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/4fish.jpeg")));
		add(traditionalPuzzle5Button);
		
		JButton traditionalPuzzle6Button = new JButton("New button");
		traditionalPuzzle6Button.setBounds(349, 317, 95, 101);
		traditionalPuzzle6Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/5duck.jpeg")));
		add(traditionalPuzzle6Button);
		
		JButton traditionalPuzzle7Button = new JButton("New button");
		traditionalPuzzle7Button.setBounds(501, 317, 95, 101);
		traditionalPuzzle7Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/6dontknow.jpeg")));
		add(traditionalPuzzle7Button);
		
		JButton traditionalPuzzle8Button = new JButton("New button");
		traditionalPuzzle8Button.setBounds(656, 317, 95, 101);
		traditionalPuzzle8Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/7turtle.jpeg")));
		add(traditionalPuzzle8Button);
		
		JButton traditionalPuzzle9Button = new JButton("New button");
		traditionalPuzzle9Button.setBounds(199, 483, 95, 101);
		traditionalPuzzle9Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/8house100.jpg")));
		add(traditionalPuzzle9Button);
		
		JButton traditionalPuzzle10Button = new JButton("New button");
		traditionalPuzzle10Button.setBounds(349, 483, 95, 101);
		traditionalPuzzle10Button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/10dog100.jpeg")));
		add(traditionalPuzzle10Button);
		
		/*JButton returnShapeSetButton = new JButton("Return");
		returnShapeSetButton.setBounds(656, 555, 95, 46);
		add(returnShapeSetButton);*/
		
		JLabel chooseAPuzzleTitle = new JLabel("Choose a Puzzle");
		chooseAPuzzleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAPuzzleTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chooseAPuzzleTitle.setBounds(375, 90, 221, 25);
		add(chooseAPuzzleTitle);
		
		JButton btnBacktoShapeset = new JButton("Back to Shapeset");
		btnBacktoShapeset.setBounds(544, 550, 187, 34);
		btnBacktoShapeset.addActionListener(new BacktoShapeset(p));
		//btnBackToShapeset.addActionListener(new BacktoShapeset(b, p));
		add(btnBacktoShapeset);
	}
}
