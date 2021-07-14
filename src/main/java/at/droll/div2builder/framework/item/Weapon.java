package at.droll.div2builder.framework.item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.droll.div2builder.framework.attribute.*;
import at.droll.div2builder.framework.mod.Mod;
import at.droll.div2builder.framework.mod.ModException;
import at.droll.div2builder.framework.mod.Modslot;
import at.droll.div2builder.framework.TalentWeapon;
import at.droll.div2builder.framework.attribute.Attribute;
import at.droll.div2builder.framework.attribute.AttributeException;

/**
 * Concrete weapon class implementation
 * @author Marco Droll
 */
public class Weapon extends ItemAbstract implements Weaponable  {

	/**
	 * Kind of weapon
	 */
	private WeaponType type;
	
	/**
	 *	Rounds per minutes
	 */
	private int rpm;
	
	/**
	 * Base magazine size of the weapon
	 */
	private int magSize;
		
	/**
	 * Base damage of the weapon
	 */
	private int baseDamage;
		
	/**
	 * Reload speed of the weapon 
	 */
	private double reloadSpeed;
	
	/**
	 * First weapon default. Usually all weapons have only one talent
	 */
	private TalentWeapon talent;
	
	/**
	 * Second talent. Usually Eagle Bearer got this talent
	 */
	private TalentWeapon talent2;
	
	/**
	 * Allowed list of allowed optics mods. 
	 */
	private List<String> allowedModOpticsList;
	
	/**
	 * Allowed list of allowed muzzle mods. 
	 */
	private List<String> allowedModMuzzleList;

	/**
	 * 	Allowed list of allowed grip mods  
	 */
	private List<String> allowedModGripList;
	
	/**
	 * ALlowed list of allowed magazine mods 
	 */
	private List<String> allowedModMagList;
	
	/**
	 * Holds a mod instance for the grip
	 */
	private Mod modGrip = null;

	/**
	 * Holds a mod instance for the mag
	 */
	private Mod modMag = null;
	
	/**
	 * Holds a mod instance for the muzzle
	 */
	private Mod modMuzzle = null;
	
	/**
	 * Holds a mod instance for the optics
	 */
	private Mod modOptics = null;		
	
	/**
	 * Setter for the rpm
	 * @param rpm The round per minute
	 * @return Buildable instance
	 */
	@Override
	public Buildable setRpm(int rpm) {
		this.rpm = rpm;
		return (Buildable)this;
	}
	
	/**
	 * Getter for the type
	 * @return the type
	 */
	public WeaponType getType() {
		return type;
	}

	/**
	 * Sets the type
	 * @param type the type to set
	 * @return Buildable instance
	 */
	public Buildable setType(WeaponType type) {
		this.type = type;
		
		try {
			switch(type) {		
				case ASSAULTRIFLE:
					this.setFirstAttribute(Attribute.ASSAULTRIFLEDAMAGE);
					this.setSecond(Attribute.DAMAGETOHEALTH, 21.0);			
					break;
				case LIGHTMACHINEGUN:
					this.setFirstAttribute(Attribute.LMGDAMAGE);
					this.setSecondAttribute(Attribute.DAMAGETOTARGETOUTOFCOVER);				
					break;
				case MARKSMANRIFLE:
					this.setFirstAttribute(Attribute.MARKSMANRIFLEDAMAGE);
					this.setSecondAttribute(Attribute.HEADSHOTDAMAGE);
					break;
				case PISTOL:
					this.setFirstAttribute(Attribute.PISTOLDAMAGE);
					break;
				case RIFLE:
					this.setFirstAttribute(Attribute.RIFLEDAMAGE);
					this.setSecondAttribute(Attribute.CRITICALHITDAMAGE);
					break;
				case SHOTGUN:
					this.setFirstAttribute(Attribute.SHOTGUNDAMAGE);
					this.setSecondAttribute(Attribute.DAMAGETOARMOR);
					break;
				case SUBMACHINEGUN:
					this.setFirstAttribute(Attribute.SMGDAMAGE);
					this.setSecondAttribute(Attribute.CRITICALHITCHANCE);
					break;
			}
		
		} catch(AttributeException e) {
		}
		
		return (Buildable)this;
	}

//	/**
//	 * Default constructor
//	 */
//	public Weapon() {		
//	}
//	
//	/**
//	 * Parameterized constructor	 
//	 * 
//	 * @param type WeaonType
//	 * @see WeaponType
//	 */
//	public Weapon(WeaponType type) {		
//		
//		this.setType(type);
//
//	}	
	
