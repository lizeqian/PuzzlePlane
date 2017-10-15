package PuzzlePlane.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PuzzlePlane.models.*;

import PuzzlePlane.controllers.*;

public class PuzzleSolvingView extends JPanel {

	JPanel palette;
	JPanel solutionSpace;
	Board board;
	int palette_h;
	int palette_w;
	int solution_w;
	int solution_h;
	// Current mouse listener
	MouseListener        activeListener;
	MouseMotionListener  activeMotionListener;
	
	/** Properly register new listener (and unregister old one if present). */
	public void setActiveListener(MouseListener ml) {
		this.removeMouseListener(activeListener);
		activeListener = ml;
		if (ml != null) { 
			this.addMouseListener(ml);
		}
	}
	
	/** Properly register new motion listener (and unregister old one if present). */
	public void setActiveMotionListener(MouseMotionListener mml) {
		this.removeMouseMotionListener(activeMotionListener);
		activeMotionListener = mml;
		if (mml != null) {
			this.addMouseMotionListener(mml);
		}
	}
	
	public PuzzleSolvingView(Board b, PuzzlePlaneGui p, int w, int h) {
		setLayout(null);		
		
		this.palette_w = w;
		this.solution_w = w;
		this.palette_h = (int)(h*0.3);
		this.solution_h = h - palette_h;
		this.board = b;
		
		
		this.palette = new JPanel();
		this.palette.setBounds(0, 0, palette_w, palette_h);
		add(this.palette);
		
		JLabel lblPalette = new JLabel("Palette");
		lblPalette.setBounds(147, 11, 46, 14);
		this.palette.add(lblPalette);
		
		this.solutionSpace = new JPanel();
		this.solutionSpace.setBounds(0, palette_h, solution_w, solution_h);
		add(this.solutionSpace);
		
		JLabel lblSolutionspace = new JLabel("SolutionSpace");
		lblSolutionspace.setBounds(183, 22, 76, 14);
		this.solutionSpace.add(lblSolutionspace);
		
		JButton button_next = new JButton("Exit Puzzle");
		button_next.setBounds(183, 64, 89, 23);
		this.solutionSpace.add(button_next);
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
				int x = point.x+pos.x;
				int y = point.y+pos.y;
				p.addPoint(x, y);
			}
			g.setColor(Color.BLACK);
			g.fillPolygon(p);
			
		}
	}
}
