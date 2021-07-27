package at.droll.div2builder.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.attribute.AttributeAbstract;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.mod.Mod;

/**
 * Tests for the world package
 * @author Marco Droll
 */
@TestInstance(Lifecycle.PER_CLASS)
class WorldTests {
	World world;	
	
	@BeforeAll
	void setUp() throws Exception {
		world = new World();
		world.bootstrap("Test", true);		
	}
		
	/**
	 * Initialze the inventory with a mockup inventory
	 * @return
	 */
	public Inventory createMockupInventory() {
		Inventory inventory = new Inventory();
		return inventory.createMockupInventory();
	}
	
	/**
	 * Test calculate Weapon Damange
	 */
	@Test
	public void testCalcWeaponDamage() {
		Inventory inventory = createMockupInventory();
		Map<String, Double> values = world.getPlayer().getLoadout("Default").getStatistic()
											   						.calculateWeaponDamage(inventory, 1d);
		
		System.out.println(values);
	}
	
	/**
	 *Should be around: 493.061 Weapon Damage
	* 60 Critical Hit Chance
	* 206.9 Critical Hit Damage
	* 95 Headshot Damages
	* 100 All Weapon Damage Bonus
	* 15% Assault Rifle Damage
	* 40% Rifle Damage Bonus
	* 15% Pistol Damage
	* 
	* Brandset Bonus:
	* 1x Ceska + 10CHC
	* 2x Providence + 15 HSD 10% CHC
	* 1x Grupo + 15 CHD
	* 1x Overlord 10% Rifle Damage
	* 
	* 10% DMG to target out of cover m1a
	* 8% dmg to target of of cover foxprayer
	 */
	@Test
	void testMockupStatistic() {
		Inventory inventory = createMockupInventory();
		
		world.getPlayer().getLoadout("Default")
						 .getStatistic()
						 .calculate(inventory);
	}
	
	/**
	 * Determine the colors of the core and minitor attribute i.e. 6 red 0 blue 0 yellow

	 */
	@Test
	void testDetermineRedYellowBlueColors() {
		Inventory inventory = createMockupInventory();
		Map<String, Map<String, Integer>> colors = world.getPlayer().getLoadout("Default").getStatistic()
											   						.determineRedYellowBlueColors(inventory);
		
		
		assertTrue(
			colors.get("core").get("red") == 6
			&& colors.get("minor").get("red") == 11
		);
	}
	
	/**
	 * Testing the default statistic values
	 */
	@Test
	void testMockupStatisticDefaultBonus() {
		@SuppressWarnings("unused")
		Inventory inventory = createMockupInventory();		
		Map<Attribute, Double> values = world.getPlayer().getLoadout("Default")
														 .getStatistic()
														 .getData();
		
		assertTrue(
			values.get(Attribute.SWAPSPEED) == 30.0
			&& values.get(Attribute.SMGDAMAGE) == 15.0
			&& values.get(Attribute.RIFLEDAMAGE) == 15.0
			&& values.get(Attribute.ASSAULTRIFLEDAMAGE) == 15.0
			&& values.get(Attribute.SHOTGUNDAMAGE) == 15.0
			&& values.get(Attribute.MARKSMANRIFLEDAMAGE) == 15.0
			&& values.get(Attribute.CRITICALHITCHANCE) == 10.0
			&& values.get(Attribute.HAZARDPROTECTION) == 10.0
		);
	}

	/**
	 * Testing the brandset bonus for the mockup inventory
	 */
	@Test
	void testMockupStatisticBrandsetBonus() {
		Inventory inventory = createMockupInventory();
		
		Map<Attribute, Double> values = world.getPlayer().getLoadout("Default")
														 .getStatistic()
														 .calculateBrandsetBonus(inventory)
		;
		
		assertTrue(
			values.get(Attribute.CRITICALHITCHANCE) == 20.0
			&& values.get(Attribute.CRITICALHITDAMAGE) == 15.0
			&& values.get(Attribute.HEADSHOTDAMAGE) == 15.0
			&& values.get(Attribute.RIFLEDAMAGE) == 10.0
		);
		
	}
	
	/**
	 * Testing plain equipment stats for the mockup inventory
	 */
	@Test
	void testMockupStatisticEquipmentBonus() {
		Inventory inventory = createMockupInventory();
		
		Map<Attribute, Double> values = world.getPlayer().getLoadout("Default")
														 .getStatistic()
														 .calculateEquipmentBonus(inventory)
		;
				
		assertTrue(
			values.get(Attribute.WEAPONDAMAGE) == 90.0
			&& values.get(Attribute.CRITICALHITCHANCE) == 30.0
			&& values.get(Attribute.DAMAGETOTARGETOUTOFCOVER) == 8.0
			&& values.get(Attribute.CRITICALHITDAMAGE) == 120
		);
	}
	
