
public class PrimeList extends IntegerList{

	private final static int FIRST_PRIME = 2;
	
	public PrimeList() {
		super();
	}
	
	public PrimeList(int upperBound) {
		
		super(10);
		if(upperBound <= 0) {
			throw new IllegalArgumentException("The upper bound must be positive."); 
		}
		
		//int[] array = new int[100];

		for(int i = 2; i<= upperBound; i++)
		{ 
			if(isPrime(i) == true)
			{ 
				super.insert(super.size(),i);
			}
			
		
			
		}
	}
	//designed helpper method with help from stackoverflow
	public static boolean isPrime(int x) {
		
		for(int i = 2; i < x; ++i)
		{ 
			if(x%i == 0)
			{ 
				return false;
			}
		}
		return true;
		
	}
	
	
	
	  public static boolean CheckPrime(int numberToCheck) {
	        int remainder;
	        for (int i = 2; i <= numberToCheck / 2; i++) {
	            remainder = numberToCheck % i;
	            //if remainder is 0 than numberToCheckber is not prime and break loop. Else continue loop
	            if (remainder == 0) {
	                return false;
	            }
	        }
	        return true;

	    }
	
	
	public void add(int upperBound) {
		

		if(upperBound < FIRST_PRIME)
		{ 
			throw new IllegalArgumentException("The upper bound cannot be less than 2.");
		} else if(super.size() >= 1 && upperBound == super.get(super.size()-1))
		{ 
			throw new IllegalArgumentException("The upper bound must be greater than the last prime in the list: " + 
					super.get(super.size()-1) + ".");
		} else { 
			for(int i =2; i <= upperBound; ++i) { 
				if(super.contains(i) == true)
				{ 
					continue;
				}
				if(i ==2 || i == 3)
				{ 
					super.insert(super.size(), i);
				}
				if(i > 3)
				{ 
					int j; 
					for(j = 2; j < i; ++ j)
					{ 
						if(i % j == 0)
						{ 
							break;
						}
					}
					if(j ==i) { 
						super.insert(super.size(), i);
					}
				}
			}
		}
	}
	
	public void insert(int index, int integer) {
		
		throw new UnsupportedOperationException();
	}
	
	public int remove(int index) {
		
		if (index < 0 || index >= size()) {
			String message = "The index is outside the range [0, " + (size() - 1) + "].";
			throw new IndexOutOfBoundsException(message);
		}
		
		int count = 0;
		
		int sizeYeah = size();
		
		for(int i = sizeYeah-1; i >= index; i--) 
		{
			super.remove(i);
			count++;
		}
	
		return count;
		
		
		
	}
	
}
