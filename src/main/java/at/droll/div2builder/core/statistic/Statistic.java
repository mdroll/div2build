package at.droll.div2builder.core.statistic;

import at.droll.div2builder.core.Manufacturer;
import at.droll.div2builder.core.Talent;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.ItemAbstract;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.item.weapon.WeaponType;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.Modslot;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

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
	public static final double LEVEL30_ASSAULTRIFLEDAMAGE = 15.0;
		
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
		
		sumBrandset(inventory, manuBonus);
		
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
	 * 
	 * @param inventory Classic inventory
	 * @param manuBonus Bonus collection where to store the sum for the brandsets
	 */
	private void sumBrandset(Inventory inventory, Map<String, Integer> manuBonus) {
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
	}	
	
	/**
	 * Returns the bonus by brandset
	 * @param inventory Inventory to determine the Bonus on
	 * @return Return a List of the manufacturer with their specific bonus attributes
	 */
	public Map<String, Map<Attribute, Double>> getBonusByBrandset(Inventory inventory) {
		
		Map<String, Integer> manuBonus = new HashMap<>();		
		Map<String, Map<Attribute, Double>> returnValue = new HashMap<>(); 
		
		sumBrandset(inventory, manuBonus);
		
		manuBonus.forEach((manufacturer, amount) -> {
			if (amount > 0) {				
				Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manufacturer);
				returnValue.put(manufacturer, manu.getAttributesAndValues(amount));
			}
		});
		
		return returnValue;
	}
	
	
	/**
	 * Calculates the statistics, accumulates them and put in in the internal statistic map
	 * @param inventory Inventory with all the slots and equipment
	 * @return Returns a list of primary, secondary, pistol and all accumulated statistics
	 */
	public Map<String, Map<Attribute, Double>> calculate(Inventory inventory) {
		
		String[] slotList = {
			InventorySlot.PRIMARY.toString(), InventorySlot.SECONDARY.toString(), InventorySlot.PISTOL.toString()
		};		
		equipmentStats 	= calculateEquipmentBonus(inventory);
		brandsetStats 	= calculateBrandsetBonus(inventory);
		weaponStats		= calculateWeaponBonus(inventory);
		colors 			= determineRedYellowBlueColors(inventory);
				
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
	 * Determines the amount of core attributes and the amount of minor first, second, third attribtues 
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
	 * Returns the damage by bullet for PRIMARY, SECONDARY und PISTOL inventory slot
	 * 
	 * <pre>
 	 * {@code
	 * See https://www.reddit.com/r/thedivision/comments/gi0uel/weapon_damage_101_bullet_damage/?utm_medium=android_app&utm_source=share
	 * D = base damage
	 *   x (1 + WD + weapon type damage + sum of ("weapon damage" talents x talent uptime)) // Factor 1
	 *   x (1 + sum of ("total weapon damage" talents * talent uptime))						// Factor 2
	 *   x (1 + "amplify" talent1 x uptime)													// Factor 3
	 *   x (1 + "amplify" talent2 x uptime)													// Factor 4
	 *   x (1 + "amplify" talent3 x uptime)													// Factor 5
	 *   x (1 + CHC x CHD + HsD x headshot chance)											// Factor 6
	 *   x (1 + DtA x %Armor + DtH x (1 - %Armor))											// Factor 7
	 *   x (1 + OoCD x %OutOfCover)   														// Factor 8
	 * }
	 * </pre>
	 * 
	 * @param inventory The inventory to calculcate the weapon damage
	 * @param headshotChance The probably percentage of headshot chance
	 * @return Returns a map of String and Double i.e. PRIMARY -> 100.000,0 SECONDARY -> 200.000,0
	 * @TODO Taking talent uptime into calculation. Right now it's a guessed value. See
	 */
	public Map<String, Double> calculateWeaponDamage(Inventory inventory, Double headshotChance) {
		
		// Pre calculate the combinedStats for primary, secondary and pistol
		this.calculate(inventory);
		
		String[] slotList = {
			InventorySlot.PRIMARY.toString(), InventorySlot.SECONDARY.toString(), InventorySlot.PISTOL.toString()
		};		
	
		Double baseDamage;
		
		Double factors[] = {1d, 1d, 1d, 1d, 1d, 1d, 1d, 1d};
		
		Double term1, term2;
		
		Double enemyArmorPercentage = 0.72;
		
		Double enemyOutOfCover = 0.66;
		
		Weapon weapon;
        
        Equipment armor, backpack;
        
        // Guessed and firstly not considered directly
        // TODO Guess or calculate the correct factor
        Double weaponTalentUptime = 0.9;
        
        Map<String, Double> result = new HashMap<>();
        
                        
		for(String slot : slotList) {			
			
			Arrays.fill(factors, 1d);
			
			weapon = (Weapon) inventory.getEquipment(InventorySlot.valueOf(slot));
			baseDamage = Double.valueOf(weapon.getBaseDamage());
			
			// Factor1 calculation
			factors[0] +=
			(
					(inventory.getEquipment(InventorySlot.MASK).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.MASK).getCoreAttributeValue() : 0) +
					(inventory.getEquipment(InventorySlot.BACKPACK).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.BACKPACK).getCoreAttributeValue() : 0) +
					(inventory.getEquipment(InventorySlot.ARMOR).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.ARMOR).getCoreAttributeValue() : 0) +
					(inventory.getEquipment(InventorySlot.GLOVE).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.GLOVE).getCoreAttributeValue() : 0) +
					(inventory.getEquipment(InventorySlot.HOLSTER).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.HOLSTER).getCoreAttributeValue() : 0) +
					(inventory.getEquipment(InventorySlot.KNEEPAD).getCoreAttribute() == Attribute.WEAPONDAMAGE ? inventory.getEquipment(InventorySlot.KNEEPAD).getCoreAttributeValue() : 0) + 
					getData().get(Attribute.WEAPONDAMAGE)				
					
