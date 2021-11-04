import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortingAlg {
	
	//File file = new File("ComplexDates.txt");
	static String fileName = ("ComplexDates.txt");
	
	/*
	 * Reads in the file complex dates, and then assigsn them a hashmap.trims these values for appropiate whitespace in the process.
	 * @Throws FileNotFoundException, IOException
	 */
	public HashMap<LocalDate, Integer> dates() throws FileNotFoundException, IOException{
	//	ArrayList<String> intial = new ArrayList<String>();
	//	ArrayList<String> cropped = new ArrayList<String>();
		
		HashMap<LocalDate,Integer> map = new HashMap<LocalDate,Integer>();
		
		File filePath = new File(fileName);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath.getAbsolutePath())))
		{
		
			String str;
			
			while((str = reader.readLine()) != null){
				
				//removes the white space
				String data = str.trim().replaceAll("\\s+", "");
				String[] eh = data.split("\t");
				
				//formatting each complex date
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				LocalDate ld = LocalDate.parse(eh[0], formatter);
				
				if(map.containsKey(ld)) {
					int number = map.get(ld) +1;
					map.put(ld,number);
					
				}
				else map.put(ld,1);
			}
		}
		return map;
	}
	
	/*
	 * Sorts the hashmap by descending order using the provided helper sorting methods. 
	 * @Throws FileNotFoundException, IOException
	 */
	public void sortDescending() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Map<LocalDate,Integer> map = new HashMap<LocalDate, Integer>();
		map = dates();
		
		Set<LocalDate> ks = map.keySet();
		ArrayList<LocalDate> listOfKeys = new ArrayList<LocalDate>(ks);
		
		int size = listOfKeys.size();
		
		qs(listOfKeys,0,size-1,false);
		printArray(listOfKeys,size);
	}

	/*
	 * Sorts the hasMap by ascending order using the provided helper sorting methods.
	 * @throws FileNotFoundException, IOEXception
	 */
	public void sortAscending() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Map<LocalDate,Integer> map = new HashMap<LocalDate,Integer>();
		map = dates();
		
		Set<LocalDate> ks = map.keySet();
		ArrayList<LocalDate> listOfKeys = new ArrayList<LocalDate>(ks);
		
	int size = listOfKeys.size();
		
		qs(listOfKeys,0,size-1,true);
		printArray(listOfKeys,size);
		
	}
	
	/*
	 * Uses a temp LocalDate object to swap values
	 * @param ArrayList<LocalDate> arr, int a, int b
	 */
	public static void swi(ArrayList<LocalDate> arr,int a, int b) {
		
		LocalDate temp = arr.get(a);
		
		arr.set(a,arr.get(b));
		arr.set(b,temp );
	}
	
	/*
	 * Partition method. 
	 * @param ArrayList<LocalDate> arr, int low, int high, boolean isA
	 */
	static int uhh(ArrayList<LocalDate> arr,int low,int high,boolean isA) {
		LocalDate swap = arr.get(high);
		int i = (low-1);
		
		for(int j = low; j<= high-1; j++) {
			LocalDate e = arr.get(j);
			if((isA == true && e.compareTo(swap) < 0) || (e.compareTo(swap)>0 && isA == false)){
				i++;
				swi(arr,i,j);
				
			}
			
			}
		swi(arr,i+1, high);
		return (i+1);
	}
	
	/*
	 * QuickSwitch, qs for short
	 * Uses recursion to switch two values
	 * @param ArrayList<LocalDate> arr, int low, int high, boolean isA
	 */
	static void qs(ArrayList<LocalDate> arr,int low, int high,boolean isA) {
		if(low<high) {
			int pi = uhh(arr,low,high,isA);
			
			qs(arr,low,pi-1,isA);
			qs(arr,pi+1,high,isA);
		}
	}
	
	static void printArray(ArrayList<LocalDate> arr, int size) {
		for(int i =0; i < size; i++) 
			System.out.println(arr.get(i) + " ");
		
		System.out.println();
		
	}
}
