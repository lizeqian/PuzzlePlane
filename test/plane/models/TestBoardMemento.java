package plane.models;

import junit.framework.TestCase;

public class TestBoardMemento extends TestCase {
	public void testConstructor() {
		Board b = new Board();
		BoardMemento bm = new BoardMemento(b);
	}
	
}
