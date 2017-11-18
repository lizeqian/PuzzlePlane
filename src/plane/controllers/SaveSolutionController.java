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
 * @author cheng zhu
 */
public class SaveSolutionController {
	
	/** The plane. */
	public Application plane;
	
	/** The memento. */
	public BoardMemento memento;
	
	/**
	 * Gets the plane.
	 *
	 * @return the plane
	 */
	public Application getPlane() {
		return plane;
	}
	
	/**
	 * Gets the memento.
	 *
	 * @return the memento
	 */
	public BoardMemento getMemento() {
		return memento;
	}

	/**
	 * Instantiates a new save solution controller.
	 *
	 * @param plane the plane
	 * @param memento the memento
	 */
	public SaveSolutionController(Application plane, BoardMemento memento) {
		this.plane =  plane;
		this.memento = memento;
	}
	
	/**
	 * Save.
	 */
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
