package at.droll.div2builder.framework;

import java.util.HashMap;
import java.util.Map;

import at.droll.div2builder.framework.attribute.*;
import at.droll.div2builder.framework.item.Buildable;
import at.droll.div2builder.framework.attribute.AttributeAbstract;

/**
 * Manufacturer representation for equipment 
 * @author Marco Droll
 */
public class Manufacturer extends AttributeAbstract implements Buildable {

	/**
	 * Short form of the name for better recogniation inside/outside
	 */
	private String shortname;	
	
	/**
	 * The name of Airaldi as a string constant with the value {@value}
	 */	
	public static final String AIRALDI = "Airaldi";
	
	/**
	 * The long name of Airaldi as a string constant with the value {@value}
	 */
	public static final String AIRALDI_LONGNAME = "Airaldi Holdings";
	
	/**
	 * The core value of Airaldi as a double constant with the value {@value}
	 */
	public static final double AIRALDI_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Airaldi as a double constant with the value {@value}
	 */
	public static final double AIRALDI_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Airaldi as a double constant with the value {@value}
	 */
	
	public static final double AIRALDI_SECOND_VALUE = 15.0;
	
	/**
	 * The third value of Airaldi as a double constant with the value {@value}
	 */
	public static final double AIRALDI_THIRD_VALUE = 5.0;
		
	/**
	 * The name of Alps as a string constant with the value {@value}
	 */
	public static final String ALPS = "Alps";
	
	/**
	 * The long name of Alps as a string constant with the value {@value}
	 */
	public static final String ALPS_LONGNAME = "Alps Summit Armament";
	
	/**
	 * The core value of Alps as a double constant with the value {@value}
	 */
	public static final double ALPS_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Alps as a double constant with the value {@value}
	 */
	public static final double ALPS_FIRST_VALUE = 20.0;
	
	/**
	 * The second value of Alps as a double constant with the value {@value}
	 */
	public static final double ALPS_SECOND_VALUE = 20.0;
	
	/**
	 * The third value of Alps as a double constant with the value {@value}
	 */
	public static final double ALPS_THIRD_VALUE = 1.0;
	
	/**
	 * The name of Badger as a string constant with the value {@value}
	 */
	public static final String BADGER = "Badger";
	
	/**
	 * The long name of Badger as a string constant with the value {@value}
	 */
	public static final String BADGER_LONGNAME = "Badger Tuff";
	
	/**
	 * The core value of Badger as a double constant with the value {@value}
	 */	
	public static final double BADGER_CORE_VALUE = 0;
	
	/**
	 * The first value of Badger as a double constant with the value {@value}
	 */
	public static final double BADGER_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Badger as a double constant with the value {@value}
	 */
	public static final double BADGER_SECOND_VALUE = 5.0;
	
	/**
	 * The third value of Badger as a double constant with the value {@value}
	 */
	public static final double BADGER_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Belstone as a string constant with the value {@value}
	 */
	public static final String BELSTONE = "Belstone";
	
	/**
	 * The long name of Belstone as a string constant with the value {@value}
	 */
	public static final String BELSTONE_LONGNAME = "Belstone Armory";
	
	/**
	 * The core value of Belstone as a double constant with the value {@value}
	 */
	public static final double BELSTONE_CORE_VALUE = 0;
	
	/**
	 * The first value of Belstone as a double constant with the value {@value}
	 */
	public static final double BELSTONE_FIRST_VALUE = 1.0;
	
	/**
	 * The second value of Belstone as a double constant with the value {@value}
	 */
	public static final double BELSTONE_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Belstone as a double constant with the value {@value}
	 */
	public static final double BELSTONE_THIRD_VALUE = 20.0;
		
	/**
	 * The name of Ceska as a string constant with the value {@value}
	 */
	public static final String CESKA = "Ceska";
	
	/**
	 * The long name of Ceska as a string constant with the value {@value}
	 */
	public static final String CESKA_LONGNAME = "Ceska Vyroba s.r.o.";
	
	/**
	 * The core value of Ceska as a double constant with the value {@value}
	 */
	public static final double CESKA_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Ceska as a double constant with the value {@value}
	 */
	public static final double CESKA_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Ceska as a double constant with the value {@value}
	 */
	public static final double CESKA_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Ceska as a double constant with the value {@value}
	 */
	public static final double CESKA_THIRD_VALUE = 10.0;
	
