/**
 * This is an Abstract class.
 * 
 * @author Mohammad Mukhtaruzzaman
 * @version 2021-09
 */
public abstract class AbstractVANET {
	/** 
	 * vehicleName 		the name of the vehicle as well as the name of the company
	 * vehicleNumber 	the index number of a vehicle
	 * vehicleAddress	the present address 
	 */
	private String vehicleName;	
	private int vehicleNumber;
	private String vehicleAddress;

	/** 
	 * @param vehicleName 		the name of the vehicle as well as the name of the company
	 * @param vehicleNumber 	the index number of a vehicle
	 * @param vehicleAddress	the present address 
	 */
	public AbstractVANET(String vehicleName, int vehicleNumber, String vehicleAddress) {		
		System.out.println("All the vehicles are being tracked from the head quarter, i.e., abstract class.");
		
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.vehicleAddress = vehicleAddress;
	}

	public String getName() {
		return vehicleName;
	}	

	public String getAddress() {
		return vehicleAddress;
	}

	public void setAddress(String newAddress) {
		vehicleAddress = newAddress;
	}

	public int getNumber() {
		return vehicleNumber;
	}
		
	/** 
	 * To send/mail the price for a vehicle as a check
	 */
	public void mailPriceCheck() {
		System.out.println("Mailing a check to " + this.vehicleName + " from " + this.vehicleAddress);
	}
	
	public String toString() {
		return vehicleName + " of " + vehicleAddress + " is " + vehicleNumber;
	}
}
