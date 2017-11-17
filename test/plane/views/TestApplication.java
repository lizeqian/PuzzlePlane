package plane.views;

import junit.framework.TestCase;
import plane.models.Board;


/**
 * The Class TestApplication.
 * Test the Appliation
 */
public class TestApplication extends TestCase {
	
	/** The application. */
	Application ap;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() {
		Board board = new Board();
		this.ap = new Application(board);
		this.ap.setVisible(true);
		this.ap.jumpPage("p2");
		this.ap.jumpPage("p3");
		this.ap.jumpPage("p4");
		this.ap.jumpPage("p5");
		this.ap.jumpPage("p1");		
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() {
		if (this.ap != null) {
			this.ap.dispose();
		}
	}
	
	/**
	 * Test application.
	 */
	public void testApp() {
		System.out.println("Sample MainGui");
	}
}
