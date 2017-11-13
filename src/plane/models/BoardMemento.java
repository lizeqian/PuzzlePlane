package plane.models;

import java.util.List;

public class BoardMemento {
	
	public List<PlacedShape> shapes;
	public String puzzleName;
	public String shapesetName;
	
	public List<PlacedShape> getShapes() {
		return shapes;
	}

	public void setShapes(List<PlacedShape> shapes) {
		this.shapes = shapes;
	}

	public BoardMemento(Board b) {
		// TODO Auto-generated constructor stub
		this.shapes = b.getShapes();
		this.puzzleName = b.getPuzzle().getName();
		this.shapesetName = b.getShapeset().getName();
	}

	public String getPuzzleName() {
		return puzzleName;
	}

	public String getShapesetName() {
		return shapesetName;
	}

	public void setPuzzleName(String puzzleName) {
		this.puzzleName = puzzleName;
	}

	public void setShapesetName(String shapesetName) {
		this.shapesetName = shapesetName;
	}

}
