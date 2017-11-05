package PuzzlePlane.controllers;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
import java.awt.*;

public class MoveShapePaletteSolutionController extends MouseAdapter{
	Board board;
	PuzzleSolvingView puzzleSolvingView;
	Point origin, shapePos;
	PlacedShape beforeShape;
	int x = 0;
	int y = 0;
	int palette_w;
	int palette_h;
	boolean shapeContain;
	int lx, rx, ty, by;
	
	public MoveShapePaletteSolutionController (Board b, PuzzleSolvingView p, int w, int h) {
		this.board = b;
		this.puzzleSolvingView = p;
		this.palette_w = w;
		this.palette_h = h;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		this.origin = me.getPoint();
		this.shapeContain = this.board.selectShape(this.origin.x, this.origin.y);
		if (this.shapeContain) {
			PlacedShape selectedShape = this.board.getSelectedShape();
			this.beforeShape = new PlacedShape(selectedShape);
			this.shapePos = selectedShape.getPosition();
			this.x = (int)this.shapePos.getX();
			this.y = (int)this.shapePos.getY();
			
			this.lx = selectedShape.getLeftX();
			this.rx = selectedShape.getRightX();
			this.ty = selectedShape.getTopY();
			this.by = selectedShape.getBottomY();
			
			this.board.reorder();
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
			if (fy + this.by >= this.puzzleSolvingView.getHeight() - 50) y = this.puzzleSolvingView.getHeight() - 50 - 1 - (this.by - offset_y);
			
			this.board.setPosition(x, y);
			this.puzzleSolvingView.repaint();	
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent me) {
		if (this.shapeContain) {
			PlacedShape selectedShape = this.board.getSelectedShape();
			int topY = selectedShape.getTopY();
			if (topY < this.palette_h) { //this.palette_h + (maximum height of a shape)
				selectedShape.selectShape();
				selectedShape.resetPos();
				selectedShape.getStatus().setOnPalette(true);
				this.board.setSelectedShape(null);
			} else {
				selectedShape.getStatus().setOnPalette(false);
			}
			this.board.pushDrag(beforeShape);
		}
	
		this.shapeContain = false;
		this.puzzleSolvingView.repaint();
	}
}
	