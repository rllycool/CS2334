import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EqualAverage {

	private int asciiAvg;
	private HashMap<String, Integer> asciiValues;
	private ArrayList<Integer> asciiVals;
	
	/*
	 * @Param vehicleID. the ID of the vehicle to have the ascii avg calculated
	 */
	public EqualAverage(String vehicleID) {
		// TODO Auto-generated constructor stub
		AsciiAverage asciiAverage = new AsciiAverage(new Vanet(vehicleID));
		ArrayList<Integer> vals = new ArrayList<Integer>();
		asciiAvg = asciiAverage.calAverage();
		HashMap<String, Integer> asciiVal = new HashMap<String,Integer>();
		String[] vehicles = FulltoVehicleID();
		
		for(int i = 0; i < vehicles.length; i++) {
			AsciiAverage arrvehicle = new AsciiAverage(new Vanet(vehicles[i]));
			int arrAvg = arrvehicle.calAverage();
			asciiVal.put(vehicles[i], arrAvg);
			vals.add(arrAvg);
		}
		this.asciiValues = asciiVal;
		this.asciiVals = vals;
	}

	/*
	 * Finds all the values with equal asciivalues and stores into a hashMap
	 */
	public HashMap<String, Integer> calAsciiEqual() {
		// TODO Auto-generated method stub
		HashMap<String,Integer> equal = new HashMap<String,Integer>();
		
		for(Map.Entry<String,Integer> name : asciiValues.entrySet()) {
			if(name.getValue() == asciiAvg) {
				equal.put(name.getKey(), name.getValue());
			}
		}
		return equal;
	}
	
	/*
	 * Reads the provided file into a List of type string.
	 * @param file. the file to be read in
	 */
	public static String[] readFileIntoList(String file) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
			}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		String[] full = new String[lines.size()];
		full = lines.toArray(full);
		return full;
	}

	/*
	 * Reads the file into a string array, and then parses and trims it.
	 */
	public static String[] FulltoVehicleID() {
		String[] full = readFileIntoList("VANETData.txt");
		
		for(int i = 0 ; i < full.length -1; i++) {
			full[i] = full[i+1];
			
		}
		
		for(int i = 0; i < full.length-1; i++) {
			String total = full[i];
			String[] condensed = total.split("\\s+");
			String vehicleID = condensed[0];
			full[i] = vehicleID;
		}
		return full;
	}

}
