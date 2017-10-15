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
		int x = 100;
		int y = 100;
		Polygon p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x - 50, y + 100);
		p.addPoint(x, y + 100);
		p.addPoint(x, y);
		g.setColor(Color.BLACK);
		g.fillPolygon(p);
		//g.drawOval(20, 20, 20, 20);
	}
	
	
}
