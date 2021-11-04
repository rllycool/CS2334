
public class RightTriangle extends Triangle{

	//private double hypotenuse=0;
	
	public RightTriangle(double base, double height) {
		super(base,height,Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));
		
	}
	public double getBase() {
		return getSideA();
	}
	public double getHeight() {
		return getSideB();
	}
	public double getHypotenuse(){
		double hypo;
		hypo = Math.sqrt(Math.pow(getSideA(), 2) + Math.pow(getSideB(), 2));
		
		return hypo;
	}
	
	
}
