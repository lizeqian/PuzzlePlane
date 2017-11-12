package plane.controllers.windowJump;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;
import plane.controllers.ControllerCase;
import plane.models.PlacedShape;
import plane.utils.PolygonUtils;

public class TestExitInfoBoardController extends ControllerCase {

	ExitInfoBoardController controller;
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
		
		app.setPuzzleName("test");
		app.setShapesetName("traditional");
		
		controller = new ExitInfoBoardController(board, app);
	}
	
	public void testConstructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPuzzlePlaneGui(), app);
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		PlacedShape shape = controller.getBoard().getShapes().get(0);
		assertEquals(PolygonUtils.toString(shape.getOriginalPolygon()), PolygonUtils.toString(shape.getChangedPolygon()));
		assertFalse(app.getSolvedPuzzleNames().isEmpty());
	}

}
