import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
		static final Map<Rank, Integer> CARD_VALUES = new HashMap<Rank,Integer>();
	 
	 static{
		// Map<Rank, Integer> CARD_VALUES ;
		CARD_VALUES.put(Rank.TWO,2);
		 CARD_VALUES.put(Rank.THREE,3);
		 CARD_VALUES.put(Rank.FOUR,4);
		 CARD_VALUES.put(Rank.FIVE,5);
		 CARD_VALUES.put(Rank.SIX,6);
		 CARD_VALUES.put(Rank.SEVEN,7);
		 CARD_VALUES.put(Rank.EIGHT,8);
		 CARD_VALUES.put(Rank.NINE,9);
		 CARD_VALUES.put(Rank.TEN,10);
		 CARD_VALUES.put(Rank.JACK, 10);
		 CARD_VALUES.put(Rank.QUEEN, 10);
		 CARD_VALUES.put(Rank.KING, 10);
		 CARD_VALUES.put(Rank.ACE,11);
		 
	}
	private static final int MAX_VALUE = 21;
	
	private List<Card> cards = new ArrayList<Card>();

	private int value =0;
	private int numAcesAs11 = 0;
	
	public BlackjackHand(Card c1, Card c2) {
		cards.add(c1);
		cards.add(c2);
	}
	public void addCard(Card card) {
		//check if card is null
		if(card == null) {
			throw new NullPointerException();
		}
		
		//if the value of the hand is above max dont ass card
		if(getValue() < MAX_VALUE) {
			
			//check if card is an ace 
			if(card.getRank() == Rank.ACE) {
				numAcesAs11 ++;
				
			}
			
			cards.add(card);
		}
			

		
	}
	public int size() {
		return cards.size();
		
	}
	public static Map<Rank,Integer> getCardValues() {
		Map<Rank,Integer> copy = assign();
		return copy;
		
	}
	public static Map<Rank,Integer> assign(){
		Map<Rank,Integer> copy = CARD_VALUES;
		return copy;
	}
	public List<Card> getCards(){
		List<Card> copy = cards;
		return copy;
		
	}
	public int getValue() {
		
		int value = 0;
		
		List<Card> copyCards = new ArrayList<Card>();
		copyCards = getCards();
		
		for(int i = 0; i< size(); ++i) {
			Card currentCard = copyCards.get(i);
			Rank card = currentCard.getRank();
			value += CARD_VALUES.get(card);
		}
		
		for(int i = 0 ; i<size(); ++i) {
			Card currentCard = copyCards.get(i);
			Rank card = currentCard.getRank();
			if(value <= MAX_VALUE)
			{
				break;
				
			}
			if(CARD_VALUES.get(card) ==11) {
				value = value-10;
			}
		}
		return value;
	}
	
	public String toString() {
		return Arrays.toString(cards.toArray());
		
	}
}
