
public class Triangle extends Polygon{

	private double sideA;
	private double sideB;
	private double sideC;
	private double area;
	
	public Triangle(double sideA, double sideB, double sideC) {
		super(sideA,sideB,sideC);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	public double getSideA() {
		return this.sideA;
	}
	
	public double getSideB() {
		return this.sideB;
	}
	
	public double getSideC() {
		return this.sideC;
	}

	//@Override
	public double getArea() {
		double s;
		s = ((this.sideA + this.sideB + this.sideC )/2);
		area = Math.sqrt(s *(s-this.sideA)*(s - this.sideB) * (s- this.sideC));
		return area;
	}
	/**
	public double getPerimeter() {
		return super.getPerimeter();
	}
	**/
}
