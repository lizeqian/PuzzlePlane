package plane.controllers;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.utils.PolygonUtils;

/**
 * The Class TestSolutionCheckController.
 */
public class TestSolutionCheckController extends ControllerCase {
	
	/** The controller. */
	SolutionCheckController controller;
	
	/** The shapes. */
	List<PlacedShape> shapes;
	
	/** The puzzle shapes. */
	List<Polygon> puzzleShapes;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 * Set up board and application for testing 
	 */
	protected void setUp() throws Exception {
		super.setUp();
		Polygon polygon = new Polygon();
		polygon.addPoint(10, 20);
		polygon.addPoint(10, 40);
		polygon.addPoint(20, 20);
		polygon.addPoint(10, 20);
		
		PlacedShape placedShape = new PlacedShape(Color.RED);
		placedShape.setOriginalPolygon(PolygonUtils.copy(polygon));
		placedShape.setChangedPolygon(PolygonUtils.copy(polygon));
		
		shapes = new ArrayList<>();
		shapes.add(placedShape.copy());
		shapes.add(placedShape.copy());
		shapes.add(placedShape.copy());
		
		board.setShapes(shapes);
		
		List<PlacedShape> shapesCopy = new ArrayList<>();
		for(PlacedShape shape : shapes) {
			shapesCopy.add(shape.copy());
		}
		Puzzle p = new Puzzle("test");
		p.setShape(shapesCopy);
		board.setPuzzle(p);
		
		controller = new SolutionCheckController(board, app);
	}
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPuzzlePlaneGui(), app);
	}
	
	/**
	 * Test check.
	 */
	public void testCheck() {
		assertTrue(controller.check());
		board.getPuzzle().getPuzzleShape().remove(0);
		assertFalse(controller.check());
	}

}
