package plane.models;

import java.awt.Polygon;

import plane.utils.PolygonUtils;

/**
 * The Class Move.
 * The entity class to record a move by user. Will be used for undo and redo.
 * @author cheng zhu
 */
public class Move {
	
	/** The selected shape. */
	public PlacedShape selectedShape;
	
	/** The before shape. */
	public PlacedShape beforeShape;
	
	/** The after shape. */
	public PlacedShape afterShape;
	
	/**
	 * @return a String representing the Move states
	 */
	public String toString() {
		String ret = "";
		ret += "selectedShape:\n";
		ret += selectedShape.toString();
		ret += "beforeShape:\n";
		ret += beforeShape.toString();
		ret += "afterShape:\n";
		ret += afterShape.toString();
		return ret;
	}
	
	/**
	 * Instantiates a new move.
	 *
	 * @param shape the selected shape
	 * @param beforeShape the before shape
	 */
	public Move(PlacedShape shape, PlacedShape beforeShape) {
		this.selectedShape = shape;
		this.beforeShape = beforeShape.copy();
		this.afterShape = shape.copy();
	}
	
	/**
	 * Undo the Move
	 */
	public void undo() {
		Polygon polygon = this.beforeShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(PolygonUtils.copy(polygon));
		this.selectedShape.setStatus(this.beforeShape.getStatus().copy());
	}
	
	/**
	 * Redo the Move
	 */
	public void redo() {
		Polygon polygon = this.afterShape.getChangedPolygon();
		this.selectedShape.setChangedPolygon(PolygonUtils.copy(polygon));
		this.selectedShape.setStatus(new ShapeStatus(this.afterShape.getStatus()));
	}
}
