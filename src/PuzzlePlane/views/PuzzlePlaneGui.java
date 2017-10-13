package PuzzlePlane.views;
import PuzzlePlane.models.*;
import PuzzlePlane.controllers.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;


//This JFrame is the main Frame of application. Use JPanels as content, and switch JPanels for each different view
public class PuzzlePlaneGui extends JFrame {
	Board board;
	
	public PuzzlePlaneGui(Board b) {
		super ("Puzzle Plane");
		
		this.board = b;
		
		setSize(600, 600);
//TODO add panels		
	}
	
}