package at.droll.div2builder.framework.mod;

/**
 * ModException class 
 * @author Marco Droll
 */
@SuppressWarnings("serial")
public class ModException extends Exception {
	
	/**
	 * Default constructor
	 */
	public ModException( ) {
	}
	
	/**
	 * Parameterized constructor
	 * @param errorMessage Errror mesage to throw
	 */
	public ModException(String errorMessage) {		
		super(errorMessage);
	}
}