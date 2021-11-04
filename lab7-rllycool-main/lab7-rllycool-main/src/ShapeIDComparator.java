import java.util.Comparator;

public class ShapeIDComparator implements Comparator<Shape>{

	@Override
	public int compare(Shape s1, Shape s2) {
		// TODO Auto-generated method stub
		
		int result = s1.getID() < s2.getID() ? 
				-1 : (s1.getID() == s2.getID() ? 0: 1);
		return result;
	}

}
