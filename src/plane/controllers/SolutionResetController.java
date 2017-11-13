package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.models.Board;
import plane.views.Application;
import plane.views.PuzzleSolvingView;
import plane.views.SecondPPGui;

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
		String puzzleName = board.getPuzzle().getName();
		String shapesetName = board.getShapeset().getName();
		
		ShapeLoader loader = new ShapeLoader(FilePathConfig.getShapesetPath(shapesetName));
		this.board.setShapes(loader.load());
		this.puzzleSolvingView.repaint();
		
		File file = new File(FilePathConfig.getPuzzleSolutionPath(shapesetName, puzzleName));
		if(file.exists()) file.delete();
		
		((SecondPPGui)this.plane.p_2).reset();
	}
}
