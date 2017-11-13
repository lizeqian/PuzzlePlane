package plane.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.models.Shapeset;

public class TestSelectPuzzleController extends ControllerCase {

	SelectPuzzleController controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.board.setShapeset(new Shapeset("traditional"));
		controller = new SelectPuzzleController(board, app, "bird");
	}
	
	public void testConstructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPlane(), app);
		assertEquals(controller.getPuzzleName(), "bird");
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		
		List<PlacedShape> puzzleShapes;
		puzzleShapes = (new ShapeLoader(FilePathConfig.getPuzzlePath("traditional", "bird"))).load();
		assertEquals(puzzleShapes.size(), board.getPuzzle().getPuzzleShape().size());
		
	}

}
