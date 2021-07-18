package at.droll.div2builder.core.item;
import at.droll.div2builder.core.attribute.Attributable;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.equipment.Equipmentable;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.item.weapon.Weaponable;
import at.droll.div2builder.core.mod.Modable;

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
