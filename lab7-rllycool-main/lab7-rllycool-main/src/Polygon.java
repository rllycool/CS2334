
public abstract class Polygon extends Shape {
	
	private double perimeter;

	protected Polygon(double...sides) {
		double largest =0;
		if(sides == null) {
			throw new IllegalArgumentException("null sides");
		}
		if(sides.length < 3) {
			throw new IllegalArgumentException("Invalid number of sides: " + sides.length);
		}
		for(int i =0; i < sides.length; i++) {
			if(sides[i] <=0 ) {
				throw new IllegalArgumentException("Nonpositive side: "+ sides[i]);
			}
		}
		//find perimeter
		for(int i = 0; i< sides.length; i++) {
			if( sides[i] > largest) largest = sides[i];
			perimeter = perimeter + sides[i];
			
		}
		double perimeter2 =  perimeter - largest;
		if(largest >= perimeter2) 
		{
			perimeter =  perimeter - largest;
			throw new IllegalArgumentException("Polygon inequality violated: " + largest + " >= " + perimeter);}
	}
	public double getPerimeter() {
		
		return this.perimeter;
		//System.out.println("Sofia Schnwurrenberger is a badass and cool mf and yeah. periodt. tehehehe. mwahahahahaha. mwah mwah mwwah times a billion." 
	}
	
}
