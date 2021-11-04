import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends Player{

	private Random generator;
	
	/*
	 * @param name of the player
	 */
	
	public RandomPlayer(String name) {
		super(name);
		generator = new Random();
	}

	public int[] getMove(int[] pileSizes) {
		
		int nonEmpty =0;
		int lastNonEmpPile = 0;
		for(int i =0; i< pileSizes.length; ++i) {
			if(pileSizes[i]>0) {
				nonEmpty++;
				lastNonEmpPile =i;
				
			}
			
		}
		if( nonEmpty==1) {
			int[] move2 = {lastNonEmpPile, pileSizes[lastNonEmpPile] -1};
			return move2;
		}
		else {
			int randomLegalIndex = generator.nextInt(pileSizes.length);
			int randomLegalObjectNumBound = 0;
			int randomLegalObjectNum =0;
			while(pileSizes[randomLegalIndex]==0) {
				randomLegalIndex = generator.nextInt(pileSizes.length);
			}
			randomLegalObjectNumBound = pileSizes[randomLegalIndex];
			randomLegalObjectNum = generator.nextInt(randomLegalObjectNumBound);
			int[] move3 = {randomLegalIndex , randomLegalObjectNum};
			return move3;
		}
	}
	
	
	
	
}
