package plane.models;

import java.awt.Color;
import java.awt.Polygon;

import junit.framework.TestCase;
import plane.utils.PolygonUtils;

public class TestPlacedShape extends TestCase {
	
	public Polygon createPolygon(int x, int y) {
		Polygon polygon = new Polygon();
		polygon.addPoint(x, y);
		polygon.addPoint(x+10, y);
		polygon.addPoint(x+5, y+10);
		polygon.addPoint(x, y);
		return polygon;
	}
	
	public void testConstructor() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		assertEquals(ps.getColor(), Color.BLACK);
		PlacedShape ps2 = new PlacedShape(ps);
		assertEquals(ps2.toString(), ps.toString());
	}
	
	public void testGetStatus() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		ShapeStatus ss = new ShapeStatus(Color.BLACK);
		
		ps.setStatus(ss);
		assertEquals(ss, ps.getStatus());
	}
	
	public void testGetOriginalPolygon() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setOriginalPolygon(p);
		
		assertEquals(ps.getOriginalPolygon(), p);
	}
	
	public void testCopy() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		assertEquals(ps.toString(), ps.copy().toString());
	}
	
	public void testAddPoint() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		for (int i = 0; i < p.npoints; i++) {
			ps.addPoint(p.xpoints[i], p.ypoints[i]);
		}
		
		Polygon p2 = ps.getOriginalPolygon();
		assertEquals(p.npoints, p2.npoints);
		for (int i = 0; i < p.npoints; i++) {
			assertEquals(p2.xpoints[i], p.xpoints[i]);
			assertEquals(p2.ypoints[i], p.ypoints[i]);
		}
	}
	
	public void testIsSelected() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.selectShape();
		assertTrue(p.isSelected());
	}
	
	public void testGetLeftX() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(0, p.getLeftX());
	}
	
	public void testGetRightX() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(10, p.getRightX());
	}
	
	public void testGetTopY() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(0, p.getTopY());
	}
	
	public void testGetBottomY() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 10);
		p.addPoint(5, 20);
		p.addPoint(0, 0);
		assertEquals(20, p.getBottomY());
	}
	
	public void testRotate() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.rotate(90);
		
		Polygon p2 = new Polygon();
		p2.addPoint(8, -2);
		p2.addPoint(8, 8);
		p2.addPoint(-1, 3);
		p2.addPoint(8, -2);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	public void testVFlip() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.vFlip();
		
		Polygon p2 = new Polygon();
		p2.addPoint(0, 6);
		p2.addPoint(10, 6);
		p2.addPoint(5, -3);
		p2.addPoint(0, 6);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	public void testHFlip() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.hFlip();
		
		Polygon p2 = new Polygon();
		p2.addPoint(10, 0);
		p2.addPoint(0, 0);
		p2.addPoint(5, 9);
		p2.addPoint(10, 0);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
	
	public void testResetPos() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.hFlip();
		p.resetPos();
		
		PlacedShape p2 = new PlacedShape(Color.BLACK);
		p2.addPoint(0, 0);
		p2.addPoint(10, 0);
		p2.addPoint(5, 9);
		p2.addPoint(0, 0);
		assertEquals(p.toString(), p2.toString());
	}
	
	public void testSetChangedPolygon() {
		PlacedShape ps = new PlacedShape(Color.BLACK);
		Polygon p = this.createPolygon(0, 0);
		ps.setChangedPolygon(p);
		assertEquals(p, ps.changedPolygon);
	}
	
	public void testSetPosition() {
		PlacedShape p = new PlacedShape(Color.BLACK);
		p.addPoint(0, 0);
		p.addPoint(10, 0);
		p.addPoint(5, 9);
		p.addPoint(0, 0);
		p.setPosition(1, 1);
		
		Polygon p2 = new Polygon();
		p2.addPoint(1, 1);
		p2.addPoint(11, 1);
		p2.addPoint(6, 10);
		p2.addPoint(1, 1);
		assertEquals(PolygonUtils.toString(p.getChangedPolygon()), PolygonUtils.toString(p2));
	}
}
