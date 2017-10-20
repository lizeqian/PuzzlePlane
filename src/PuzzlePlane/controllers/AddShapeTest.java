package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class AddShapeTest implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Board board;
	ArrayList<Point> s = new ArrayList<Point>(), s1 = new ArrayList<Point>();
	//ArrayList<Point> puzzleShape = new ArrayList<>();
	
	public AddShapeTest(PuzzlePlaneGui p, Board b) {
		this.puzzlePlaneGui = p;
		this.board = b;
		Point x = new Point();
		Point y = new Point();
		Point z = new Point();
		x.setLocation(0, 0);
		y.setLocation(-10, 100);
		z.setLocation(50, 100);
		s.add(x);
		s.add(y);
		s.add(z);
		s.add(x);
		
		Point x1 = new Point();
		Point y1 = new Point();
		Point z1 = new Point();
		x1.setLocation(0, 0);
		y1.setLocation(110, 120);
		z1.setLocation(170, 120);
		s1.add(x1);
		s1.add(y1);
		s1.add(z1);
		s1.add(x1);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p3");
		this.board.initialAddShape(this.s, new Color(255, 0, 0));	//Shapes should only be added the first time been triggered, color (int r, int g, int b)
		this.board.initialAddShape(this.s1, new Color(0, 255, 0));
		
	}
}