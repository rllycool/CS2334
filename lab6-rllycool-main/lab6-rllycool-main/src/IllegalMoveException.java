
public class IllegalMoveException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalMoveException(String moveInfo) {
		super(moveInfo);
	}
}
