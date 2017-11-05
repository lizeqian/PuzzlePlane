package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzlePlaneGui;

public class SelectShapesetController implements ActionListener{
	public Board board;
	public PuzzlePlaneGui plane;
	public String filePath;
	
	public static final String traditionalShapesetPath = "shapeset.txt";
	public static final String nontraditionalShapesetPath = "shapeset.txt";
	
	public static final String traditionalPuzzleName = "traditional";
	public static final String nontraditionalPuzzleName = "nontraditional";
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String whichShapeset) {
		if (whichShapeset.equals("traditional")) {
			this.filePath = SelectShapesetController.traditionalShapesetPath;
			this.plane.setPuzzleFolderName(SelectShapesetController.traditionalPuzzleName);
		} else {
			this.filePath = SelectShapesetController.nontraditionalShapesetPath;
			this.plane.setPuzzleFolderName(SelectShapesetController.nontraditionalPuzzleName);
		}
	}

	public SelectShapesetController(PuzzlePlaneGui p, Board board) {
		// TODO Auto-generated constructor stub
		this.plane = p;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.jumpPage("p2");
		this.board.setShapes((new ShapeLoader(filePath)).load());
	}

}
