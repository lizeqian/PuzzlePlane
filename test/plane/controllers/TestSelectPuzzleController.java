package plane.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import plane.config.FilePathConfig;
import plane.models.PlacedShape;

public class TestSelectPuzzleController extends ControllerCase {

	SelectPuzzleController controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		app.setShapesetName("traditional");
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
		
		List<PlacedShape> shapeset = new ShapeLoader(FilePathConfig.getShapesetPath("traditional")).load();
		assertEquals(shapeset.size(), board.getShapes().size());
		
		controller.getPlane().setSolvedPuzzleNames(null);
		controller.actionPerformed(null);
		assertEquals(shapeset.size(), board.getShapes().size());
		
		
		//NOTE: Please ensure the solution for 'traditional/test' exists to pass the following test codes.
		Set<String> solved = new HashSet<>();
		solved.add("test");
		solved.add("drib");
		
		app.setSolvedPuzzleNames(solved);
		controller = new SelectPuzzleController(board, app, "test");
		controller.actionPerformed(null);
		try {
			shapeset = new ShapeLoader(FilePathConfig.getPuzzleSolutionPath("traditional", "test")).load();
			assertEquals(shapeset.size(), this.board.getShapes().size());
		} catch (Exception e) {
			
		}
		
	}

}
