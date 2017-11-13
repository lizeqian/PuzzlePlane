package plane.controllers;


public class TestSelectShapeSetController extends ControllerCase {
	
	SelectShapesetController controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = new SelectShapesetController(app, board, "nontraditional");
	}
	
	public void testConstructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPlane(), app);
		assertEquals(controller.getShapesetName(), "nontraditional");
	}
	
	public void testSetter() {
		controller.setShapesetName("traditional");
		assertEquals(controller.getShapesetName(), "traditional");
	}
	
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assertEquals(this.board.getShapeset().getName(), "nontraditional");
	}

}
