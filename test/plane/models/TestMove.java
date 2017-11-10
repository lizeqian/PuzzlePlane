package plane.models;

import java.awt.Color;
import java.awt.color.*;

import junit.framework.TestCase;

public class TestMove extends TestCase {
	public PlacedShape before;
	public PlacedShape after;
	public PlacedShape select;
	
	public void setUp() {
		this.before = new PlacedShape(Color.RED);
		this.before.setPosition(10, 20);
		this.before.hFlip();
		this.before.rotate(20);
		
		this.after = new PlacedShape(Color.BLUE);
		this.after.setPosition(20, 0);
		this.after.vFlip();
		this.after.rotate(100);
		
		this.select = null;
	}
	
	public void testConstructor() {
		this.select = this.after.copy();
		Move move = new Move(this.select, this.before);
		assertEquals(move.toString(), "selectedShape:\n" 
										+ this.select.toString()
										+ "beforeShape:\n"
										+ this.before.toString()
										+ "afterShape:\n"
										+ this.after.toString());
	}
}
