package plane.models;

import java.util.ArrayList;
import java.util.List;

import plane.config.FilePathConfig;
import plane.config.NameConfig;
import plane.controllers.PuzzleChecker;
import plane.controllers.ShapeLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class Shapeset.
 */
public class Shapeset {
	
	/** The name. */
	public String name;
	
	/** The puzzles. */
	public List<Puzzle> puzzles;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String ret = "";
		ret += "name: " + name + "\n";
		ret += "puzzles: " + puzzles.size() + "\n";
		return ret;
	}
	
	/**
	 * Gets the puzzles.
	 *
	 * @return the puzzles
	 */
	public List<Puzzle> getPuzzles() {
		return puzzles;
	}

	/**
	 * Sets the puzzles.
	 *
	 * @param puzzles the new puzzles
	 */
	public void setPuzzles(List<Puzzle> puzzles) {
		this.puzzles = puzzles;
	}

	/**
	 * Instantiates a new shapeset.
	 *
	 * @param name the name
	 */
	public Shapeset(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.loadPuzzles();
	}
	
	/**
	 * Load puzzles.
	 */
	public void loadPuzzles() {
		puzzles = new ArrayList<>();
		for(String puzzleName : NameConfig.getPuzzles(name)) {
			if(PuzzleChecker.check(name, puzzleName)) {
				Puzzle p = new Puzzle(puzzleName);
				p.setShape(new ShapeLoader(FilePathConfig.getPuzzleSolutionPath(this.name, puzzleName)).load());
				puzzles.add(p);
			} else {
				Puzzle p = new Puzzle(puzzleName);
				p.setShape(new ShapeLoader(FilePathConfig.getPuzzlePath(this.name, puzzleName)).load());
				puzzles.add(p);
			}
		}
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
