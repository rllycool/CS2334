
/**
 * This is the Driver class to initiate objects.
 * 
 * @author Mohammad Mukhtaruzzaman
 * @version 2021-09
*/
import java.io.IOException;

public class Driver {
	private static final int CAL_CEILING = 0;
	private static final int CAL_FLOOR = 1;
	private static final int CAL_AVG = 2;

	/**
	 * The is the Main method to execute the program.
	 * 
	 * @param args String array as a command-line argument
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//Instantiating objects for abstract and derived classes.
		AbstractVANET abstractVANET = new InheritVANET("BMW", 17, "OK", 36000);
		InheritVANET inheritVANET = new InheritVANET("TESLA", 25, "TX", 40000);
		
		/*
		   Output of the following two lines:
			Price is shown from AbstractVANET class.
			Sending check from InheritVANET.
			Mailing check to BMW company for price 36000.
		*/
		
		System.out.println("\nPrice is shown from AbstractVANET class.");
		abstractVANET.mailPriceCheck();
		
		/*
		 * Output of the following two lines:
		  	Price is shown from InheritVANET class.
			Sending check from InheritVANET.
			Mailing check to TESLA company for price 40000.
		 */
		System.out.println("\nPrice is shown from InheritVANET class.");
		inheritVANET.mailPriceCheck();


		System.out.print("\n");
		System.out.print("\n");
		/**
		 * InheritDateTime is a class that should inherit the class AbstractDateTime
		 */

		InheritDateTime dateTimeInherit = new InheritDateTime();

		/*
		 * The payment is due in a month. So we want to know the first and last day of a given month. 
		 * 
		 * In the following method, the first parameter is the month and the second parameter is the year. 
		 * We are going to print the first day and the last day (day of the week) of any given month of a year.
		 * Output format: for (4, 2020): 
		 * In the year 2020, for the 4th month: the first day is WEDNESDAY and the last day is THURSDAY
		 */
		dateTimeInherit.daysOfAnyMonth(10, 2021);
		dateTimeInherit.daysOfAnyMonth(11, 2021);
		dateTimeInherit.daysOfAnyMonth(12, 2021);
		System.out.print("\n");

		/**
		 * Description of the following codes and outputs are in the PDF.
		 */

		String vehicleID = "BMv020";

		PosAvg posAvg = new PosAvg(vehicleID);
		System.out.println("The Index of the vehicle is: " + posAvg.indexOfVehicle());
		System.out.println(posAvg);
		System.out.print("\n");

		InheritVehicle inheritVehicle = new InheritVehicle(new Vanet(vehicleID));

		System.out.println("Ascii Ceiling is: " + inheritVehicle.calAverage()[CAL_CEILING]);
		System.out.println("Ascii Floor is: " + inheritVehicle.calAverage()[CAL_FLOOR]);
		System.out.println("Ascii Average is: " + inheritVehicle.calAverage()[CAL_AVG]);
		System.out.print("\n");

		System.out.println("Letter Average: " + inheritVehicle.letterAverage());
		System.out.print("\n");

		LetterAvg letterAvg = new LetterAvg(inheritVehicle.letterAverage());
		System.out.println("Total number of vehicles starting with the letter '" + inheritVehicle.letterAverage()
				+ "' is " + letterAvg.numberOfVehicleWithLetterAvg() + ".");

		System.out.print(letterAvg);
	}
}
