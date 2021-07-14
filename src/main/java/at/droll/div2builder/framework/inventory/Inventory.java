package at.droll.div2builder.framework.inventory;

import java.lang.reflect.Field;

import at.droll.div2builder.framework.item.ItemAbstract;

/**
 * Represents the inventory
 * 
 * @author Marco Droll
 */
public class Inventory implements Equipmentable {
	
	/**
	 * 
	 */
	public final static String[] slotList = {"ARMOR", "BACKPACK", "GLOVE", "MASK", "HOLSTER", "KNEEPAD",
											 "PRIMARY", "SECONDARY", "PISTOL"
	};
	
	/**
	 * Holds the primary weapon
	 */
	private ItemAbstract primary;
	
	/**
	 * Holds the secondary weapon
	 */
	private ItemAbstract secondary;
	
	/**
	 * Holds the pistol
	 */
	private ItemAbstract pistol;
	
	/**
	 * Holds the mask equipment
	 */
	private ItemAbstract mask;
	
	/**
	 * Holds the body equipment
	 */
	private ItemAbstract body;
	
	/**
	 * Holds the armor equipment
	 */
	private ItemAbstract armor;
	
	/**
	 * Holds the backpack equipment
	 */
	private ItemAbstract backpack;
	
	/**
	 * Holds the kneepad equipment
	 */
	private ItemAbstract kneepad;
	
	/**
	 * Holds the glove equipment
	 */
	private ItemAbstract glove;
	
	/**
	 * Holds the holser equipemnt
	 */
	private ItemAbstract holster;

	/**
	 * Return the appropirates equipment to the specific slot
	 * @param slot Give the enum InventorySlot to return the specific equipment
	 * @return AttributeAbstract
	 */
	public ItemAbstract getEquipment(InventorySlot slot) {
		switch(slot) {
			case ARMOR:
				return this.armor;			
			case BACKPACK:
				return this.backpack;			
			case MASK:
				return this.mask;			
			case GLOVE:
				return this.glove;			
			case HOLSTER:
				return this.holster;			
			case KNEEPAD:
				return this.kneepad;			
			case PRIMARY:
				return this.primary;			
			case SECONDARY:
				return this.secondary;			
			case PISTOL:
				return this.pistol;
			default:
				return null;
		}
	}
		
	
	/**
	 * Add to the specific slot the specific item
	 * @param slot The slot where something should be add
	 * @param item The item itself
	 * @return Inventory
	 * @see InventorySlot
	 * @see ItemAbstract
	 */
	@Override
	public Inventory addEquipment(InventorySlot slot, ItemAbstract item) {
		
		switch(slot) {
			case ARMOR:
				this.armor = item;
				break;
			case BACKPACK:
				this.backpack = item;
				break;
			case MASK:
				this.mask = item;
				break;
			case GLOVE:
				this.glove = item;
				break;
			case HOLSTER:
				this.holster = item;
				break;
			case KNEEPAD:
				this.kneepad = item;
				break;
			case PRIMARY:
				this.primary = item;
				break;
			case SECONDARY:
				this.secondary = item;
				break;
			case PISTOL:
				this.pistol = item;
				break;
		}		
		
		return this;
	}
	
	/**
	 * Remove from the specific slot the item
	 * @param slot Inventory slot to remove the item from
	 * @return Returns true if the item could be removed
	 */
	@Override
	public boolean removeEquipment(InventorySlot slot) {
		switch(slot) {
			case ARMOR:
				this.armor = null;
				break;
			case BACKPACK:
				this.backpack = null;
				break;
			case MASK:
				this.mask = null;
				break;
			case GLOVE:
				this.glove = null;
				break;
			case HOLSTER:
				this.holster = null;
				break;
			case KNEEPAD:
				this.kneepad = null;
				break;
			case PRIMARY:
				this.primary = null;
				break;
			case SECONDARY:
				this.secondary = null;
				break;
			case PISTOL:
				this.pistol = null;
				break;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [primary=" + primary + ", secondary=" + secondary + ", pistol=" + pistol + ", mask=" + mask
				+ ", body=" + body + ", armor=" + armor + ", backpack=" + backpack + ", kneepad=" + kneepad + ", glove="
				+ glove + ", holster=" + holster + "]";
	}
}
