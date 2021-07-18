package at.droll.div2builder.core.statistic;

import at.droll.div2builder.core.Manufacturer;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.ItemAbstract;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.Modslot;

import java.util.HashMap;
import java.util.Map;

/**
 * Statistic class
 * @author Marco Droll
 */
public class Statistic {
	
	/**
	 * Default value for Accuracy when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_ACCURACY = 10.0;
	
	/**
	 * Default value for Ammo Capacity when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_AMMOCAPACITY = 20.0;
	
	/**
	 * Default value for Critical Hit Chance when Player hits level 1000 and the keener watch is completely unlocked
	 */	
	public static final double KEENER_WATCH_CRITICALHITCHANCE = 10.0;
	
	/**
	 * Default value for Critical Hit Damage when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_CRITICALHITDAMAGE = 20.0;
	
	/**
	 * Default value for Hazard Protection when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_HAZARDPROTECTION = 10.0;
	
	/**
	 * Default value for Health when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_HEALTH = 10.0;
	
	/**
	 * Default value for Headshot Damage when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_HEADSHOTDAMAGE = 20.0;
	
	/**
	 * Default value for Explosive Resistance when Player hits level 1000 and the keener watch is completely unlocked
	 */	
	public static final double KEENER_WATCH_EXPLOSIVERESISTANCE = 10.0;
	
	/**
	 * Default value for Reload Speed when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_RELOADSPEED = 10.0;
	
	/**
	 * Default value for Repair Skills when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_REPAIRSKILLS = 10.0;
	
	/**
	 * Default value for Skill Damage when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_SKILLDAMAGE = 10.0;
	
	/**
	 * Default value for Skill Duration when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_SKILLDURATION = 20.0;
	
	/**
	 * Default value for Skill Haste when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_SKILLHASTE = 10.0;
	
	/**
	 * Default value for Weapon Stability when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_STABILITY = 20.0;
	
	/**
	 * Default value for Total Armor when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_TOTALARMOR = 10.0;
	
	/**
	 * Default value for Weapon Damage when Player hits level 1000 and the keener watch is completely unlocked
	 */
	public static final double KEENER_WATCH_WEAPONDAMAGE = 10.0;
	
	/**
	 * Default value for Accuracy when the Player hits level 30
	 */
	public static final double LEVEL30_ACCURARY = 30.0;
	
	/**
	 * Default value for Assault Rifle when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_ASSAULTRIFLEDAMAGE = 40.0;
		
	/**
	 * Default value for Critical Hit Damage when the Player hits level 30
	 */
	public static final double LEVEL30_CRITICALHITDAMAGE = 25;
	
	/**
	 * Default value for headshot Damage when the Player hits level 30
	 */
	public static final double LEVEL30_HEADSHOTDAMAGE = 65.0;
	
	/**
	 * Default value for Lightmachine Gun when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_LMGDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
	
	/**
	 * Default value for Marksmanrifle Damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_MARKMANRIFLEDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
	
	/**
	 * Default value for Pistol Damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_PISTOLDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
	
	/**
	 * Default value for Rifle Damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_RIFLEDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
		
	/**
	 * Default value for Reload Speed when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_RELOADSPEED = 30.0;
	
	/**
	 * Default value for Shotgun Damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_SHOTGUNDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
	
	/**
	 * Default value for Submachien Gun Damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_SMGDAMAGE = LEVEL30_ASSAULTRIFLEDAMAGE;
	
	/**
	 * Default value for Assault Rifle when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_STABILITY = 20.0;
	
	/**
	 * Default value for Swap speed when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_SWAPSPEED = 30.0;
	
	/**
	 * Default value for Weapon damage when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_WEAPONDAMAGE = 10.0;
	
	/**
	 * Default value for Weapon Handling when the Player hits level 30 and he unlocks the talent in the tree
	 */
	public static final double LEVEL30_WEAPONHANDLING = 30.0;
		
	
	/**
	 * Holds the common player start default dasta
	 */
	private Map<Attribute, Double> playerStats = new HashMap<>(); 	
	
