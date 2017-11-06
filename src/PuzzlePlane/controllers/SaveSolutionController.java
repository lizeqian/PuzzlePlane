package PuzzlePlane.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import PuzzlePlane.models.BoardMemento;
import PuzzlePlane.models.PlacedShape;
import PuzzlePlane.views.Applicatoin;

public class SaveSolutionController {
	public Applicatoin plane;
	public BoardMemento memento;
	
	public BoardMemento getMemento() {
		return memento;
	}

	public void setMemento(BoardMemento memento) {
		this.memento = memento;
	}

	public SaveSolutionController(Applicatoin plane, BoardMemento memento) {
		// TODO Auto-generated constructor stub
		this.plane =  plane;
		this.memento = memento;
	}
	
	public void save() {
		if(plane == null || memento == null) return;
		String path = this.plane.getSolutionPath();
		if(path == null) return;
		try {
			File file = new File(path);
			FileWriter writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			for(PlacedShape shape : this.memento.getShapes()) {
				bw.write(shape.toString() + "\n");
			}
			bw.close();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
