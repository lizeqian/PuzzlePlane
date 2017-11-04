package PuzzlePlane.controllers.moves;

import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.PlacedShape;

public class VerticalFlipMove extends Move{

	public VerticalFlipMove(PlacedShape shape) {
		// TODO Auto-generated constructor stub
		super(shape);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.selectedShape.vFlip();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.selectedShape.vFlip();
	}

}