	/**
	 * Holds the calculated equipment data
	 */
	private Map<Attribute, Double> equipmentStats = new HashMap<>();
	
	/**
	 * Holds the brandset statistics
	 */
	private Map<Attribute, Double> brandsetStats = new HashMap<>();
	
	/**
	 * Holds the calculated weapon statistics 
	 */
	private Map<String, Map<Attribute, Double>> weaponStats = new HashMap<>();

	/**
	 * Holds the complete calculated statistics 
	 */
	private Map<String, Map<Attribute, Double>> combinedStats = new HashMap<>();
	
	/**
	 * Holds the color count
	 * TODO Use later for the colours
	 */
	private Map<String, Map<String, Integer>> colors = new HashMap<>(); 
	
	/**
	 * Statistic constructor 
	 * @param isMaxKeenerWatch Is the keener watch available
	 */
	public Statistic(boolean isMaxKeenerWatch) {
		
		// Initialize with all available default attributes (Level 30)
		for (Attribute attribute : Attribute.values()) {
			
			switch(attribute) {
				case ACCURACY 				-> this.playerStats.put(attribute, LEVEL30_ACCURARY);
				case ASSAULTRIFLEDAMAGE 	-> this.playerStats.put(attribute, LEVEL30_ASSAULTRIFLEDAMAGE);
				case CRITICALHITDAMAGE 		-> this.playerStats.put(attribute, LEVEL30_CRITICALHITDAMAGE);
				case HEADSHOTDAMAGE 		-> this.playerStats.put(attribute, LEVEL30_HEADSHOTDAMAGE);
				case LMGDAMAGE				-> this.playerStats.put(attribute, LEVEL30_LMGDAMAGE);
				case MARKSMANRIFLEDAMAGE 	-> this.playerStats.put(attribute, LEVEL30_MARKMANRIFLEDAMAGE);
				case PISTOLDAMAGE 			-> this.playerStats.put(attribute, LEVEL30_PISTOLDAMAGE);
				case RIFLEDAMAGE 			-> this.playerStats.put(attribute, LEVEL30_RIFLEDAMAGE);
				case RELOADSPEED 			-> this.playerStats.put(attribute, LEVEL30_RELOADSPEED);
				case SHOTGUNDAMAGE			-> this.playerStats.put(attribute, LEVEL30_SHOTGUNDAMAGE);					
				case SMGDAMAGE 				-> this.playerStats.put(attribute, LEVEL30_SMGDAMAGE);
				case STABILITY 				-> this.playerStats.put(attribute, LEVEL30_STABILITY);
				case SWAPSPEED 				-> this.playerStats.put(attribute, LEVEL30_SWAPSPEED);					
				case WEAPONDAMAGE 			-> this.playerStats.put(attribute, LEVEL30_WEAPONDAMAGE);
				case WEAPONHANDLING 		-> this.playerStats.put(attribute, LEVEL30_WEAPONHANDLING);
				default 					-> this.playerStats.put(attribute, 0.0);
			}			
        }		
		
		// After reaching level 40, the keener watch can be maxed out. Afterthis, these values are default values
		if (isMaxKeenerWatch == true) {			
			
			this.playerStats.computeIfPresent(
				Attribute.ACCURACY, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_ACCURACY
			);
			this.playerStats.computeIfPresent(
				Attribute.AMMOCAPACITY, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_AMMOCAPACITY
			);
			this.playerStats.computeIfPresent(
				Attribute.CRITICALHITCHANCE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_CRITICALHITCHANCE
			);
			this.playerStats.computeIfPresent(
				Attribute.CRITICALHITDAMAGE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_CRITICALHITDAMAGE
			);
			this.playerStats.computeIfPresent(
				Attribute.EXPLOSIVERESISTANCE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_EXPLOSIVERESISTANCE
			);
			this.playerStats.computeIfPresent(
				Attribute.HAZARDPROTECTION, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_HAZARDPROTECTION
			);
			this.playerStats.computeIfPresent(
				Attribute.HEALTH, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_HEALTH
			);
			this.playerStats.computeIfPresent(
				Attribute.HEADSHOTDAMAGE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_HEADSHOTDAMAGE
			);
			this.playerStats.computeIfPresent(
				Attribute.RELOADSPEED, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_RELOADSPEED
			);
			this.playerStats.computeIfPresent(
				Attribute.REPAIRSKILLS, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_REPAIRSKILLS
			);
			this.playerStats.computeIfPresent(
				Attribute.SKILLDAMAGE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_SKILLDAMAGE
			);
			this.playerStats.computeIfPresent(
				Attribute.SKILLDURATION, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_SKILLDURATION
			);
			this.playerStats.computeIfPresent(
				Attribute.SKILLHASTE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_SKILLHASTE
			);
			this.playerStats.computeIfPresent(
				Attribute.STABILITY, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_STABILITY
			);
			this.playerStats.computeIfPresent(
				Attribute.TOTALARMOR, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_TOTALARMOR
			);
			this.playerStats.computeIfPresent(
				Attribute.WEAPONDAMAGE, (attribute, attributeValue) ->
				attributeValue + KEENER_WATCH_WEAPONDAMAGE
			);
		}
	}
	
