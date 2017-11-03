package PuzzlePlane.controllers;

import java.awt.Color;
import java.io.*;
import java.util.Scanner;

import PuzzlePlane.models.PlacedShape;

public class PuzzleShapeLoader {
	
	File file;
	Scanner scan;
	
	public PuzzleShapeLoader(String path) {
		// TODO Auto-generated constructor stub
		file = new File(path);
		scan = null;
		try {
			scan = new Scanner(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public PlacedShape load() {
		int r, g, b;
		r = scan.nextInt();
		g = scan.nextInt();
		b = scan.nextInt();
		PlacedShape puzzleShape = new PlacedShape(new Color(r, g, b));
		while(scan.hasNext()) {
			puzzleShape.addPoint(scan.nextInt(), scan.nextInt());
		}
		scan.close();
		return puzzleShape;
	}

}
