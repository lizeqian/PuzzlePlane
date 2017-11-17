package plane.controllers;


// TODO: Auto-generated Javadoc
/**
 * The Class TestSelectShapeSetController.
 */
public class TestSelectShapeSetController extends ControllerCase {
	
	/** The controller. */
	SelectShapesetController controller;
	
	/* (non-Javadoc)
	 * @see plane.controllers.ControllerCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		controller = new SelectShapesetController(app, board, "nontraditional");
	}
	
	/**
	 * Test constructor.
	 */
	public void testConstructor() {
		assertEquals(controller.getBoard(), board);
		assertEquals(controller.getPlane(), app);
		assertEquals(controller.getShapesetName(), "nontraditional");
	}
	
	/**
	 * Test setter.
	 */
	public void testSetter() {
		controller.setShapesetName("traditional");
		assertEquals(controller.getShapesetName(), "traditional");
	}
	
	/**
	 * Test action performed.
	 */
	public void testActionPerformed() {
		controller.actionPerformed(null);
		assertEquals(this.board.getShapeset().getName(), "nontraditional");
	}

}
