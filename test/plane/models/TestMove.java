package plane.models;

import java.awt.Color;
import java.awt.color.*;

import javax.management.RuntimeErrorException;

import junit.framework.TestCase;
import plane.utils.PolygonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMove.
 */
public class TestMove extends TestCase {
	
	/** The before. */
	public PlacedShape before;
	
	/** The after. */
	public PlacedShape after;
	
	/** The select. */
	public PlacedShape select;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
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
	
	/**
	 * Test constructor.
	 */
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
	
	/**
	 * Test undo.
	 */
	public void testUndo() {
		this.select = this.after.copy();
		Move move = new Move(this.select, this.before);
		move.undo();
		assertEquals(this.select.toString(), this.before.toString());
	}
	
	/**
	 * Test redo.
	 */
	public void testRedo() {
		this.select = this.after.copy();
		Move move = new Move(this.select, this.before);
		move.undo();
		move.redo();
		assertEquals(this.select.toString(), this.after.toString());
	}
}
