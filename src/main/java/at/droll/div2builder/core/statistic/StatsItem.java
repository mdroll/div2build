package at.droll.div2builder.core.statistic;

import at.droll.div2builder.core.attribute.Attribute;

/**
 * 
 * @author Marco Droll
 */
public class StatsItem {
	
	private String attribute = null;
	
	private String value = null;
	
	@Override
	public String toString() {
		return "StatsItem [attribute=" + attribute + ", value=" + value + ", category=" + category + "]";
	}

	private String category = "";
	
	public StatsItem() { 
	}
	
	public StatsItem(String attribute, String value) {
	
		this.attribute = attribute;
		this.value 	   = value;
	}
	
	public StatsItem(Attribute attribute, Double value) {
		super();
				
		switch(attribute) {
			case CRITICALHITCHANCE:
			case CRITICALHITDAMAGE:
			case HEADSHOTDAMAGE:
			case WEAPONHANDLING:			
			case ASSAULTRIFLEDAMAGE:
			case RIFLEDAMAGE:
			case WEAPONDAMAGE:
			case LMGDAMAGE:
			case MARKSMANRIFLEDAMAGE:
			case SMGDAMAGE:
			case PISTOLDAMAGE:
			case SHOTGUNDAMAGE:
			case DAMAGETOTARGETOUTOFCOVER:
			case DAMAGETOARMOR:
			case DAMAGETOHEALTH:
			case HEALTHONKILL:
			case SWAPSPEED:
			case MELEEDAMAGE:
				category = "offensive";
				break;
			case ARMOR:
			case ARMORREGEN:
			case ARMORONKILL:
			case HAZARDPROTECTION:
			case HEALTH:
			case TOTALARMOR:
			case RESISTANCEBLEED:
			case RESISTANCEDESORIENT:
			case RESISTANCEDISRUPT:
			case RESISTANCEBLIND:
			case RESISTANCEESNARE:
			case RESISTANCEPULSE:
			case RESISTANCESHOCK:
			case EXPLOSIVERESISTANCE:
			case INCOMINGREPAIRS:
			case PROTECTIONFROMELITES:
				category = "defensive";
				break;
			case PRECISION:			
			case RELOADSPEED:
			case STABILITY:
			case ACCURACY:
			case OPTIMALRANGE:
			case RATEOFFIRE:
			case REPAIRSKILLS:
			case SKILLTIER:
			case SKILLDAMAGE:
			case SKILLDURATION:
			case SKILLHASTE:
			case SKILLHEALTH:
			case SKILLEFFICIENCY:
			case STATUSEFFECTS:
			case SCANNERHASTE:
			case SHIELDHEALTH:
			case EXPLOSIVESDAMAGE:			
				category = "skill";
				break;
			default:
		}
	
		this.attribute = attribute.toString();
		this.value = value.toString();
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}	
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}	
}