	/**
	 * The name of China as a string constant with the value {@value}
	 */
	public static final String CHINA = "China";
	
	/**
	 * The long name of China as a string constant with the value {@value}
	 */
	public static final String CHINA_LONGNAME = "China Light Industries Corporation";
	
	/**
	 * The core value of China as a double constant with the value {@value}
	 */
	public static final double CHINA_CORE_VALUE = 1.0;
	
	/**
	 * The first value of China as a double constant with the value {@value}
	 */
	public static final double CHINA_FIRST_VALUE = 15.0;
	
	/**
	 * The second value of China as a double constant with the value {@value}
	 */
	public static final double CHINA_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of China as a double constant with the value {@value}
	 */
	public static final double CHINA_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Douglas as a string constant with the value {@value}
	 */
	public static final String DOUGLAS = "Douglas";
	
	/**
	 * The long name of Douglas as a string constant with the value {@value}
	 */
	public static final String DOUGLAS_LONGNAME = "Douglas & Harding";
	
	/**
	 * The core value of Douglas as a double constant with the value {@value}
	 */
	public static final double DOUGLAS_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Douglas as a double constant with the value {@value}
	 */
	public static final double DOUGLAS_FIRST_VALUE = 20.0;
	
	/**
	 * The second value of Douglas as a double constant with the value {@value}
	 */
	public static final double DOUGLAS_SECOND_VALUE = 20.0;
	
	/**
	 * The third value of Douglas as a double constant with the value {@value}
	 */
	public static final double DOUGLAS_THIRD_VALUE = 20.0;
	
	/**
	 * The name of Empress as a string constant with the value {@value}
	 */
	public static final String EMPRESS = "Empress";
	
	/**
	 * The long name of Empress as a string constant with the value {@value}
	 */
	public static final String EMPRESS_LONGNAME = "Empress International";
	
	/**
	 * The core value of Empress as a double constant with the value {@value}
	 */
	public static final double EMPRESS_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Empress as a double constant with the value {@value}
	 */
	public static final double EMPRESS_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Empress as a double constant with the value {@value}
	 */
	public static final double EMPRESS_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Empress as a double constant with the value {@value}
	 */
	public static final double EMPRESS_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Fenris as a string constant with the value {@value}
	 */
	public static final String FENRIS = "Fenris";
	
	/**
	 * The long name of Fenris as a string constant with the value {@value}
	 */
	public static final String FENRIS_LONGNAME = "Fenris Group AB";
	
	/**
	 * The core value of Fenris as a double constant with the value {@value}
	 */
	public static final double FENRIS_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Fenris as a double constant with the value {@value}
	 */
	public static final double FENRIS_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Fenris as a double constant with the value {@value}
	 */
	public static final double FENRIS_SECOND_VALUE = 20.0;
	
	/**
	 * The third value of Fenris as a double constant with the value {@value}
	 */
	public static final double FENRIS_THIRD_VALUE = 20.0;
	
	/**
	 * The name of 5.11 as a string constant with the value {@value}
	 */
	public static final String FIVEELEVEN = "Fiveeleven";
	
	/**
	 * The long name of 5.11 as a string constant with the value {@value}
	 */
	public static final String FIVEELEVEN_LONGNAME = "5.11 Tactical";
	
	/**
	 * The core value of 5.11 as a double constant with the value {@value}
	 */
	public static final double FIVEELEVEN_CORE_VALUE = 0;
	
	/**
	 * The first value of 5.11 as a double constant with the value {@value}
	 */
	public static final double FIVEELEVEN_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of 5.11 as a double constant with the value {@value}
	 */	
	public static final double FIVEELEVEN_SECOND_VALUE = 15.0;
	
	/**
	 * The third value of 5.11 as a double constant with the value {@value}
	 */
	public static final double FIVEELEVEN_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Gila as a string constant with the value {@value}
	 */
	public static final String GILA = "Gila";
	
	/**
	 * The long name of Gila as a string constant with the value {@value}
	 */
	public static final String GILA_LONGNAME = "Gila Guard";
	
	/**
	 * The core value of Gila as a double constant with the value {@value}
	 */
	public static final double GILA_CORE_VALUE = 0;
	
	/**
	 * The first value of Gila as a double constant with the value {@value}
	 */
	public static final double GILA_FIRST_VALUE = 5.0;
	
