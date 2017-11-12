package plane.controllers;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;
import plane.config.FilePathConfig;
import plane.models.BoardMemento;
import plane.models.PlacedShape;

public class TestSaveSolutionController extends ControllerCase{
	
	SaveSolutionController controller;
	BoardMemento memento;
	
	protected void setUp() throws Exception {
		super.setUp();
		List<PlacedShape> shapes = (new ShapeLoader(FilePathConfig.getShapesetPath("traditional"))).load();
		app.setShapesetName("traditional");
		app.setPuzzleName("test");
		board.setShapes(shapes);
		memento = board.createMemento();
		controller = new SaveSolutionController(app, memento);
	}
	
	public void testConstructor() {
		assertEquals(controller.getMemento(), memento);
		assertEquals(controller.getPlane(), app);
	}
	
	public void testSave() {
		File file = new File(FilePathConfig.getPuzzleSolutionPath(this.app.getShapesetName(), this.app.getPuzzleName()));
		if(file.exists()) file.delete();
		controller.save();
		assertTrue(file.exists());
	}
}
