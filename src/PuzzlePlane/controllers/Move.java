package PuzzlePlane.controllers;

import java.awt.Polygon;

import PuzzlePlane.models.PlacedShape;
import PuzzlePlane.models.ShapeStatus;
import PuzzlePlane.utils.PolygonUtils;

public class Move {
	
	public PlacedShape selectedShape;
	public PlacedShape beforeShape;
	public PlacedShape afterShape;
	
	public Move(PlacedShape shape, PlacedShape beforeShape) {
		this.selectedShape = shape;
		this.beforeShape = beforeShape.copy();
		this.afterShape = shape.copy();
	}
	
	public void undo() {
		Polygon polygon = this.beforeShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(PolygonUtils.copy(polygon));
		this.selectedShape.setStatus(this.beforeShape.getStatus().copy());
	}
	
	public void redo() {
		Polygon polygon = this.afterShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(PolygonUtils.copy(polygon));
		this.selectedShape.setStatus(new ShapeStatus(this.afterShape.getStatus()));
	}
}
