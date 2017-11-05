package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzlePlaneGui;

public class SelectShapesetController implements ActionListener{
	public Board board;
	public PuzzlePlaneGui plane;
	public String shapesetPath;
	public String puzzleFolderPath;
	
	public String getShapesetPath() {
		return shapesetPath;
	}

	public void setFilePath(String shapesetPath) {
		this.shapesetPath = shapesetPath;
	}
	
	public SelectShapesetController(PuzzlePlaneGui p, Board board, Map<String, String> path) {
		// TODO Auto-generated constructor stub
		this.plane = p;
		this.board = board;
		this.shapesetPath = path.get("shapeset");
		this.puzzleFolderPath = path.get("puzzleFolder");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.setPuzzleFolderPath(this.puzzleFolderPath);
		this.plane.jumpPage("p2");
		this.board.setShapes((new ShapeLoader(shapesetPath)).load());
	}

}
