package at.droll.div2builder.framework.item;
import at.droll.div2builder.framework.mod.Modable;
import at.droll.div2builder.framework.attribute.Attributable;

/**
 * Common interface of all together which use of all builders
 * @author Marco Droll
 * @see Equipment.Builder
 * @see Weapon.Builder
 */
public interface Buildable extends Attributable, Itemable, Equipmentable, Weaponable, Modable {
	
	/**
	 * Every Builder needs to implement the build method
	 * @return ItemAbstract
	 * @see ItemAbstract
	 */
	default public ItemAbstract build() {
		return null;
	}
}
