import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class HammingDist {

	private String vehicleOne = "";
	
	private String vehicleTwo = "";
	
	private String vechileZero = "VEH00";
	
	
	private vehicleArray vehs;
	
	//assign name of file
	String fileName = ("vanetp1data.txt");

	
	/**
	 * hamming dist constructor
	 */
	public HammingDist() {

	}
	/**
	 * hamming dist construcor with one string
	 * @param vehOneIn
	 */
	public HammingDist(String vehOneIn) {
		this.vehicleOne = vehOneIn;
	}
	
	
	public HammingDist(String vehOneIn, String vehTwoIn) throws FileNotFoundException, IOException {
		this.vehicleOne = vehOneIn;
		
		this.vehicleTwo = vehTwoIn;
		
		this.vehs = vehicleArray.readFile(this.fileName);
	}

	//toString
	public String toString() {
		
		//tests if inputs are null
		
		if (vehicleOne.isEmpty() && vehicleTwo.isEmpty()) {
			return "The inputs are empty.";
		}
		
		//if second input is null
		if (vehicleTwo.isEmpty()) {
			return "The second vehicle is missing.";
		}
		
		if (vehicleOne.equals(vehicleTwo)) {
			vehicleTwo = reverse(vehicleTwo);
		}
		
		//find hammdist between two cars
		
		int hamDist = hammingDistance(vechileZero, vehicleOne);
		int hamDist2 = hammingDistance(vechileZero, vehicleTwo);

		
		//find total hammind dist
		
		int totalDist = totHammingDistance(hamDist, vehicleOne);
		int totalDist2 = totHammingDistance(hamDist2, vehicleTwo);

		String distance = ("The Hamming distance between " + vechileZero + " and " + this.vehicleOne + " is " + hamDist
				+ "; between " + vechileZero + " and " + this.vehicleTwo + " is " + hamDist2 + ".");
		String totalDistance = ("For " + this.vehicleOne + ": Number of vehicles of Hamming Distance " + hamDist + ": "
				+ totalDist + ".");
		String totalDistance2 = ("For " + this.vehicleTwo + ": Number of vehicles of Hamming Distance " + hamDist2
				+ ": " + totalDist2 + ".");

		return distance + "\n" + totalDistance + "\n" + totalDistance2;

	}
	
	//count how ma ny vehicles end with zeroes.
	
	public int getCountZero() {
		int numOfZeros = 0;

		for (int j = 0; j < vehs.getNumVehicle(); ++j) {
			String veh = vehs.getVehicle(j);
			int b = veh.length() - 1;

			if (veh.charAt(b) == '0') {
				++numOfZeros;
			}

		}

		System.out.println("Number of vehicles ended with zero: " + numOfZeros);
		return numOfZeros;
	}

	public String reverse(String vechile) {
		char[] newWord = vechile.toCharArray();
		int begin = 0;
		int end = newWord.length - 1;
		char temp;
		while (end > begin) {
			temp = newWord[begin];
			newWord[begin] = newWord[end];
			newWord[end] = temp;
			end--;
			begin++;
		}
		return new String(newWord);
	}

	// calculating the singular hamming distance between two vehicles
	
	public int hammingDistance(String veh1, String veh2) {
		int i = 0;
		int count = 0;

		// calculate the hamm dist
		
		while (i < veh1.length()) {
			if (veh1.charAt(i) != veh2.charAt(i)) {
				count++;
			}
			i++;
		}
		return count;
	}

	// calculating the total hamming distance
	
	public int totHammingDistance(int index, String vehA) {
		
		int totalDist = 0;
		for (int j = 0; j < vehs.getNumVehicle(); ++j) {
			String veh2 = vehs.getVehicle(j);
			if (hammingDistance(vehA, veh2) == index) {
				++totalDist;
			}
		}

		return totalDist;
	}

}

class vehicleArray {

	private int numVehicle = 0;
	private String[] newVechArr = new String[20];

	public String getVehicle(int index) {
		return newVechArr[index];
	}

	public int getNumVehicle() {
		return numVehicle;
	}

	public void addVehicle(String vehId) {
		if (numVehicle >= newVechArr.length) {
			newVechArr = Arrays.copyOf(newVechArr, newVechArr.length + 10);
		}
		newVechArr[numVehicle] = vehId;
		++numVehicle;

	}
	
	
	//creates array method to read in file and assign to array
	
	public static vehicleArray readFile(String fileName) throws FileNotFoundException, IOException {
		vehicleArray vehicles = new vehicleArray();  //new vehicle Arr object
		File file = new File(fileName);      

		try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
			String Fileline;
			br.readLine();
			while ((Fileline = br.readLine()) != null) {
				
				// adding vehicle ID to the array

				String[] vechileList = Fileline.split("\t");
				String vehId = vechileList[2].toUpperCase();
				

				vehicles.addVehicle(vehId);
			}
		}

		return vehicles;

	}
}

