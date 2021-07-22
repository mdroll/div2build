package at.droll.div2builder.core.inventory;

import at.droll.div2builder.core.Manufacturer;
import at.droll.div2builder.core.TalentWeapon;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.attribute.AttributeException;
import at.droll.div2builder.core.item.ItemAbstract;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.ModException;

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
	
	/**
	 * Create a mockup inventory to testing the statistic data in the first implementation test and inside the
	 * unit tests
	 * @return inventory
	 */
	public Inventory createMockupInventory() {
		try {			
			Equipment mask = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.CESKA)
												                .setSlot(InventorySlot.MASK)
												                .setCore(Attribute.WEAPONDAMAGE, 15.0)
												                .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
												                .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
												                .addMod((Mod)World.Registry.get("mod", "44"))
												                .build()
		    ;			
			
			Equipment armor = (Equipment) World.Registry.get("equipment", Equipment.THESACRIFICE)
														.setCore(Attribute.WEAPONDAMAGE, 15.0)
														.setFirst(Attribute.CRITICALHITCHANCE, 6.0)											
														.setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														.addMod((Mod)World.Registry.get("mod", "44"))
			;

			Equipment backpack = (Equipment) World.Registry.get("equipment", Equipment.THEGIFT)
														   .setCore(Attribute.WEAPONDAMAGE, 15.0)
														   .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
														   .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														   .addMod((Mod)World.Registry.get("mod", "44"));
			;
			
			Equipment kneepad = (Equipment) World.Registry.get("equipment", Equipment.FOXSPRAYER)
														  .setCore(Attribute.WEAPONDAMAGE, 15.0)
														  .setSecond(Attribute.CRITICALHITDAMAGE, 12.0);
			
			Equipment glove = (Equipment) new Equipment.Builder()
													   .setImprovisedItem(true)
										               .setSlot(InventorySlot.GLOVE)
										               .setCore(Attribute.WEAPONDAMAGE, 15.0)
										               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
										               .setThird(Attribute.CRITICALHITDAMAGE, 12.0)
										               .addMod((Mod)World.Registry.get("mod", "44"))										               
										               .build();		
						
			Equipment holster = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.GRUPO)
													               .setSlot(InventorySlot.HOLSTER)
													               .setCore(Attribute.WEAPONDAMAGE, 15.0)
													               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
													               .setThird(Attribute.CRITICALHITDAMAGE, 12.0)
													               .build();
			
			Weapon primary = (Weapon) World.Registry.get("weapon", "Classic M1A")
													 .setFirst(Attribute.RIFLEDAMAGE, 15.0)
													 .setSecond(Attribute.CRITICALHITDAMAGE, 17.0)
													 .setThird(Attribute.DAMAGETOTARGETOUTOFCOVER, 10.0)
													 .setTalent(TalentWeapon.RIFLEMEN)
													 .setModGrip((Mod) World.Registry.get("mod", "20"))
													 .setModMag((Mod) World.Registry.get("mod", "42"))
													 .setModOptics((Mod) World.Registry.get("mod", "1"))
			;		
			
			Weapon secondary = (Weapon) World.Registry.get("weapon", "Police M4")
													  .setFirst(Attribute.ASSAULTRIFLEDAMAGE, 15.0)													  
													  .setThird(Attribute.DAMAGETOTARGETOUTOFCOVER, 10)
													  .setTalent(TalentWeapon.FASTHANDS)
													  .setModMag((Mod) World.Registry.get("mod", "28"))
													  .setModGrip((Mod) World.Registry.get("mod", "20"))
													  .setModOptics((Mod) World.Registry.get("mod", "1"))
													  .setModMuzzle((Mod) World.Registry.get("mod", "14"))
			;
			
			Weapon pistol = (Weapon) World.Registry.get("weapon", "Orbit")
												   .setCore(Attribute.PISTOLDAMAGE, 15.0)
												   .setFirst(Attribute.DAMAGETOARMOR, 6.0)
												   .setTalent(TalentWeapon.FINISHER)
												   .setModOptics((Mod) World.Registry.get("mod", "1"))
												   .setModMag((Mod) World.Registry.get("mod", "38"))
			;			
			
			return this.addEquipment(InventorySlot.MASK, mask)
					   .addEquipment(InventorySlot.ARMOR, armor)
					   .addEquipment(InventorySlot.BACKPACK, backpack)
					   .addEquipment(InventorySlot.KNEEPAD, kneepad)
					   .addEquipment(InventorySlot.GLOVE, glove)
					   .addEquipment(InventorySlot.HOLSTER, holster)
					   .addEquipment(InventorySlot.PRIMARY, primary)
					   .addEquipment(InventorySlot.SECONDARY, secondary)
					   .addEquipment(InventorySlot.PISTOL, pistol)
			;

		} catch(InventoryException | AttributeException | ModException e) {
			e.printStackTrace();	
		} return null;
	}
}
