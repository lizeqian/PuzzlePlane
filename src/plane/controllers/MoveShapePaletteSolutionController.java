package plane.controllers;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import plane.models.*;
import plane.views.*;

import java.awt.*;

public class MoveShapePaletteSolutionController extends MouseAdapter{
	/** Needed for controller behavior. */
	Board board;
	PuzzleSolvingView puzzleSolvingView;
	Application puzzlePlaneGui;
	Point origin, shapePos;
	PlacedShape beforeShape;
	/** Original x,y where shape was before move. */
	int x = 0;
	int y = 0;
	/** confirm point where first grabbed and color from that location. */
	int palette_w;
	int palette_h;
	boolean shapeContain;
	/** Button that started off. */
	int lx, rx, ty, by;
	SolutionCheckController solutionCheckController;
	/** Constructor holds onto key manager objects. */
	public MoveShapePaletteSolutionController (Board b, Application pg, PuzzleSolvingView p,int w, int h, SolutionCheckController s) {
		this.board = b;
		this.puzzlePlaneGui = pg;
		this.puzzleSolvingView = p;
		this.palette_w = w;
		this.palette_h = h;
		this.solutionCheckController = s;
	}

	
	
	/** Set up press events but no motion events. */
	/**
	 * Whenever mouse is pressed (left button), attempt to select object.
	 * This is a GUI controller.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		this.origin = me.getPoint();
		this.shapeContain = this.board.selectShape(this.origin.x, this.origin.y);
		if (this.shapeContain) {
			PlacedShape selectedShape = this.board.getSelectedShape();
			this.beforeShape = selectedShape.copy();
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
	
	
	
	
	/**
	 * Whenever mouse is dragged, attempt to start object.
	 * This is a GUI controller.
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		if (this.shapeContain) {
			int offset_x = this.x;
			int offset_y = this.y;
			
			int x = me.getX() - this.origin.x + offset_x;
			int y = me.getY() - this.origin.y + offset_y;
			
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
	
	
	/**
	 * Whenever mouse is released, complete the move. 
	 * This is a GUI controller.
	 */
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
		if (this.solutionCheckController.check()) {
			(new SaveSolutionController(this.puzzlePlaneGui, this.board.createMemento())).save();
			this.puzzlePlaneGui.jumpPage("p4");
		}
	}
}
	