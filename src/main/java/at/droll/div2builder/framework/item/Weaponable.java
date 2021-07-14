package at.droll.div2builder.framework.item;

import at.droll.div2builder.framework.mod.Mod;
import at.droll.div2builder.framework.mod.ModException;
import at.droll.div2builder.framework.mod.Modslot;
import at.droll.div2builder.framework.TalentWeapon;

/**
 * Weaponable mit all default implemnted methods, cause these Interface is also used in the equipment class
 * @author Marco Droll
 */
public interface Weaponable {
		
	/**
	 * Set the rpm of the weapon
	 * @param rpm Rounds per minute
	 * @return Buildable
	 */
	default public Buildable setRpm(int rpm) {
		return null;
	}
	
	/**
	 * Set the type of the weapon
	 * @param type WeaponType to set
	 * @return Buildable
	 */
	default public Buildable setType(WeaponType type) {
		return null;
	}
	
	/**
	 * Add amod
	 * @param slot The slot where the mod should be attached
	 * @param mod The mod itself
	 * @return Buildable
	 * @throws ModException Throws Mod Exception if the mod couldnt be attached
	 */
	default public Buildable addMod(Modslot slot, Mod mod) throws ModException {
		return null;
	}
	
	/**
	 * Sets the magazine size for the weapon
	 * @param magSize The magazine size
	 * @return Buildable
	 */
	default public Buildable setMagSize(int magSize) {
		return null;
	}
	
	/**
	 * Sets the base damage for the weapon
	 * @param baseDamage The base damage 
	 * @return Buildable
	 */
	default public Buildable setBaseDamage(int baseDamage) {		
		return null;
	}
	
	/**
	 * Sets the reload speed for the weapon
	 * @param reloadSpeed The reload speef for the weapon
	 * @return Buildable
	 */
	default public Buildable setReloadSpeed(double reloadSpeed) {
		return null;
	}
	
	/**
	 * Sets the first/main talent for weapon
	 * @param talent The talent to set
	 * @return Buildable
	 */
	default public Buildable setTalent(TalentWeapon talent) {
		return null;
	}
	
	/**
	 * Sets the second talent for the weapon. i.e. the Eagle Bearer
	 * @param talent2 The talent to set
	 * @return Buildable
	 */
	default public Buildable setTalent2(TalentWeapon talent2) {
		return null;
	}
	
	/**
	 * Sets the allowed mods for the optics slot
	 * @param list A comma separated id list from the database
	 * @return Buildable
	 */
	default public Buildable setAllowedModOpticsList(String list) {
		return null;
	}
	
	/**
	 * Sets the allowed mods for the muzzle slot
	 * @param list A comma separated id list from the database
	 * @return Buildable
	 */
	default public Buildable setAllowedModMuzzleList(String list) {
		return null;
	}
	
	/**
	 * Sets the allowed mods for the grip slot
	 * @param list A comma separated id list from the database
	 * @return Buildable
	 */
	default public Buildable setAllowedModGripList(String list) {
		return null;
	}
	
	/**
	 * Sets the allowed mods for the mag slot
	 * @param list A comma separated id list from the database
	 * @return Buildable
	 */
	default public Buildable setAllowedModMagList(String list) {
		return null;
	}
	
	/**
	 * Sets the mod for the grip
	 * @param modGrip The mod to set
	 * @return Buildable
	 */
	default public Buildable setModGrip(Mod modGrip) {
		return null;
	}
	
	/**
	 * Sets the mod for the mag
	 * @param modMag The mod to set
	 * @return Buildable
	 */
	default public Buildable setModMag(Mod modMag) {
		return null;
	}
	
	/**
	 * Sets the mod for the muzzle
	 * @param modMuzzle The mod to set
	 * @return Buildable
	 */
	default public Buildable setModMuzzle(Mod modMuzzle) {
		return null;
	}
	
	/**
	 * Sets the mod for the optics
	 * @param modOptics The mod to set
	 * @return Buildable
	 */
	default public Buildable setModOptics(Mod modOptics) {
		return null;
	}
}
