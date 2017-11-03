package PuzzlePlane.models;

import java.awt.Polygon;
import java.util.List;

import PuzzlePlane.utils.ArrayUtils;

public class Puzzle{
	PlacedShape puzzleShape;
	PlacedShape lastSolution;
	boolean isSolved;
	
	public Puzzle(PlacedShape puzzleShape) {
		this.puzzleShape = new PlacedShape(puzzleShape);
	}
	
	public PlacedShape getPuzzleShape() {
		return this.puzzleShape;
	}
	
	public void setPuzzleShape(PlacedShape puzzleShape) {
		this.puzzleShape = new PlacedShape(puzzleShape);
		//TODO: set puzzleShape, avoid shallow copy.
	}
	
	public boolean isSolved(List<PlacedShape> shapes) {
		int errorNum = 0;
		int lx = ArrayUtils.min(puzzleShape.originalPolygon.xpoints, puzzleShape.originalPolygon.npoints);
		int hx = ArrayUtils.max(puzzleShape.originalPolygon.xpoints, puzzleShape.originalPolygon.npoints);
		int ly = ArrayUtils.min(puzzleShape.originalPolygon.ypoints, puzzleShape.originalPolygon.npoints);
		int hy = ArrayUtils.max(puzzleShape.originalPolygon.ypoints, puzzleShape.originalPolygon.npoints);
		
		for(int i = lx; i <= hx; i++) {
			for(int j = ly; j <= hy; j++) {
				boolean found = false;
				if(!puzzleShape.originalPolygon.contains(i, j)) continue;
				for(PlacedShape shape : shapes) {
					Polygon polygon = shape.getChangedPolygon();
					if(polygon.contains(i, j)) {
						found = true;
						break;
					}
				}
				if(!found) errorNum++;
			}
		}
		System.out.println(errorNum);
		return errorNum < 1500;
	}
}