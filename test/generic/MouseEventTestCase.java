package generic;
import java.awt.Container;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class MouseEventTestCase.
 */
public class MouseEventTestCase extends TestCase {
	
	/**
	 * Test nothing.
	 */
	// put here to allow testing to succeed. Grr...
	public void testNothing() { 
		
	}
	
	/**
	 * Creates the pressed.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createPressed (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, x, y, 0, false);
		return me;
	}
	
	/**
	 * Creates the dragged.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createDragged (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_DRAGGED, 
				System.currentTimeMillis(), 0, x, y, 0, false);
		return me;
	}
	
	/**
	 * Creates the right click.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createRightClick  (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, x, y, 0, true);
		return me;
	}
	
	
	/**
	 * Creates the released.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createReleased  (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, x, y, 0, false);
		return me;
	}
	
	
	/**
	 * Creates the clicked.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createClicked  (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, x, y, 0, false);
		return me;
	}
	
	
	/**
	 * Creates the double clicked.
	 *
	 * @param view the view
	 * @param x the x
	 * @param y the y
	 * @return the mouse event
	 */
	public MouseEvent createDoubleClicked  (Container view, int x, int y) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, x, y, 0, false);
		return me;
	}
}
