package at.droll.div2builder.core.inventory;

import at.droll.div2builder.core.statistic.Statistic;

/**
 * Loadout class
 * @author Marco Droll
 */
public class Loadout {
	
	/**
	 * Holds the name of the loadout
	 */
	private String name;
	
	/**
	 * Holds the inventory
	 */
	private Inventory inventory;
	
	/**
	 * Holds the statisic of the inventory
	 */
	private Statistic statistic;
		
	/**
	 * Constructor
	 * @param keenerWatch Is the keener watch is available
	 */
	public Loadout(boolean keenerWatch) {
		this.name = "Default";
		this.inventory = new Inventory();
		this.statistic = new Statistic(keenerWatch);
	}
	
	/**
	 * Gets the name of the loadout
	 * @return Returns the name of the loadout
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the inventory
	 * @return Returns the tnventory
	 */
	public Inventory getInventory() {
		return this.inventory;
	}	
	
	/**
	 * Sets a complete inventory object
	 * @param inventory Sets the specific inventory in the loadout
	 * @return Returns the loadout
	 */
	public Loadout setInventory(Inventory inventory) {
		this.inventory = inventory;
		return this;
	}
	
	/**
	 * Return the assoicated statistic object
	 * @return Returns the statistic
	 */
	public Statistic getStatistic() {
		return this.statistic;
	}
	
	/**
	 * Sets a statistic object
	 * @param stats Statistic object to set in the loadout
	 * @return Returns the Loadout
	 */
	public Loadout setStatistic(Statistic stats) {
		this.statistic = stats;
		return this;
	}
}