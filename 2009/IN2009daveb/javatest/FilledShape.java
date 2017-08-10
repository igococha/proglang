import java.awt.Color;
import java.awt.Graphics;

/** An abstract class representing a filled shape.
 */
public abstract class FilledShape {
	/** X-coordinate of the reference point for the shape. */
	protected int centreX;
	/** Y-coordinate of the reference point for the shape. */
	protected int centreY;

	/** Filling colour for the shape. */
	protected Color fillColour;

	public FilledShape() {
		centreX = 0;
		centreY = 0;
		fillColour = Color.black;
	}

	public int getCentreX() {
		return centreX;
	}

	public int getCentreY() {
		return centreY;
	}

	/** Move the shape to a new reference point. */
	public void setCentre(int x, int y) {
		centreX = x;
		centreY = y;
	}

	public void setColour(Color fillColour) {
		this.fillColour = fillColour;
	}

	/** Draw the shape.  */
	public abstract void draw(Graphics g);

	/** Is the point inside the shape?  */
	public abstract boolean contains(int x, int y);

	/** Scale the shape.  */
	public abstract void scale(float factor);
}
