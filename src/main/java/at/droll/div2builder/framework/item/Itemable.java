package at.droll.div2builder.framework.item;

import at.droll.div2builder.framework.inventory.InventoryException;
import at.droll.div2builder.framework.inventory.InventorySlot;

/**
 * Interface for Inventory called Itemable
 * @author Marco Droll
 */
public interface Itemable {

	/**
	 * @param isNamedItem the isNamedItem to set
	 * @return Buildable
	 * @see Buildable
	 */
	default public Buildable setNamedItem(boolean isNamedItem) {
		return null;
	}
		
	/**
	 * @param isExoticItem the isExoticItem to set
	 * @return Buildable
	 * @see Buildable
	 */
	default public Buildable setExoticItem(boolean isExoticItem) {
		return null;
	}
	
	/**
	 * param isTalentChangeable isTalentChangeable
	 * @param isTalentChangeable Set if talent is changeable
	 * @return Buildable
	 * @see Buildable
	 */
	default public Buildable setTalentChangeable(boolean isTalentChangeable) {
		return null;
	}
	
	/**
	 * Sets the slot of the item
	 * @param slot The InventorySlot to set
	 * @return Buildable
	 * @see Buildable
	 * @see InventorySlot
	 * @throws InventoryException Throws an exception if an item is not in the appropirate slot
	 */
	default public Buildable setSlot(InventorySlot slot) throws InventoryException {
		return null;
	}
}
