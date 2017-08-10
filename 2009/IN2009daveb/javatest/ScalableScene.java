import java.awt.event.*;

public class ScalableScene extends Scene implements MouseListener {

	public ScalableScene() {
		super();
		addMouseListener(this);
	}

	// implementation of MouseListener

	/** Scale objects under the mouse.
	 * If the left button is pressed, make them larger.
	 * If the right button is pressed, make them smaller.
	 */
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		float factor = e.isMetaDown() ? 1.25f : 0.80f;
		for (int i = 0; i < feature_count; i++) {
			if (feature[i].contains(x, y)) {
				feature[i].scale(factor);
			}
		}
		repaint();
	}

	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public static void main(String arg[]) {
		new ScalableScene();
	}
}
