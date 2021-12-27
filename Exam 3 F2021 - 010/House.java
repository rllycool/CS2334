import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class House extends Location implements Comparable<House> {
    private static final double MINIUMUM_VALID = 100.0;
    private static final double MINIUMUM_VALID_AREA = 100.0;
    private static Integer counter = 0;
    private Integer id;

    private Double area;
    private Double pricePerSquareFoot;
    final private java.time.LocalDate buildOn;

    // assigns counter to id
    // increment a static counter every time a new house is created
    public House(Double x, Double y, Double ppsf, Double area, LocalDate buildOn) throws InvalidPricePerSquareFootExcpetion, InvalidAreaException {
		super(x,y);
		this.buildOn = buildOn;
    	id = counter;
    	setArea(area);
    	setPricePerSquareFoot(ppsf);
    	//super(area, area);
    }

    // sets an id
    public House(Double x, Double y, Double ppsf, Double area, LocalDate buildOn, Integer id2) throws InvalidPricePerSquareFootExcpetion, InvalidAreaException {
    	super(x,y);
		this.buildOn = buildOn;
		setArea(area);
		setPricePerSquareFoot(ppsf);
		
		id2 = id;
		
        // FIXME
        // here you will use an id passed as parameter to this constructor
        // comes handy when creating a house from values captured in a file
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "House [id=" + id + ", area=" + area + ", buildOn=" + buildOn + ", " + str + "]";
    }

    public Integer getId() {
        // FIXME
        return this.id;
    }


    public void setPricePerSquareFoot(Double ppsf) throws InvalidPricePerSquareFootExcpetion {
        // FIXME if the price is less than the minimum valid price, throw the appropriate
        //  excpetion
    	if(ppsf < MINIUMUM_VALID ) {
    		throw new InvalidPricePerSquareFootExcpetion(null);
    	}
    	
    	this.pricePerSquareFoot = ppsf;
    }

    public double getPricePerSquareFoot() {
		return this.pricePerSquareFoot;
        
    }

    public Double getArea() {
        return this.area;
    }

    public void setArea(Double area) throws InvalidAreaException {
        // FIXME if the area is less than the minimum area for the house, throw the appropriate
        //  excpetion
    	
    	if(area < MINIUMUM_VALID_AREA) {
    		throw new InvalidAreaException("oops");
    	}
    	
    	this.area = area;
    }

    public java.time.LocalDate getBuildOn() {
        return buildOn;
    }


    @Override
    public int compareTo(House house) {
        // If the house value of "this" is bigger that of the other "house" => return 1
        // If the house value of "this" is smaller than of the other "house" => return -1
        // compare values of the house, if they are the same (differ only by DELTA)
        //      compare how close they are to the center of (x,y) and return the value of the comparison, unless this bring 0
        //          then
        //              if "this" has smaller id than house.id, return -1
        //              if "this" has bigger id than house.id, return 1

        // FIXME can it even happen this way
    	
    	House idk = house;
    //	if((house) < this) return 1;
    	
    	
    	
    	
        if (house == this) return 0;

        // FIXME
        return 0;

    }

    private int compareHouseLocation(House house1, House house2) {
        // return  1  if house1 is closer to center than house2 (distanceFromCenter is smaller)
        // return 0 if their distance differs within DELTA
        //  return -1 if house1 is farther to center than house2 (distanceFromCenter is bigger)

    	if(house1.distanceFromCenter() == house2.distanceFromCenter()) return 0;
    	
    	if(house1.distanceFromCenter() > house2.distanceFromCenter()) return -1;
    	
    	if(house1.distanceFromCenter() < house2.distanceFromCenter()) return 1;
        
    	return 0;
    }

    public Double calculateValue() {
        return area * pricePerSquareFoot;

    }
    @Override
    public Double calculatePropertyTax(Double taxRate) {
        return calculateValue() * taxRate;
    }

}
