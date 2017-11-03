package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.PuzzlePlaneGui;

public class SelectShapesetController implements ActionListener{
	Board board;
	PuzzlePlaneGui plane;
	String filePath;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		this.board.setSelectedShapeSet(0);
		this.board.setShapes((new ShapesetLoader(filePath)).load());
	}

}