//					inventory.getEquipment(InventorySlot.BACKPACK).getCoreAttributeValue() +
//					inventory.getEquipment(InventorySlot.MASK).getCoreAttributeValue() +
//					inventory.getEquipment(InventorySlot.HOLSTER).getCoreAttributeValue() +
//					inventory.getEquipment(InventorySlot.GLOVE).getCoreAttributeValue() +
//					inventory.getEquipment(InventorySlot.KNEEPAD).getCoreAttributeValue() +
			) / 100;
			
			// Get the Weapon Damage of the specialization (After level 30) usually 15%
			switch(weapon.getType()) {
				case ASSAULTRIFLE -> factors[0] += getData().get(Attribute.ASSAULTRIFLEDAMAGE) / 100;
				case LIGHTMACHINEGUN -> factors[0] += getData().get(Attribute.LMGDAMAGE) / 100;
				case MARKSMANRIFLE -> factors[0] += getData().get(Attribute.MARKSMANRIFLEDAMAGE) / 100;
				case PISTOL -> factors[0] += getData().get(Attribute.PISTOLDAMAGE) / 100;
				case RIFLE -> factors[0] += getData().get(Attribute.RIFLEDAMAGE) / 100;					
				case SUBMACHINEGUN -> factors[0] += getData().get(Attribute.SMGDAMAGE) / 100;
				case SHOTGUN -> factors[0] += getData().get(Attribute.SHOTGUNDAMAGE) / 100;
			}		
			
			// Accumulate brandset bonus i.e. Fenris, Walker to weaponTypeDamage
			for(Attribute attribute : brandsetStats.keySet()) {
				if (
					(attribute == Attribute.WEAPONDAMAGE && brandsetStats.get(attribute) > 0.0) ||
					(attribute == Attribute.ASSAULTRIFLEDAMAGE && weapon.getType() == WeaponType.ASSAULTRIFLE) ||
					(attribute == Attribute.LMGDAMAGE && weapon.getType() == WeaponType.LIGHTMACHINEGUN) ||
					(attribute == Attribute.MARKSMANRIFLEDAMAGE && weapon.getType() == WeaponType.MARKSMANRIFLE) ||
					(attribute == Attribute.PISTOLDAMAGE && weapon.getType() == WeaponType.PISTOL) ||
					(attribute == Attribute.RIFLEDAMAGE && weapon.getType() == WeaponType.RIFLE) ||
					(attribute == Attribute.SMGDAMAGE && weapon.getType() == WeaponType.SUBMACHINEGUN) ||
					(attribute == Attribute.SHOTGUNDAMAGE && weapon.getType() == WeaponType.SHOTGUN)
				) {
					factors[0] += brandsetStats.get(attribute) / 100;
				} 
			}
		
			switch(weapon.getTalent()) {
				case BOOMERANG, KILLER -> {
					factors[1] += 0.4 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case RIFLEMEN -> {					
					factors[1] += 0.5 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case CLOSEANDPERSONAL -> {
					factors[1] += 0.3 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case OPTIMIST -> {
					factors[1] += 0.31 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case VINDICTIVE -> {					
					factors[1] += 0.18 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case RANGER -> {
					factors[1] += 0.8 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case SADIST, EYELESS, IGNITED -> {					
					factors[1] += 0.2 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				case INSYNC -> {
					factors[1] += 0.15 * weaponTalentUptime;
					factors[0] += factors[1] - 1;
				}
				default -> {}
			}
			
			// Factor3 calculation
			armor = (Equipment) inventory.getEquipment(InventorySlot.ARMOR);
			
			switch(armor.getTalent()) {
				case FOCUS -> factors[2] += armor.isNamedItem() == true ? 0.6 : 0.5;				
				case GLASSCANNON -> factors[2] += armor.isNamedItem() == true ? 0.3 : 0.25;				
				case GUNSLINGER -> factors[2] += 0.2;
				case OBLITERATE -> factors[2] += 0.25;
				case SPARK -> factors[2] += 0.20;
				case SPOTTER -> factors[2] += 0.15;				
				case INITMIDATE -> factors[2] += 0.35;				
				default -> {}
			}
			
			// Factor 4 calculation 
			backpack = (Equipment) inventory.getEquipment(InventorySlot.BACKPACK);
			
			switch(backpack.getTalent()) {
				case COMPANION, COMPOSURE -> factors[3] += 0.15;
				case CONCUSSION, VERSATILE -> factors[3] += 0.1;
				case UNSTOPPABLEFORCE, VIGILIANCE -> factors[3] += 0.25;				
				case WICKED -> factors[3] += 0.18;
				default -> {}
			}
			
			// Factor5 calculation
			// No need to calculate anymore, because there are just two maximum amplify talents
			
			// factor6 calculation (shot factor)
			term1 = (combinedStats.get(slot).get(Attribute.CRITICALHITCHANCE) / 100) *  
					(combinedStats.get(slot).get(Attribute.CRITICALHITDAMAGE) / 100);
			
			term2 = (combinedStats.get(slot).get(Attribute.HEADSHOTDAMAGE) / 100) * headshotChance;
			factors[5] += term1 + term2;
		
			// Factor 7 calculation (armor factor)
			term1 = combinedStats.get(slot).get(Attribute.DAMAGETOARMOR) / 100 * enemyArmorPercentage;
			term2 = (combinedStats.get(slot).get(Attribute.DAMAGETOHEALTH) / 100) * (1 - enemyArmorPercentage);
			factors[6] += term1 + term2;
			
			// Factor 8 calculation (out of cover factor)
			factors[7] += (combinedStats.get(slot).get(Attribute.DAMAGETOTARGETOUTOFCOVER) / 100) * enemyOutOfCover;
			
//			System.out.println("fac1 " + df.format(factors[0]));			
//			System.out.println("fac2 " + df.format(factors[1]));
//			System.out.println("fac3 " + df.format(factors[2]));
//			System.out.println("fac4 " + df.format(factors[3]));
//			System.out.println("fac5 " + df.format(factors[4]));
//			System.out.println("fac6 " + df.format(factors[5]));
//			System.out.println("fac7 " + df.format(factors[6]));
//			System.out.println("fac8 " + df.format(factors[7]));
					
			result.put(
				slot, baseDamage * factors[0] * factors[1] * factors[2] * factors[3] * factors[4] * factors[5] *
				factors[6] * factors[7]
			);
		}
		
		return result;
	}
	
	/**
	 * Returns the internal statistic data
	 * @return Map with Attribute Double pair
	 */
	public Map<Attribute, Double> getData() {		
		return this.playerStats;
	}
}