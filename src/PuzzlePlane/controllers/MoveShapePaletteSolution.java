package PuzzlePlane.controllers;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class MoveShapePaletteSolution extends MouseAdapter{
	Board board;
	PuzzleSolvingView puzzleSolvingView;
	Point origin;
	
	public MoveShapePaletteSolution (Board b, PuzzleSolvingView p) {
		this.board = b;
		this.puzzleSolvingView = p;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		origin = me.getPoint();
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		puzzleSolvingView.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		puzzleSolvingView.repaint();
	}
}