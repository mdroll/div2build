package at.droll.div2builder.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import at.droll.div2builder.core.attribute.*;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.item.weapon.WeaponType;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.Modslot;

/**
 * The pseudo world in where we live and want to create loadouts
 * 
 * @author Marco Droll
 */
public class World implements Populateable {
	
	/**
	 * Holds the player object 
	 */
	private Player player;	
	
	/**
	 * Initiailize database connection
	 * @return Connection Returns an instance of datbase connection, which is used on other places
	 */ 
	private static Connection initializeDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:div2builder.db");            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
	}
	
	/**
	 * Bootstrapping method which makes the world alive
	 * @param name Playername
	 * @param keenerWatch Is keenerWatch available
	 */
	public void bootstrap(String name, boolean keenerWatch) {		
		Player player = new Player(name, keenerWatch);
		this.addPlayer(player);
		World.initializeRegistries();
	}
	
	/**
	 * Initializing all the object registries
	 * @see Registry
	 */
	private static void initializeRegistries() {	
		World.initializeManufacturerIntoRegistry();
		World.initializeEquipmentIntoRegistry();
		World.initializeModIntoRegistry();
		World.initializeWeaponIntoRegistry();
	}
	
	/**
	 * Initialize the registry with weapons
	 * @see Registry
	 * @see Weapon
	 */
	private static void initializeWeaponIntoRegistry() {
		
		Weapon weapon = null;
		
		try (Connection connection = World.initializeDatabase()) {
			
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(30);  // set timeout to 30 sec.		
		
	    	ResultSet result = stmt.executeQuery("""
	    		SELECT w.*, (
					SELECT GROUP_CONCAT(wmr.idmod) modlist
					FROM modtype mt
					INNER JOIN mod m ON mt.id = m.idmodtype
					INNER JOIN weaponmodrelation wmr ON wmr.idmod = m.id
					WHERE wmr.idweapon = w.id
					AND mt.name = 'OPTICS'
					GROUP BY mt.id	
	    		) AS opticslist,
	    		(
					SELECT GROUP_CONCAT(wmr.idmod) modlist
					FROM modtype mt
					INNER JOIN mod m ON mt.id = m.idmodtype
					INNER JOIN weaponmodrelation wmr ON wmr.idmod = m.id
					WHERE wmr.idweapon = w.id
					AND mt.name = 'MUZZLE'
					GROUP BY mt.id	
	    		) AS muzzlelist, 
	    		(
					SELECT GROUP_CONCAT(wmr.idmod) modlist
					FROM modtype mt
					INNER JOIN mod m ON mt.id = m.idmodtype
					INNER JOIN weaponmodrelation wmr ON wmr.idmod = m.id
					WHERE wmr.idweapon = w.id
					AND mt.name = 'GRIP'
					GROUP BY mt.id	
	    		) AS griplist,
	    		(
					SELECT GROUP_CONCAT(wmr.idmod) modlist
					FROM modtype mt
					INNER JOIN mod m ON mt.id = m.idmodtype
					INNER JOIN weaponmodrelation wmr ON wmr.idmod = m.id
					WHERE wmr.idweapon = w.id
					AND mt.name = 'MAG'
					GROUP BY mt.id	
	    		) AS maglist,
	    		wt.name AS weapontype
				FROM weapon w
				INNER JOIN weapontype wt ON w.idweapontype = wt.id	
				/*WHERE w.id = 2*/   		
	    	""");
    	
	    	while (result.next()) {
	    		try {
	    			weapon = (Weapon) new Weapon.Builder()
	    						.setType(WeaponType.valueOf(result.getString("weapontype")))
	    						.setName(result.getString("name"))
	    						.setExoticItem(result.getInt("exotic") == 1 ? true : false)
	    						.setNamedItem(result.getInt("named") == 1 ? true : false)
	    						.setRpm(result.getInt("rpm"))	    						
								.setMagSize(result.getInt("magsize"))								
								.setReloadSpeed(result.getDouble("reloadspeed"))
								.setBaseDamage(result.getInt("basedamage"))
								.setTalent(TalentWeapon.valueOf(result.getString("talent1")))
								.setTalent2(TalentWeapon.valueOf(result.getString("talent2")))
				    			.setAllowedModGripList(result.getString("griplist"))
								.setAllowedModMagList(result.getString("maglist"))
								.setAllowedModMuzzleList(result.getString("muzzlelist"))
								.setAllowedModOpticsList(result.getString("opticslist"))
								.build()
					;	    			
	    			World.Registry.set("weapon", weapon.getName(), weapon);
    		
	    		} catch(Exception e) {
	    			System.err.println(e.getMessage());
	    		} 
	    	}    	
		}  catch(SQLException e) {
	    	System.err.println(e.getMessage());
	    }
	}
	
	/**
	 * Initialize the registry with equipment
	 * @see Registry
	 * @see Equipment
	 */
	private static void initializeEquipmentIntoRegistry() {
		for(String itemName : Equipment.namedEquipmentItemList) {
			
			Equipment item = (Equipment) new Equipment.Builder()
													  .setName(itemName)
													  .build();			
			World.Registry.set("equipment", itemName, item);		
		}
	}	
	
	/**
	 * Initialize the registry with manufacturer
	 * @see Registry
	 * @see Manufacturer
	 */
	private static void initializeManufacturerIntoRegistry() {
		try {
			for (String name : Manufacturer.manufacturerList) {
				Manufacturer manufacturer = new Manufacturer(name);
				World.Registry.set("manufacturer", name, manufacturer);
			}			

		} catch(AttributeException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Initialize the registry with mods
	 * @see World.Registry
	 * @see Mod
	 */
	private static void initializeModIntoRegistry() {
		Mod mod = null;
		
		try (Connection connection = World.initializeDatabase()) {		
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(30);  // set timeout to 30 sec.
	    	
	    	ResultSet result = stmt.executeQuery("""
	    		SELECT m.*, mt.name modtype
	    		FROM mod m
	    		INNER JOIN modtype mt ON m.idmodtype = mt.id	    		
	    	""");
	    	
        	while (result.next()) {
        		
        		if (result.getString("modtype").equals("EQUIPMENT")) {
        			mod = new Mod(
        					result.getInt("id"),
        					result.getString("name"),
        					Attribute.valueOf(result.getString("firstAttribute")),
        					result.getDouble("firstAttributeValue")
        			);
        			
        		} else {
        			mod = new Mod(
        				result.getInt("id"),
        				Modslot.valueOf(result.getString("modtype")),
        				result.getString("name"),
        				Attribute.valueOf(result.getString("firstAttribute")),
        				result.getDouble("firstAttributeValue"),
        				Attribute.valueOf(result.getString("secondAttribute")),
        				result.getDouble("secondAttributeValue"),
        				result.getString("requiredspecialization"),
        				result.getInt("exotic")
        			);
        		}
        		// TODO Instead of mod.getId() use result.getString("name"). addMod(44) instead of addMod("CRITICAL HIT CHANCE")?
        		World.Registry.set("mod", String.valueOf(mod.getId()), mod);
        	}        	
	    	
		} catch(SQLException e) {
        	System.err.println(e.getMessage());
        } 
	}
	
	/**
	 * Returns the player out of the world
	 * @return Player object
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Adding a player to the world
	 * @param player Player object to add
	 * @return Instance of the world
	 */
	@Override
	public Populateable addPlayer(Player player) {
		this.player = player;
		return this;
	}

	/**
	 * Remove a before added player to the world
	 * @return Instance of the world
	 */
	@Override
	public World removePlayer() {
		this.player = null;
		return this;
	}
	
	/**
	 * Registry (Registry pattern) of all kind of equipment, manufacturer, weapon and mods
	 * @author Marco Droll
	 */
	public static class Registry {

		/**
		 * Registry Pattern holds a lot of singleton instances of weapon, mods, manufacturer 
		 */
		private static final HashMap<String, HashMap<String, AttributeAbstract>> registry = new HashMap<>();
		
		/**
		 * Static initialisator
		 */
		static {
			Registry.registry.put("equipment", new HashMap<String, AttributeAbstract>());
			Registry.registry.put("manufacturer", new HashMap<String, AttributeAbstract>());
			Registry.registry.put("weapon", new HashMap<String, AttributeAbstract>());
			Registry.registry.put("mod", new HashMap<String, AttributeAbstract>());
		}
		
		/**
		 * Private constructor
		 */
		private Registry() {
			super();
		}
		
		/**
		 * Set specific object in the registry
		 * 
		 * @param type type element, mod or weapon type
		 * @param key Identnfier in the Registry
		 * @param object The object itself to store
		 * @return true or false if it was successful
		 */
		public static boolean set(String type, String key, AttributeAbstract object) {
						
			if (registry.get(type).containsKey(key) == false) {
				registry.get(type).put(key, object);
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Get element from the registry
		 * 
		 * @param type equipment, mod or weapon type
		 * @param key Identifier in the Registry / id or name
		 * @return Returns the abstract object from the specified type 
		 */
		public static AttributeAbstract get(String type, String key) {
			if (registry.get(type).containsKey(key) == true) {
				return registry.get(type).get(key);
			} else {
				return null;
			}
		}
	}
}
