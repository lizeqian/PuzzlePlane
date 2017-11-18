package plane.models;

import java.util.List;

/**
 * The Class Puzzle.
 * The entity class for a puzzle.
 * Puzzle has a List of PlacedShape representing the silhouette shape
 * Puzzle has a puzzle name.
 * @author cheng zhu Zeqian Li
 */
public class Puzzle{

	/** The puzzle shape. */
	public List<PlacedShape> puzzleShape;
	
	/** The name. */
	public String name;

	/**
	 * @return a String representing the silhouette shape
	 */
	public String toString() {
		String ret = "";
		for(PlacedShape shape : puzzleShape) {
			ret += shape.toString() + "\n";
		}
		return ret;
	}
	
	/**
	 * Get the puzzle name.
	 *
	 * @return the puzzle name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the puzzle name.
	 *
	 * @param name the puzzle name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiate a new puzzle, with a puzzle name.
	 *
	 * @param name the puzzle name
	 */
	public Puzzle(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiates a new puzzle, with silhouette shape.
	 *
	 * @param shapes the shapes
	 */
	public Puzzle(List<PlacedShape> shapes) {
		// TODO Auto-generated constructor stub
		this.puzzleShape = shapes;
	}

	/**
	 * Sets the shape.
	 *
	 * @param puzzleShape set the silhouette shape
	 */
	public void setShape(List<PlacedShape> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	/**
	 * Gets the silhouette shape.
	 *
	 * @return the silhouette shape
	 */
	public List<PlacedShape> getPuzzleShape() {
		return this.puzzleShape;
	}

}