	/**
	 * The second value of Gila as a double constant with the value {@value}
	 */
	public static final double GILA_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Gila as a double constant with the value {@value}
	 */
	public static final double GILA_THIRD_VALUE = 1.0;
	
	/**
	 * The name of Golan as a string constant with the value {@value}
	 */
	public static final String GOLAN = "Golan";
	
	/**
	 * The long name of Golan as a string constant with the value {@value}
	 */
	public static final String GOLAN_LONGNAME = "Golan Gear";
	
	/**
	 * The core value of Golan as a double constant with the value {@value}
	 */
	public static final double GOLAN_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Golan as a double constant with the value {@value}
	 */
	public static final double GOLAN_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Golan as a double constant with the value {@value}
	 */
	public static final double GOLAN_SECOND_VALUE = 1.0;
	
	/**
	 * The third value of Golan as a double constant with the value {@value}
	 */
	public static final double GOLAN_THIRD_VALUE = 5.0;
	
	/**
	 * The name of Grupo  as a string constant with the value {@value}
	 */
	public static final String GRUPO = "Grupo";
	
	/**
	 * The long name of Grupo as a string constant with the value {@value}
	 */	
	public static final String GRUPO_LONGNAME = "Grupo Sombra S.A.";
	
	/**
	 * The core value of Grupo as a double constant with the value {@value}
	 */
	public static final double GRUPO_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Grupo as a double constant with the value {@value}
	 */
	public static final double GRUPO_FIRST_VALUE = 15.0;
	
	/**
	 * The second value of Grupo as a double constant with the value {@value}
	 */
	public static final double GRUPO_SECOND_VALUE = 15.0;
	
	/**
	 * The third value of Grupo as a double constant with the value {@value}
	 */	
	public static final double GRUPO_THIRD_VALUE = 15.0;
	
	/**
	 * The name of Hana as a string constant with the value {@value}
	 */
	public static final String HANA = "Hana";
	
	/**
	 * The lonng name of Hana as a string constant with the value {@value}
	 */
	public static final String HANA_LONGNAME = "Hana-U Corporation";
	
	/**
	 * The core value of Hana as a double constant with the value {@value}
	 */
	public static final double HANA_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Hana as a double constant with the value {@value}
	 */
	public static final double HANA_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Hana as a double constant with the value {@value}
	 */
	public static final double HANA_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Hana as a double constant with the value {@value}
	 */
	public static final double HANA_THIRD_VALUE = 5.0;	
	
	/**
	 * The name of Murakami as a string constant with the value {@value}
	 */
	public static final String MURAKAMI = "Murakami";
	
	/**
	 * The long of Murakami as a string constant with the value {@value}
	 */
	public static final String MURAKAMI_LONGNAME = "Murakami Industries";
	
	/**
	 * The core value of Murakami as a double constant with the value {@value}
	 */
	public static final double MURAKAMI_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Murakami as a double constant with the value {@value}
	 */
	public static final double MURAKAMI_FIRST_VALUE = 20.0;
	
	/**
	 * The second value of Murakami as a double constant with the value {@value}
	 */
	public static final double MURAKAMI_SECOND_VALUE = 20.0;
	
	/**
	 * The third value of Murakami as a double constant with the value {@value}
	 */
	public static final double MURAKAMI_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Overlord as a string constant with the value {@value}
	 */
	public static final String OVERLORD = "Overlord";
	
	/**
	 * The long name of Overlord as a string constant with the value {@value}
	 */
	public static final String OVERLORD_LONGNAME = "Overlord Armaments";
	
	/**
	 * The core value of Overlord as a double constant with the value {@value}
	 */
	public static final double OVERLORD_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Overlord as a double constant with the value {@value}
	 */
	public static final double OVERLORD_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Overlord as a double constant with the value {@value}
	 */
	public static final double OVERLORD_SECOND_VALUE = 20.0;
	
	/**
	 * The third value of Overlord as a double constant with the value {@value}
	 */
	public static final double OVERLORD_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Petrov as a string constant with the value {@value}
	 */
	public static final String PETROV = "Petrov";
	
	/**
	 * The long name of Petrov as a string constant with the value {@value}
	 */
	public static final String PETROV_LONGNAME = "Petrov Defense Group";
	
