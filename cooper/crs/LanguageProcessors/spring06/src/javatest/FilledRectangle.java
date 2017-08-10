import java.awt.Color;
import java.awt.Graphics;

/** A filled rectangle.
 */
public class FilledRectangle extends FilledShape {
	protected int height;
	protected int width;

	public FilledRectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	/** Draw the shape.
	 */
	public void draw(Graphics g) {
		g.setColor(fillColour);
		g.fillRect(centreX - width/2, centreY - height/2, width, height);
	}

	/** Is the point inside the shape?
	 */
	public boolean contains(int x, int y) {
		int leftX = centreX - width/2;
		int topY = centreY - height/2;
		return leftX < x && x < leftX + width && topY < y && y < topY + height;
	}

	/** Scale the shape.
	 */
	public void scale(float factor) {
		height = Math.round(height * factor);
		width = Math.round(width * factor);
	}
}
