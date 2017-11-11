package plane.views;

import junit.framework.TestCase;
import plane.models.Board;

public class TestApplication extends TestCase {
	Application ap;
	
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
	
	protected void tearDown() {
		if (this.ap != null) {
			this.ap.dispose();
		}
	}
	
	public void testApp() {
		System.out.println("Sample MainGui");
	}
}
