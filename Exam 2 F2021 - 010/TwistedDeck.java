import java.util.ArrayList;
import java.util.List;

public class TwistedDeck extends Deck {
   //FIXME
	int drawOrder =0;
	//ArrayList<Card> cards= new ArrayList<>();
	
	public TwistedDeck() {
		super();
	}

	@Override
	public Card draw() {
		
		Card removed = null;
			
		if(drawOrder == 0) {
			removed = super.draw();
			drawOrder++;
			return removed;
		}
		
		if(drawOrder==1) {
			int indexlast = cards.size() -1;
			removed = cards.remove(indexlast);
			drawOrder--;
			return removed;
		}
			
		return null;
		 
	}
	
	@Override
	public List<Card> draw(int count){
      //FIXME
      // Remove a "number" of cards from the deck using TwistedDeck draw method
      // THIS RETURN IS ONLY TO  COMPILE THIS METHOD FOR NOW
		ArrayList<Card> removed = new ArrayList<>();

		for(int i =0 ; i<count; i++) {
			removed.add(draw());
		}
		return removed;
	}


	public void deal(int numberOfCardsToDeal) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < numberOfCardsToDeal; i++) {
			cards.add(draw());
		}
	
	}
	
}
