package plane.controllers;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import plane.config.FilePathConfig;
import plane.models.PlacedShape;

public class TestShapeLoader extends TestCase {
	ShapeLoader loader;
	File file;
	PlacedShape shape0, shape3, shape6; 
	
	protected void setUp() throws Exception {
		super.setUp();
		
		shape0 = new PlacedShape(new Color(0, 255, 0));
		shape0.addPoint(450, 200);
		shape0.addPoint(590, 200);
		shape0.addPoint(590, 60);
		shape0.addPoint(450, 200);
		
		shape3 = new PlacedShape(new Color(200, 0, 0));
		shape3.addPoint(100, 190);
		shape3.addPoint(200, 190);
		shape3.addPoint(150, 140);
		shape3.addPoint(50, 140);
		shape3.addPoint(100, 190);
		
		shape6 = new PlacedShape(new Color(0, 255, 0));
		shape6.addPoint(50, 50);
		shape6.addPoint(120, 50);
		shape6.addPoint(120, 120);
		shape6.addPoint(50, 120);
		shape6.addPoint(50, 50);
		
		file = new File("traditional/shapeset.txt");
		loader = new ShapeLoader(FilePathConfig.getShapesetPath("traditional"));
	}
	
	public void testConstructor() {
		assertEquals(file.getPath(), loader.getFile().getPath());
	}
	
	public void testLoad() {
		List<PlacedShape> list = loader.load();
		assertEquals(list.get(0).toString(), shape0.toString());
		assertEquals(list.get(3).toString(), shape3.toString());
		assertEquals(list.get(6).toString(), shape6.toString());
		
	}

}
