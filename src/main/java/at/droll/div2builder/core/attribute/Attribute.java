package at.droll.div2builder.core.attribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.WeaponType;

/**
 * Attribute
 * @author Marco Droll
 */
public enum Attribute {
	
	/**
	 * Armor Attribute
	 */
	ARMOR,
	
	/**
	 * Armor On Kill Attribute
	 */
	ARMORONKILL,
	
	/**
	 * Health On Kill Attribute
	 */
	HEALTHONKILL,
	
	/**
	 * Armor Regeneration Attribute
	 */
	ARMORREGEN,
	
	/**
	 * Accuracy
	 */
	ACCURACY,
	
	/**
	 * Ammo capacity
	 */
	AMMOCAPACITY,
	
	/**
	 * Assault rifle damage
	 */
	ASSAULTRIFLEDAMAGE,
	
	/**
	 * Critical hit chance
	 */
	CRITICALHITCHANCE,
	
	/**
	 * Critical hit damage
	 */
	CRITICALHITDAMAGE,
	
	/**
	 * Explosive resistance
	 */
	EXPLOSIVERESISTANCE,
	
	/**
	 * Damage to health
	 */
	DAMAGETOHEALTH,
	
	/**
	 * Damage to armor
	 */
	DAMAGETOARMOR,
	
	/**
	 * Damage to target out of cover
	 */
	DAMAGETOTARGETOUTOFCOVER,
	
	/**
	 * Explosive damage
	 */
	EXPLOSIVESDAMAGE,
	
	/**
	 * Headshot damage
	 */
	HEADSHOTDAMAGE,
	
	/**
	 * Hazard protection
	 */
	HAZARDPROTECTION,
	
	/**
	 * Health
	 */
	HEALTH,	
	
	/**
	 * Incoming repairs
	 */
	INCOMINGREPAIRS,
	
	/**
	 * LMG Damage
	 */
	LMGDAMAGE,
	
	/**
	 * NULL
	 */
	NULL,
	
	/**
	 * Melee Damage
	 */
	MELEEDAMAGE,
	
	/**
	 * Marksman Rifle Damage
	 */
	MARKSMANRIFLEDAMAGE,
	
	/**
	 * Mag size
	 */
	MAGSIZE,	
	
	/**
	 * OFFENSIVE
	 */
	
	/**
	 * Optimal range
	 */
	OPTIMALRANGE,
	
	/**
	 * Pistol damage
	 */
	PISTOLDAMAGE,
	
	/**
	 * Precision
	 */
	PRECISION,
	
	/**
	 * Protection from Elitess
	 */
	PROTECTIONFROMELITES,
	
	/**
	 * Rate on fire
	 */
	RATEOFFIRE,
	
	/**
	 * Rounds
	 */
	ROUNDS,
	
	/**
	 * Rifle damage
	 */
	RIFLEDAMAGE,
	
	/**
	 * Reload speed
	 */
	RELOADSPEED,
	
	/**
	 * Repair skills
	 */
	REPAIRSKILLS,
	
	/**
	 * Resistance bleed
	 */
	RESISTANCEBLEED,
	
	/**
	 * Resistance burn
	 */
	RESISTANCEBURN,
	
	/**
	 * Resistance blind
	 */
	RESISTANCEBLIND,
	
	/**
	 * Resistance desorient
	 */
	RESISTANCEDESORIENT,
	
	/**
	 * Resistance disrupt
	 */
	RESISTANCEDISRUPT,
	
	/**
	 * Resistance ensnare
	 */
	RESISTANCEENSNARE,
	
	/**
	 * Resistance shock
	 */
	RESISTANCESHOCK,
	
	/**
	 * Resistance pulse
	 */
	RESISTANCEPULSE,
	
	/**
	 * Resistance haste
	 */
	SCANNERHASTE,
	
	/**
	 * Shield health
	 */
	SHIELDHEALTH,
	
	/**
	 * Shotgun damage
	 */
	SHOTGUNDAMAGE,
	
	/**
	 * Smg damage
	 */
	SMGDAMAGE,	
	
