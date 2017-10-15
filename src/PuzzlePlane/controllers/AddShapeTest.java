package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class AddShapeTest implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Palette palette;
	PolyShape s;
	
	public AddShapeTest(PuzzlePlaneGui p, Palette pl) {
		this.puzzlePlaneGui = p;
		this.palette = pl;
		Point x = new Point();
		Point y = new Point();
		Point z = new Point();
		x.setLocation(100, 30);
		y.setLocation(10, 100);
		z.setLocation(50, 100);
		s = new PolyShape();
		this.s.addPoint(x);
		this.s.addPoint(y);
		this.s.addPoint(z);
		this.s.addPoint(x);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p3");
		this.palette.initialAddShape(this.s);
	}
}