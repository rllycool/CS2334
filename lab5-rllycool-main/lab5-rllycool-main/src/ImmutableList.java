import java.util.StringJoiner;

public class ImmutableList extends IntegerList{

	public ImmutableList(int...integers) {
		
		int index = 0;
		for(int input: integers) {
			
			super.insert(index, input);
			index++;
		}
	}
	
	public void add(int integer) {
		
		throw new UnsupportedOperationException();
		
	}
	
	public void insert(int index, int integer) {
		
		throw new UnsupportedOperationException();
	}
	
	public int remove(int index) {
		
		throw new UnsupportedOperationException();
	}
	
}
