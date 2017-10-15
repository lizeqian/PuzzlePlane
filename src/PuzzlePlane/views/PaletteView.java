package PuzzlePlane.views;

import PuzzlePlane.models.*;
import PuzzlePlane.controllers.*;
import javax.swing.JPanel;


import javax.swing.JLabel;

import java.awt.*;
import java.awt.Color;
import java.util.*;

public class PaletteView extends JPanel {

	/**
	 * Create the panel.
	 */
	Board board;
	
	public PaletteView(Board b, PuzzleSolvingView p) {
		
		this.board = b;

		MoveShapePaletteSolution control = new MoveShapePaletteSolution(b, p);
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
		
		setLayout(null);
		
		JLabel lblPalette = new JLabel("Palette");
		lblPalette.setBounds(147, 11, 46, 14);
		add(lblPalette);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Palette pl = this.board.getPalette();
		ArrayList<PlacedShape> shapes = pl.getShapes();
		for (PlacedShape s : shapes) {
			PolyShape polyshape = s.getShape();
			Point pos = s.getPosition();
			Polygon p = new Polygon();
			ArrayList<Point> points = polyshape.getPoints();
			for (Point point : points) {
				int x = (int)(point.getX()+pos.getX());
				int y = (int)(point.getY()+pos.getY());
				p.addPoint(x, y);
			}
			g.setColor(Color.BLACK);
			g.fillPolygon(p);
		}
	}
	
	
}
