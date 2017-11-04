package PuzzlePlane.controllers.moves;

import PuzzlePlane.controllers.Move;
import PuzzlePlane.models.PlacedShape;
import PuzzlePlane.models.ShapeStatus;

public class RotateMove extends Move{

	int angle;
	
	public RotateMove(PlacedShape shape, int angle) {
		// TODO Auto-generated constructor stub
		super(shape);
		this.angle = angle;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.selectedShape.rotate( - angle );
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		this.selectedShape.rotate(angle);
	}

}
