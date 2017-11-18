package plane.models;

import java.awt.*;

import plane.utils.*;

/**
 * The Class PlacedShape.
 * Any entity being placed on the board must be of this class type. 
 * A PlacedShape will have its initial Polygon state, when user first enters the PuzzleSolving Board.
 * A PlaedShape will have its changed Polygon state, after several operations by user, 
 * and a ShapeStatus to record detailed status information of the changed Polygon.
 * @author cheng zhu Zeqian Li
 */
public class PlacedShape{
	
	/** The original polygon. */
	Polygon originalPolygon;
	
	/** The changed polygon. */
	Polygon changedPolygon;
	
	/** The status. */
	ShapeStatus status;
	
	/**
	 * @return a String representing this PlacedShape states.
	 */
	public String toString() {
		String ret = "";
		ret += status.toString();
		ret += "originalPolygon:\n";
		ret += PolygonUtils.toString(originalPolygon);
		ret += "changedPolygon:\n";
		ret += PolygonUtils.toString(changedPolygon);
		return ret;
	}
	
	/**
	 * Return a String representing the changedPolygon states, 
	 * so that this PlacedShape can be saved on disk as a part of a solution, and be loaded back next time
	 *
	 * @return the solution string
	 */
	public String toSolutionString() {
		String ret = "";
		ret += status.getColor().getRed();
		ret += " " + status.getColor().getGreen();
		ret += " " + status.getColor().getBlue();
		for(int i = 0; i < changedPolygon.npoints; i++) {
			ret += " " + changedPolygon.xpoints[i];
			ret += " " + changedPolygon.ypoints[i];
		}
		return ret;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ShapeStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ShapeStatus status) {
		this.status = status;
	}

	/**
	 * Gets the original polygon.
	 *
	 * @return the original polygon
	 */
	public Polygon getOriginalPolygon() {
		return originalPolygon;
	}

	/**
	 * Sets the original polygon.
	 *
	 * @param originalPolygon the new original polygon
	 */
	public void setOriginalPolygon(Polygon originalPolygon) {
		this.originalPolygon = originalPolygon;
	}
	
	/**
	 * Instantiates a new placed shape.
	 *
	 * @param color the color
	 */
	public PlacedShape(Color color) {
		this.status = new ShapeStatus(color);
		this.originalPolygon = new Polygon();
		this.changedPolygon = new Polygon();
	}
	
	/**
	 * Instantiates a new placed shape.
	 *
	 * @param shape the shape
	 */
	public PlacedShape(PlacedShape shape) {
		this.originalPolygon = PolygonUtils.copy(shape.getOriginalPolygon());
		this.changedPolygon = PolygonUtils.copy(shape.getChangedPolygon());
		this.status = shape.getStatus().copy();
	}
	
	/**
	 * Copy this placedShape to a new PlacedShape instance
	 *
	 * @return the placed shape
	 */
	public PlacedShape copy() {
		return new PlacedShape(this);
	}
	
	/**
	 * Reset status and Polygon to initial states.
	 */
	public void resetPos(){
		int numPoints = this.originalPolygon.npoints;
		this.changedPolygon.reset();
		for (int i = 0; i < numPoints; i++) {
			this.changedPolygon.addPoint(this.originalPolygon.xpoints[i], this.originalPolygon.ypoints[i]);
		}
		this.status.reset();
	}
	
	/**
	 * Adds the point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void addPoint(int x, int y) {
		this.originalPolygon.addPoint(x, y);
		this.changedPolygon.addPoint(x, y);
	}
	
	/**
	 * Select this shape.
	 */
	public void selectShape() {
		this.status.select();
	}
	
	/**
	 * Gets the position of this shape.
	 *
	 * @return the position
	 */
	public Point getPosition() {
		return this.status.getPosition();
	}
	
	/**
	 * Checks if is selected.
	 *
	 * @return true, if is selected
	 */
	public boolean isSelected() {
		return this.status.isSelected();
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return this.status.getColor();
	}
	
	/**
	 * Gets the most left coordinate of X of this placedShape.
	 *
	 * @return the most left X
	 */
	public int getLeftX() {
		return ArrayUtils.min(this.changedPolygon.xpoints, this.changedPolygon.npoints);
	}
	
	/**
	 * Gets the most right coordinate of X of this placedShape.
	 *
	 * @return the most right X
	 */
	public int getRightX() {
		return ArrayUtils.max(this.changedPolygon.xpoints, this.changedPolygon.npoints);
	}
	
	/**
	 * Gets the most top coordinate of Y of this placedShape.
	 *
	 * @return the most top Y
	 */
	public int getTopY() {
		return ArrayUtils.min(this.changedPolygon.ypoints, this.changedPolygon.npoints);
	}
	
	/**
	 * Gets the most bottom coordinate of Y of this placedShape.
	 *
	 * @return the most bottom Y
	 */
	public int getBottomY() {
		return ArrayUtils.max(this.changedPolygon.ypoints, this.changedPolygon.npoints);
	}
	
	
	/**
	 * Sets the position of this shape.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setPosition(int x, int y) {
		Point p = this.getPosition();
		this.changedPolygon.translate(x - p.x, y - p.y);
		this.status.setPosition(x, y);
	}
	
	/**
	 * Rotate this shape.
	 *
	 * @param angle the rotating angle
	 */
	public void rotate(int angle) {
		this.status.rotate(angle);
		PolygonUtils.rotate(this.changedPolygon, angle);
	}
	
	/**
	 * Vertically flip the shape
	 */
	public void vFlip() {
		this.status.vFlip();
		PolygonUtils.vFlip(this.changedPolygon);
	}
	
	/**
	 * Horizontally flip the shape
	 */
	public void hFlip() {
		this.status.hFlip();
		PolygonUtils.hFlip(this.changedPolygon);
	}

	/**
	 * Get the changed polygon.
	 *
	 * @return the changed polygon
	 */
	public Polygon getChangedPolygon() {
		return changedPolygon;
	}

	/**
	 * Sets the changed polygon.
	 *
	 * @param changedPolygon the new changed polygon
	 */
	public void setChangedPolygon(Polygon changedPolygon) {
		this.changedPolygon = changedPolygon;
	}
}