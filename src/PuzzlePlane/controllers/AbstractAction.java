package PuzzlePlane.controllers;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.event.*;

public abstract class AbstractAction implements ActionListener{
	public PuzzleSolvingView puzzleSolvingView;
	public Board board;
	
	public final static int LEFT_ROTATE = 345;
	public final static int RIGHT_ROTATE = 15;
	
	public PlacedShape selectedShape;
	public ShapeStatus beforeStatus;
	public ShapeStatus afterStatus;
	public boolean hasUndo;
	
	public AbstractAction (Board b, PuzzleSolvingView p) {
		this.puzzleSolvingView = p;
		this.board = b;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.selectedShape = this.board.getSelectedShape();
		this.hasUndo = false;
		this.beforeStatus = new ShapeStatus(this.selectedShape.getStatus());
		this.afterStatus = new ShapeStatus(this.selectedShape.getStatus());
	}
}