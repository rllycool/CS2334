import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LetterAvg {

	char letter;
	String filename = "VANETdata.txt";
	/**
	 * constructor method. just assigns letter
	 * @param letterAverage. char user passes
	 */
	public LetterAvg(char letterAverage) {
		this.letter = letterAverage;
	}
	/**
	 * 
	 * @return the num of vehilces with the same letter avg
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public int numberOfVehicleWithLetterAvg() throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		
		List<String> carCount =new ArrayList<String>();
		
		carCount = PosAvg.readFileForString(filename);
		
		String str = String.valueOf(letter);
		int num =0;
		for(int i =0; i< carCount.size(); i++) {
			
			if(carCount.get(i).substring(0,1).equals(str)){
				num++;
			}
		}
		
		
		return num;
	}

	public String[] vehicleWithLetAvg() throws FileNotFoundException, IOException{
		
		String str = String.valueOf(letter);
		
		List<String> carCount = new ArrayList<String>();
		List<String> carCount2 = new ArrayList<String>();
		
		carCount2 = PosAvg.readFileForString(filename);
		
		for( int i =0; i< carCount2.size(); ++i) {
			if(carCount2.get(i).substring(0,1).equals(str)) {
				carCount.add(carCount.get(i));
			}
		}
		String[] vehicleIDS= new String[carCount.size()];
		vehicleIDS = carCount.toArray(vehicleIDS);
		
		return vehicleIDS;
	}
	
	
	public String toString() {
		String[] l = new String[100];
		try {
			l = vehicleWithLetAvg();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String output = "";
		
		for(int i=0; i< l.length; i++) {
			output = output + l[i] + " ";
				
		}
		String yah = "These vehicles are: ";
		
		return yah + output;
	}
}
