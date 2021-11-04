import java.util.Objects;

public class Card implements Comparable<Card>{
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		if(rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}
	
	public int compareTo(Card otherCard) {
		//Card other = (Card) otherObject;
		
		if(this.rank == otherCard.rank) {
			return this.suit.compareTo(otherCard.suit);
		}
		return this.rank.compareTo(otherCard.rank);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	public Rank getRank() {
		return this.rank;
		
	}
	public Suit getSuit() {
		return this.suit;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}
	
	@Override
	public String toString() {
		return (rank.toString() + suit.toString());
	}
	
}
