package plane.controllers.windowJump;

import java.awt.Color;
import java.awt.Polygon;
import plane.controllers.ControllerCase;
import plane.models.PlacedShape;
import plane.utils.PolygonUtils;
import java.util.*;

/**
 * The Class TestExitPuzzleSolvingController.
 */
public class TestExitPuzzleSolvingController extends ControllerCase {

	/** The controller. */
	ExitPuzzleSolvingController controller;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 * set up Board and Application to test
	 */
	protected void setUp() throws Exception {
		super.setUp();
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 0);
		polygon.addPoint(10, 0);
		polygon.addPoint(10, 10);
		polygon.addPoint(0, 0);
		PlacedShape shape = new PlacedShape(Color.red);
		shape.setOriginalPolygon(PolygonUtils.copy(polygon));
		shape.setChangedPolygon(PolygonUtils.copy(polygon));
		
		List<PlacedShape> list = new ArrayList<>();
		list.add(shape);
		board.setShapes(list);
		board.setSelectedShape(shape);
		board.rotate(30);
		
		controller = new ExitPuzzleSolvingController(board, app);
	}
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		assertEquals(board, controller.getBoard());
		assertEquals(app, controller.getPuzzlePlaneGui());
	}
	
	/**
	 * Test action performed.
	 */
	public void testActionPerformed() {
		controller.actionPerformed(null);
		PlacedShape shape = controller.getBoard().getShapes().get(0);
		assertEquals(PolygonUtils.toString(shape.getOriginalPolygon()), PolygonUtils.toString(shape.getChangedPolygon()));
	}

}
