import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HandComparator implements Comparator<List<Card>>{

	@Override
	public int compare(List<Card> arg0, List<Card> arg1) {
	   //FIXME
	   // You are comparing two hands passed in as List
	   // first: you have to sort both of these lists, that is arg0 and arg1
	   // second: you compare first two elements in both lists
	   //    if they are the same, you will move to the second elements, and repeat the comparions
	   //         if they are the same, you will move to the third element, and so on..
	   //    if the two elements are not equal, you will return the the comparison of Ranks
	   //    I have converted String values to the corresponding Integer values
	   //    and yes,for "A", "K", "Q" and "J", I have chosen Integer values
	   //   EXAMPLE
	   // arg0 [2S, 5H, KH]
	   // arg1 [2H, 3D, KD]
	   //       |
	   //       these 2 elements are the same (both have 2), comparision returns 0
	   //            |  compare the next two elements, 5 is bigger than 3, return a postitive value
	   
	   // Make sure you don't modify the arg0 and arg1 lists, so you may have to make a copy
	
		List<Card> copyarg0 = arg0;
		List<Card> copyarg1 = arg1;
		int length = copyarg0.size();
		//System.out.println(length);
		
		Collections.sort(copyarg0);
		Collections.sort(copyarg1);
	//	System.out.println(copyarg0);
	//	System.out.println(copyarg1);
		int diff =copyarg0.get(0).compareTo(copyarg1.get(0));
		if(diff!= 0) {
			return Math.abs(diff); 
		}
		if(diff ==0) {
			diff =copyarg0.get(1).compareTo(copyarg1.get(1));
			if(diff!=0) {
				return Math.abs(diff);
				
			}
			if(diff == 0) {
				diff =copyarg0.get(2).compareTo(copyarg1.get(2));
				if(diff != 0) {
					return Math.abs(diff);
					
				}
				if(diff == 0) {
					
				}
			}
		}
		return 0;
	}
}