	/**
	 * Adds a mod to the weapon
	 * @param slot The specific mod slot where the mod should be attached
	 * @param mod The mod itselt to add
	 * @throws ModException If the mod can't be attached
	 * @return Buildable instance
	 */
	public Buildable addMod(Modslot slot, Mod mod) throws ModException {
	
		// If mod in t he wrong slot		
		if (slot != mod.getSlot() ) {
			throw new ModException("Mod isn't applicable to specific mod slot! " + slot);
		} 

		String modIdAsString = String.valueOf(mod.getId());

		switch(slot) {
			case GRIP:				
				if (this.allowedModGripList.contains(modIdAsString) == true ) {
					this.modGrip = mod;					
				} else {
					throw new ModException("Current mod is not in the allowed grip mod list!");
				}
				break;
			case MAG:
				if (this.allowedModMagList.contains(modIdAsString) == true) {										
					this.modMag = mod;
				} else {										
					throw new ModException("Current mod is not in the allowed mag mod list!");
				}
				break;
			case MUZZLE:
				if (this.allowedModMuzzleList.contains(modIdAsString) == true) {
					this.modMuzzle = mod;
				} else {
					throw new ModException("Current mod is not in the allowed muzzle mod list!");
				}
				break;
			case OPTICS:
				if (this.allowedModOpticsList.contains(modIdAsString) == true) {					
					this.modOptics = mod;					
				} else {
					throw new ModException("Current mod is not in the allowed optics mod list!");
				}
				break;
			default:				
				throw new ModException("Only possible modslots are GRIP, MAG, MUZZLE or OPTICS!");
			}

		return (Buildable)this;
	}	
	
	/**
	 * Getter for the round per minute
	 * @return Returns the round per minute
	 */
	public int getRpm() {
		return this.rpm;
	}
		
	/**
	 * Getter for the magasize size
	 * @return the magSize
	 */
	public int getMagSize() {
		return magSize;
	}

	/**
	 * Setter for the magazine size
	 * @param magSize the magSize to set
	 * @return Buildable instance
	 */
	public Buildable setMagSize(int magSize) {
		this.magSize = magSize;
		return (Buildable)this;
	}

	/**
	 * Getter for the base damage
	 * @return the baseDamage
	 */
	public int getBaseDamage() {
		return baseDamage;
	}

