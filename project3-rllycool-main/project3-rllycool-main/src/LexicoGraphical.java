import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LexicoGraphical extends AbstractSort{

	public LexicoGraphical(HashMap<String, Integer> asciiVal) {
		Map<String,Integer> sorted = sortedMap(asciiVal);
		for(Map.Entry<String,Integer> entry :sorted.entrySet()) {
			System.out.println(entry.getKey() );
		}
	
		
		
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		// TODO Auto-generated method stub
		Map<String,Integer> sorted = new TreeMap<String,Integer>(unsorted);
		
		return sorted;
	}
	
		

}