	/**
	 * The core value of Petrov as a double constant with the value {@value}
	 */
	public static final double PETROV_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Petrov as a double constant with the value {@value}
	 */
	public static final double PETROV_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Petrov as a double constant with the value {@value}
	 */
	public static final double PETROV_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Petrov as a double constant with the value {@value}
	 */
	public static final double PETROV_THIRD_VALUE = 20.0;
	
	/**
	 * The name of Providence as a string constant with the value {@value}
	 */
	public static final String PROVIDENCE = "Providence";
	
	/**
	 * The long name of Providence as a string constant with the value {@value}
	 */
	public static final String PROVIDENCE_LONGNAME = "Providence Defense";
	
	/**
	 * The core value of Providence as a double constant with the value {@value}
	 */
	public static final double PROVIDENCE_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Providence as a double constant with the value {@value}
	 */
	public static final double PROVIDENCE_FIRST_VALUE = 15.0;
	
	/**
	 * The second value of Providence as a double constant with the value {@value}
	 */
	public static final double PROVIDENCE_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Providence as a double constant with the value {@value}
	 */
	public static final double PROVIDENCE_THIRD_VALUE = 15.0;
	
	/**
	 * The name of Richter as a string constant with the value {@value}
	 */
	public static final String RICHTER = "Richter";
	
	/**
	 * The long name of Richter as a string constant with the value {@value}
	 */
	public static final String RICHTER_LONGNAME = "Richter & Kaiser GmbH";
	
	/**
	 * The core value of Richter as a double constant with the value {@value}
	 */
	public static final double RICHTER_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Richter as a double constant with the value {@value}
	 */
	public static final double RICHTER_FIRST_VALUE = 20.0;
	
	/**
	 * The second value of Richter as a double constant with the value {@value}
	 */
	public static final double RICHTER_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Richter as a double constant with the value {@value}
	 */
	public static final double RICHTER_THIRD_VALUE = 20.0;
	
	/**
	 * The name of Sokolov as a string constant with the value {@value}
	 */
	public static final String SOKOLOV = "Sokolov";
	
	/**
	 *  The long name of Sokolov as a string constant with the value {@value}
	 */
	public static final String SOKOLOV_LONGNAME = "Sokolov Concern";
	
	/**
	 * The core value of Sokolv as a double constant with the value {@value}
	 */
	public static final double SOKOLOV_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Sokolv as a double constant with the value {@value}
	 */
	public static final double SOKOLOV_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Sokolv as a double constant with the value {@value}
	 */
	public static final double SOKOLOV_SECOND_VALUE = 15.0;
	
	/**
	 * The third value of Sokolv as a double constant with the value {@value}
	 */
	public static final double SOKOLOV_THIRD_VALUE = 10.0;
	
	/**
	 * The name of Walker as a string constant with the value {@value}
	 */
	public static final String WALKER = "Walker";
	
	/**
	 * The long name of Walker as a string constant with the value {@value}
	 */
	public static final String WALKER_LONGNAME = "Walker & Harris";
	
	/**
	 * The core value of Walker as a double constant with the value {@value}
	 */
	public static final double WALKER_CORE_VALUE = 0.0;
	
	/**
	 * The first value of Walker as a double constant with the value {@value}
	 */
	public static final double WALKER_FIRST_VALUE = 5.0;
	
	/**
	 * The second value of Walker as a double constant with the value {@value}
	 */
	public static final double WALKER_SECOND_VALUE = 5.0;
	
	/**
	 * The third value of Walker as a double constant with the value {@value}
	 */
	public static final double WALKER_THIRD_VALUE = 5.0;
	
	/**
	 * The name of Wyvern as a string constant with the value {@value}
	 */
	public static final String WYVERN = "Wyvern";
	
	/**
	 * The long name of Wyvern as a string constant with the value {@value}
	 */
	public static final String WYVERN_LONGNAME = "Wyvern Wear";
	
	/**
	 * The core value of Wyvern as a double constant with the value {@value}
	 */
	public static final double WYVERN_CORE_VALUE = 1.0;
	
	/**
	 * The first value of Wyvern as a double constant with the value {@value}
	 */
	public static final double WYVERN_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Wyvern as a double constant with the value {@value}
	 */
	public static final double WYVERN_SECOND_VALUE = 10.0;
	
	/**
	 * The third value of Wyvern as a double constant with the value {@value}
	 */
	public static final double WYVERN_THIRD_VALUE = 20.0;
	
