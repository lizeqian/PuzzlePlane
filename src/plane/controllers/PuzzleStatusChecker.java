package plane.controllers;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.config.NameConfig;
import plane.models.Board;
import plane.views.Application;

public class PuzzleStatusChecker {
	Board board;
	Application plane;
	
	public PuzzleStatusChecker(Board b, Application p) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.plane = p;
	}
	
	public Set<String> getSolvedPuzzleNames() {
		Set<String> ret = new HashSet<String>();
		String shapesetName = this.plane.getShapesetName();
		for(String puzzleName : NameConfig.getPuzzles(shapesetName)) {
			File f = new File(FilePathConfig.getPuzzleSolutionPath(shapesetName, puzzleName));
			if(f.exists()) {
				ret.add(puzzleName);
			}
		}
		return ret;
	}

}
