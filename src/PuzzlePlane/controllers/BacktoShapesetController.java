package PuzzlePlane.controllers;

import PuzzlePlane.views.*;
import java.awt.event.*;

public class BacktoShapesetController implements ActionListener{
	PuzzlePlaneGui puzzlePlaneGui;
	
	public BacktoShapesetController(PuzzlePlaneGui p) {
		this.puzzlePlaneGui = p;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.puzzlePlaneGui.jumpPage("p1");
	}
}