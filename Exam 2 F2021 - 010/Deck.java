
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {


	protected List<Card> cards;

	public Deck() {
		cards = new LinkedList<>();
		for (Suit suit: Suit.values()) {
			for (Rank rank: Rank.values()) {
				Card card = new Card(rank, suit);
				cards.add(card);
			}
		}
	}

	public int size() {
		return cards.size();
	}

	public String toString() {
		return cards.toString();
	}
	public Card draw() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
	

	public List<Card> draw(int count){
		if (count > cards.size()) {
			count = cards.size();
		}

		ArrayList<Card> removed = new ArrayList<>();
		if (count < 0) {
			return removed;
		}

		for (int i = 0 ; i < count ; i++) {
			removed.add(draw());
		}
		return removed;
	}

	public void shuffle() {
		Collections.shuffle(cards);		
	}

	public List<Card> getCardsByRank(Rank rank){
		if (rank == null) {
			throw new NullPointerException();
		}
		List<Card> result = new ArrayList<>();
		for (Card card: cards) {
			if (card.getRank().equals(rank)) {
				result.add(card);
			}
		}
		return result;
	}
}