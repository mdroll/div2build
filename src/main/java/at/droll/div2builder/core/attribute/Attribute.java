package at.droll.div2builder.core.attribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import at.droll.div2builder.core.item.equipment.Equipment;

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
	 * @return Returns a linked hashmap of attributes and their max values
	 */
	public static Map<Attribute, Number> getMinorAttributes(Equipment equipment) {
		
		Map<Attribute, Number> value = Attribute.getMinorAttributes();
		
		if (equipment.isNamedItem()) {
			Stack<Integer> fixed = equipment.getAllFixedAttributes();
			fixed.forEach(nr -> {
				switch(nr) {
					case 1 -> {
						value.put(equipment.getFirstAttribute(), equipment.getFirstAttributeValue());
					}
					case 2 -> {
						value.put(equipment.getSecondAttribute(), equipment.getSecondAttributeValue());
					}
					case 3 -> {
						value.put(equipment.getThirdAttribute(), equipment.getThirdAttributeValue());
					}
				}
			});
		}
		
		return value;
	}
	
	
	/**
	 * Return the miniopr attributes and hide the passed hideAttribute
	 * @param hideAttribute Attribute to hide
	 * @return Returns a linked hashmap of attribtues and their max values
	 * TODO Need to implement here
	 */
	public static Map<Attribute, Number> getMinorAttribute(Attribute hideAttribute) {
				
		Map<Attribute, Number> attributes = Attribute.getMinorAttribute(hideAttribute);
		return attributes;
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
}
