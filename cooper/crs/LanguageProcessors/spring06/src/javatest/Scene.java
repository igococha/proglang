import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scene extends JPanel {
	/** The maximum number of features that the scene can contain. */
	protected static final int FEATURES = 40;

	/** The number of features currently in the scene. */
	protected int feature_count = 0;

	/** Array of features. */
	protected FilledShape feature[] = new FilledShape[FEATURES];

	/** A Scene in a top-level window. */
	public Scene() {
		setBackground(Color.white);

		FilledShape redRectangle = new FilledRectangle(230, 160);
		redRectangle.setColour(Color.red);
		redRectangle.setCentre(250, 250);
		addFeature(redRectangle);

		FilledShape greenRectangle = new FilledRectangle(100, 200);
		greenRectangle.setColour(Color.green);
		greenRectangle.setCentre(140, 250);
		addFeature(greenRectangle);

		FilledShape blueRectangle = new FilledRectangle(120, 190);
		blueRectangle.setColour(Color.blue);
		blueRectangle.setCentre(140, 100);
		addFeature(blueRectangle);

		JFrame w = new JFrame("Shapes");
		w.getContentPane().add(this, BorderLayout.CENTER);
		w.setSize(400, 500);
		w.setVisible(true);
	}

	/** Add a feature to the scene.
	 * require: feature_count < FEATURES
	 */
	public void addFeature(FilledShape shape) {
		feature[feature_count] = shape;
		feature_count++;
		repaint();
	}

	/** Draw the contents of the scene. */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < feature_count; i++) {
			feature[i].draw(g);
		}
	}
}
