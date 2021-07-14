package at.droll.div2builder.framework;

import java.util.HashMap;

import at.droll.div2builder.framework.inventory.*;

/**
 * 
 * @author Marco Droll
 */
public class Player {

	/**
	 * Player name
	 */
	private String name;
	
	/**
	 * Stores loadouts by name. First we working just with one loadout
	 */
	private HashMap<String, Loadout> loadout = new HashMap<>();
	
	/**
	 * Parameterized constructor 
	 * @param name Name of the player
	 * @param keenerWatch Is Level 40 Reached and the Keener Watch unlocked (SHD Level 1000 reached)
	 */
	public Player(String name, boolean keenerWatch) {
		Loadout loadout = new Loadout(keenerWatch);
		this.name = name;
		this.loadout.put(loadout.getName(), loadout);		
	}
	
	/**
	 * Returns a loadout
	 * @param name The name of the loadout to get
	 * @return Returnts the loadout
	 */
	public Loadout getLoadout(String name) {
		return this.loadout.get(name);	
	}	
	
	/**
	 * Return the player name
	 * @return Returns the player name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Set the player name and returns an iown instance
	 * @param name Sets the name of the player
	 * @return Returns an instance of PLayer pbject
	 */
	public Player setName(String name) {
		this.name = name;
		return this;
	}
}