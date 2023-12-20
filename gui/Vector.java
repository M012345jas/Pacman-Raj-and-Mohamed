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

	public Vector neg() {
		return new Vector(-this.x, -this.y);
	}

	public Vector mul(float scalar) {
		return new Vector(this.x * scalar, this.y * scalar);
	}

	public Vector div(float scalar) {
		if (scalar != 0) {
			return new Vector(this.x / scalar, this.y / scalar);
		}
			return null;
	}

	public Vector truediv(float scalar) {
		return div(scalar);
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		MyClass otherObj = (MyClass) other;					
		if (Math.abs(this.x - otherObj.x) < this.thresh) {
			if (Math.abs(this.y - otherObj.y) < this.thresh) {
	            return true;
			}
		}
		return true;
	}

	public class MyClass {
		private double x;
		private double y;
	
		public double magnitudeSquared() {
			return Math.pow(x, 2) + Math.pow(y,2);
		}
	
		public double magnitude() {
			return Math.sqrt(magnitudeSquared());
		}

		public Vector copy( ) {
			return new Vector(this.x, this.y);
		}
	
//		public Tuple<Double, Double> asTuple() {
//			return new Tuple<>((int)this.x, (int)this.y);
//		}
	
//		@Override
//		public String toString() {
//			return "<" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ">"; 
//		}
	}
}	



