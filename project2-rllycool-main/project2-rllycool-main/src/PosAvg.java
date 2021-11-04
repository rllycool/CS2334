import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PosAvg {

	private String carID;
	private String[] newVeh = new String[1000];
	private String[] index = new String [1000];
	/**
	 * Constructor assigns carID to what user passes
	 * @param id the vehicle id the user passes
	 */
	public PosAvg(String id){
	
		this.carID = id;
	
	}
	
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

	
	public static String[] FulltoVehicleID() {
		String[] full = readFileIntoList("VANETdata.txt");
		
		for(int i =0; i < full.length -3;i++)
		{
			full[i] = full[i+3];
		}
		for(int i =0; i< full.length -1 ; i++) {
			String total = full[i];
			String[] condensed = total.split("\\s+");
			String vehicleID = condensed[1];
			full[i] = vehicleID;
		}
		return full;
	}
	/**
	 * 
	 * @return index of vehicle
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int indexOfVehicle() throws FileNotFoundException, IOException {
		
		String indexCar = carID.substring(carID.length()-3);
		int getIndex = Integer.parseInt(indexCar);
		
		return (getIndex);
		
	}
	/**
	 * Prints out message
	 */
	
	public String toString() {
	
		return "This index is average of BHv019 and BYv021, BGv018 and CAv022, and so on.";
	}

	public static List<String> readFileForString(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
}

