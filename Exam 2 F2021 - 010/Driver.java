import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) {
		TwistedDeck d = new TwistedDeck();
		System.out.println(d);
		d.shuffle();
		System.out.println(d);
		
		int numberOfCardsToDeal = 3;
		d.deal(numberOfCardsToDeal);
		 
		int n = d.size();
		for (int i = 0; i < n; ++i) {
			Card x = d.draw();
			System.out.println(x);
		}
		System.out.println("=== 2");
		Deck d1 = new TwistedDeck();
		List<Card> out = d1.draw(3);

		Collections.sort(out);
		System.out.println("out " + out);

		List<Card> x1 = d1.draw(3);
		Collections.sort(x1);
		System.out.println("x1 " + x1);
		HandComparator hc = new HandComparator();
		System.out.println(hc.compare(out, x1));
		System.out.println(hc.compare(x1, out));

		List<Card> x2 = new LinkedList<>(x1);
		System.out.println(hc.compare(x1, x2));
/**
		TwistedDeck r = new TwistedDeck();
		TreeSet<List<Card>> ts = new TreeSet<>(new HandComparator());
		for (int i = 0; i < 4; ++i) {
			List<Card> lc = r.draw(14);
			ts.add(lc);
		}

	}
	**/
	}
}
