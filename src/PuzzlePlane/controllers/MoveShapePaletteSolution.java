package PuzzlePlane.controllers;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import PuzzlePlane.models.*;
import PuzzlePlane.views.*;

import java.awt.*;
import java.awt.event.*;

public class MoveShapePaletteSolution extends MouseAdapter{
	Palette palette;
	SolutionSpace solutionSpace;
	PuzzleSolvingView puzzleSolvingView;
	Point origin, shapePos;
	int x = 0;
	int y = 0;
	int palette_w;
	int palette_h;
	int selectedShapeOrder;
	boolean shapeContain;
	
	
	public MoveShapePaletteSolution (Board b, PuzzleSolvingView p, int w, int h) {
		this.palette = b.getPalette();
		this.solutionSpace = b.getSolutionSpace();
		this.puzzleSolvingView = p;
		this.palette_w = w;
		this.palette_h = h;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		this.origin = me.getPoint();
		if (this.origin.y < this.palette_h) {
			this.paletteMousePressed();
		}
		else {
			this.solutionSpaceMousePressed();
		}
	}
	
	public void paletteMousePressed() {
		this.shapeContain=this.palette.selectShape(this.origin.x, this.origin.y);
		if (this.shapeContain) {
			this.selectedShapeOrder = this.palette.getSelectedOrder();
			this.shapePos = this.palette.getShape(this.selectedShapeOrder).getPosition();
			this.x = this.shapePos.x;
			this.y = this.shapePos.y;
		}
	}
	
	public void solutionSpaceMousePressed() {
		this.shapeContain=this.solutionSpace.selectShape(this.origin.x, this.origin.y);
		if (this.shapeContain) {
			this.selectedShapeOrder = this.solutionSpace.getSelectedOrder();
			this.shapePos = this.solutionSpace.getShape(this.selectedShapeOrder).getPosition();
			this.x = this.shapePos.x;
			this.y = this.shapePos.y;
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		this.palette.debug0();
		if (this.shapeContain) {
			if (this.origin.y < this.palette_h) {
				this.paletteMouseDragged(me);
			}
			else {
				this.solutionSpaceMouseDragged(me);
			}
		}
	}
	
	public void paletteMouseDragged(MouseEvent me) {
		int offset_x = this.x;
		int offset_y = this.y;
		int x = me.getX() - this.origin.x + offset_x;
		int y = me.getY() - this.origin.y + offset_y;
		this.palette.setPosition(x, y, this.selectedShapeOrder);
		this.puzzleSolvingView.repaint();	
		//System.out.println(me.getX());
	}
	
	public void solutionSpaceMouseDragged(MouseEvent me) {
		int offset_x = this.x;
		int offset_y = this.y;
		int x = me.getX() - this.origin.x + offset_x;
		int y = me.getY() - this.origin.y + offset_y;
		this.solutionSpace.setPosition(x, y, this.selectedShapeOrder);
		this.puzzleSolvingView.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (this.shapeContain) {
			if (this.origin.y < this.palette_h) {
				this.paletteMouseReleased(me);
			}
			else {
				this.solutionSpaceMouseReleased(me);
			}
		}
		
		this.shapeContain = false;
	}
	
	public void paletteMouseReleased(MouseEvent me) {
		Point end = me.getPoint();
		if (end.y < this.palette_h) {
			this.palette.setPosition(this.x, this.y, this.selectedShapeOrder);
			this.palette.getShape(this.selectedShapeOrder).setSelected(false);
		}
		else {
			this.solutionSpace.addPlacedShape(this.palette.getShape(this.selectedShapeOrder));
			this.palette.removePlacedShape(this.selectedShapeOrder);
		}
		this.puzzleSolvingView.repaint();	
	}
	
	public void solutionSpaceMouseReleased(MouseEvent me) {
		Point end = me.getPoint();
		if (end.y < this.palette_h) {
			this.palette.addPlacedShape(this.solutionSpace.getShape(this.selectedShapeOrder));
			this.solutionSpace.removePlacedShape(this.selectedShapeOrder);
		}
		else {
			
		}
		this.puzzleSolvingView.repaint();
	}
}