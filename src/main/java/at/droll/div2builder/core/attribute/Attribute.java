package at.droll.div2builder.core.attribute;

import java.util.LinkedHashMap;
import java.util.Map;


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
	 * Resistance esnare
	 */
	RESISTANCEESNARE,
	
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
	 * @return Returns a map of Attributes and their max values
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
	
}
