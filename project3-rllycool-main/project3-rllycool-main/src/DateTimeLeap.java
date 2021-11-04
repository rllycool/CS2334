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
import java.util.Map.Entry;
import java.util.TreeMap;
import java.time.Period;



public class DateTimeLeap {
	private Map<LocalDate, Integer> dates;
	/*
	 * Constructor for DateTimeLeap
	 */
	public DateTimeLeap() {

	}
	/*
	 * CompareYear Method. Will create a hashmap and store the values read in from the file.
	 * 
	 */
	public void compareYear() {
		// TODO Auto-generated method stub
		
		// makes hashmap
		Map<LocalDate, Integer> map = new HashMap<LocalDate, Integer>();

		// makes arraylist to intially store dates in before formatting
		ArrayList<String> intial = new ArrayList<String>();
		File file = new File("SimpleDates.txt");

		// reads the dates into arraylist
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String st;
			while ((st = reader.readLine()) != null) {
				intial.add(st);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int counter = 1;

		LocalDate current = LocalDate.now();

		// splits date by . delimiter and then combines them in the right format and
		// converts to localDate and then adds to hashmap
		for (int i = 0; i < intial.size(); i++) {
			String og = intial.get(i);
			String[] arr = og.split("[.]");
			String month = arr[0];
			String day = arr[1];
			String year = arr[2];
			int leap = Integer.parseInt(year);
			String dateFormatted = year + "-" + month + "-" + day;
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dateFormatted, formatter);
			Period period = Period.between(date, current);
			map.put(date, counter);
			counter++;
			if ((leap % 4 == 0) && (leap % 100 != 0) || (leap % 400 == 0)) {
				System.out.println(date.getYear() + " is a leap year, and the difference: " + period.getYears()
						+ " years, " + period.getMonths() + " months, and " + period.getDays() + " days.");
			} else {
				System.out.println(date.getYear() + " is not a leap year, and the difference: " + period.getYears()
						+ " years, " + period.getMonths() + " months, and " + period.getDays() + " days.");
			}

		}

		dates = map;

	}

	/*
	 * outprints the hashmap unsorted
	 */
	public void dateHashMap() {
		// TODO Auto-generated method stub
		for (LocalDate key : dates.keySet()) {
			System.out.println(key + ":" + dates.get(key));
		}

	}
	
	/*
	 * converts the hashmap to a treepmap which automatically sorts it.
	 * then outprints it.
	 */
	public void dateHashMapSort() {
		// TODO Auto-generated method stub
		Map<LocalDate, Integer> sorted = new TreeMap<LocalDate, Integer>(dates);
		for (Map.Entry<LocalDate, Integer> entry : sorted.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

}