	/**
	 * The name of Yaahl Gear as a string constant with the value {@value}
	 */
	public static final String YAAHL = "Yaahl";
	
	/**
	 * The long name of Yaahl as a string constant with the value {@value}
	 */
	public static final String YAAHL_LONGNAME = "Yaahl Gear";
	
	/**
	 * The core value of Yaahl as a double constant with the value {@value}
	 */
	public static final double YAAHL_CORE_VALUE = 0;
	
	/**
	 * The first value of Yaahl as a double constant with the value {@value}
	 */
	public static final double YAAHL_FIRST_VALUE = 10.0;
	
	/**
	 * The second value of Yaahl as a double constant with the value {@value}
	 */
	public static final double YAAHL_SECOND_VALUE = 5.0;
	
	/**
	 * The third value of Yaahl as a double constant with the value {@value}
	 */
	public static final double YAAHL_THIRD_VALUE = 40.0;
	
	/**
	 * Named Item equipment list
	 */
	public static final String[] manufacturerList = {
		AIRALDI, ALPS, BADGER, BELSTONE, CESKA, CHINA, DOUGLAS, EMPRESS, FENRIS, FIVEELEVEN, GILA, GOLAN, GRUPO,
		HANA, MURAKAMI, OVERLORD, PETROV, PROVIDENCE, RICHTER, SOKOLOV, WALKER, WYVERN, YAAHL
	};
	
	/**
	 * Sets the short name for a manufacturer
	 * @param name The shortname to set
	 * @return Returns an Manufacturer instance
	 */
	public Manufacturer setShortname(String name) {
		shortname = name;
		return this;
	}
	
	/**
	 * Returns the short name for the manufacturer
	 * @return Returns the shortname of the manufacturer
	 */
	public String getShortname() {
		return this.shortname;
	}	
	
