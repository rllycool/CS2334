
import java.util.Objects;

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = Objects.requireNonNull(rank);
		this.suit = Objects.requireNonNull(suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card card = (Card) obj;
		return card.rank == rank && card.suit == suit;
	}

	@Override
	public int compareTo(Card card) {
		int result = suit.compareTo(card.suit);
		if (result == 0) {
			result = rank.compareTo(card.rank);
		}
		return result;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public String toString() {
		return rank.toString() + suit.toString();
	}
}
