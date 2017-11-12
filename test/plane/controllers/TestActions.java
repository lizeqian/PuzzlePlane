package plane.controllers;

import java.awt.*;

import junit.framework.TestCase;
import plane.config.FilePathConfig;
import plane.controllers.actions.*;
import plane.models.PlacedShape;
import plane.models.Puzzle;
import plane.utils.PolygonUtils;

public class TestActions extends ControllerCase {
	
	AbstractAction hFlip;
	AbstractAction vFlip;
	AbstractAction left;
	AbstractAction right;
	SolutionCheckController check;
	PlacedShape select;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		select = new PlacedShape(Color.BLUE);
		Polygon polygon = new Polygon();
		polygon.addPoint(0, 10);
		polygon.addPoint(10, 10);
		polygon.addPoint(0, 0);
		polygon.addPoint(0, 10);
		select.setChangedPolygon(PolygonUtils.copy(polygon));
		select.setOriginalPolygon(PolygonUtils.copy(polygon));
		
		Puzzle puzzle = new Puzzle();
		puzzle.setShape((new ShapeLoader(FilePathConfig.getPuzzlePath("traditional", "test"))).load());
		board.setPuzzle(puzzle);
		
		check = new SolutionCheckController(board, app);
		hFlip = new ShapeHorizontalFlipController(board, plane, check);
		vFlip = new ShapeVerticalFlipController(board, plane, check);
		left = new ShapeLeftRotateController(board, plane, check);
		right = new ShapeRightRotateController(board, plane, check);
	}
	
	public void testActionPerformed() {
		board.setSelectedShape(select.copy());
		hFlip.actionPerformed(null);
		assertFalse(board.getMoves().isEmpty());
		assertFalse(PolygonUtils.toString(board.getSelectedShape().getOriginalPolygon()).equals(PolygonUtils.toString(board.getSelectedShape().getChangedPolygon())));
		
		board.setSelectedShape(select.copy());
		vFlip.actionPerformed(null);
		assertFalse(board.getMoves().isEmpty());
		assertFalse(PolygonUtils.toString(board.getSelectedShape().getOriginalPolygon()).equals(PolygonUtils.toString(board.getSelectedShape().getChangedPolygon())));

		board.setSelectedShape(select.copy());
		left.actionPerformed(null);
		assertFalse(board.getMoves().isEmpty());
		assertFalse(PolygonUtils.toString(board.getSelectedShape().getOriginalPolygon()).equals(PolygonUtils.toString(board.getSelectedShape().getChangedPolygon())));
		
		board.setSelectedShape(select.copy());
		right.actionPerformed(null);
		assertFalse(board.getMoves().isEmpty());
		assertFalse(PolygonUtils.toString(board.getSelectedShape().getOriginalPolygon()).equals(PolygonUtils.toString(board.getSelectedShape().getChangedPolygon())));
	}

}
