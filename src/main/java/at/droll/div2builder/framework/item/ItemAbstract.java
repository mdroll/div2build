package at.droll.div2builder.framework.item;

import at.droll.div2builder.framework.attribute.*;
import at.droll.div2builder.framework.inventory.InventoryException;
import at.droll.div2builder.framework.inventory.InventorySlot;
import at.droll.div2builder.framework.mod.Mod;
import at.droll.div2builder.framework.attribute.AttributeAbstract;

/**
 * Abstract item class describes all common attributes of equipment or weapon
 * @author Marco Droll
 */
abstract public class ItemAbstract extends AttributeAbstract implements Itemable {
	
	/**
	 * Is item a named item?
	 */
	private boolean isNamedItem;
		
	/**
	 * Is item an exotic item? 
	 */
	private boolean isExoticItem;
	
	/**
	 * Is talent changeable?
	 */
	private boolean isTalentChangeable;	
	
	/**
	 * Holds the kind of slot the item is
	 */
	private InventorySlot slot;	
		
	/**
	 * Getter if the item is a named item
	 * @return the isNamedItem
	 */
	public boolean isNamedItem() {
		return isNamedItem;
	}	
	
	/**
	 * Setter for a named item
	 * @param isNamedItem the isNamedItem to set
	 * @return Buildable instance
	 */
	public Buildable setNamedItem(boolean isNamedItem) {
		this.isNamedItem = isNamedItem;
		return (Buildable)this;
	}
	
	/**
	 * Getter for an exotic item
	 * @return the isNamedItem
	 */
	public boolean isExoticItem() {
		return isExoticItem;
	}

	/**
	 * Setter of an exotic item
	 * @param isExoticItem Sets ture if its an exotic item
	 * @return Buildable instance
	 */
	public Buildable setExoticItem(boolean isExoticItem) {
		this.isExoticItem = isExoticItem;
		return (Buildable)this;
	}

	/**
	 * @return the isTalentChangeable
	 */
	public boolean isTalentChangeable() {
		return isTalentChangeable;
	}

	/**
	 * @param isTalentChangeable the isTalentChangeable to set
	 */
	public Buildable setTalentChangeable(boolean isTalentChangeable) {
		this.isTalentChangeable = isTalentChangeable;
		return (Buildable) this;
	}	

	/**
	 * @param slot the slot to set
	 */
	public Buildable setSlot(InventorySlot slot) throws InventoryException {
		this.slot = slot;
		return (Buildable) this;
	}
	
	
	/**
	 * @return the slot
	 */
	public InventorySlot getSlot() {
		return slot;
	}
}