	/**
	 * Calculate on the given inventory all the statistic values
	 * @param inventory The inventory on what the calculation should be cone
	 * @return Returns the statistic dictionary with attribute value pairs
	 * TODO calculateEquipmentBonus
	 */
	public Map<Attribute, Double> calculateEquipmentBonus(Inventory inventory) {		
		Mod mod;
		Map<Attribute, Double> attributesAndValuesOuter = new HashMap<>();
		Map<Attribute, Double> attributesAndValues;
		
		ItemAbstract tempItem;
		Equipment item;
		
		for (String slot : Inventory.slotList) {
			tempItem = inventory.getEquipment(InventorySlot.valueOf(slot));
			
			if (tempItem instanceof Equipment) {
				item = (Equipment) tempItem;
				attributesAndValues = item.getAttributesAndValues();
				
				/* Sum up all this.data with the returned HashMap from values. Using lambda and functional
				 * merge method of the collection 
				 */
				attributesAndValues.forEach(
					(attribute, attributeValue) -> attributesAndValuesOuter.merge(attribute, attributeValue, Double::sum)
				);
		
				/* 
				 * TODO Check with an improsised item
				 * Calculate the bonus if a mod is attached
				 */
				mod = (Mod)item.getMod();
				if (mod != null) {					
					attributesAndValues = mod.getAttributesAndValues();
					attributesAndValues.forEach(
						(attribute, attributeValue) -> attributesAndValuesOuter.merge(attribute, attributeValue, Double::sum)
					);
				}
			} 
		}	
		return attributesAndValuesOuter;
	}
	

	/**
	 * Calculate on the given inventory all the statistic for the weapons
	 * @param inventory The inventory on what the calculation should be cone
	 * @return Returns a Map within a map with the attributes and value for PRIMARY, SECONDARY and PISTOL	 * 
	 * TODO Own data type to avoid messy encapsulating of map map
	 */
	public Map<String, Map<Attribute, Double>> calculateWeaponBonus(Inventory inventory) {
		
		Mod mod;
		Map<String, Map<Attribute, Double>> attribtuesAndValues = new HashMap<>();

		for (String slot : Inventory.slotList) {
			Map<Attribute, Double> attributesAndValuesInner;
			ItemAbstract tempItem = inventory.getEquipment(InventorySlot.valueOf(slot));
			
			// Only consider weapon instances
			if (tempItem instanceof Weapon) {
				Map<Attribute, Double> modAttributesAndValues;
				attributesAndValuesInner = tempItem.getAttributesAndValues();
				
				for(Modslot modslot : Modslot.values()) {
					mod = ((Weapon) tempItem).getMod(modslot);
					if (mod != null) {
						modAttributesAndValues = mod.getAttributesAndValues();
						
						// Sum up mod attributes and values
						modAttributesAndValues.forEach(
							(attribute, attributeValue) -> attributesAndValuesInner.merge(
							attribute, attributeValue, Double::sum
						));
					}
				}
				// Building my map 
				attribtuesAndValues.put(slot, attributesAndValuesInner);
			}
		}
		return attribtuesAndValues;
	}
	