	/**
	 * Testing the weapon bonus for the mockup inventory
	 * 
	 */
	@Test
	void testMockupStatisticWeaponBonus() {
		Inventory inventory = createMockupInventory();
		
		Map<String, Map<Attribute, Double>> values = world.getPlayer().getLoadout("Default")
														 .getStatistic()
														 .calculateWeaponBonus(inventory)
		;		
		assertTrue(
			values.get("PRIMARY").get(Attribute.RIFLEDAMAGE) == 15.0
			&& values.get("PRIMARY").get(Attribute.CRITICALHITDAMAGE) == 27.0
			&& values.get("PRIMARY").get(Attribute.ROUNDS) == 5.0
			&& values.get("PRIMARY").get(Attribute.DAMAGETOTARGETOUTOFCOVER) == 10.0
			
			&& values.get("SECONDARY").get(Attribute.ASSAULTRIFLEDAMAGE) == 15.0
			&& values.get("SECONDARY").get(Attribute.DAMAGETOHEALTH) == 21.0
			&& values.get("SECONDARY").get(Attribute.ROUNDS) == 20.0
			&& values.get("SECONDARY").get(Attribute.CRITICALHITDAMAGE) == 15.0
			&& values.get("SECONDARY").get(Attribute.RELOADSPEED) == -10.0
		);
	}
	
	
	/**
	 * Test of initializing weapon into registry
	 */
	@Test
	void testInitializeweaponRegistry() {
		Weapon weapon1 = (Weapon) World.Registry.get("weapon", "Police M4");		
		Weapon weapon2 = (Weapon) World.Registry.get("weapon", "Eagle Bearer");
			
		assertTrue(
			weapon1.getBaseDamage() == 44200
			&& weapon2.getName().contains("Eagle Bearer")
		);		
	}
	
	/**
	 * Test of initializing mods into registry
	 */
	@Test
	void testInitializeModRegistry() {		
		Mod mod1 = (Mod) World.Registry.get("mod", "32");
		Mod mod2 = (Mod) World.Registry.get("mod", "49");		
		
		assertTrue(
			mod1.getName().equals("Tactical 5.56 Mag")
			&& mod2.getName().equals("Protection From Elites")
		);
	}
	
	/**
	 * Test of initializing manufacturer into registry
	 */
	@Test
	void testInitializeManufacturerRegistry() {
		Manufacturer airaldi 	= (Manufacturer) World.Registry.get("manufacturer", Manufacturer.AIRALDI);
		Manufacturer empress 	= (Manufacturer) World.Registry.get("manufacturer", Manufacturer.EMPRESS);
		Manufacturer providence = (Manufacturer) World.Registry.get("manufacturer", Manufacturer.PROVIDENCE);
		Manufacturer yaahl 		= (Manufacturer) World.Registry.get("manufacturer", Manufacturer.YAAHL);
		
		assertTrue(
			airaldi.getShortname() == Manufacturer.AIRALDI
			&& empress.getShortname() == Manufacturer.EMPRESS
			&& providence.getShortname() == Manufacturer.PROVIDENCE
			&& yaahl.getShortname() == Manufacturer.YAAHL
		);
	}
	
	/**
	 * Test of initalizing equipment into registry
	 * 
	 */
	@Test
	void testInitializeEquipmentRegistry() {
		
		AttributeAbstract item1 = World.Registry.get("equipment", Equipment.THEGIFT);		
		AttributeAbstract item2 = World.Registry.get("equipment", Equipment.THESACRIFICE);
		AttributeAbstract item3 = World.Registry.get("equipment", Equipment.FOXSPRAYER);
		
		assertTrue(
			item1.getName() == Equipment.THEGIFT
			&& item2.getName() == Equipment.THESACRIFICE
			&& item3.getName() == Equipment.FOXSPRAYER
		);
	}
	
	/**
	 * Test default loadout creation
	 */
	@Test
	void testDefaultLoadoutCreation() {
		Inventory inventory = createMockupInventory();
		
		// Check if all items are there where they should
		assertTrue(
			((Equipment)inventory.getEquipment(InventorySlot.MASK)).getManufacturer().getShortname().equals(Manufacturer.CESKA)
			&& inventory.getEquipment(InventorySlot.ARMOR).getName().equals(Equipment.THESACRIFICE)			
			&& inventory.getEquipment(InventorySlot.KNEEPAD).getName().equals(Equipment.FOXSPRAYER)
			&& ((Equipment)inventory.getEquipment(InventorySlot.GLOVE)).isImprovisedItem() == true				
			&& String.valueOf(inventory.getEquipment(InventorySlot.PRIMARY).getName()).equals("Classic M1A")
			&& String.valueOf(inventory.getEquipment(InventorySlot.SECONDARY).getName()).equals("Police M4")
			&& String.valueOf(inventory.getEquipment(InventorySlot.PISTOL).getName()).equals("Orbit")	
		);
	}
}
