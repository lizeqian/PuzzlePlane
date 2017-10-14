package PuzzlePlane.views;

import PuzzlePlane.models.*;
import PuzzlePlane.controllers.*;

import javax.swing.JPanel;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.GridLayout;

public class SolutionSpace extends JPanel {

	/**
	 * Create the panel.
	 */
	JButton button_next = null;
	Board board;
	PuzzlePlaneGui puzzlePlaneGui;
	
	public SolutionSpace(Board board, PuzzlePlaneGui p) {
		
		puzzlePlaneGui = p;
		
		ExitPuzzleSolving exitPuzzleSolving = new ExitPuzzleSolving(p);
		
		setLayout(null);
		
		JLabel lblSolutionspace = new JLabel("SolutionSpace");
		lblSolutionspace.setBounds(183, 22, 76, 14);
		add(lblSolutionspace);
		
		JButton button_next = new JButton("Exit Puzzle");
		button_next.setBounds(183, 64, 89, 23);
		add(button_next);
		button_next.addActionListener(exitPuzzleSolving);
	}
}