	/**
	 * Constructor Build a manufacturer object on the given shortname
	 * @param name The short name i.e. Airaldi instead of Airalidi Holdings as string
	 * @throws AttributeException Throws a AttributeException if something happend deeper in the class
	 */
	public Manufacturer(String name) throws AttributeException {	
		switch(name) {
			default:
			case AIRALDI:
				this.setName(AIRALDI_LONGNAME)
					.setShortname(AIRALDI)
					.setCore(Attribute.WEAPONDAMAGE, AIRALDI_CORE_VALUE)
					.setFirst(Attribute.MARKSMANRIFLEDAMAGE, AIRALDI_FIRST_VALUE)
					.setSecond(Attribute.HEADSHOTDAMAGE, AIRALDI_SECOND_VALUE)
					.setThird(Attribute.DAMAGETOHEALTH, AIRALDI_THIRD_VALUE);
				break;
			case ALPS:
				this.setName(ALPS_LONGNAME)
					.setShortname(ALPS)
					.setCore(Attribute.SKILLTIER, ALPS_CORE_VALUE)
					.setFirst(Attribute.REPAIRSKILLS, ALPS_FIRST_VALUE)
					.setSecond(Attribute.SKILLDURATION, ALPS_SECOND_VALUE)
					.setThird(Attribute.SKILLHASTE, ALPS_THIRD_VALUE);
				break;
			case BADGER:
				this.setName(BADGER_LONGNAME)
					.setShortname(BADGER)
					.setCore(Attribute.ARMOR, BADGER_CORE_VALUE)
					.setFirst(Attribute.SHOTGUNDAMAGE, BADGER_FIRST_VALUE)
					.setSecond(Attribute.TOTALARMOR, BADGER_SECOND_VALUE)
					.setThird(Attribute.ARMORONKILL, BADGER_THIRD_VALUE);
				break;
			case BELSTONE:
				this.setName(BELSTONE_LONGNAME)
					.setShortname(BELSTONE)
					.setCore(Attribute.ARMOR, BELSTONE_CORE_VALUE)
					.setFirst(Attribute.ARMORREGEN, BELSTONE_FIRST_VALUE)
					.setSecond(Attribute.ARMORONKILL, BELSTONE_SECOND_VALUE)
					.setThird(Attribute.INCOMINGREPAIRS, BELSTONE_THIRD_VALUE);
				break;
			case CESKA:
				this.setName(CESKA_LONGNAME)
					.setShortname(CESKA)
					.setCore(Attribute.WEAPONDAMAGE, CESKA_CORE_VALUE)
					.setFirst(Attribute.CRITICALHITCHANCE, CESKA_FIRST_VALUE)
					.setSecond(Attribute.HAZARDPROTECTION, CESKA_SECOND_VALUE)
					.setThird(Attribute.HEALTH, CESKA_THIRD_VALUE);
				break;
			case CHINA:
				this.setName(CHINA_LONGNAME)
					.setShortname(CHINA)
					.setCore(Attribute.SKILLTIER, CHINA_CORE_VALUE)
					.setFirst(Attribute.EXPLOSIVESDAMAGE, CHINA_FIRST_VALUE)
					.setSecond(Attribute.SKILLHASTE, CHINA_SECOND_VALUE)
					.setThird(Attribute.STATUSEFFECTS, CHINA_THIRD_VALUE);
				break;
			case DOUGLAS:
				this.setName(DOUGLAS_LONGNAME)
					.setShortname(DOUGLAS)
					.setCore(Attribute.WEAPONDAMAGE, DOUGLAS_CORE_VALUE)
					.setFirst(Attribute.PISTOLDAMAGE, DOUGLAS_FIRST_VALUE)
					.setSecond(Attribute.STABILITY, DOUGLAS_SECOND_VALUE)
					.setThird(Attribute.ACCURACY, DOUGLAS_THIRD_VALUE);
				break;
			case EMPRESS:
				this.setName(EMPRESS_LONGNAME)
					.setShortname(EMPRESS)
					.setCore(Attribute.SKILLTIER, EMPRESS_CORE_VALUE)
					.setFirst(Attribute.SKILLHEALTH, EMPRESS_FIRST_VALUE)
					.setSecond(Attribute.SKILLDAMAGE, EMPRESS_SECOND_VALUE)
					.setThird(Attribute.SKILLEFFICIENCY, EMPRESS_THIRD_VALUE);
				break;
			case FENRIS:
				this.setName(FENRIS_LONGNAME)
					.setShortname(FENRIS)
					.setCore(Attribute.WEAPONDAMAGE, FENRIS_CORE_VALUE)
					.setFirst(Attribute.ASSAULTRIFLEDAMAGE, FENRIS_FIRST_VALUE)
					.setSecond(Attribute.RELOADSPEED, FENRIS_SECOND_VALUE)
					.setThird(Attribute.STABILITY, FENRIS_THIRD_VALUE);
				break;
			case FIVEELEVEN:
				this.setName(FIVEELEVEN_LONGNAME)
					.setShortname(FIVEELEVEN)
					.setCore(Attribute.ARMOR, FIVEELEVEN_CORE_VALUE)
					.setFirst(Attribute.HEALTH,FIVEELEVEN_FIRST_VALUE)
					.setSecond(Attribute.INCOMINGREPAIRS, FIVEELEVEN_SECOND_VALUE)
					.setThird(Attribute.HAZARDPROTECTION, FIVEELEVEN_THIRD_VALUE);
				break;
			case GILA:
				this.setName(GILA_LONGNAME)
					.setShortname(GILA)
					.setCore(Attribute.ARMOR, GILA_CORE_VALUE)
					.setFirst(Attribute.TOTALARMOR, GILA_FIRST_VALUE)
					.setSecond(Attribute.HEALTH, GILA_SECOND_VALUE)
					.setThird(Attribute.ARMORREGEN, GILA_THIRD_VALUE);
				break;
			case GOLAN:
				this.setName(GOLAN_LONGNAME)
					.setShortname(GOLAN)
					.setCore(Attribute.SKILLTIER, GOLAN_CORE_VALUE)
					.setFirst(Attribute.STATUSEFFECTS, GOLAN_FIRST_VALUE)
					.setSecond(Attribute.ARMORREGEN, GOLAN_SECOND_VALUE)
					.setThird(Attribute.TOTALARMOR, GOLAN_THIRD_VALUE);
				break;
			case GRUPO:
				this.setName(GRUPO_LONGNAME)
					.setShortname(GRUPO)
					.setCore(Attribute.WEAPONDAMAGE, GRUPO_CORE_VALUE)
					.setFirst(Attribute.CRITICALHITDAMAGE, GRUPO_FIRST_VALUE)
					.setSecond(Attribute.EXPLOSIVESDAMAGE, GRUPO_SECOND_VALUE)
					.setThird(Attribute.HEADSHOTDAMAGE, GRUPO_THIRD_VALUE);
				break;				
			case HANA:
				this.setName(HANA_LONGNAME)
					.setShortname(HANA)
					.setCore(Attribute.SKILLTIER, HANA_CORE_VALUE)
					.setFirst(Attribute.SKILLHASTE, HANA_FIRST_VALUE)
					.setSecond(Attribute.SKILLDAMAGE, HANA_SECOND_VALUE)
					.setThird(Attribute.WEAPONDAMAGE, HANA_THIRD_VALUE);
				break;
			case MURAKAMI:
				this.setName(MURAKAMI_LONGNAME)
					.setShortname(MURAKAMI)
					.setCore(Attribute.SKILLTIER, MURAKAMI_CORE_VALUE)
					.setFirst(Attribute.SKILLDURATION, MURAKAMI_FIRST_VALUE)
					.setSecond(Attribute.REPAIRSKILLS, MURAKAMI_SECOND_VALUE)
					.setThird(Attribute.SKILLDAMAGE, MURAKAMI_THIRD_VALUE);
				break;
			case OVERLORD:
				this.setName(OVERLORD_LONGNAME)
					.setShortname(OVERLORD)
					.setCore(Attribute.WEAPONDAMAGE, OVERLORD_CORE_VALUE)
					.setFirst(Attribute.RIFLEDAMAGE, OVERLORD_FIRST_VALUE)
					.setSecond(Attribute.ACCURACY, OVERLORD_SECOND_VALUE)
					.setThird(Attribute.WEAPONHANDLING, OVERLORD_THIRD_VALUE);
				break;
			case PETROV:
				this.setName(PETROV_LONGNAME)
					.setShortname(PETROV)
					.setCore(Attribute.WEAPONDAMAGE, PETROV_CORE_VALUE)
					.setFirst(Attribute.LMGDAMAGE, PETROV_FIRST_VALUE)
					.setSecond(Attribute.WEAPONHANDLING, PETROV_SECOND_VALUE)
					.setThird(Attribute.AMMOCAPACITY, PETROV_THIRD_VALUE);
				break;
			case PROVIDENCE:
				this.setName(PROVIDENCE_LONGNAME)
					.setShortname(PROVIDENCE)
					.setCore(Attribute.WEAPONDAMAGE, PROVIDENCE_CORE_VALUE)
					.setFirst(Attribute.HEADSHOTDAMAGE, PROVIDENCE_FIRST_VALUE)
					.setSecond(Attribute.CRITICALHITCHANCE, PROVIDENCE_SECOND_VALUE)
					.setThird(Attribute.CRITICALHITDAMAGE, PROVIDENCE_THIRD_VALUE);
				break;			
			case RICHTER:
				this.setName(RICHTER_LONGNAME)
					.setShortname(RICHTER)
					.setCore(Attribute.SKILLTIER, RICHTER_CORE_VALUE)
					.setFirst(Attribute.INCOMINGREPAIRS, RICHTER_FIRST_VALUE)
					.setSecond(Attribute.EXPLOSIVERESISTANCE, RICHTER_SECOND_VALUE)
					.setThird(Attribute.REPAIRSKILLS, RICHTER_THIRD_VALUE);
				break;				
			case SOKOLOV:
				this.setName(CESKA_LONGNAME)
					.setShortname(SOKOLOV)
					.setCore(Attribute.WEAPONDAMAGE, SOKOLOV_CORE_VALUE)
					.setFirst(Attribute.SMGDAMAGE, SOKOLOV_FIRST_VALUE)
					.setSecond(Attribute.CRITICALHITDAMAGE, SOKOLOV_SECOND_VALUE)
					.setThird(Attribute.CRITICALHITCHANCE, SOKOLOV_THIRD_VALUE);
				break;				
			case WALKER:
				this.setName(WALKER_LONGNAME)
					.setShortname(WALKER)
					.setCore(Attribute.WEAPONDAMAGE, WALKER_CORE_VALUE)
					.setFirst(Attribute.WEAPONDAMAGE, WALKER_FIRST_VALUE)
					.setSecond(Attribute.DAMAGETOARMOR, WALKER_SECOND_VALUE)
					.setThird(Attribute.DAMAGETOHEALTH, WALKER_THIRD_VALUE);
				break;				
			case WYVERN:
				this.setName(WYVERN_LONGNAME)
					.setShortname(WYVERN)
					.setCore(Attribute.SKILLTIER, WYVERN_CORE_VALUE)
					.setFirst(Attribute.SKILLDAMAGE, WYVERN_FIRST_VALUE)
					.setSecond(Attribute.STATUSEFFECTS, WYVERN_SECOND_VALUE)
					.setThird(Attribute.SKILLDURATION, WYVERN_THIRD_VALUE);
				break;				
			case YAAHL:
				this.setName(YAAHL_LONGNAME)
					.setShortname(YAAHL)
					.setCore(Attribute.ARMOR, YAAHL_CORE_VALUE)
					.setFirst(Attribute.HAZARDPROTECTION, YAAHL_FIRST_VALUE)
					.setSecond(Attribute.WEAPONDAMAGE, YAAHL_SECOND_VALUE)
					.setThird(Attribute.RESISTANCEPULSE, YAAHL_THIRD_VALUE);
				break;
		}
	}
	
