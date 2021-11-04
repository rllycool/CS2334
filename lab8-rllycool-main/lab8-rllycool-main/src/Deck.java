import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	
	public Deck() {
		int index = 0;
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		List<Card> bruh = new ArrayList<Card>();
	
		for(int j= 0; j < suits.length; j++) {
			
			for(int i = 0; i< 13; i++) {
				
				bruh.add((index),(new Card(ranks[i],suits[j])));
				index ++;
			}
		}
		cards = bruh;
		
	}
	
	public int size() {
		return cards.size();
	}
	
	public String toString() {
		return cards.toString();
		
	}
	
	public Card draw() {
		if(cards == null || cards.size() ==0) {
			return null;
		}
		
		Card value;
		
		value = this.cards.get(0);
		this.cards.remove(0);
		return value;
	}
	
	
	public List<Card> draw(int count){
		
		if(count <= 0) {
			List<Card> something = new ArrayList<Card>();
			return something;
		}
		
		if(count > this.cards.size()) {
			List<Card> yeah = this.cards;
			List<Card> removed = new ArrayList<Card>();
			
			while(cards.size() != 0) {
			   
			removed.add(yeah.get(0));
			cards.remove(0);
			
			}
			return removed;
		}
	
		List<Card> removed = new ArrayList<Card>();
		
		for(int i = 0; i < count; i++) {
			if(this.cards.get(0) != null) {
			List<Card> copy = this.cards;
			
			removed.add(copy.get(0));
			this.cards.remove(0);
			}
			else {
				return removed;
			}
		}
		return removed;
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		
	}
	
	public List<Card> getCardsByRank(Rank rank){
		List<Card> deckRanked = new ArrayList<Card>();
		
		for(int i = 0 ; i< cards.size();i++) {
			
			if (rank == cards.get(i).getRank()) {
				deckRanked.add(cards.get(i));
			}
		}
		return deckRanked;
		
	}
}

