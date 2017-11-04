package PuzzlePlane.controllers.moves;

import java.awt.Point;

import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.PlacedShape;

public class PositionMove extends Move{
	
	public Point beforePosition;
	public Point afterPosition;
	
	public PositionMove(PlacedShape shape, Point bPos, Point aPos) {
		super(shape);
		this.beforePosition = new Point(bPos);
		this.afterPosition = new Point(aPos);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.selectedShape.setPosition((int)beforePosition.getX(), (int)beforePosition.getY());
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.selectedShape.setPosition((int)afterPosition.getX(), (int)afterPosition.getY());
	}
}
