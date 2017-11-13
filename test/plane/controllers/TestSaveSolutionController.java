package plane.controllers;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;
import plane.config.FilePathConfig;
import plane.models.BoardMemento;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.Shapeset;

public class TestSaveSolutionController extends ControllerCase{
	
	SaveSolutionController controller;
	BoardMemento memento;
	
	protected void setUp() throws Exception {
		super.setUp();
		List<PlacedShape> shapes = (new ShapeLoader(FilePathConfig.getShapesetPath("traditional"))).load();

		board.setShapes(shapes);
		board.setPuzzle(new Puzzle("test"));
		board.setShapeset(new Shapeset("traditional"));
		
		memento = board.createMemento();
		controller = new SaveSolutionController(app, memento);
	}
	
	public void testConstructor() {
		assertEquals(controller.getMemento(), memento);
		assertEquals(controller.getPlane(), app);
	}
	
	public void testSave() {
		File file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "test"));
		if(file.exists()) file.delete();
		controller.save();
		assertTrue(file.exists());
	}
}
