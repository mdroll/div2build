package at.droll.div2builder.core.statistic;

import at.droll.div2builder.core.attribute.Attribute;

/**
 * Used classes for the TreeTableView in the frontend
 * @author Marco Droll
 */
public class StatsItem {
	
	/**
	 * Holds the Attribute as string
	 */
	private String attribute = null;
	
	/**
	 * Holds the Value as String
	 */
	private String value = null;
	
	/**
	 * Holds the category of the attribute i.e. Offensive, Defensive or Skill 
	 */
	private String category = "";
	
	
	/**
	 * Default constructor
	 * @param attribute Attribtue to set
	 * @param value Value to set
	 */
	public StatsItem(String attribute, String value) {
		this.attribute = attribute;
		this.value 	   = value;
	}
	
	/**
	 * More specific constructor where the category of StatsItem is also setted
	 * @param attribute attribtue to set
	 * @param value Value to set
	 */
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
	 * Getter for the Value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for the Value
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Getter for the category
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter for the categroy
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Getter for the attribute
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}	
	
	/**
	 * Setter for the attribute
	 * @param attribute Attribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	/**
	 * To string Method for debugging purposes
	 */
	@Override
	public String toString() {
		return "StatsItem [attribute=" + attribute + ", value=" + value + ", category=" + category + "]";
	}
}
