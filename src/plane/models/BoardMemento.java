package plane.models;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardMemento.
 */
public class BoardMemento {
	
	/** The shapes. */
	public List<PlacedShape> shapes;
	
	/** The puzzle name. */
	public String puzzleName;
	
	/** The shapeset name. */
	public String shapesetName;
	
	/**
	 * Gets the shapes.
	 *
	 * @return the shapes
	 */
	public List<PlacedShape> getShapes() {
		return shapes;
	}

	/**
	 * Sets the shapes.
	 *
	 * @param shapes the new shapes
	 */
	public void setShapes(List<PlacedShape> shapes) {
		this.shapes = shapes;
	}

	/**
	 * Instantiates a new board memento.
	 *
	 * @param b the b
	 */
	public BoardMemento(Board b) {
		// TODO Auto-generated constructor stub
		this.shapes = b.getShapes();
		this.puzzleName = b.getPuzzle().getName();
		this.shapesetName = b.getShapeset().getName();
	}

	/**
	 * Gets the puzzle name.
	 *
	 * @return the puzzle name
	 */
	public String getPuzzleName() {
		return puzzleName;
	}

	/**
	 * Gets the shapeset name.
	 *
	 * @return the shapeset name
	 */
	public String getShapesetName() {
		return shapesetName;
	}

	/**
	 * Sets the puzzle name.
	 *
	 * @param puzzleName the new puzzle name
	 */
	public void setPuzzleName(String puzzleName) {
		this.puzzleName = puzzleName;
	}

	/**
	 * Sets the shapeset name.
	 *
	 * @param shapesetName the new shapeset name
	 */
	public void setShapesetName(String shapesetName) {
		this.shapesetName = shapesetName;
	}

}