	/**
	 * Skill effiency
	 */
	SKILLEFFICIENCY,
	
	/**
	 * Skill damage
	 */
	SKILLDAMAGE,
	
	/**
	 * Skill duration
	 */
	SKILLDURATION,
	
	/**
	 * Skill haste
	 */
	SKILLHASTE,
	
	/**
	 * Skill health
	 */
	SKILLHEALTH,
	
	/**
	 * Skill tier
	 */
	SKILLTIER,
	
	/**
	 * Stability
	 */
	STABILITY,
	
	/**
	 * Status effects
	 */
	STATUSEFFECTS,
	
	/**
	 * Total armor
	 */
	TOTALARMOR,
	
	/**
	 * Swap speed
	 */
	SWAPSPEED,
	
	/**
	 * Weapon damage
	 */
	WEAPONDAMAGE,
	
	/**
	 * Weapon handling
	 */
	WEAPONHANDLING;
		
	/**
	 * Return the core Attributes with their max values 
	 * @return Returns a map of Attributes and their max values
	 */
	public static Map<Attribute, Number> getCoreAttributes() {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		value.put(Attribute.WEAPONDAMAGE, 15.0);
		value.put(Attribute.ARMOR, 170000);
		value.put(Attribute.SKILLTIER, 1.0);
		return value;
	}
	
	/**
	 * Return the minor attributes with their max values 
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getMinorAttributes() {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		value.put(Attribute.CRITICALHITCHANCE, 6.0);
		value.put(Attribute.CRITICALHITDAMAGE, 12.0);
		value.put(Attribute.WEAPONHANDLING, 8.0);
		value.put(Attribute.HEADSHOTDAMAGE, 10.0);
		value.put(Attribute.ARMORREGEN, 4925);
		value.put(Attribute.HAZARDPROTECTION, 10.0);
		value.put(Attribute.HEALTH, 18935);
		value.put(Attribute.EXPLOSIVERESISTANCE, 10.0);
		value.put(Attribute.SKILLDAMAGE, 10.0);
		value.put(Attribute.REPAIRSKILLS, 20.0);
		value.put(Attribute.SKILLHASTE, 10.0);
		value.put(Attribute.STATUSEFFECTS, 10.0);
		return value;
	}
	
	/**
	 * Return the minor attributes with their max values 
	 * @param equipment Equipment
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getMinorAttributes(Equipment equipment) {
		
		Map<Attribute, Number> value = Attribute.getMinorAttributes();
		
		if (equipment.isNamedItem()) {
			Stack<Integer> fixed = equipment.getAllFixedAttributes();
			fixed.forEach(nr -> {
				switch(nr) {
					case 1 -> value.put(equipment.getFirstAttribute(), equipment.getFirstAttributeValue());
					case 2 -> value.put(equipment.getSecondAttribute(), equipment.getSecondAttributeValue());
					case 3 -> value.put(equipment.getThirdAttribute(), equipment.getThirdAttributeValue());				
					default -> {}
				}
			});
		}
		
		return value;
	}
	
	
	/**
	 * Return the minior attributes and hide the passed hideAttribute
	 * @param hideAttribute Attribute to hide
	 * @return Returns a linked hashmap of attribtues and their max values
	 */
	public static Map<Attribute, Number> getMinorAttribute(Attribute hideAttribute) {
				
		return Attribute.getMinorAttribute(hideAttribute);
	}
	
