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
	int x = 0;
	int y = 0;
	int palette_w;
	int palette_h;
	int selectedShapeOrder;
	boolean shapeContain;
	
	
	public MoveShapePaletteSolution (Board b, PuzzleSolvingView p, int w, int h) {
		this.board = b;
		this.puzzleSolvingView = p;
		this.palette_w = w;
		this.palette_h = h;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		this.origin = me.getPoint();
		this.shapeContain=this.board.selectShape(this.origin.x, this.origin.y);
		if (this.shapeContain) {
			this.selectedShapeOrder = this.board.getSelectedOrder();
			this.shapePos = this.board.getShape(this.selectedShapeOrder).getPosition();
			this.x = this.shapePos.x;
			this.y = this.shapePos.y;
		}
	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent me) {
		if (this.shapeContain) {
			int offset_x = this.x;
			int offset_y = this.y;
			int x = me.getX() - this.origin.x + offset_x;
			int y = me.getY() - this.origin.y + offset_y;
			this.board.setPosition(x, y, this.selectedShapeOrder);
			this.puzzleSolvingView.repaint();	
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (this.shapeContain) {
			if (me.getPoint().y < this.palette_h) { //this.palette_h + (maximum height of a shape)
				Point initialPosition = this.board.getShapePosition(this.selectedShapeOrder);
				this.board.setPosition(initialPosition.x, initialPosition.y, this.selectedShapeOrder);
			}
		}
		
		this.shapeContain = false;
		this.puzzleSolvingView.repaint();
	}
}
	