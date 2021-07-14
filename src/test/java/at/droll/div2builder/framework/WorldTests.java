package at.droll.div2builder.framework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import at.droll.div2builder.framework.inventory.Inventory;
import at.droll.div2builder.framework.inventory.InventoryException;
import at.droll.div2builder.framework.inventory.InventorySlot;
import at.droll.div2builder.framework.item.Equipment;
import at.droll.div2builder.framework.item.Weapon;
import at.droll.div2builder.framework.mod.Mod;
import at.droll.div2builder.framework.mod.ModException;
import at.droll.div2builder.framework.attribute.Attribute;
import at.droll.div2builder.framework.attribute.AttributeAbstract;
import at.droll.div2builder.framework.attribute.AttributeException;

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
	 * Create mockup inventory
	 * @return inventory
	 */
	Inventory createMockupInventory() {
		try {
			Inventory inventory;										
						
			Equipment mask = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.CESKA)
												                .setSlot(InventorySlot.MASK)
												                .setCore(Attribute.WEAPONDAMAGE, 15.0)
												                .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
												                .setThird(Attribute.CRITICALHITDAMAGE, 12.0)
												                .addMod((Mod)World.Registry.get("mod", "44"))
												                .build()
		    ;			
			
			Equipment armor = (Equipment) World.Registry.get("equipment", Equipment.THESACRIFICE)
														.setCore(Attribute.WEAPONDAMAGE, 15.0)
														.setFirst(Attribute.CRITICALHITCHANCE, 6.0)											
														.setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														.addMod((Mod)World.Registry.get("mod", "44"))
			;

			Equipment backpack = (Equipment) World.Registry.get("equipment", Equipment.THEGIFT)
														   .setCore(Attribute.WEAPONDAMAGE, 15.0)
														   .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
														   .setSecond(Attribute.CRITICALHITDAMAGE, 12.0)
														   .addMod((Mod)World.Registry.get("mod", "44"));
			;
			
			Equipment kneepad = (Equipment) World.Registry.get("equipment", Equipment.FOXSPRAYER)
														  .setCore(Attribute.WEAPONDAMAGE, 15.0)
														  .setSecond(Attribute.CRITICALHITDAMAGE, 12.0);
			
			Equipment glove = (Equipment) new Equipment.Builder()
													   .setImprovisedItem(true)
										               .setSlot(InventorySlot.GLOVE)
										               .setCore(Attribute.WEAPONDAMAGE, 15.0)
										               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
										               .setThird(Attribute.CRITICALHITDAMAGE, 12.0)
										               .addMod((Mod)World.Registry.get("mod", "44"))										               
										               .build();		
						
			Equipment holster = (Equipment) new Equipment.Builder().setManufacturer(Manufacturer.GRUPO)
													               .setSlot(InventorySlot.HOLSTER)
													               .setCore(Attribute.WEAPONDAMAGE, 15.0)
													               .setFirst(Attribute.CRITICALHITCHANCE, 6.0)
													               .setThird(Attribute.CRITICALHITDAMAGE, 12.0)
													               .build();
			
			Weapon primary = (Weapon) World.Registry.get("weapon", "Classic M1A")
													 .setFirst(Attribute.RIFLEDAMAGE, 15.0)
													 .setSecond(Attribute.CRITICALHITDAMAGE, 17.0)
													 .setThird(Attribute.DAMAGETOTARGETOUTOFCOVER, 10.0)
													 .setTalent(TalentWeapon.RIFLEMEN)
													 .setModGrip((Mod) World.Registry.get("mod", "20"))
													 .setModMag((Mod) World.Registry.get("mod", "42"))
													 .setModOptics((Mod) World.Registry.get("mod", "1"))
			;		
			
			Weapon secondary = (Weapon) World.Registry.get("weapon", "Police M4")
													  .setFirst(Attribute.ASSAULTRIFLEDAMAGE, 15.0)													  
													  .setThird(Attribute.DAMAGETOTARGETOUTOFCOVER, 10)
													  .setTalent(TalentWeapon.FASTHANDS)
													  .setModMag((Mod) World.Registry.get("mod", "28"))
													  .setModGrip((Mod) World.Registry.get("mod", "20"))
													  .setModOptics((Mod) World.Registry.get("mod", "1"))
													  .setModMuzzle((Mod) World.Registry.get("mod", "14"))
			;
			
			Weapon pistol = (Weapon) World.Registry.get("weapon", "Orbit")
												   .setCore(Attribute.PISTOLDAMAGE, 15.0)
												   .setFirst(Attribute.DAMAGETOARMOR, 6.0)
												   .setTalent(TalentWeapon.FINISHER)
												   .setModOptics((Mod) World.Registry.get("mod", "1"))
												   .setModMag((Mod) World.Registry.get("mod", "38"))
			;			
			
			inventory = world.getPlayer().getLoadout("Default").getInvetory()
										.addEquipment(InventorySlot.MASK, mask)
										.addEquipment(InventorySlot.ARMOR, armor)
										.addEquipment(InventorySlot.BACKPACK, backpack)
										.addEquipment(InventorySlot.KNEEPAD, kneepad)
										.addEquipment(InventorySlot.GLOVE, glove)
										.addEquipment(InventorySlot.HOLSTER, holster)
										.addEquipment(InventorySlot.PRIMARY, primary)
										.addEquipment(InventorySlot.SECONDARY, secondary)
										.addEquipment(InventorySlot.PISTOL, pistol)
			;
			return inventory;
		} catch(InventoryException e) {
		} catch(AttributeException e) {
		} catch(ModException e) {	
		} return null;
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
			&& values.get(Attribute.SMGDAMAGE) == 40.0
			&& values.get(Attribute.RIFLEDAMAGE) == 40.0
			&& values.get(Attribute.ASSAULTRIFLEDAMAGE) == 40.0
			&& values.get(Attribute.SHOTGUNDAMAGE) == 40.0
			&& values.get(Attribute.MARKSMANRIFLEDAMAGE) == 40.0
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
			&& inventory.getEquipment(InventorySlot.BACKPACK).getName().equals(Equipment.THEGIFT)
			&& inventory.getEquipment(InventorySlot.KNEEPAD).getName().equals(Equipment.FOXSPRAYER)
			&& ((Equipment)inventory.getEquipment(InventorySlot.GLOVE)).isImprovisedItem() == true				
			&& String.valueOf(inventory.getEquipment(InventorySlot.PRIMARY).getName()).equals("Classic M1A")
			&& String.valueOf(inventory.getEquipment(InventorySlot.SECONDARY).getName()).equals("Police M4")
			&& String.valueOf(inventory.getEquipment(InventorySlot.PISTOL).getName()).equals("Orbit")	
		);
	}
}