	/**
	 * Calculate the brandset bonus given on the passed inventory
	 * 
	 * @param inventory Inventory with all the slots and equipment
	 * @return Returns a map of calculated brandset bonus with attribute and value pair  
	 */
	public Map<Attribute, Double> calculateBrandsetBonus(Inventory inventory) {
		Map<String, Integer> manuBonus = new HashMap<>();
		Map<Attribute, Double> brandsetBonus = new HashMap<>();
		
		// Initialize manufacturer bonus array
		for (String manufacturer : Manufacturer.manufacturerList) {
			manuBonus.put(manufacturer, 0);
		}		
		
		for (String slot : Inventory.slotList) {
			ItemAbstract tempItem = inventory.getEquipment(InventorySlot.valueOf(slot));
			
			// Just calculate brandset bonus for equipment not weapon
			if (tempItem instanceof Equipment) {
				Equipment item = (Equipment) tempItem;
				
				// Increase the type of manufacturer to calcuate the bonus for the parts 
				if (item.isImprovisedItem() != true) {					
					manuBonus.computeIfPresent(
						item.getManufacturer().getShortname(),
						(attribute, attributeValue) -> attributeValue + 1
					);
				}
			}			
		}
		
		// Loop over the brandset bonus and sum up all the specific values
		manuBonus.forEach(
			(manufacturer, amount) -> {
				
				if (amount > 0) {
					Manufacturer manu = (Manufacturer)World.Registry.get("manufacturer", manufacturer);
				
					// Return the bonus for 3, 2 or 1 set item
					// see Manufacturer class
					Map<Attribute, Double> attributesAndValuesSingle = manu.getAttributesAndValues(amount);					
					attributesAndValuesSingle.forEach(
						(attribute, attributeValue) -> brandsetBonus.merge(attribute, attributeValue, Double::sum)
					);
				}
			}
		);
		
		// i.e. for 2 Parts Providence, 1 Part Overlord, 1 part Grupo, 1 Part Ceska
		// Result is: Weapon Damage can be read over
		// {WEAPONDAMAGE=0.0, HEADSHOTDAMAGE=15.0, CRITICALHITCHANCE=20.0, RIFLEDAMAGE=10.0, CRITICALHITDAMAGE=15.0}		
		return brandsetBonus;
	}
	
	/**
	 * Calculates the statistics, accumulates them and put in in the internal statistic map
	 * @param inventory Inventory with all the slots and equipment
	 * @return Returns a Map<String, Map<Attribute, Double> Collection with all the calculated values
	 */
	public Map<String, Map<Attribute, Double>> calculate(Inventory inventory) {
		
		String[] slotList = {
			InventorySlot.PRIMARY.toString(), InventorySlot.SECONDARY.toString(), InventorySlot.PISTOL.toString()
		};		
		equipmentStats 	= calculateEquipmentBonus(inventory);
		brandsetStats 	= calculateBrandsetBonus(inventory);
		weaponStats		= calculateWeaponBonus(inventory);
		colors 			= determineRedYellowBlueColors(inventory);
		
//		System.out.println("Player " + playerStats);
//		System.out.println("Weapon " + weaponStats.get("PRIMARY"));
//		System.out.println("Brandset " + brandsetStats);
//		System.out.println("Equipment " + equipmentStats);
		
		// Calculate the bonus for primary weapon, secondary weapon and pistol and combination with the other stats
		Map<Attribute, Double> attributesAndValues = null;
		for (String slot : slotList) {
			combinedStats.put(slot, new HashMap<Attribute, Double>());
			
			playerStats.forEach(
				(attribute, attributeValue) ->
				combinedStats.get(slot).merge(attribute, attributeValue, Double::sum)
			);
			
			equipmentStats.forEach(
				(attribute, attributeValue) ->
				combinedStats.get(slot).merge(attribute, attributeValue, Double::sum)
			);
			
			brandsetStats.forEach(
				(attribute, attributeValue) ->
				combinedStats.get(slot).merge(attribute, attributeValue, Double::sum)
			);
			
			weaponStats	= calculateWeaponBonus(inventory);
			
			attributesAndValues = weaponStats.get(slot);
			attributesAndValues.forEach(
				(attribute, attributeValue) ->
				combinedStats.get(slot).merge(attribute, attributeValue, Double::sum)
			);
		}		
				
		return combinedStats;
	}
	
