import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Ethan Tillotson
 *
 */

public class InheritVANET extends AbstractVANET{

	private int price;
	private String brand;
	
	public InheritVANET(String string, int i, String string2, int j) {
		// TODO Auto-generated constructor stub
		
		super(string,i,string2);
		this.price = j;
		this.brand = string;
	}

	
	
	public void mailPriceCheck() {
		
		System.out.println("Sending check from InheritVANET.");
		System.out.println("Mailing check to " + brand + " company for price " + price + ".");
		
		
		
	}
	
	
}
