package at.droll.div2builder.framework.attribute;

/**
 * AttributeException class
 * 
 * @author Marco Droll
 */
@SuppressWarnings("serial")
public class AttributeException extends Exception {
	
	/**
	 * Default constructor
	 */
	public AttributeException( ) {
	}
	
	/**
	 * Parameterized constructor
	 * @param errorMessage The error message to throw
	 */
	public AttributeException(String errorMessage) {		
		super(errorMessage);
	}
}