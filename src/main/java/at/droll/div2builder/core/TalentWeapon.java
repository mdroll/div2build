package at.droll.div2builder.core;

import java.util.LinkedList;
import java.util.List;
import at.droll.div2builder.core.item.weapon.WeaponType;

/**
 * Enum of weapon talent
 * @author Marco Droll
 */
public enum TalentWeapon {
	
	/**
	 * Boomerang Talent 
	 */
	BOOMERANG,
	
	/**
	 * Breadbasket Talent
	 */
	BREADBASKET,
	
	/**
	 * Close and Person Talent
	 */
	CLOSEANDPERSONAL,
	
	/**
	 * Eyeless Talent
	 */
	EYELESS,
	
	/**
	 * Ignited Talent
	 */
	IGNITED,
	
	/**
	 * Finisher Talent
	 */
	FINISHER,
	
	/**
	 * First Blood Talent
	 */
	FIRSTBLOOD,
	
	/**
	 * Fast Hands Talent
	 */
	FASTHANDS,
	
	/**
	 * Frenzy Talent
	 */
	FRENZY,
	
	/**
	 * Future Perfect Talent
	 */
	FUTUREPERFECT,
	
	/**
	 * In Sync Talent
	 */
	INSYNC,
	
	/**
	 * Killer Talent
	 */
	KILLER,
	
	/**
	 * Luckyshot Talent
	 */
	LUCKYSHOT,
	
	/**
	 * Measured Talent
	 */
	MEASURED,
	
	/**
	 * Naked Talent
	 */
	NAKED,
	
	/**
	 * Near Sighted Talent
	 */
	NEARSIGHTED,
	
	/**
	 * Optimist Talent
	 */
	OPTIMIST,
	
	/**
	 * Perputation Talent
	 */
	PERPETUATION,		
	
	/**
	 * Preservation Talent
	 */
	PRESERVATION,
	
	/**
	 * Pummel Talent
	 */
	PUMMEL,
	
	/**
	 * Pumped up Talent
	 */
	PUMPEDUP,
	
	/**
	 * On Empty Talent
	 */
	ONEMPTY,
	
	/**
	 * Outsider Talent
	 */
	OUTSIDER,
	
	/**
	 * Overflowing Talent
	 */
	OVERFLOWING,
	
	/**
	 * Overwhelm Talent
	 */
	OVERWHELM,
	
	/**
	 * Ranger talent
	 */
	RANGER,
	
	/**
	 * Reformation talent
	 */
	REFORMATION,
	
	/**
	 * Riflemen talent
	 */
	RIFLEMEN,
	
	/**
	 * Sadist talent
	 */
	SADIST,		
	
	/**
	 * Salvage
	 */
	SALVAGE,
	
	/**
	 * Steady handed talent
	 */
	STEADYHANDED,
	
	/**
	 * Spike talent
	 */
	SPIKE,
	
	/**
	 * Strained talent
	 */
	STRAINED,	
	
	/**
	 * Vindictive talent
	 */
	VINDICTIVE,
	
	/**
	 * First eagle bearer talent
	 */
	EAGLESSTRIKE,
	
	/**
	 * Second eagle bearer talent
	 */
	TENACITY,
	
	/**
	 * Unhinged Talent
	 */
	UNHINGED,
	
	/**
	 * Unwavering Talent
	 */
	UNWAVERING,
	
	/**
	 * Default talent
	 */
	NULL;
	
	
	/**
	 * Return all the available armor talents 
	 * @param type WeaponType
	 * @return Returns a linked list with all available backpack talents
	 */
	public static List<TalentWeapon> getWeaponTalents(WeaponType type) {
		List<TalentWeapon> value = new LinkedList<>();
			
		value.add(BREADBASKET);
		value.add(KILLER);
		value.add(PRESERVATION);
		value.add(OPTIMIST);
		value.add(STRAINED);
		value.add(CLOSEANDPERSONAL);
		value.add(FASTHANDS);
		value.add(SADIST);
		value.add(VINDICTIVE);
		value.add(RANGER);
		value.add(STEADYHANDED);
		value.add(SPIKE);
		value.add(EYELESS);
		value.add(IGNITED);
		value.add(PERPETUATION);
		value.add(REFORMATION);
		value.add(FUTUREPERFECT);
		value.add(INSYNC);		
		
		switch(type) {
			case ASSAULTRIFLE -> {		
				value.add(NEARSIGHTED);						
				value.add(ONEMPTY);
				value.add(MEASURED);
				value.add(OVERFLOWING);
			}
			case RIFLE -> {
				value.add(RIFLEMEN);
				value.add(BOOMERANG);		
				value.add(LUCKYSHOT);
			}
			case MARKSMANRIFLE -> {
				value.add(NAKED);
				value.add(FIRSTBLOOD);
				value.add(LUCKYSHOT);
			}
			case SHOTGUN -> {
				value.add(PUMMEL);
				value.add(PUMPEDUP);				
			}
			case SUBMACHINEGUN -> {
				value.add(OUTSIDER);
				value.add(UNWAVERING);
				value.add(MEASURED);
			}
			case LIGHTMACHINEGUN -> {
				value.add(UNHINGED);
				value.add(FRENZY);
				value.add(MEASURED);
				value.add(OVERWHELM);				
			}
			case PISTOL -> {
				value.add(SALVAGE);
				value.add(FINISHER);
				value.add(LUCKYSHOT);
			}
		}		
		
		return value;
	}

}
