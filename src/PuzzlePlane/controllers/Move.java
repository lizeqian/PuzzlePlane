package PuzzlePlane.controllers;

import java.awt.Polygon;

import PuzzlePlane.models.PlacedShape;
import PuzzlePlane.models.ShapeStatus;

public class Move {
	
	public PlacedShape selectedShape;
	public PlacedShape beforeShape;
	public PlacedShape afterShape;
	
	public Move(PlacedShape shape, PlacedShape beforeShape) {
		this.selectedShape = shape;
		this.beforeShape = new PlacedShape(beforeShape);
		this.afterShape = new PlacedShape(shape);
	}
	
	public void undo() {
		Polygon polygon = this.beforeShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints));
		this.selectedShape.setStatus(new ShapeStatus(this.beforeShape.getStatus()));
	}
	
	public void redo() {
		Polygon polygon = this.afterShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints));
		this.selectedShape.setStatus(new ShapeStatus(this.afterShape.getStatus()));
	}
}
