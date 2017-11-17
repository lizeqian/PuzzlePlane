package plane.controllers;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;
import plane.config.FilePathConfig;
import plane.models.BoardMemento;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.Shapeset;


/**
 * The Class TestSaveSolutionController.
 * ControllerCase
 * @author Li Zhang
 */
public class TestSaveSolutionController extends ControllerCase{
	
	/** The controller. */
	SaveSolutionController controller;
	
	/** The memento. */
	BoardMemento memento;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		List<PlacedShape> shapes = (new ShapeLoader(FilePathConfig.getShapesetPath("traditional"))).load();

		board.setShapes(shapes);
		board.setPuzzle(new Puzzle("test"));
		board.setShapeset(new Shapeset("traditional"));
		
		memento = board.createMemento();
		controller = new SaveSolutionController(app, memento);
	}
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		assertEquals(controller.getMemento(), memento);
		assertEquals(controller.getPlane(), app);
	}
	
	/**
	 * Test save.
	 */
	public void testSave() {
		File file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "test"));
		if(file.exists()) file.delete();
		controller.save();
		assertTrue(file.exists());
	}
}
