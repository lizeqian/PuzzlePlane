package PuzzlePlane.models;

public class Board {
	Palette palette;
	SolutionSpace solutionSpace;
	
	
	
	public Board() {
		this.palette = new Palette();
		this.solutionSpace = new SolutionSpace();
	}
	
	public Palette getPalette ( ) {
		return this.palette;
	}
	
	public SolutionSpace getSolutionSpace ( ) {
		return this.solutionSpace;
	}
	
	public void selectShapeSet( ) {
		
	}
	
	public void selectPuzzle( ) {
		
	}
	
	public void placeShape( ) {
		
	}
	
	public void returnShape( ) {
		
	}
	
	public void reset ( ) {
		
	}
	
	public void undo ( ) {
		
	}
	
	public void redo ( ) {
		
	}
	
}