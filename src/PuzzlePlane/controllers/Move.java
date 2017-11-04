package PuzzlePlane.controllers;

import PuzzlePlane.models.PlacedShape;
import PuzzlePlane.models.ShapeStatus;

public abstract class Move {
	
	public PlacedShape selectedShape;
	
	public Move(PlacedShape shape) {
		this.selectedShape = shape;
	}
	
	public abstract void undo();
	
	public abstract void redo();
}
