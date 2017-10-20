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

	Board board;
	int palette_h;
	int palette_w;
	int solution_w;
	int solution_h;
	int buttonAreaHeight;
	// Current mouse listener
	MouseListener        activeListener;
	MouseMotionListener  activeMotionListener;
	
	
	public PuzzleSolvingView(Board b, PuzzlePlaneGui p, int w, int h) {
		setLayout(null);		
		
		this.buttonAreaHeight = 20;
		this.palette_w = w;
		this.solution_w = w;
		this.palette_h = (int)(h*0.3);
		this.solution_h = h - palette_h;
		this.board = b;
		MoveShapePaletteSolution moveShapePaletteSolution = new MoveShapePaletteSolution(b, this, this.palette_w, this.palette_h);
		this.addMouseListener(moveShapePaletteSolution);
		this.addMouseMotionListener(moveShapePaletteSolution);
		ExitPuzzleSolving exitPuzzleSolving = new ExitPuzzleSolving(p);
		JButton button_next = new JButton("Exit Puzzle");
		button_next.setBounds(w-300, h-200, 200, 30);
		button_next.addActionListener(exitPuzzleSolving);
		this.add(button_next);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, this.palette_h, this.palette_w, this.palette_h);
		

		ArrayList<PlacedShape> shapes = this.board.getShapes();
		
		for (PlacedShape s : shapes) {
			Polygon p = new Polygon();
			p = s;
			
			g.setColor(s.getColor());
			g.fillPolygon(p);
			
		}
	}
	
	@Override
	public int getHeight() {
		return super.getHeight() - this.buttonAreaHeight;
	}
	
}
