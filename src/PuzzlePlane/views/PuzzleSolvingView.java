package PuzzlePlane.views;

import javax.swing.JPanel;

import PuzzlePlane.models.*;

public class PuzzleSolvingView extends JPanel {

	PaletteView palette;
	SolutionSpaceView solutionSpace;
	
	public PuzzleSolvingView(Board b, PuzzlePlaneGui p) {
		setLayout(null);
		
		palette = new PaletteView();
		palette.setBounds(0, 0, 450, 100);
		add(palette);
		
		solutionSpace = new SolutionSpaceView(b, p);
		solutionSpace.setBounds(0, 100, 450, 200);
		add(solutionSpace);

	}
}
