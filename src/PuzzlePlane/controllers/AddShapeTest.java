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
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p3");
		this.palette.addShape(s);
	}
}