	/**
	 * Return the mod attributes with their max values
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getModAttributes() {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		value.put(Attribute.CRITICALHITCHANCE, 6.0);
		value.put(Attribute.CRITICALHITDAMAGE, 12.0);		
		value.put(Attribute.HEADSHOTDAMAGE, 10.0);
		value.put(Attribute.ARMORONKILL, 18935);
		value.put(Attribute.INCOMINGREPAIRS, 20.0);
		value.put(Attribute.PROTECTIONFROMELITES, 13.0);
		value.put(Attribute.RESISTANCEBLEED, 10.0);
		value.put(Attribute.RESISTANCEBLIND, 10.0);
		value.put(Attribute.RESISTANCEBURN, 10.0);
		value.put(Attribute.RESISTANCEDISRUPT, 10.0);
		value.put(Attribute.RESISTANCEENSNARE, 10.0);
		value.put(Attribute.RESISTANCEDESORIENT, 10.0);	
		value.put(Attribute.RESISTANCESHOCK, 10.0);
		value.put(Attribute.REPAIRSKILLS, 20.0);
		value.put(Attribute.SKILLHASTE, 10.0);
		value.put(Attribute.SKILLDURATION, 10.0);
		return value;		
	}
	
	/**
	 * Return the weapon core attributes dependly on weapon type 
	 * @param type WeaponType
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getWeaponCoreAttributes(WeaponType type) {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		
		switch(type) {
			case ASSAULTRIFLE:
				value.put(Attribute.ASSAULTRIFLEDAMAGE, 15.0);											
				break;
			case LIGHTMACHINEGUN:
				value.put(Attribute.LMGDAMAGE, 15.0);								
				break;
			case MARKSMANRIFLE:
				value.put(Attribute.MARKSMANRIFLEDAMAGE, 15.0);								
				break;
			case PISTOL:
				value.put(Attribute.PISTOLDAMAGE, 15.0);
				break;
			case RIFLE:
				value.put(Attribute.RIFLEDAMAGE, 15.0);								
				break;
			case SHOTGUN:
				value.put(Attribute.SHOTGUNDAMAGE, 15.0);				
				break;
			case SUBMACHINEGUN:
				value.put(Attribute.SMGDAMAGE, 15.0);				
				break;
		}		
		return value;
	}
	
	/**
	 * Return the weapon second attributes dependly on weapon type
	 * @param type WeaponType
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getWeaponSecondAttributes(WeaponType type) {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		
		switch(type) {
			case ASSAULTRIFLE:				
				value.put(Attribute.DAMAGETOHEALTH, 21.0);							
				break;
			case LIGHTMACHINEGUN:				
				value.put(Attribute.DAMAGETOTARGETOUTOFCOVER, 12);				
				break;
			case MARKSMANRIFLE:				
				value.put(Attribute.DAMAGETOTARGETOUTOFCOVER, 111.0);				
				break;			
			case RIFLE:				
				value.put(Attribute.CRITICALHITDAMAGE, 17.0);				
				break;
			case SHOTGUN:				
				value.put(Attribute.DAMAGETOARMOR, 12.0);
				break;
			case SUBMACHINEGUN:				
				value.put(Attribute.CRITICALHITCHANCE, 21.0);
				break;
			default:
		}		
		return value;
	}
	
	/**
	 * Return the weapon minor attributes dependly on weapon type
	 * @param type WeaponType
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getWeaponMinorAttributes(WeaponType type) {
		Map<Attribute, Number> value = new LinkedHashMap<>();
		
		if (type != WeaponType.SHOTGUN) {
			value.put(Attribute.DAMAGETOARMOR, 6.0);
		}
		if (type != WeaponType.SUBMACHINEGUN) {
			value.put(Attribute.CRITICALHITCHANCE, 9.5);
		}
		if (type != WeaponType.RIFLE) {
			value.put(Attribute.CRITICALHITDAMAGE, 10.0);
		}
		if (type != WeaponType.MARKSMANRIFLE) {		
			value.put(Attribute.HEADSHOTDAMAGE, 10);
		}
		
		value.put(Attribute.DAMAGETOTARGETOUTOFCOVER, 10);
		value.put(Attribute.DAMAGETOARMOR, 6.0);		
		value.put(Attribute.MAGSIZE, 12.5);
		value.put(Attribute.SWAPSPEED, 15.0);
		value.put(Attribute.RELOADSPEED, 12);
		value.put(Attribute.STABILITY, 12.0);
		value.put(Attribute.ACCURACY, 12.0);
		value.put(Attribute.OPTIMALRANGE, 24.0);
		value.put(Attribute.RATEOFFIRE, 5.0);
		
		return value;
	}
}
