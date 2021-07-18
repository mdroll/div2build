package at.droll.div2builder.core;

/**
 * Populaable Interface
 * @author Marco Droll
 */
public interface Populateable {
	
	/**
	 * Adds Player
	 * @param player Player to add
	 * @return Returns Populateable instance 
	 */
	public Populateable addPlayer(Player player);
	
	/**
	 * Removes the player from the world
	 * @return Returns a world instance
	 */
	public World removePlayer();
}
