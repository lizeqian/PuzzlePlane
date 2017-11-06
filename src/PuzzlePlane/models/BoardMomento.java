package PuzzlePlane.models;

import java.util.List;

public class BoardMomento {
	
	public List<PlacedShape> shapes;
	
	public List<PlacedShape> getShapes() {
		return shapes;
	}

	public void setShapes(List<PlacedShape> shapes) {
		this.shapes = shapes;
	}

	public BoardMomento(Board b) {
		// TODO Auto-generated constructor stub
		this.shapes = b.getShapes();
	}

}
