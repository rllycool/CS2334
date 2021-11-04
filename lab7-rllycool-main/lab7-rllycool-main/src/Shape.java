
public abstract class Shape implements Comparable<Shape> {

	// TODO: Complete this class.

	private int id;
	private static int nextID =0;
	
	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
	
	protected Shape() {
		this.id = nextID;
		nextID++;
	}
	
	
	public int getID() {
		return this.id;
	}
	
	//do this shit
	public int compareTo(Shape other) {
	
		String type = other.getClass().getName();
		int result = this.getClass().getName().compareTo(type);
		
		if(result ==0) {
			result = (this.getPerimeter() < other.getPerimeter() ? 
					-1 :(this.getPerimeter() == other.getPerimeter() ? 0 : 1 ));
				
			if(result ==0) {
				result =( this.getArea() < other.getArea() ?
						-1 :(this.getArea() == other.getArea() ? 0: 1));
			}
		}
		return result;
	}
	
	public abstract double getPerimeter();
	public abstract double getArea();
}
