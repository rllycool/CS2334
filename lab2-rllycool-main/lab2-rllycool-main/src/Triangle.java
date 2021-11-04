import java.text.DecimalFormat;

public class Triangle {
	//instance variables
	private double sideA = DEFAULT_SIDE;
	private double sideB = DEFAULT_SIDE;
	private double sideC = DEFAULT_SIDE;
	
	public static final double DEFAULT_SIDE= 1.000;
	
	//constructors
	
	public Triangle() {          //not needed because already intialized but ill leave it in
		
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
			
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		if(isTriangle(sideA,sideB,sideC)) {
			this.sideA =sideA;
			this.sideB = sideB;
			this.sideC = sideC;
			
		}
		else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
	
		}
	}
	
	public Triangle(double[] sides) { 
		
		if ( isTriangle(sides)) {
			
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			
		}
		else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle(Triangle triangle) {
		if (triangle == null) {
			return;
		}
		else {
		
		this.sideA = triangle.sideA;
		this.sideB = triangle.sideB;
		this.sideC = triangle.sideC;
	
		}
	}
	
	//side getters
	
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	
	public double[] getSides() {
		double[] sides = {sideA,sideB,sideC};
		return sides;
	}
	
	//Angle Getters
	//I had to consult the api on how to do these math fucntions
	//Orignally i wrote it out a ton before realizing thats what the law of cosines method was for
	
	public double getAngleA() {
		//double angleA = Math.toDegrees(Math.acos((Math.pow(this.sideB,2) + Math.pow(this.sideC,2) - Math.pow(this.sideA,2)) / (2 * this.sideB * this.sideC)));
		//return angleA; //stub
		double angleA = lawOfCosines(sideB,sideC,sideA );
		return angleA;
	}
	public double getAngleB() {
		double angleB = lawOfCosines(sideA,sideC,sideB);
		return angleB;
	}
	public double getAngleC() {
		//double angleC = Math.toDegrees(Math.acos((Math.pow(this.sideA,2) + Math.pow(this.sideB,2) - Math.pow(this.sideC,2)) / (2 * this.sideA * this.sideB)));
		//return angleC;
		
		double angleC = lawOfCosines(sideA,sideB,sideC );
		return angleC;
	}
	
	public double[] getAngles() {
		//really simple. just uses the three angle getter methods then returns them in an array.
		double[] result = {getAngleA(),getAngleB(),getAngleC()};
		
		return result;
	}
	
	
	//Individual side setters
	public boolean setSideA(double sideA) {
		//ensures the side doesnt violate triangle inequality before assigning the side
		if(isTriangle(sideA,this.sideB,this.sideC)) {
			this.sideA = sideA;
			return true;
		}
		return false;
	}
	
	public boolean setSideB(double sideB) {
		//ensures the side doesnt violate triangle inequality before assigning the side
		if(isTriangle(this.sideA,sideB,this.sideC)) {
			this.sideB = sideB;
			return true;
		}
		return false;
	}
	public boolean setSideC(double sideC) {
		//ensures the side doesnt violate triangle inequality before assigning the side
		if(isTriangle(this.sideA,this.sideB,sideC)) {
			this.sideC = sideC;
			return true;
		}
		return false;
		}
	
	//SetSides
	
	public boolean setSides(double[] sides) {
		
		//test if array sides is null
     	if(sides == null) {
			return false;
		}
     	//check is array sides length is 3, then assigns the sides. The way this is set up avoid the array out of bounds exception
     	if(sides.length ==3) {
     		if(isTriangle(sides[0],sides[1],sides[2])) {
     			this.sideA = sides[0];
     			this.sideB = sides[1];
     			this.sideC = sides[2];
     			return true;
		}
			else {
				return false;
			}
	} else {
		return false;
		}
	}
	
	//helper methods
	
	public static boolean isTriangle(double a, double b, double c) {
		boolean result = false;
		//test that all sides are positive
		if(a >0 && b> 0 && c>0) {
			//Triangle inequality test
		if(a<(b+c) && b < (a+c) && c < (a+b)){
			result = true;
			}
		}
		return result;
	}
	
	public static boolean isTriangle(double[] sides) {
		if(sides != null && sides.length ==3) {
			if(sides[0] > 0 && sides[1] >0 && sides[2] > 0) {
				if(sides[0] + sides[1] >sides[2] && sides[2] +sides[1] > sides[0] && sides[0] +sides[2] >sides[1]) {
					return true;
					}
				return false;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public static double lawOfCosines(double a,double b,double c) {  //this works just need to be careful when passing parameters
		
		double angle =  Math.toDegrees(Math.acos((Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2)) / (2 * a * b)));
		return angle;
	}
	
	
	//testToString
	
	private static DecimalFormat df = new DecimalFormat("0.000");  //Established the decimalformat object 
	
	public String toString() {  // needs to be fixed. returns 1,1,1 instead of 1.000,1.000,1.000
		
		//System.out.println(df.format(this.sideA));
	//	System.out.println(df.format(this.sideB));
	//	System.out.println(df.format(getSideC()));
		
		return "Triangle(" + df.format(sideA) + ", " + df.format(sideB) + ", " + df.format(sideC) + ")";
	
	}
	
	

}


