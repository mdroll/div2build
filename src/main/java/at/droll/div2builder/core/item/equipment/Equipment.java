package at.droll.div2builder.core.item.equipment;

import at.droll.div2builder.core.Manufacturer;
import at.droll.div2builder.core.Talent;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.*;
import at.droll.div2builder.core.inventory.InventoryException;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.Buildable;
import at.droll.div2builder.core.item.ItemAbstract;
import at.droll.div2builder.core.mod.*;

import java.util.HashMap;

/**
 * Concrete equipment class implementation. Should not be created via constructor. Use {link #build} Method instead.
 * 
 * @author Marco Droll
 * @see Equipment.Builder
 */
public class Equipment extends ItemAbstract implements Equipmentable, Modable {
	
	/**
	 * Is the item an crafted improvised item (with additional mod slot)?
	 */
	private boolean improvisedItem;
	
	/**
	 * Holds the manufacturer object of the item
	 */
	private Manufacturer manufacturer;
	
	/**
	 * Holds the mod object
	 */
	private Mod mod;

	/**
	 * Holds the equipment talent
	 */
	private Talent talent;	
		
	/**
	 * The named item Ammo Dump as string constant with the value {@value}
	 */
	public static final String AMMODUMP					= "Ammo Dump";
	
	/**
	 * The named item Anarchist's Cookbook as string constant with the value {@value}
	 */
	public static final String ANARCHISTSCOOKBOOK	 	= "Anarchist's Cookbook";
	
	/**
	 * The named item Battery Pack as string constant with the value {@value}
	 */
	public static final String BATTERYPACK 				= "Battery Pack";
	
	/**
	 * The named item Caesar's Guard as string constant with the value {@value}
	 */	
	public static final String CAESARSGUARD 			= "Caesar's Guard";
	
	/**
	 * The named item Chainkiller as string constant with the value {@value}
	 */	
	public static final String CHAINKILLER 				= "Chainkiller";
	
	/**
	 * The named item Contractor's gloves as string constant with the value {@value}
	 */	
	public static final String CONTRACTORSGLOVES 		= "Contractor's Gloves";
	
	/**
	 * The named item Claws Out as string constant with the value {@value}
	 */	
	public static final String CLAWSOUT 				= "Claws Out";
	
	/**
	 * The named item Death Grips as string constant with the value {@value}
	 */	
	public static final String DEATHGRIPS 				= "Death Grips";
	
	/**
	 * The named item Devil's Due as string constant with the value {@value}
	 */	
	public static final String DEVILSDUE 				= "Devil's Due";
	
	/**
	 * The named item Door-Kicker's Knock as string constant with the value {@value}
	 */	
	public static final String DOORKICKERSKNOCK 		= "Door-Kicker's Knock";
	
	/**
	 * The named item Emperor's Guard as string constant with the value {@value}
	 */	
	public static final String EMPERORSGUARD 			= "Emperor's Guard";
	
	/**
	 * The named item Everyday Carrier as string constant with the value {@value}
	 */	
	public static final String EVERYDAYCARRIER 			= "Everyday Carrier";
	
	/**
	 * The named item Ferocious Calm as string constant with the value {@value}
	 */	
	public static final String FEROCIOUSCALM 			= "Ferocious Calm";
	
	/**
	 * The named item Firm handshake as string constant with the value {@value}
	 */	
	public static final String FIRMHANDSHAKE			= "Firm Handshake";
	
	/**
	 * The named item Force Multiplier as string constant with the value {@value}
	 */	
	public static final String FORCEMULTIPLIER 			= "Force Multiplier";
	
	/**
	 * The named item Forge as string constant with the value {@value}
	 */	
	public static final String FORGE 					= "Forge";
	
	/**
	 * The named item Fox's Prayer as string constant with the value {@value}
	 */	
	public static final String FOXSPRAYER 				= "Fox's Prayer";
	
	/**
	 * The named item Hunter Killer as string constant with the value {@value}
	 */	
	public static final String HUNTERKILLER 			= "Hunter Killer";
	
