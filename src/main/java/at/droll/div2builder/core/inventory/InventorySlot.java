package at.droll.div2builder.core.inventory;

/**
 * Enum of all available inventory slots
 * @author Marco Droll
 */
public enum InventorySlot {
	/**
	 * Armor or chest
	 */
	ARMOR,
	
	/**
	 * Backpack
	 */
	BACKPACK,
	
	/**
	 * Holster
	 */
	HOLSTER,
	
	/**
	 * Kneepad
	 */
	KNEEPAD,
	
	/**
	 * Glove
	 */
	GLOVE,
	
	/**
	 * Mask
	 */
	MASK,
	
	/**
	 * Primary weapon
	 */
	PRIMARY,
	
	/**
	 * Secondary weapon
	 */
	SECONDARY,
	
	/**
	 * Pistol sidearm
	 */
	PISTOL;
	
	/**
	 * Get all equipment slots as array
	 * @return
	 */
	public static InventorySlot[] getAllEquipmentSlots() {
		InventorySlot[] slot = {ARMOR, BACKPACK, HOLSTER, KNEEPAD, GLOVE, MASK};
		return slot;
	}
}
