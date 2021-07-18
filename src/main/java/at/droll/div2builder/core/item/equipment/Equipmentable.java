package at.droll.div2builder.core.item.equipment;

import at.droll.div2builder.core.Talent;
import at.droll.div2builder.core.inventory.InventoryException;
import at.droll.div2builder.core.item.Buildable;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.ModException;

/**
 * Equipmentable Interface
 * @author Marco Droll
 */
public interface Equipmentable {
	
	/**
	 * Defining default signature for the Weapon class. 
	 * @param improvisedItem If the equipment is an improvised item
	 * @return Returns a buildable instance to use it in a fluent way
	 * @throws InventoryException If the equipment can't be set as an improsived item
	 */
	default public Buildable setImprovisedItem(boolean improvisedItem) throws InventoryException {
		return null;
	}
	
	/**
	 * Defining default signature for the Weapon class
	 * @return Returns if the equipment is an improvised item
	 */
	default public boolean isImprovisedItem() {
		return false;
	}
	
	/**
	 * Defining default signature for the Weapon class
	 * @param manufacturer The name of manufacturer to set
	 * @return Returns a buildable instance to use it in a fluent way
	 */
	default public Buildable setManufacturer(String manufacturer) {
		return null;
	}

	
	/**
	 * Define default signature for the Weapon class
	 * @param mod The mod which should be attached to the equipment
	 * @return Returns a buildable instance to use it in a fluent way
	 * @throws ModException Throws a ModException a mod can't be attached
	 * @see Mod
	 */
	default public Buildable addMod(Mod mod) throws ModException {
		return null;
	}
	
	/**
	 * Set the specific talent to the item
	 * @param talent The talent to set
	 * @return Returns a buildable instance to use it in a fluent way
	 * @throws InventoryException Throws a InventoryException if a talent can't be set for specific equipment item
	 */
	default public Buildable setTalent(Talent talent) throws InventoryException {
		return null;
	}
}