	/**
	 * The named item Liquid Engineer as string constant with the value {@value}
	 */	
	public static final String LIQUIDENGINEER 			= "Liquid Engineer";
	
	/**
	 * The named item Matador as string constant with the value {@value}
	 */	
	public static final String MATADOR 					= "Matador";
	
	/**
	 * The named item Motherly Gloves as string constant with the value {@value}
	 */	
	public static final String MOTHERLYGLOVES	 		= "Motherly Gloves";
	
	/**
	 * The named item Nightwatcher as string constant with the value {@value}
	 */	
	public static final String NIGHTWATCHER 			= "Nightwatcher";
	
	/**
	 * The named item Percussive Maintenance as string constant with the value {@value}
	 */	
	public static final String PERCUSSIVEMAINTENANCE	= "Percussive Maintenance";
	
	/**
	 * The named item Pointman as string constant with the value {@value}
	 */	
	public static final String POINTMAN 				= "Pointman";
	
	/**
	 * The named item Prestine Example as string constant with the value {@value}
	 */	
	public static final String PRESTINEEXAMPLE 			= "Prestine Example";
	
	/**
	 * The named item Punch Drunk as string constant with the value {@value}
	 */	
	public static final String PUNCHDRUNK 				= "Punch Drunk";
	
	/**
	 * The named item Strategic Alignment as string constant with the value {@value}
	 */	
	public static final String STRATEGICALIGNMENT 		= "Strategic Alignment";
	
	/**
	 * The named item The gift as string constant with the value {@value}
	 */	
	public static final String THEGIFT 					= "The Gift";
	
	/**
	 * The named item The Hollow Man as string constant with the value {@value}
	 */	
	public static final String THEHOLLOWMAN 			= "The Hollow Man";
	
	/**
	 * The named item The Sacrifice as string constant with the value {@value}
	 */	
	public static final String THESACRIFICE 			= "The Sacrifice";
	
	/**
	 * The named item Vedmedytsya Vest as string constant with the value {@value}
	 */	
	public static final String VEDMEDYTSYAVEST 			= "Vedmedytsya Vest";
	
	/**
	 * The named item Zero F's as string constant with the value {@value}
	 */	
	public static final String ZEROFS 					= "Zero F's";
	
	/**
	 * All named equipment items as string array constant
	 */
	public static final String[] namedEquipmentItemList = {
		Equipment.AMMODUMP, Equipment.ANARCHISTSCOOKBOOK, Equipment.BATTERYPACK, Equipment.CAESARSGUARD,
		Equipment.CHAINKILLER, Equipment.CONTRACTORSGLOVES, Equipment.CLAWSOUT, Equipment.DEATHGRIPS,
		Equipment.DEVILSDUE, Equipment.DOORKICKERSKNOCK, Equipment.EMPERORSGUARD, Equipment.EVERYDAYCARRIER,
		Equipment.FEROCIOUSCALM, Equipment.FIRMHANDSHAKE, Equipment.FORCEMULTIPLIER, Equipment.FORGE,
		Equipment.FOXSPRAYER, Equipment.HUNTERKILLER, Equipment.LIQUIDENGINEER, Equipment.MATADOR,
		Equipment.MOTHERLYGLOVES, Equipment.NIGHTWATCHER, Equipment.PERCUSSIVEMAINTENANCE, Equipment.POINTMAN,
		Equipment.PRESTINEEXAMPLE, Equipment.PUNCHDRUNK, Equipment.STRATEGICALIGNMENT, Equipment.THEGIFT,
		Equipment.THEHOLLOWMAN, Equipment.THESACRIFICE, Equipment.VEDMEDYTSYAVEST, Equipment.ZEROFS
	};
	
	
	/**
	 * Setting a name for a equipment
	 */
	@Override
	public Buildable setName(String name) {		
		try {
			switch(name) {				 
				case Equipment.AMMODUMP:
					this.setSlot(InventorySlot.HOLSTER)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.BADGER)			
						.setFirst(Attribute.AMMOCAPACITY, 10.0)
						.setFixedAttribute(1);					
					break;
			
				case Equipment.ANARCHISTSCOOKBOOK:					
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.WICKED)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.GOLAN)
						.setTalentChangeable(false);					
					break;
					
