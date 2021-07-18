package at.droll.div2builder.core.attribute;

import java.util.Stack;
import at.droll.div2builder.core.item.Buildable;

/**
 * Abstract method for the concrete implementation of setting the attributes and their corrosponding values 
 * @author Marco Droll
 */
abstract public class AttributeAbstract implements Attributable {

	/**
	 * Holds the name
	 */
	private String name;
	
	/**
	 * Holds the core attribute
	 */
	private Attribute coreAttribute;
	
	/**
	 * Holds the first attribute
	 */
	private Attribute firstAttribute;
		
	/**
	 * Holds the second attribute 
	 */
	private Attribute secondAttribute;
	
	/**
	 * Holds the third attribtue
	 */
	private Attribute thirdAttribute;
	
	/**
	 * Holds the core attribute value
	 */
	private double coreAttributeValue;
	
	/**
	 * Holds the first attribute value
	 */
	private double firstAttributeValue;
	
	/**
	 * Holds the second attribute value
	 */
	private double secondAttributeValue;
	
	/**
	 * Holds the third attribute value
	 */
	private double thirdAttributeValue;	
	
	/**
	 * Stores which Attribute position is fix by a Named/Exotic Item.
	 * Differs from 1 up to 3 
	 */
	protected Stack<Integer> fixedAttribute = new Stack<>();
	
	// ------------------------------------------------------------------------------------------
	// Following short forms / alias for setXXXAttribute and setXXXAttributeValue
	// ------------------------------------------------------------------------------------------
	@Override
	public Buildable setCore(Attribute attribute, double value) throws AttributeException {
		this.setCoreAttribute(attribute);
		this.setCoreAttributeValue(value);		
		return (Buildable) this;
	}
	
	@Override
	public Buildable setFirst(Attribute attribute, double value) throws AttributeException {
		this.setFirstAttribute(attribute);
		this.setFirstAttributeValue(value);
		return (Buildable) this;
	}
	
	@Override
	public Buildable setSecond(Attribute attribute, double value) throws AttributeException {
		this.setSecondAttribute(attribute);
		this.setSecondAttributeValue(value);
		return (Buildable) this;
	}
	
	@Override
	public Buildable setThird(Attribute attribute, double value) throws AttributeException {
		this.setThirdAttribute(attribute);
		this.setThirdAttributeValue(value);
		return (Buildable) this;
	}
	
	
	@Override
	public Buildable setFixedAttribute(int nr) {
		this.fixedAttribute.push(nr);
		return (Buildable) this;
	}	

	/**
	 * Removes all fixed attribute of an item
	 * @return Buildable instance
	 */
	public Buildable clearFixedAttribute() {
		this.fixedAttribute.clear();
		return (Buildable) this;
	}
	
	@Override
	public Buildable setName(String name) {
		this.name = name;
		return (Buildable) this; 
	}
	

	@Override
	public Buildable setCoreAttribute(Attribute attribute) {
		coreAttribute = attribute;
		return (Buildable) this;
	}
	
	@Override
	public Buildable setFirstAttribute(Attribute attribute) {
		firstAttribute = attribute;
		return (Buildable) this;
	}
	
	@Override
	public Buildable setSecondAttribute(Attribute attribute) {
		secondAttribute = attribute;
		return (Buildable) this;
	}
	
	@Override
	public Buildable setThirdAttribute(Attribute attribute) {
		thirdAttribute = attribute;
		return (Buildable) this;
	}	
	
	@Override
	public Buildable setCoreAttributeValue(double value) throws AttributeException {
		coreAttributeValue = value;
		return (Buildable) this;
	}
	
	
	@Override
	public Buildable setFirstAttributeValue(double value) throws AttributeException {
		firstAttributeValue = value;
		return (Buildable) this;
	}
	
	@Override
	public Buildable setSecondAttributeValue(double value) throws AttributeException {
		secondAttributeValue = value;
		return (Buildable) this;
	}
	
	@Override
	public Buildable setThirdAttributeValue(double value) throws AttributeException {
		thirdAttributeValue = value;
		return (Buildable) this;
	}
	
	// Getters
	
	/**
	 * Getter for the name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter for the core Attribute
	 * @return Attribute
	 */
	public Attribute getCoreAttribute() {
		return coreAttribute;
	}
	
	/**
	 * Getter for the core Attribute
	 * @return Attribute
	 */
	public Attribute getFirstAttribute() {
		return firstAttribute;
	}
	
	/**
	 * Getter for the core Attribute
	 * @return Attribute
	 */
	public Attribute getSecondAttribute() {
		return secondAttribute;
	}
	
	/**
	 * Getter for the core Attribute
	 * @return Attribute
	 */
	public Attribute getThirdAttribute() {
		return thirdAttribute;
	}
	
	/**
	 * Getter for the core attribute value
	 * @return double
	 */
	public double getCoreAttributeValue() {
		return coreAttributeValue;
	}	

	/**
	 * Getter for the core attribute value
	 * @return double
	 */
	public double getFirstAttributeValue() {
		return firstAttributeValue;
	}

	/**
	 * Getter for the core attribute value
	 * @return double
	 */
	public double getSecondAttributeValue() {
		return secondAttributeValue;
	}	

	/**
	 * Getter for the core attribute value
	 * @return double
	 */
	public double getThirdAttributeValue() {
		return thirdAttributeValue;
	}
}