	/**
	 * Get the attribute and corrosponding value of the manufacturer
	 * 
	 * @param amount Determines if we want the 1st, 2nd or all threed bonused to get.
	 * @return Returns the attributes and values in map
	 */
	public Map<Attribute, Double> getAttributesAndValues(int amount) {
		Map<Attribute, Double> map = new HashMap<>();
		
		// Fall through!
		switch(amount) {
			case 3:
				map.put(getThirdAttribute(), getThirdAttributeValue());
			case 2:
				map.put(getSecondAttribute(), getSecondAttributeValue());
			case 1:
				map.put(getFirstAttribute(), getFirstAttributeValue());
			default:
				map.put(getCoreAttribute(), getCoreAttributeValue());
		}
			
		return map;
	}
	
	/**
	 * Default method of returning attribute and values of a  Values as key value pair collection of
	 * {link Attribute} as key and {link Double}
	 * as value
	 * 
	 * @return Returns all attributes and values of a manufacturer 
	 */
	@Override
	public Map<Attribute, Double> getAttributesAndValues() {
		return getAttributesAndValues(3);
	}
	
	/**
	 * Sets the name of the manufacturer
	 * @param name The name to set
	 * @return Return a manufacturer instance
	 */
	@Override
	public Manufacturer setName(String name) {
		return (Manufacturer)super.setName(name);
	}

