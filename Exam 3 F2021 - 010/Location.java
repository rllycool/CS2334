import java.util.HashMap;
import java.util.Objects;

public abstract class Location extends Point {

    protected Location(Double x, Double y) {
        super();
    	
    } 

    // this method is abstract because we may use the same method for calculations of
    // property tax for commercial building, or just an empty lot
    public abstract Double calculatePropertyTax(Double taxRate);


    HashMap<String, Double> getLocation() {
    	HashMap<String, Double> mapson = new HashMap<>();
    	
    	mapson.put("x", x);
    	mapson.put("y", y);
		return mapson;
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Utility.compareDoubleIfEqual(x, location.x) && Utility.compareDoubleIfEqual(y, location.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
   

    protected double distanceDifferenceFromCenter(Location house2) {
    	
    	
    	
        // FIXME
        // negative value with a difference between two distances  if location of this house is closer to center than location of house 2 (distanceFromCenter is smaller)
        // 0 if their distances differs less than  DELTA (use Utility.compareDoubleIfEqual)
        // > 0 if house1 is farther to center than house1 (distanceFromCenter is bigger)

        // FIXME
        //double distance1 = 0;
        double distance2 = 0;
        double distance1 =0;
        if (Utility.compareDoubleIfEqual(distance1, distance2)) return 0;
        
        
        // FIXME
        return 0;

    }

    static class Utility {
        protected static boolean compareDoubleIfEqual(Double a, Double b) {
            final var DELTA = 0.00001;
            return (Math.abs(a - b) < DELTA);
        }
    }
}
