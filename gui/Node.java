import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class Node {
	private Point2D position;
	private Map<String, Node> neighbors;

	public Node(double x, double y) { 
		position = new Point2D.Double(x, y);
		neighbors = new HashMap<>();
		neighbors.put("RIGHT", null);
		neighbors.put("LEFT", null);
		neighbors.put("UP", null);
		neighbors.put("DOWN", null);
	}
    public void render(Graphics2D g2d) {
        for (String n : neighbors.keySet()) {
            if (neighbors.get(n) != null) {
                Point2D lineStart = position;
                Point2D lineEnd = neighbors.get(n).getPosition();
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(4));
                g2d.draw(new Line2D.Double(lineStart, lineEnd));
                g2d.setColor(Color.RED);
                g2d.fillOval((int) position.getX() - 6, (int) position.getY() - 6, 12, 12);
            }
        }
    }
	private Point2D getPosition() {
		return position;
	}
	
	
}
