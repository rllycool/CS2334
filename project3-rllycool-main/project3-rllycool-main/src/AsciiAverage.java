import java.io.*;

public class AsciiAverage extends AbstractAscii{
	private int sumchar = 0;
	private Vanet id;
	
	/*
	 * Callss the super constructor in abstractAscii
	 * @param Vanet object to be assigned to the Vanet id
	 */
	public AsciiAverage(Vanet vanet) {
		// TODO Auto-generated constructor stub
		super();
		this.id = vanet;
	}

	/*
	 * calculate the average of the ascii vals.
	 */
	public int calAverage() {
		// TODO Auto-generated method stub
		double sumOfChar = 0.0;
		String ids = id.getVehicleID();
			
		for(int i = 0 ; i< ids.length(); i++) {
			sumOfChar += (double)ids.charAt(i);
		}
		return (int) Math.round(sumOfChar/ids.length());
	}

}
