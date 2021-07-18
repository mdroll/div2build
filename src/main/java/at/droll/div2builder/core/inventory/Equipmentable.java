package at.droll.div2builder.core.inventory;

import at.droll.div2builder.core.item.ItemAbstract;

/**
 * Equipmentable Interface for equipment
 * @author Marco Droll
 */
public interface Equipmentable {	
	
	/**
	 * Add equipment
	 * @param slot The slot where the item should be set
	 * @param item The item itselt what should be added
	 * @return Inventory instance
	 */
	public Inventory addEquipment(InventorySlot slot, ItemAbstract item);
	
	/**
	 * Removes equipment
	 * @param slot The slot where the equipment should be removed
	 * @return True if the remove was successful
	 */
	public boolean removeEquipment(InventorySlot slot);
}
