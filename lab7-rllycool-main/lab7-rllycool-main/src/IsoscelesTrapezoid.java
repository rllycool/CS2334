
public class IsoscelesTrapezoid extends Polygon{

	private double top;
	private double base;
	private double leg;
	private double area;
	
	public IsoscelesTrapezoid(double top, double base, double leg) {
		super(top,base,leg,leg);
		this.top = top;
		this.base = base;
		this.leg = leg;
	}
	
	public double getTop() {
		return this.top;
	}
	
	public double getBase() {
		return this.base;
	}
	
	public double getLeg() {
		return this.leg;
	}
	
	public double getArea() {
		double newbase = ((this.base - this.top) / 2);
		area = .5*(top + base) *( Math.sqrt(Math.pow(this.leg, 2) - Math.pow(newbase, 2)));
		return this.area;
	}
	
	public Rectangle getCenterRectangle() {
		double newbase = ((this.base - this.top) / 2);
		double height = Math.sqrt(Math.pow(this.leg, 2) - Math.pow(newbase, 2));
		//if(height == 0) {
		//	height = this.base;
	//	}
		double width =0;
		if(top >= base ) width = base;
		if(base > top) width = top;
		
		Rectangle rec = new Rectangle(width,height);
		return rec;
		
	}
	
	public RightTriangle getSideTriangle() {
		 double newbase =0;
		if(base > top) newbase = ((this.base - this.top) / 2);
		if(top > base) newbase = ((this.top - this.base)/2);
		
		double height = Math.sqrt(Math.pow(this.leg, 2) - Math.pow(newbase, 2));
	//	double hypo = Math.sqrt(Math.pow(newbase, 2) + Math.pow(height, 2));
		
		RightTriangle rt = new RightTriangle(newbase,height);
		return rt;
		
	}
	
}
