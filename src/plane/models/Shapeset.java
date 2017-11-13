package plane.models;

import java.util.ArrayList;
import java.util.List;

import plane.config.FilePathConfig;
import plane.config.NameConfig;
import plane.controllers.PuzzleChecker;
import plane.controllers.ShapeLoader;

public class Shapeset {
	
	public String name;
	public List<Puzzle> puzzles;
	
	public String toString() {
		String ret = "";
		ret += "name: " + name + "\n";
		ret += "puzzles: " + puzzles.size() + "\n";
		return ret;
	}
	
	public List<Puzzle> getPuzzles() {
		return puzzles;
	}

	public void setPuzzles(List<Puzzle> puzzles) {
		this.puzzles = puzzles;
	}

	public Shapeset(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.loadPuzzles();
	}
	
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
	
	public String getName() {
		return name;
	}

}
