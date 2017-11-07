package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.models.Board;
import PuzzlePlane.views.Application;

public class SelectShapesetController implements ActionListener{
	public Board board;
	public Application plane;
	
	public String shapesetName;
	
	public String getShapesetName() {
		return shapesetName;
	}

	public void setShapesetName(String shapesetName) {
		this.shapesetName = shapesetName;
	}
	
	public SelectShapesetController(Application p, Board board, String shapesetName) {
		// TODO Auto-generated constructor stub
		this.plane = p;
		this.board = board;
		this.shapesetName = shapesetName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.setShapesetName(this.shapesetName);
		this.plane.jumpPage("p2");
		this.board.setShapes((new ShapeLoader(FilePathConfig.getShapesetPath(this.shapesetName))).load());
		this.board.setIsSolved((new StatusFileOperator()).loadFile());
	}

}
