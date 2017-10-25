package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class BacktoShapeset implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	
	public BacktoShapeset(PuzzlePlaneGui p) {
		this.puzzlePlaneGui = p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}