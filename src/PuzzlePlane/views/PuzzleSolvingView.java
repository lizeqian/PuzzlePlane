package PuzzlePlane.views;

import javax.swing.JPanel;

import PuzzlePlane.models.*;

public class PuzzleSolvingView extends JPanel {

	PaletteView palette;
	SolutionSpaceView solutionSpace;
	
	public PuzzleSolvingView(Board b, PuzzlePlaneGui p) {
		setLayout(null);
		
		this.palette = new PaletteView(b);
		palette.setBounds(0, 0, 450, 100);
		add(palette);
		
		this.solutionSpace = new SolutionSpaceView(b, p);
		this.solutionSpace.setBounds(0, 100, 450, 200);
		add(this.solutionSpace);

	}
}
