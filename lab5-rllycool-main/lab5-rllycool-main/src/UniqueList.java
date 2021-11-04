
public class UniqueList extends IntegerList{

	public UniqueList() {
		super();
	}
	
	public UniqueList(int capacity) {
		
		super(capacity);
	}
	
	public void add(int number) {
		
		if(contains(number) == true) {
			throw new IllegalArgumentException("The integer " + number + " is already in the list.");
		}
		
		super.add(number);
		
	}
	
	public void insert(int index, int integer) {
		
		if(contains(integer) ==true) {
			throw new IllegalArgumentException("The integer " + integer + " is already in the list.");

		}
		super.insert(index, integer);
	}
}