	/**
	 * Set s the core attribute and core value
	 * @param attribute The core attribute to set
	 * @param value The value to set
	 * @return Manufacturer
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */
	@Override
	public Manufacturer setCore(Attribute attribute, double value) throws AttributeException {
		return (Manufacturer) super.setCore(attribute, value);
	}
	
	/**
	 * Set s the first attribute and first value
	 * @param attribute The core attribute to set
	 * @param value The value to set
	 * @return Manufacturer
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */
	@Override
	public Manufacturer setFirst(Attribute attribute, double value) throws AttributeException {
		return (Manufacturer) super.setFirst(attribute, value);
	}
	
	/**
	 * Set s the second attribute and second value
	 * @param attribute The core attribute to set
	 * @param value The value to set
	 * @return Manufacturer
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */
	@Override
	public Manufacturer setSecond(Attribute attribute, double value) throws AttributeException {
		return (Manufacturer) super.setSecond(attribute, value);
	}	
	
	/**
	 * Set s the third attribute and third value
	 * @param attribute The core attribute to set
	 * @param value The value to set
	 * @return Manufacturer
	 * @throws AttributeException Throws an exception if the attribute or value couldn't be set
	 */
	@Override
	public Manufacturer setThird(Attribute attribute, double value) throws AttributeException {
		return (Manufacturer) super.setThird(attribute, value);
	}
	
	@Override
	public String toString() {
		return "Manufacturer [shortname=" + shortname + ", getCoreAttribute()=" + getCoreAttribute()
				+ ", getFirstAttribute()=" + getFirstAttribute() + ", getSecondAttribute()=" + getSecondAttribute()
				+ ", getThirdAttribute()=" + getThirdAttribute() + ", getCoreAttributeValue()="
				+ getCoreAttributeValue() + ", getFirstAttributeValue()=" + getFirstAttributeValue()
				+ ", getSecondAttributeValue()=" + getSecondAttributeValue() + ", getThirdAttributeValue()="
				+ getThirdAttributeValue() + "]";
	}
}