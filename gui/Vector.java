import java.lang.Math;

public class Vector {
	private double x;
	private double y;
	private double thresh;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		this.thresh = 0.000001;
	}

public Vector add(Vector other) {
    return new Vector(this.x + other.x, this.y + other.y);
}

public Vector sub(Vector other) {
    return new Vector(this.x - other.x, this.y - other.y);
	}
}



