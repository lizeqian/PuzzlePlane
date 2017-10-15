package PuzzlePlane.views;

import javax.swing.JPanel;

import PuzzlePlane.models.*;

import PuzzlePlane.controllers.*;

public class PuzzleSolvingView extends JPanel {

	PaletteView palette;
	SolutionSpaceView solutionSpace;
	int palette_h;
	int palette_w;
	int solution_w;
	int solution_h;
	
	public PuzzleSolvingView(Board b, PuzzlePlaneGui p, int w, int h) {
		setLayout(null);
		
		
		/*MoveShapePaletteSolution control = new MoveShapePaletteSolution(b, this);
		this.addMouseListener(control);
		this.addMouseMotionListener(control);*/
		
		palette_w = w;
		solution_w = w;
		palette_h = (int)(h*0.3);
		solution_h = h - palette_h;
		
		
		this.palette = new PaletteView(b, this);
		palette.setBounds(0, 0, palette_w, palette_h);
		add(palette);
		
		this.solutionSpace = new SolutionSpaceView(b, p);
		this.solutionSpace.setBounds(0, palette_h, solution_w, solution_h);
		add(this.solutionSpace);

	}
}
