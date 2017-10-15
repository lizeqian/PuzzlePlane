package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class AddShapeTest implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	Palette palette;
	PolyShape s;
	Point x,y,z;
	
	public AddShapeTest(PuzzlePlaneGui p, Palette pl) {
		this.puzzlePlaneGui = p;
		this.palette = pl;
		this.x.setLocation(0, 0);
		this.y.setLocation(0, 100);
		this.z.setLocation(50, 100);
		this.s.addPoint(x);
		this.s.addPoint(y);
		this.s.addPoint(z);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p3");
		this.palette.addShape(s);
	}
}