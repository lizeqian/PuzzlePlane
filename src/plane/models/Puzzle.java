package plane.models;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Puzzle.
 */
public class Puzzle{

	/** The puzzle shape. */
	public List<PlacedShape> puzzleShape;
	
	/** The name. */
	public String name;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String ret = "";
		for(PlacedShape shape : puzzleShape) {
			ret += shape.toString() + "\n";
		}
		return ret;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiates a new puzzle.
	 *
	 * @param name the name
	 */
	public Puzzle(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiates a new puzzle.
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
	 * @param puzzleShape the new shape
	 */
	public void setShape(List<PlacedShape> puzzleShape) {
		this.puzzleShape = puzzleShape;
	}
	
	/**
	 * Gets the puzzle shape.
	 *
	 * @return the puzzle shape
	 */
	public List<PlacedShape> getPuzzleShape() {
		return this.puzzleShape;
	}

}