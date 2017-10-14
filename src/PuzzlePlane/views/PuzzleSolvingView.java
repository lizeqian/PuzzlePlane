package PuzzlePlane.views;

import javax.swing.JPanel;

public class PuzzleSolvingView extends JPanel {

	Palette palette;
	SolutionSpace solutionSpace;
	
	public PuzzleSolvingView() {
		setLayout(null);
		
		palette = new Palette();
		palette.setBounds(0, 0, 450, 100);
		add(palette);
		
		solutionSpace = new SolutionSpace();
		solutionSpace.setBounds(0, 100, 450, 200);
		add(solutionSpace);

	}
}
