package plane.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import plane.config.FilePathConfig;
import plane.models.Board;
import plane.models.Shapeset;
import plane.views.Application;
import plane.views.SecondPPGui;
import plane.views.ViewShapesetPPGui;

public class SelectShapesetController implements ActionListener{
	public Board board;

	public Application plane;
	
	public String shapesetName;
	
	public Board getBoard() {
		return board;
	}

	public Application getPlane() {
		return plane;
	}
	
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
		this.board.setShapeset(new Shapeset(this.shapesetName));
		((SecondPPGui)(this.plane.p_2)).reset();
		((ViewShapesetPPGui)(this.plane.p_5)).reset();
		this.plane.jumpPage("p2");
	}

}
