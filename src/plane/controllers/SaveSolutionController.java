package plane.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import plane.config.FilePathConfig;
import plane.models.Board;
import plane.models.BoardMemento;
import plane.models.PlacedShape;
import plane.views.Application;
/**
 * The Class SaveSolutionController.
 */
public class SaveSolutionController {
	public Application plane;
	public BoardMemento memento;
	
	public Application getPlane() {
		return plane;
	}
	
	public BoardMemento getMemento() {
		return memento;
	}

	public SaveSolutionController(Application plane, BoardMemento memento) {
		// TODO Auto-generated constructor stub
		this.plane =  plane;
		this.memento = memento;
	}
	
	public void save() {
		if(plane == null || memento == null) return;
		String path = FilePathConfig.getPuzzleSolutionPath(this.memento.getShapesetName(), this.memento.getPuzzleName());
		if(path == null) return;
		try {
			File file = new File(path);
			FileWriter writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			for(PlacedShape shape : this.memento.getShapes()) {
				bw.write(shape.toSolutionString() + "\n");
			}
			bw.close();
			writer.close();
		} catch (Exception e) {
		}
	}

}
