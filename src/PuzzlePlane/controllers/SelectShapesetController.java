package PuzzlePlane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import PuzzlePlane.models.Board;
import PuzzlePlane.views.Applicatoin;

public class SelectShapesetController implements ActionListener{
	public Board board;
	public Applicatoin plane;
	public String shapesetPath;
	public String puzzleFolderPath;
	public String shapesetImgPath;
	public String solutionFolderPath;
	
	public String getShapesetImgPath() {
		return shapesetImgPath;
	}

	public void setShapesetImgPath(String shapesetImgPath) {
		this.shapesetImgPath = shapesetImgPath;
	}

	public String getShapesetPath() {
		return shapesetPath;
	}

	public void setFilePath(String shapesetPath) {
		this.shapesetPath = shapesetPath;
	}
	
	public SelectShapesetController(Applicatoin p, Board board, Map<String, String> path) {
		// TODO Auto-generated constructor stub
		this.plane = p;
		this.board = board;
		this.shapesetPath = path.get("shapeset");
		this.puzzleFolderPath = path.get("puzzleFolder");
		this.shapesetImgPath = path.get("shapesetImg");
		this.solutionFolderPath = path.get("solutionFolder");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.plane.setPuzzleFolderPath(this.puzzleFolderPath);
		this.plane.setShapesetImgPath(this.shapesetImgPath);
		this.plane.setSolutionFolderPath(this.solutionFolderPath);
		this.plane.jumpPage("p2");
		this.board.setShapes((new ShapeLoader(shapesetPath)).load());
	}

}
