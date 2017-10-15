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
	Point origin, shapePos;
	PaletteView paletteView;
	int x = 0;
	int y = 0;
	
	
	public MoveShapePaletteSolution (Board b, PaletteView p) {
		this.board = b;
		this.paletteView = p;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		this.origin = me.getPoint();
		this.shapePos = this.board.getPalette().getShapes().get(0).getPosition();
		this.x = this.shapePos.x;
		this.y = this.shapePos.y;
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		int offset_x = this.x;
		int offset_y = this.y;
		int x = me.getX() - origin.x + offset_x;
		int y = me.getY() - origin.y + offset_y;
		this.board.getPalette().setPosition(x, y, 0);
		paletteView.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		paletteView.repaint();
	}
}