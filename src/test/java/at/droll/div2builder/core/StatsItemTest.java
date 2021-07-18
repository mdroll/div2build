package at.droll.div2builder.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.statistic.StatsItem;

class StatsItemTest {

	/**
	 * Testing create dummy StatsItem
	 */
	@Test
	void testCreateDummy() {
		
		StatsItem item = new StatsItem("Offensive", "...");
		
		assertTrue(
			item.getAttribute() == "Offensive"	
			&& item.getValue() == "..."
			&& item.getCategory() == ""
		);
	}
	
	/**
	 * Testing  create Attribute and correct value attribute
	 */
	@Test
	void testCreateAttributeValue() {
		StatsItem item = new StatsItem(Attribute.CRITICALHITCHANCE, 6.0);
		
		assertTrue(
			item.getAttribute() == Attribute.CRITICALHITCHANCE.toString()
			&& Double.parseDouble(item.getValue()) == 6.0
			&& item.getCategory() == "offensive"
		);
	}

}
