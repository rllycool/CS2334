
public class SortedList extends IntegerList {

	public SortedList() {
		super();
		
	}
	
	public SortedList(int capacity) {
		super(capacity);
	}
	
	
	public void add (int integer) {
		boolean addToList = false;
		
		for(int i =0; i<size(); i++) {
			if(integer < get(i)) {
				super.insert(i, integer);
				addToList = true;
				break;
			}
		}
		
		
		if(addToList == false) {
			if(size() >0 && integer <= get(0)) {
				super.insert(0, integer);
				
			}
			else {
				super.insert(size(), integer);
			}
		}
		
	}
	
	public void insert(int index, int integer) {
		
		throw new UnsupportedOperationException("");
		
		
	}
	
	
	
	
}

