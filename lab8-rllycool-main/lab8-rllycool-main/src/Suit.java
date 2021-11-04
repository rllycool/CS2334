
public enum Suit {
	
	CLUBS("C"),
	DIAMONDS("D"),
	HEARTS("H"),
	SPADES("S");
	
	private String symbol;
	
	Suit(String symbol) {
		this.symbol = symbol;
	}
	
	public String toString() {
		String output = null;
		
		output = this.symbol;
		return output;
		
	}
}