				case Equipment.BATTERYPACK:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.CALCULATED)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.EMPRESS)
						.setTalentChangeable(false);
					break;
					
				case Equipment.CAESARSGUARD:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.SKILLED)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.EMPRESS)
						.setTalentChangeable(false);					
					break;
				
				case Equipment.CHAINKILLER:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.HEADHUNTER)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.WALKER)
						.setTalentChangeable(false);								
					break;
					
				case Equipment.CONTRACTORSGLOVES:
					this.setSlot(InventorySlot.GLOVE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.PETROV)
						.setFirst(Attribute.DAMAGETOARMOR, 8.0)
						.setFixedAttribute(1);
					break;
					
				case Equipment.CLAWSOUT:
					this.setSlot(InventorySlot.HOLSTER)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.WYVERN)
						.setCore(Attribute.SKILLTIER, 1.0)
						.setFirst(Attribute.MELEEDAMAGE, 500.0)
						.setThird(Attribute.PISTOLDAMAGE, 9.0)				
						.setFixedAttribute(1)
						.setFixedAttribute(3);					
					break;
					
				case Equipment.DEATHGRIPS:
					this.setSlot(InventorySlot.GLOVE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.FIVEELEVEN)
						.setFirst(Attribute.ARMORONKILL, 10.0)								
						.setFixedAttribute(1);
					break;
					
				case Equipment.DEVILSDUE:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.CLUTCH)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.CESKA)
						.setTalentChangeable(false);
					break;
					
				case Equipment.DOORKICKERSKNOCK:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.SPARK)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.GRUPO)
						.setTalentChangeable(false);					
					break;
					
				case Equipment.EMPERORSGUARD:
					this.setSlot(InventorySlot.KNEEPAD)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.MURAKAMI)			
						.setFirst(Attribute.TOTALARMOR, 1.0)								
						.setFixedAttribute(1);				
					break;
				
				case Equipment.EVERYDAYCARRIER:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.EFFICIENT)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.BELSTONE)
						.setTalentChangeable(false);
					break;
					
				case Equipment.FEROCIOUSCALM:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.OVERWATCH)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.FENRIS)
						.setTalentChangeable(false);
					break;
								
				case Equipment.FIRMHANDSHAKE:
					this.setSlot(InventorySlot.GLOVE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.SOKOLOV)
						.setFirst(Attribute.STATUSEFFECTS, 15.0)								
						.setFixedAttribute(1);				
					break;
					
				case Equipment.FORCEMULTIPLIER:					
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.COMBINEDARMS)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.HANA)
						.setTalentChangeable(false);
					break;
				
				case Equipment.FORGE:
					this.setSlot(InventorySlot.HOLSTER)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.RICHTER)
						.setFirst(Attribute.STATUSEFFECTS, 15.0)								
						.setFixedAttribute(1);				
					break;
		
				case Equipment.FOXSPRAYER:
					this.setSlot(InventorySlot.KNEEPAD)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.OVERLORD)
						.setFirst(Attribute.DAMAGETOTARGETOUTOFCOVER, 8.0)
						.setFixedAttribute(1);					
					break;
					
				case Equipment.HUNTERKILLER:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.INITMIDATE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.GOLAN)
						.setTalentChangeable(false);
					break;
					
				case Equipment.LIQUIDENGINEER:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.BLOODSUCKER)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.BELSTONE)
						.setTalentChangeable(false);		
					break;
					
				case Equipment.MATADOR:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.ADRENALINRUSH)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.WALKER)
						.setTalentChangeable(false);
					break;
					
				case Equipment.MOTHERLYGLOVES:
					this.setSlot(InventorySlot.GLOVE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.ALPS)	
						.setFirst(Attribute.SKILLHEALTH, 10.0)								
						.setFixedAttribute(1);				
					break;
					
				case Equipment.NIGHTWATCHER:
					this.setSlot(InventorySlot.MASK)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.GILA)
						.setFirst(Attribute.SCANNERHASTE, 100.0)
						.setFixedAttribute(1);
					break;				
					
				case Equipment.PERCUSSIVEMAINTENANCE:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.TECHSUPPORT)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.ALPS)
						.setTalentChangeable(false);					
					break;
					
				case Equipment.POINTMAN:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.VANGUARD)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.GILA)
						.setTalentChangeable(false);				
					break;					
					
				case Equipment.PRESTINEEXAMPLE:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.FOCUS)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.AIRALDI)
						.setTalentChangeable(false);
					break;
					
				case Equipment.PUNCHDRUNK:
					this.setSlot(InventorySlot.MASK)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.DOUGLAS)
						.setFirst(Attribute.HEADSHOTDAMAGE, 20.0)
						.setFixedAttribute(1);					
					break;
				
				case Equipment.STRATEGICALIGNMENT:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.SHOCKANDAWE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.CHINA)
						.setTalentChangeable(false);
					break;
					
				case Equipment.THEGIFT:
					this.setSlot(InventorySlot.BACKPACK)
						.setTalent(Talent.VIGILIANCE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.PROVIDENCE)
						.setTalentChangeable(false);					
					break;
					
				case Equipment.THEHOLLOWMAN:
					this.setSlot(InventorySlot.MASK)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.YAAHL)
						.setCore(Attribute.ARMOR, 1.0)						
						.setFirst(Attribute.DAMAGETOHEALTH, 10.0)
						.setThird(Attribute.CRITICALHITCHANCE, 6.0)						
						.setFixedAttribute(1);						
					break;
					
				case Equipment.THESACRIFICE:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.GLASSCANNON)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.PROVIDENCE)
						.setTalentChangeable(false);
					break;	
					
				case Equipment.VEDMEDYTSYAVEST:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.BRACED)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.PETROV)
						.setTalentChangeable(false);
					break;
					
				case Equipment.ZEROFS:
					this.setSlot(InventorySlot.ARMOR)
						.setTalent(Talent.UNBREAKABLE)
						.setNamedItem(true)
						.setManufacturer(Manufacturer.BADGER)
						.setTalentChangeable(false);
					
				default:		
			}
			super.setName(name);		
		} 
		catch(AttributeException e) { System.err.println(e.getMessage()); }
		catch(InventoryException e) {  System.err.println(e.getMessage());}
		
		return (Buildable) this;
	}
	
	/**
	 * Setter for the manufacturer
	 * @return Builder
	 */
	@Override
	public Buildable setManufacturer(String manufacturer) {
		this.manufacturer = (Manufacturer) World.Registry.get("manufacturer", manufacturer);
		return (Buildable) this;
	}
	
	/**
	 * Getter for the manufacturer
	 * @return Manufacturer
	 */
	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}
	
	/**
	 * Setter for improvised item
	 * @return Builder
	 * @throws InventoryException If an improvised item can't be created
	 */
	@Override
	public Buildable setImprovisedItem(boolean improvisedItem) throws InventoryException {
				
		if (this.getSlot() != null) {
			switch(this.getSlot() ) {
				case ARMOR:
				case BACKPACK:
				case MASK:
				default:
					throw new InventoryException("Can't create an improsived item on a " + this.getSlot() + " slot!");
			}
		}
		
		this.improvisedItem = improvisedItem;
		return (Buildable)this;
	}
	
	/**
	 * Setter for Slot
	 * @throws InventoryException If the the slot can't be changed because it's an improvised item 
	 */
	@Override
	public Buildable setSlot(InventorySlot slot) throws InventoryException {
		
		if (this.isImprovisedItem() == true) {
			switch(slot) {
				case ARMOR:
				case BACKPACK:
				case MASK:
					throw new InventoryException(
						"Can't change the slot on the current item because it's an " +
						 "improsived item and only GLOVE, HOLSTER and KNEEPAD are allowed!  " +
						"Set improvisedItem(false) first, if you want to change the slot!"
					);
				default:
			}				
		}
		
		super.setSlot(slot);
		return (Buildable)this;
	}				 
	
	
	/**
	 * Getter for improvised item
	 */
	@Override
	public boolean isImprovisedItem() {
		return improvisedItem;
	}	
	
	/**
	 * Adding mod to equipment
	 * @throws ModException If a mod can't be attached 
	 */
	@Override
	public Buildable addMod(Mod mod) throws ModException {

		if (this.getSlot() == null) {
			throw new ModException("Mod can only be attached to ARMOR, BACKPACK or MASK item with a setted inventory slot!");
		} else {
			if (this.isImprovisedItem() == true ||
				this.getSlot() == InventorySlot.BACKPACK ||
				this.getSlot() == InventorySlot.ARMOR ||
				this.getSlot() == InventorySlot.MASK
			) {
				this.mod = mod;		
			} else {
				throw new ModException("Mod can only be attached to ARMOR, BACKPACK or MASK item!");
			}
		}
		
		return (Buildable)this;
	}
	
	/**
	 * Gets the mod
	 * @return Returns the associated mod
	 * @see Mod
	 */
	public Mod getMod() {
		return this.mod;
	}

	/**
	 * Setter of talent
	 * @param value The Talent to set
	 * @return Equipment
	 * @throws InventoryException If a talent can't be changed because due of a perfect item
	 * @see Talent
	 */
	@Override
	public Buildable setTalent(Talent value) throws InventoryException {
		
		if (this.getSlot() != InventorySlot.BACKPACK && this.getSlot() != InventorySlot.ARMOR) {
			throw new InventoryException("Talent can't be changed due to item isn't a backpack or armor chest!");
		}
		
		// If Inventory slot is a BACKBACK or ARMOR item and additionaly a named item
		if (
			(this.getSlot() == InventorySlot.BACKPACK || this.getSlot() == InventorySlot.ARMOR) &&
			this.isNamedItem() == true
		) {
			throw new InventoryException("Talent can't be changed due item is a named backpack/armor item!");
		}
		
		this.talent = value;
		
		return (Buildable) this;
	}	
	
	/**
	 * Removes the mod from the item
	 */	
	public void removeMod() {
		this.mod = null;
	}
	

	/**
	 * @return the talent
	 */
	public Talent getTalent() {
		return talent;
	}
	
	/**
	 * Return all Attribute and Values of the item as a hash map
	 */
	public HashMap<Attribute, Double> getAttributesAndValues() {
		
		HashMap<Attribute, Double> map = new HashMap<>();
		
		map.put(getCoreAttribute(), getCoreAttributeValue());
		map.put(getFirstAttribute(), getFirstAttributeValue());
		map.put(getSecondAttribute(), getSecondAttributeValue());
		map.put(getThirdAttribute(), getThirdAttributeValue());
		
		// Check if we have a mod		
		return map;
	}
			
	
	/**
	 * Builder Pattern for the equipment object. This is the only way equipment should be created!
	 * <pre>
	 * {@code
	 * Equipment item = (Equipment) new Equipment.Builder().setName("Test").setImprovisedItem(true).build();
	 * }</pre>
	 */
	public static class Builder extends Equipment implements Buildable {
		
		/**
		 * Build an object of the type equipment, reassignes the values crom the builder to the object
		 */
		@Override
		public Equipment build() {
			Equipment item = new Equipment();			
			item = this;			
			return item;
		}
	}
	
	@Override
	public String toString() {
		return "Equipment [improvisedItem=" + improvisedItem + ", manufacturer=" + manufacturer + ", talent=" + talent
				+ ", getMod()=" + getMod() + ", getCoreAttribute()=" + getCoreAttribute() + ", getFirstAttribute()="
				+ getFirstAttribute() + ", getSecondAttribute()=" + getSecondAttribute() + ", getThirdAttribute()="
				+ getThirdAttribute() + ", getCoreAttributeValue()=" + getCoreAttributeValue()
				+ ", getFirstAttributeValue()=" + getFirstAttributeValue() + ", getSecondAttributeValue()="
				+ getSecondAttributeValue() + ", getThirdAttributeValue()=" + getThirdAttributeValue() + "]";
	}
}
