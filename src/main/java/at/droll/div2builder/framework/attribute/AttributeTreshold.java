package at.droll.div2builder.framework.attribute;

/**
 * Class of thresholds of Attribute values
 * @author Marco Droll
 */
public class AttributeTreshold {
	
	/**
	 * Max Armor value
	 */
	public final static Number ARMOR = 170_000d;
	
	/**
	 * Max critical chance value
	 */
	public final static Number CRITICALHITCHANCE = 6.0d;
	
	/**
	 * Max cirtical hit damage value 
	 */
	public final static Number CRITICALHITDAMAGE = 12.0d;
	
	/**
	 * Max Headshot Damage value
	 */
	public final static Number HEADSHOTDAMAGE = 20d;	
	
//    ARMORONKILL("ARMORONKILL", 18_000),
//    ARMORREGEN("ARMORREGEN", 4_935), 
//	CRITICALHITCHANCE("CRITICALHITCHANCE", 6.0),
//	CRITICALHITDAMAGE("CRITICALHITDAMAGE", 12.0),
//	DAMAGETOARMOR("DAMAGETOARMOR", 6.0),
//	DAMGETTOTARGETOUTOFCOVER("DAMGETTOTARGETOUTOFCOVER", 10.0),
//	HEADSHOTDAMAG("HEADSHOTDAMAG", 10.0),
//	HAZARDPROTECTION("HAZARDPROTECTION", 10.0),
//	HEALTH("HEALTH", 17_000),
//	HEALTHDAMAGE("HEALTHDAMAGE", 21.0),
//	INCOMINGREPAIRS("INCOMINGREPAIRS", 20.0),
//	MAGSIZE("MAGSIZE", 60.0),
//	PROTECTIONFROMELITES("PROTECTIONFROMELITES", 13.0),
//	RESISTANCEBLEED("RESISTANCEBLEED", 10.0),
//	RESISTANCEBLIND("RESISTANCEBLIND", 10.0),
//	RESISTANCEDESORIENT("RESISTANCEDESORIENT", 10.0),
//	RESISTANCEDISRUPT("RESISTANCEDISRUPT", 10.0),
//	RESISTANCEENSNARE("RESISTANCEESNARE", 10.0),
//	RESISTANCEEXPLOSIVE("RESISTANCEEXPLOSIVE", 10.0),
//	REPAIRSKILLS("REPAIRSKILLS", 10.0),
//	RESISTANCESHOCK("RESISTANCESHOCK", 10.0),
//	SKILLDAMAGE("SKILLDAMAGE", 10.0),
//	SKILLDURATION("SKILLDURATION", 10.0),
//	SKILLHASTE("SKILLHASTE", 10.0),
//	SKILLTIER("SKILLTIER", 7),
//	SKILLEFFIENCY("SKILLEFFIENCY", 10.0),
//	STATUSEFFECTS("STATUSEFFECTS", 10.0),
//	WEAPONHANDLING("WEAPONHANDLING", 10.0),
//	WEAPONDAMAGE("WEAPONDAMAGE", 15.0);
//		
//	/**
//	 * 
//	 */
//	private final static HashMap<String, Number> keyMap;    
//
//	/**
//	 * 
//	 */
//    private final String key;
//    
//    /**
//     *     
//     */
//    private final Number value;
//    
//    static {
//        keyMap = new HashMap<>();        
//        for (AttributeTreshold attribute : AttributeTreshold.values()) {
//            keyMap.put(attribute.getKey(), attribute.getValue());
//        }
//    }
//    
//    /**
//     * Constructor
//     * 
//     * @param String
//     * @param Number
//     */
//	private AttributeTreshold(String key, Number value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    /**
//     * 
//     * @return
//     */
//    public Number getValue() {
//        return value;
//    }
//
//    /**
//     * 
//     * @return
//     */
//    public String getKey() {
//        return key;
//    }  
//
//	/**
//	 * valueOff instead of valueOf, because can't be overridden :-( 
//	 * 
//	 * @param key
//	 * @return Number 
//	 */
//    public static Number valueOff(String key) {
//        return keyMap.get(key);
//    }
}
