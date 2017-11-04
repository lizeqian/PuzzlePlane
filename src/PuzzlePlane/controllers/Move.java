package PuzzlePlane.controllers;

public interface Move {
	
	public abstract void undo();
	
	public abstract void redo();
}
