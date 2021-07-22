package at.droll.div2builder.core;

import java.util.LinkedList;
import java.util.List;

/**
 * Enum a lot of talents 
 * @author Marco Droll
 */
public enum Talent {

	/**
	 * Exotic Talent for Ridgeways Pride
	 */
	BLEEDINGEDGE,

	/**
	 * Braced Armor Talent
	 */
	BRACED,
	
	/**
	 * Efficient Armor Talent
	 */
	EFFICIENT,
	
	/**
	 * Entrench Armor Talent
	 */
	ENTRENCH,
	
	/**
	 * Focus Armor Talent
	 */
	FOCUS,
	
	/**
	 * Gunslinger Armor Talent
	 */
	GUNSLINGER,	
	
	/**
	 * Glasscannon Armor Talent
	 */
	GLASSCANNON,
	
	/**
	 * Headhunter Armor Talent
	 */
	HEADHUNTER,
	
	/**
	 * Intimitdate Armor Talent
	 */
	INITMIDATE,		
	
	/**
	 * Empathic Resolve Armor Talent
	 */
	EMPATHICRESOLVE,	
	
	/**
	 * Explosive Delivery Armor Talent
	 */
	EXPLOSIVEDILVERY,
	
	/**
	 * Kinetic Momentum Armor Talent
	 */
	KINETICMOMENTUM,
	
	/**
	 * Madmober Armor Talent
	 */
	MADBOMBER,
	
	/**
	 * Obliterate Armor Talent
	 */
	OBLITERATE,
	
	/**
	 * Overwatch Armor Talent
	 */
	OVERWATCH,	
	
	/**
	 * Protected Reload Armor Talent
	 */
	
	PROTECTEDRELOAD,
	
	/**
	 * Reassigned Armor Talent
	 */
	REASSIGNED,
	
	/**
	 * Braced Armor Talent
	 */
	SPARK,
	
	/**
	 * Skilled Armor Talent
	 */
	SKILLED,
	
	/**
	 * Spotter Armor Talent
	 */
	SPOTTER,
	
	/**
	 * Tamperproof Armor Talent
	 */
	TAMPERPROOF,
	
	/**
	 * Tag team Armor Talent
	 */
	TAGTEAM,
	
	/**
	 * Trauma Armor Talent
	 */
	TRAUMA,
	
	/**
	 * Unbreakable Armor Talent
	 */
	UNBREAKABLE,
	
	/**
	 * Vanguard Armor Talent
	 */
	VANGUARD,

	/**
	 * Adrenalin Rush Backpack Talent
	 */
	ADRENALINRUSH,
	
	/**
	 * Bloodsucker Backpack Talent
	 */
	BLOODSUCKER,
	
	/**
	 * Concussion Backpack Talent
	 */
	CONCUSSION,
	
	/**
	 * Creeeping Death Backpack Talent
	 */
	CREEPINGDEATH,
	
	/**
	 * Calculated Backpack Talent
	 */
	CALCULATED,
	
	/**
	 * Clutch Rush Backpack Talent
	 */
	CLUTCH,
	
	/**
	 * Companion Rush Backpack Talent
	 */
	COMPANION,
	
	/**
	 * Compusre Rush Backpack Talent
	 */
	COMPOSURE,
	
	/**
	 * Energize Rush Backpack Talent
	 */
	ENERGIZE,
	
	/**
	 * Combined Arms Backpack Talent
	 */
	COMBINEDARMS,
	
	/**
	 * Galvanized Backpack Talent
	 */
	GALVANIZED,
	
	/**
	 * Leadership Backpack Talent
	 */
	LEADERSHIP,
	
	/**
	 * ProtectorBackpack Talent
	 */
	PROTECTOR,
	
	/**
	 * Opportunistic Backpack Talent
	 */
	OPPORTUNISTIC,	
	
	/**
	 * Overclocked Rush Backpack Talent
	 */
	OVERCLOCKED,	
	
	/**
	 * Safeguard Backpack Talent
	 */
	SAFEGUARD,
	
	/**
	 * Shock and AweBackpack Talent
	 */
	SHOCKANDAWE,	
	
	/**
	 * Tech support Backpack Talent
	 */
	TECHSUPPORT,
	
	/**
	 * Unstoppable Force Backpack Talent
	 */
	UNSTOPPABLEFORCE,
	
	/**
	 * Versatile Backpack Talent
	 */
	VERSATILE,
	
	/**
	 * Vigiliance Backpack Talent
	 */
	VIGILIANCE,
	
	/**
	 * Wicked Backpack Talent
	 */
	WICKED;
	
	/**
	 * Return all the available armor talents 
	 * @return Returns a linked list with all available backpack talents
	 */
	public static List<Talent> getArmorTalents() {
				
		List<Talent> value = new LinkedList<>();
		value.add(EXPLOSIVEDILVERY);
		value.add(EMPATHICRESOLVE);
		value.add(BRACED);
		value.add(EFFICIENT);
		value.add(ENERGIZE);
		value.add(FOCUS);
		value.add(GLASSCANNON);
		value.add(GUNSLINGER);
		value.add(HEADHUNTER);
		value.add(INITMIDATE);
		value.add(KINETICMOMENTUM);
		value.add(MADBOMBER);
		value.add(OVERWATCH);
		value.add(PROTECTEDRELOAD);
		value.add(REASSIGNED);
		value.add(SKILLED);
		value.add(SPOTTER);
		value.add(SPARK);
		value.add(OBLITERATE);
		value.add(TAGTEAM);
		value.add(TAMPERPROOF);
		value.add(TRAUMA);
		value.add(UNBREAKABLE);
		value.add(VANGUARD);
		
		return value;
	}
	
	/**
	 * Return all the available backpack talents 
	 * @return Returns a linked list with all available backpack talents
	 */
	public static List<Talent> getBackpackTalents() {
				
		List<Talent> value = new LinkedList<>();
		value.add(ADRENALINRUSH);
		value.add(BLOODSUCKER);		
		value.add(CALCULATED);
		value.add(CLUTCH);
		value.add(CREEPINGDEATH);
		value.add(COMBINEDARMS);
		value.add(COMPOSURE);
		value.add(CONCUSSION);
		value.add(ENERGIZE);
		value.add(GALVANIZED);
		value.add(LEADERSHIP);
		value.add(OPPORTUNISTIC);
		value.add(OVERCLOCKED);
		value.add(PROTECTOR);
		value.add(UNSTOPPABLEFORCE);
		value.add(TECHSUPPORT);
		value.add(CALCULATED);		
		value.add(SHOCKANDAWE);
		value.add(SAFEGUARD);
		value.add(VIGILIANCE);
		value.add(VERSATILE);
		value.add(WICKED);
		
		return value;
	}
}