package plane.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import plane.config.FilePathConfig;
import plane.config.NameConfig;
import plane.controllers.PuzzleChecker;
import plane.controllers.ShapeLoader;

public class Shapeset {
	
	public String name;

	public List<Puzzle> puzzles;
	
	public List<Puzzle> getPuzzles() {
		return puzzles;
	}

	public void setPuzzles(List<Puzzle> puzzles) {
		this.puzzles = puzzles;
	}

	public Shapeset(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
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

	public void setName(String name) {
		this.name = name;
	}

}
