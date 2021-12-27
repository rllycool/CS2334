public class Point {
    private static final double X = 0.0;
    private static final double Y = 0.0;
    protected double x;
    protected double y;

    public Point() {
    
        this.setX(x);
        this.setY(y);
    }

    public Point(Double x2, Double y2) {
		// TODO Auto-generated constructor stub
    	x = x2;
    	y= y2;
	}

	public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
   public double distanceFromCenter() {
    	
    	double distance;
    	
    	
		return x+y;
    }
}
