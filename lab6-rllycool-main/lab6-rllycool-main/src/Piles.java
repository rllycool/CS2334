import java.util.ArrayList;
import java.util.Arrays;

public class Piles {

	private int[] sizes;
	
	public Piles(int...initSizes) {
		
		//throw illegal argument if array null or length zero
		
		if(initSizes == null || initSizes.length == 0) 
		{
			throw new IllegalArgumentException();	
		}
		//Initialize new piles object with the sizes in given array
		
		int[] copySizes = Arrays.copyOf(initSizes, initSizes.length);
		this.sizes = copySizes;
		
		setSize(copySizes);
		
		//throw illegal argument if an element in array is not positive
		for(int i = 0; i < initSizes.length; i++) {
			if(initSizes[i] <= 0) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	public void setSize(int[] size) {
		this.sizes = size;
		
	}
	
	/*
	 * Returns an array with the current pile sizes
	 */
	public int[] getSizes() {
		
		return sizes.clone();
	}
	
	public void removeObjects(int[] move) throws IllegalMoveException {
		//1 check if move is null
		if(move == null) {
			throw new IllegalMoveException("null move");
		}
		//2 if the array has a length other than 2
		if(move.length !=2) {
			throw new IllegalMoveException("Invalid length: " + move.length );
		}
		
		//test all the illegal moves son
		//assigns the index and number of move to variables for readability
		int index = move[0];
		int number = move[1];
		
		
		//3 if the pile index is out of bounds
		if(index < 0 || index >= sizes.length) {
			throw new IllegalMoveException("Index out of bounds: " + index);
		}
		//4 if the pile has a size of 0. pile already empty
		if(sizes[index] == 0) {
			throw new IllegalMoveException("Pile " + index + " is empty.");
		}
		//5 if the object number is less than or equal to 0
		if(number <= 0) {
			throw new IllegalMoveException("Nonpositive object number: " + number);
		}
		//6 if the object num is greater than the pile size
		if(number > sizes[index]) {
			throw new IllegalMoveException("Object number greater than pile size: " + number +" > " + sizes[index]);
		}
		
		this.sizes[index] = Math.subtractExact(this.sizes[index],number);
	}
	/*
	 * Returns true if all the piles are empty
	 */
	public boolean isEmpty() {
		
		if(sizes == null || sizes.length == 0) {
			return true;
		}
		else {
			for(int i = 0; i< sizes.length; i++) {
				if(sizes[i] != 0) {
					return false;
				}
			}
			return true;
		}
		
		
		
	}
	/**
	 * creates an array list and adds the indexes of nonempty piles
	 * @return ArrayList of indices of nonempty piles
	 */
	public ArrayList<Integer> nonEmptyPiles(){
		
		ArrayList<Integer> non = new ArrayList<Integer>();
		
		for(int i = 0 ; i< this.sizes.length; i++) {
			
			if(this.sizes[i] > 0) {
				non.add(i);
			}
		}
		return non;
	}
}



