package at.droll.div2builder.core.attribute;

import java.util.Map;
import at.droll.div2builder.core.item.Buildable;

/**
 * First overwhelm super interface for all kind of objects with Attributes
 * @author Marco Droll
 */

public interface Attributable {

	// --- Battery of Setter ---
	
	/**
	 * Sets the name
	 * @param name The name to set
	 * @return Buildable
	 * @see Buildable
	 */
	public Buildable setName(String name);
	
	/**
	 * Set s the core attribute and core value
	 * @param attribute The core attribute to set
	 * @param value The value to set
	 * @return Buildable
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */
	public Buildable setCore(Attribute attribute, double value) throws AttributeException;
	
	/**
	 * Sets the core attribute
	 * @param attribute The core attribute to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute couldn't be set
	 */
	public Buildable setCoreAttribute(Attribute attribute) throws AttributeException;
	
	/**
	 * Sets the core value
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @throws AttributeException Throws an exception if the value couldn't be set
	 */
	public Buildable setCoreAttributeValue(double value) throws AttributeException;
	
	/**
	 * Sets the first attribute and first value
	 * @param attribute The first attribtue to set
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */	
	public Buildable setFirst(Attribute attribute, double value) throws AttributeException;
	
	/**
	 * Sets the first attribute
	 * @param attribute The first attribute to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute couldn't be set
	 */
	public Buildable setFirstAttribute(Attribute attribute) throws AttributeException;
	
	/**
	 * Sets the first attribute value
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @throws AttributeException Throws an exception if the value couldn't be set
	 */
	public Buildable setFirstAttributeValue(double value) throws AttributeException;
			
	/**
	 * Sets the second attribute and second value
	 * @param attribute The first attribtue to set
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */	
	public Buildable setSecond(Attribute attribute, double value) throws AttributeException;
	
	/**
	 * Sets the second attribute
	 * @param attribute The second attribute to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute couldn't be set
	 */
	public Buildable setSecondAttribute(Attribute attribute) throws AttributeException;
	
	/**
	 * Sets the second attribute value
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @throws AttributeException Throws an exception if the value couldn't be set
	 */ 
	public Buildable setSecondAttributeValue(double value) throws AttributeException;
		
	/**
	* Sets the third attribute and third value
	* @param attribute The third attribute to set
	* @param value The third value to set
	* @return Buildable
	* @see Buildable
	* @see Attribute
	* @throws AttributeException Throws an exception if the attribute or value couldn't be set
	*/	
	public Buildable setThird(Attribute attribute, double value) throws AttributeException;
		
	/**
	 * Sets the third attribute
	 * @param attribute The third attribute to set
	 * @return Buildable
	 * @see Buildable
	 * @see Attribute
	 * @throws AttributeException Throws an exception if the attribute couldn't be set
	 */
	public Buildable setThirdAttribute(Attribute attribute) throws AttributeException;
	
	/**
	 * Sets the third attribute value
	 * @param value The value to set
	 * @return Buildable
	 * @see Buildable
	 * @throws AttributeException Throws an exception if the value couldn't be set
	 */
	public Buildable setThirdAttributeValue(double value) throws AttributeException;
	
	/**
	 * Sets fixed attribtue i.e. for named items
	 * @param nr The number to fix. Can be called multiple times
	 * @return Buldable
	 */
	public Buildable setFixedAttribute(int nr);
	
	// --- Battery of Getter ---
	
	/**
	 * Getter for the name
	 * @return The name as string
	 */
	public String getName();
	
	/**
	 * Getter for the core attribute
	 * @return Returns the core attribute
	 * @see Attribute
	 */
	public Attribute getCoreAttribute();
	
	/**
	 * Getter for the core attribtue value
	 * @return Returns the core attribtue value
	 */
	public double getCoreAttributeValue();
	
	/**
	 * Getter for the first attribute
	 * @return Returns the first attribute
	 * @see Attribute
	 */
	public Attribute getFirstAttribute();
	
	/**
	 * Getter for the first attribute value
	 * @return Returns the first attribtue value
	 */
	public double getFirstAttributeValue();
	
	/**
	 * Getter for the second attribute
	 * @return Returns the second attribute
	 * @see Attribute
	 */
	public Attribute getSecondAttribute();
	
	/**
	 * Getter for the second attribtue value
	 * @return Returns the second attribute value
	 */
	public double getSecondAttributeValue();
	
	/**
	 * Getter for the third attribute
	 * @return Returns the third attribute
	 * @see Attribute
	 */
	
	/**
	 * Getter for the third attribute
	 * @return Returns the third attribute
	 * @see Attribute
	 */
	public Attribute getThirdAttribute();
	
	/**
	 * Getter for the third attribute value
	 * @return Returns the third attribute value
	 */
	public double getThirdAttributeValue();
		
	/**
	 * Returns all attributes and values as map
	 * @return Returns all al attributes and values as map
	 */
	public Map<Attribute, Double> getAttributesAndValues();
}
