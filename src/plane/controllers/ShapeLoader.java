package plane.controllers;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import plane.models.PlacedShape;

/**
 * The Class ShapeLoader.
 * @author cheng zhu, yinkai ma, Li Zhang
 */
public class ShapeLoader{
	
	/** The file. */
	File file;
	
	/** The scan. */
	Scanner scan;
	
	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * Instantiates a new shape loader.
	 *
	 * @param path the path
	 */
	public ShapeLoader(String path) {
		file = new File(path);
		try {
			scan = new Scanner(file);
		} catch(Exception e) {
		}
	}
	
	/**
	 * Load.
	 *
	 * @return the list
	 */
	public List<PlacedShape> load() {
		ArrayList<PlacedShape> ret = new ArrayList<>();
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			if(str.length()<=1) break;
			int r, g, b;
			String[] arr = str.split(" ");
			r = Integer.parseInt(arr[0]);
			g = Integer.parseInt(arr[1]);
			b = Integer.parseInt(arr[2]);
			PlacedShape shape = new PlacedShape(new Color(r, g, b));
			for(int i = 3; i < arr.length; i += 2) {
				shape.addPoint(Integer.parseInt(arr[i]), Integer.parseInt(arr[i+1]));
			}
			ret.add(shape);
		}
		scan.close();
		return ret;
	}

}
