package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.models.Board;
import PuzzlePlane.views.Application;
import PuzzlePlane.views.PuzzleSolvingView;

public class SolutionResetController implements ActionListener{
	
	Application plane;
	Board board;
	PuzzleSolvingView puzzleSolvingView;
	
	public SolutionResetController(Board b, Application p, PuzzleSolvingView puzzleSolvingView) {
		// TODO Auto-generated constructor stub
		this.board = b;
		this.plane = p;
		this.puzzleSolvingView = puzzleSolvingView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String puzzleName = plane.getPuzzleName();
		String shapesetName = plane.getShapesetName();
		
		ShapeLoader loader = new ShapeLoader(FilePathConfig.getShapesetPath(shapesetName));
		this.board.setShapes(loader.load());
		this.puzzleSolvingView.repaint();
		
		Set<String> solvedPuzzleNames = this.plane.getSolvedPuzzleNames();
		solvedPuzzleNames.remove(puzzleName);
		this.plane.setSolvedPuzzleNames(solvedPuzzleNames);
		
		File file = new File(FilePathConfig.getPuzzleSolutionPath(shapesetName, puzzleName));
		if(file.exists()) file.delete();
	}
}
