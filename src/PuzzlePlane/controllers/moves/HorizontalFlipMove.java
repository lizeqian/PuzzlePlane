package PuzzlePlane.controllers.moves;

import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.PlacedShape;

public class HorizontalFlipMove extends Move{
	
	public HorizontalFlipMove(PlacedShape shape) {
		// TODO Auto-generated constructor stub
		super(shape);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.selectedShape.hFlip();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.selectedShape.hFlip();
	}

}
