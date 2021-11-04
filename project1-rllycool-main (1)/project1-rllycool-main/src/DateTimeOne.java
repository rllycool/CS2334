import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.Thread;


/**
 * 
 * @author Ethan Tillotson
 *
 */
public class DateTimeOne {
	
	//create a new localDateTime object, dateTime
	private LocalDateTime dateTime = null;
	/**
	 * Constructor
	 */
	public DateTimeOne() {
		
	}
	/**
	 * retrievs the current date and time from the system and formats it.
	 * 
	 */
	
	public void dateTimeNow() {
		//assigns 
		this.dateTime = LocalDateTime.now();
		
		//created a formatter object of type datetime formatter.
		
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		
		 //this formats datetime and prepares it to be outprinted
		String theTime = timeFormat.format(dateTime);   
		
		System.out.println("Current Date/Time: " + theTime);  //where the hell does this go
	}
	/**
	 * 
	 * @return the current time in seconds
	 */
	public int getValueOfSecond() {
		
		System.out.println("The time in second now: " + this.dateTime.getSecond());
		
		return this.dateTime.getSecond(); //returns the seconds value in the dateTime object
	}
	
	/**
	 * makes the programm wait a designated amount of time 
	 * @param time. how long to wait
	 */
	
	public void sleepForSec(int time) {
		int timeInMS;
		timeInMS = time * 1000; //converts seconds to milliseconds
		
		try {
		 Thread.sleep(timeInMS); //makes the program wait desired amount of time
		}
		catch(InterruptedException ex) {     //catches error thrown by threadSleep
			Thread.currentThread().interrupt();
		}
	}
	

}
