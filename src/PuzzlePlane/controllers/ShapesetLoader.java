package PuzzlePlane.controllers;

import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import PuzzlePlane.models.PlacedShape;

public class ShapesetLoader {
	
	File file;
	Scanner scan;
	
	public ShapesetLoader(String path) {
		// TODO Auto-generated constructor stub
		file = new File(path);
		scan = null;
		try {
			scan = new Scanner(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<PlacedShape> load() {
		ArrayList<PlacedShape> ret = new ArrayList<>();
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			//System.out.println(str);
			//System.out.println("Shape: "+str);
			if(str.length()<=1) break;
			int r, g, b;
			String[] arr = str.split(" ");
			r = Integer.parseInt(arr[0]);
			g = Integer.parseInt(arr[1]);
			b = Integer.parseInt(arr[2]);
			PlacedShape puzzleShape = new PlacedShape(new Point(), false, false, 0, -1, false, false, new Color(r, g, b));
			for(int i = 3; i < arr.length; i+=2) {
				puzzleShape.addPoint(Integer.parseInt(arr[i]), Integer.parseInt(arr[i+1]));
			}
			//System.out.println("puzzleShape:"+puzzleShape.xpoints.length);
			ret.add(puzzleShape);
		}
		scan.close();
		return ret;
	}

}
