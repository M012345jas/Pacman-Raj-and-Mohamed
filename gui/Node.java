//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.geom.Line2D;
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

}
