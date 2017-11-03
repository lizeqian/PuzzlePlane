package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public abstract class ShapeOperation implements ActionListener{
	PuzzleSolvingView puzzleSolvingView;
	Board board;
	
	public final static int LEFT_ROTATE = 345;
	public final static int RIGHT_ROTATE = 15;
	
	public ShapeOperation (Board b, PuzzleSolvingView p) {
		this.puzzleSolvingView = p;
		this.board = b;
	}
	
	public abstract void actionPerformed(ActionEvent e);
		//Note: A BAD design? 2017-10-26 ppt pg6
}