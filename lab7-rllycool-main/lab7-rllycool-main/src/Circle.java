
public class Circle extends Shape {

	private double radius;
	
	/**
	public int compareTo(Shape o) {
		// TODO Auto-generated method stub
		return 0;
	}
**/
	public Circle(double radius) {
		//check if radius is invalid
		if(radius <= 0) {
			throw new IllegalArgumentException("Nonpositive radius: " + radius);
		}
		
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getPerimeter() {
		
		return (radius * 2 * Math.PI);
	}
	
	public double getArea() {
		
		return (Math.pow(radius, 2) * Math.PI);
	}
}