	/**
	 * Determines the amount of core attributes and the amount of byside first, second, third attribtues 
	 * @param inventory We need here the inventory 
	 * @return Returns a Map with a key value pair within a map with the determines core and minor colors
	 */
	public Map<String, Map<String, Integer>> determineRedYellowBlueColors(Inventory inventory) {
		 
		Map<String, Map<String, Integer>> colors = new HashMap<>();
		
		Map<String, Integer> coreAttributes = new HashMap<>();
		coreAttributes.put("red", 0);
		coreAttributes.put("blue", 0);
		coreAttributes.put("yellow", 0);
		
		Map<String, Integer> minorAttributes = new HashMap<>(coreAttributes);
		
		Attribute coreAttribute, minorAttribute;
		
		for (String slot : Inventory.slotList) {
			ItemAbstract tempItem = inventory.getEquipment(InventorySlot.valueOf(slot));
			
			if (tempItem instanceof Equipment) {
				
				// Count the core/major attributes
				coreAttribute = tempItem.getCoreAttribute();
				switch(coreAttribute) {
					case WEAPONDAMAGE:						
						coreAttributes.merge("red", 1, Integer::sum);						
						break;
					case ARMOR:
						coreAttributes.merge("blue", 1, Integer::sum);
						break;
					case SKILLTIER:						
						coreAttributes.merge("yellow", 1, Integer::sum);
						break;
					default:
				}
				
				// Count the minor attributes
				for(int i = 1; i < 4; i++) {
					switch(i) {
						case 1:
							minorAttribute = tempItem.getFirstAttribute();
							break;
						case 2:
							minorAttribute = tempItem.getSecondAttribute();
							break;
						case 3:
							minorAttribute = tempItem.getThirdAttribute();
							break;
						default:
							minorAttribute = Attribute.NULL;
					}
					
					if (minorAttribute != null) {
						
						switch(minorAttribute) {					
							case CRITICALHITCHANCE:
							case CRITICALHITDAMAGE:
							case HEADSHOTDAMAGE:
							case WEAPONHANDLING:
								minorAttributes.merge("red", 1, Integer::sum);
								break;
							case HAZARDPROTECTION:						
							case HEALTH:
							case ARMORREGEN:
							case EXPLOSIVERESISTANCE:
								minorAttributes.merge("blue", 1, Integer::sum);							
								break;
							case SKILLDAMAGE:
							case REPAIRSKILLS:
							case SKILLHASTE:
							case STATUSEFFECTS:
								minorAttributes.merge("yellow", 1, Integer::sum);							
								break;
							default:
						}
					}
				}
			}
		}
		
		colors.put("core", coreAttributes);
		colors.put("minor", minorAttributes);		
		return colors;
	}
	
	/**
	 * Returns the internal statistic data
	 * @return Map with Attribute Double pair
	 */
	public Map<Attribute, Double> getData() {		
		return this.playerStats;
	}
}