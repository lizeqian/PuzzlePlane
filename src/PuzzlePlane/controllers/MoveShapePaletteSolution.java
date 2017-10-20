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
	int lx, rx, ty, by;
	
	
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
			
			this.lx = this.board.getShape(this.selectedShapeOrder).getLeftX();
			this.rx = this.board.getShape(this.selectedShapeOrder).getRightX();
			this.ty = this.board.getShape(this.selectedShapeOrder).getTopY();
			this.by = this.board.getShape(this.selectedShapeOrder).getBottomY();
		}
	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent me) {
		if (this.shapeContain) {
			int offset_x = this.x;
			int offset_y = this.y;
			
			int x = me.getX() - this.origin.x + offset_x;
			int y = me.getY() - this.origin.y + offset_y;
			//System.out.println(this.puzzleSolvingView.getWidth()+", "+this.puzzleSolvingView.getHeight());
			
			int fx = me.getX() - this.origin.x;
			int fy = me.getY() - this.origin.y;
			
			if (fx + this.lx < 0) x = offset_x - this.lx;
			if (fx + this.rx >= this.puzzleSolvingView.getWidth()) x = this.puzzleSolvingView.getWidth() - 1 - (this.rx - offset_x);
			if (fy + this.ty < 0) y = offset_y - this.ty;
			if (fy + this.by >= this.puzzleSolvingView.getHeight()) y = this.puzzleSolvingView.getHeight() - 1 - (this.by - offset_y);
			
			this.board.setPosition(x, y, this.selectedShapeOrder);
			this.puzzleSolvingView.repaint();	
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (this.shapeContain) {
			int[] ypoints = this.board.getShape(this.selectedShapeOrder).ypoints;
			int topY = 10000000;
			for(int i = 0; i < ypoints.length; i++) {
				if (ypoints[i] < topY) {
					topY =  ypoints[i];
				}
			}
			
			if (topY < this.palette_h) { //this.palette_h + (maximum height of a shape)
				Point initialPosition = this.board.getShapePosition(this.selectedShapeOrder);
				this.board.setPosition(initialPosition.x, initialPosition.y, this.selectedShapeOrder);
			}
		}
		
		this.shapeContain = false;
		this.puzzleSolvingView.repaint();
	}
}
	