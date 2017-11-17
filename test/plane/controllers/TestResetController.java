package plane.controllers;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.Shapeset;

// TODO: Auto-generated Javadoc
/**
 * The Class TestResetController.
 */
public class TestResetController extends ControllerCase {
	
	/** The controller. */
	SolutionResetController controller;
	
	/** The shapes. */
	List<PlacedShape> shapes;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		shapes = (new ShapeLoader(FilePathConfig.getShapesetPath("traditional"))).load();
		Shapeset shapeset = new Shapeset("traditional");
		this.board.setShapeset(shapeset);
		this.board.setShapes(shapes);
		
		Puzzle p = new Puzzle("test");
		p.setShape(((new ShapeLoader(FilePathConfig.getPuzzlePath("traditional", "test"))).load()));
		this.board.setPuzzle(p);
		
		controller = new SolutionResetController(board, app, plane);
	}
	
	/**
	 * Test contructor.
	 */
	public void testContructor() {
		assertEquals(controller.board, board);
		assertEquals(controller.plane, app);
		assertEquals(controller.puzzleSolvingView, plane);
	}
	
	/**
	 * Test action performed.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void testActionPerformed() throws IOException {
		List<PlacedShape> initShapes = new ArrayList<PlacedShape>();
		initShapes.add(new PlacedShape(Color.BLACK));
		board.setShapes(initShapes);
		
		File file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "test"));
		if(!file.exists()) file.createNewFile();
		
		controller.actionPerformed(null);
		
		assertEquals(board.shapes.size(), shapes.size());
		assertEquals(board.shapes.get(0).toString(), shapes.get(0).toString());
		file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "test"));
		assert(!file.exists());
	}

}
