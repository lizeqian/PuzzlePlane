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

public class TestResetController extends ControllerCase {
	
	SolutionResetController controller;
	List<PlacedShape> shapes;
	
	protected void setUp() throws Exception {
		super.setUp();
		app.setShapesetName("traditional");
		app.setPuzzleName("bird");
		
		shapes = (new ShapeLoader(FilePathConfig.getShapesetPath("traditional"))).load();
		
		controller = new SolutionResetController(board, app, plane);
	}
	
	public void testContructor() {
		assertEquals(controller.board, board);
		assertEquals(controller.plane, app);
		assertEquals(controller.puzzleSolvingView, plane);
	}
	
	public void testActionPerformed() throws IOException {
		List<PlacedShape> initShapes = new ArrayList<PlacedShape>();
		initShapes.add(new PlacedShape(Color.BLACK));
		board.setShapes(initShapes);
		
		File file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "bird"));
		if(!file.exists()) file.createNewFile();
		
		Set<String> solutions = new HashSet<>();
		solutions.add("bird");
		app.setSolvedPuzzleNames(solutions);
		
		controller.actionPerformed(null);
		
		assertEquals(board.shapes.size(), shapes.size());
		assertEquals(board.shapes.get(0).toString(), shapes.get(0).toString());
		file = new File(FilePathConfig.getPuzzleSolutionPath("traditional", "bird"));
		assert(!file.exists());
		assert(!app.getSolvedPuzzleNames().contains("bird"));
	}

}