	/**
	 * Setter for the base damage
	 * @param baseDamage the baseDamage to set
	 * @return Buildable instance
	 */
	public Buildable setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
		return (Buildable)this;
	}

	/**
	 * Getter for the reload peed
	 * @return the reloadSpeed
	 */
	public double getReloadSpeed() {
		return reloadSpeed;
	}

	/**
	 * Setter for the reload speed
	 * @param reloadSpeed the reloadSpeed to set
	 * @return Buildable instance
	 */
	public Buildable setReloadSpeed(double reloadSpeed) {
		this.reloadSpeed = reloadSpeed;
		return (Buildable)this;
	}

	/**
	 * Getter for the talent
	 * @return the talent
	 */
	public TalentWeapon getTalent() {
		return talent;
	}

	/**
	 * Setter for the lanet
	 * @param talent the talent to set
	 * @return Buildable instance
	 */
	public Buildable setTalent(TalentWeapon talent) {
		this.talent = talent;
		return (Buildable)this;
	}

	/**
	 * Getter for the talent2
	 * @return the talent2
	 */
	public TalentWeapon getTalent2() {
		return talent2;
	}

	/**
	 * Setter for talent2
	 * @param talent2 the talent2 to set
	 * @return Buildable instance
	 */
	public Buildable setTalent2(TalentWeapon talent2) {
		this.talent2 = talent2;
		return (Buildable)this;
	}

	/**
	 * Getter for the allowed optics mods list
	 * @return the allowedModOpticsList
	 */
	public List<String> getAllowedModOpticsList() {
		return allowedModOpticsList;
	}

	/**
	 * Setter for the allowed optics mod list
	 * @param list The allowedModOpticsList to set
	 * @return Buildable instance
	 */
	public Buildable setAllowedModOpticsList(String list) {
		if (list != null) {
			this.allowedModOpticsList = Arrays.asList(list.split(","));
		}
		return (Buildable)this;
	}

	/**
	 * Getter for the allowed muzzle mod list
	 * @return the allowedModMuzzleList
	 */
	public List<String> getAllowedModMuzzleList() {
		return allowedModMuzzleList;
	}

	/**
	 * Getter for the allow muzzle mod list
	 * @param list The allowedModMuzzleList to set
	 * @return Buildable instance
	 */
	public Buildable setAllowedModMuzzleList(String list) {
		if (list != null) {
			this.allowedModMuzzleList = Arrays.asList(list.split(","));
		}
		return (Buildable)this;
	}

	/**
	 * Getter for the allowed grip mod list
	 * @return the allowedModGripList
	 */
	public List<String> getAllowedModGripList() {
		return allowedModGripList;
	}

	/**
	 * Setter for the allowed grip mod list
	 * @param list The allowedModGripList to set
	 * @return Buildable instance
	 */
	public Buildable setAllowedModGripList(String list) {
		if (list != null) {
			this.allowedModGripList = Arrays.asList(list.split(","));
		}
		return (Buildable)this;
	}

	/**
	 * Getter for the allowed mod mag list
	 * @return the allowedModMagList
	 */
	public List<String> getAllowedModMagList() {
		return allowedModMagList;
	}

	/**
	 * Setter for the allowed mod mag list
	 * @param list The allowedModMagList to set
	 * @return Buildable instance
	 */
	public Buildable setAllowedModMagList(String list) {
		if (list != null) {
			this.allowedModMagList = Arrays.asList(list.split(","));
		}
		return (Buildable)this;
	}

	/**
	 * Returns a mod given on the mod slot
	 * @param slot Modslot
	 * @return Returns a mod
	 */
	public Mod getMod(Modslot slot) {
	
		switch(slot) {
			case GRIP:
				return getModGrip();
			case MAG:
				return getModMag();
			case MUZZLE:
				return getModMuzzle();
			case OPTICS:
				return getModOptics();
			default:
				return null;
		}
	}
	
	/**
	 * Gets the grip mod
	 * @return the modGrip
	 */
	public Mod getModGrip() {
		return modGrip;
	}

	/**
	 * Setter for the grip mod
	 * @param modGrip the modGrip to set
	 * @return Buildable instance
	 */
	public Buildable setModGrip(Mod modGrip) {
		this.modGrip = modGrip;
		return (Buildable)this;
	}

	/**
	 * Getter for the mag mod
	 * @return the modMag
	 */
	public Mod getModMag() {
		return modMag;
	}

	/**
	 * Setter for the mag mod
	 * @param modMag the modMag to set
	 * @return Buildable instance
	 */
	public Buildable setModMag(Mod modMag) {		
		this.modMag = modMag;
		return (Buildable)this;
	}

	/**
	 * Getter for the mod muzzle
	 * @return the modMuzzle
	 */
	public Mod getModMuzzle() {
		return modMuzzle;
	}

	/**
	 * Setter for the mod muzzle
	 * @param modMuzzle the modMuzzle to set
	 * @return Buildable instance
	 */
	public Buildable setModMuzzle(Mod modMuzzle) {
		this.modMuzzle = modMuzzle;
		return (Buildable)this;
	}

	/**
	 * Getter for the mod optics
	 * @return the modOptics
	 */
	public Mod getModOptics() {
		return modOptics;
	}

	/**
	 * Setter for the mod optics
	 * @param modOptics the modOptics to set
	 * @return Buildable instance
	 */
	public Buildable setModOptics(Mod modOptics) {
		this.modOptics = modOptics;
		return (Buildable)this;
	}
	
	/**
	 * Setting a name for a equipment
	 * @param name Sets the name of the weapon
	 * @return Buildable instance
	 */
	@Override
	public Buildable setName(String name) {
		switch(name) {
			case "Eagle Baerer":
				this.setExoticItem(true)
					.setTalent(TalentWeapon.EAGLESSTRIKE)
					.setTalent2(TalentWeapon.TENACITY)
					.setFixedAttribute(1)
					.setFixedAttribute(2)
					.setFixedAttribute(3)
				;
				break;
		}
		super.setName(name);
		
		return (Buildable)this;
	}
	
	/**
	 * Return all Attribute and Values of the item as a hash map
	 * @return A list of Attribute and value
	 */
	public Map<Attribute, Double> getAttributesAndValues() {
		
		Map<Attribute, Double> map = new HashMap<>();
		
		map.put(getCoreAttribute(), getCoreAttributeValue());
		map.put(getFirstAttribute(), getFirstAttributeValue());
		map.put(getSecondAttribute(), getSecondAttributeValue());
		map.put(getThirdAttribute(), getThirdAttributeValue());
		
		// Check if we have a mod		
		return map;
	}
	
	/**
	 * Weapon builder class 
	 * @author Marco Droll
	 */
	public static class Builder extends Weapon implements Weaponable, Buildable {
		
		@Override
		public Weapon build() {
			Weapon item = new Weapon();
			item = this;
			return item;
		}
	}
	
	@Override
	public String toString() {
		return "Weapon [type=" + type + ", rpm=" + rpm + ", magSize=" + magSize + ", baseDamage=" + baseDamage
				+ ", reloadSpeed=" + reloadSpeed + ", talent=" + talent + ", talent2=" + talent2
				+ ", allowedModOpticsList=" + allowedModOpticsList + ", allowedModMuzzleList=" + allowedModMuzzleList
				+ ", allowedModGripList=" + allowedModGripList + ", allowedModMagList=" + allowedModMagList
				+ ", modGrip=" + modGrip + ", modMag=" + modMag + ", modMuzzle=" + modMuzzle + ", modOptics="
				+ modOptics + "]";
	}
}
	
