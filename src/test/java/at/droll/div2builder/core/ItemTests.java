package at.droll.div2builder.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import at.droll.div2builder.core.inventory.InventoryException;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;

@TestInstance(Lifecycle.PER_CLASS)
class ItemTests {

	World world;
	
	@BeforeEach
	void setUp() throws Exception {
		world = new World();
		world.bootstrap("Test", true);		
	}
	
	/**
	 * Test Named Item Zero F's
	 */
	@Test
	void testNamedItemZeroFs() {
		String itemName = Equipment.ZEROFS;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.BADGER
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.UNBREAKABLE
		);
	}
	
	
	/**
	 * Test Named Item Vedmedytsya Vest
	 */
	@Test
	void testNamedItemVedmedytsyaVest() {
		String itemName = Equipment.VEDMEDYTSYAVEST;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.PETROV
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.BRACED
		);
	}
	
	/**
	 * Test Named Item The Gift
	 */
	@Test
	void testNamedItemTheSacrifice() {
		String itemName = Equipment.THESACRIFICE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.PROVIDENCE
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.GLASSCANNON
		);
	}
	
	/**
	 * Test Named Item The Hollow Man
	 */
	@Test
	void testNamedItemTheHollowMan() {
		String itemName = Equipment.THEHOLLOWMAN;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.YAAHL
			&& item.getSlot() == InventorySlot.MASK	
		);
	}
	
	/**
	 * Test Named Item The Gift
	 */
	@Test
	void testNamedItemTheGift() {
		String itemName = Equipment.THEGIFT;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.PROVIDENCE
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.VIGILIANCE
		);
	}
	
	/**
	 * Test Named Item Prestine Example
	 */
	@Test
	void testNamedItemStrategicAlignment() {
		String itemName = Equipment.STRATEGICALIGNMENT;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.CHINA
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.SHOCKANDAWE
		);
	}
	
	/**
	 * Test Named Item Punch Drunk
	 */
	@Test
	void testNamedItemPunchDrunk() {
		String itemName = Equipment.PUNCHDRUNK;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.DOUGLAS
			&& item.getSlot() == InventorySlot.MASK			
		);
	}
	
	/**
	 * Test Named Item Prestine Example
	 */
	@Test
	void testNamedItemPrestineExample() {
		String itemName = Equipment.PRESTINEEXAMPLE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.AIRALDI
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.FOCUS
		);
	}
	
	/**
	 * Test Named Item Pointman
	 */
	@Test
	void testNamedItePointman() {
		String itemName = Equipment.POINTMAN;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.GILA
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.VANGUARD
		);
	}
	
	/**
	 * Test Named Item Percussive Maintenance
	 */
	@Test
	void testNamedItePercussiveMaintenance() {
		String itemName = Equipment.PERCUSSIVEMAINTENANCE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.ALPS
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.TECHSUPPORT
		);
	}	
	
	/**
	 * Test Named Item LiquidEngineer
	 */
	@Test
	void testNamedItemNightwatcher() {
		String itemName = Equipment.NIGHTWATCHER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.GILA
			&& item.getSlot() == InventorySlot.MASK			
		);
	}
	
	/**
	 * Test Named Item MotherlyGloves
	 */
	@Test
	void testNamedItemMotherlyGloves() {
		String itemName = Equipment.MOTHERLYGLOVES;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.ALPS
			&& item.getSlot() == InventorySlot.GLOVE			
		);
	}
	
	/**
	 * Test Named Item Matador
	 */
	@Test
	void testNamedItemMatador() {
		String itemName = Equipment.MATADOR;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.WALKER
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.ADRENALINRUSH
		);
	}
	
	/**
	 * Test Named Item LiquidEngineer
	 */
	@Test
	void testNamedItemLiquidEngineer() {
		String itemName = Equipment.LIQUIDENGINEER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.BELSTONE
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.BLOODSUCKER
		);
	}
	
	/**
	 * Test Named Item Hunter Killer
	 */
	@Test
	void testNamedItemHunterKiller() {
		String itemName = Equipment.HUNTERKILLER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.GOLAN
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.INITMIDATE
		);
	}
	
	/**
	 * Test Named Item Fox's Prayer
	 */
	@Test
	void testNamedItemFoxsPrayer() {
		String itemName = Equipment.FOXSPRAYER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.OVERLORD
			&& item.getSlot() == InventorySlot.KNEEPAD			
		);
	}
	
	/**
	 * Test Named Item Forge
	 */
	@Test
	void testNamedItemForge() {
		String itemName = Equipment.FORGE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.RICHTER
			&& item.getSlot() == InventorySlot.HOLSTER	
		);
	}
	
	/**
	 * Test Named Item Force Multiplier
	 */
	@Test
	void testNamedItemForceMultiplier() {
		String itemName = Equipment.FORCEMULTIPLIER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.HANA
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.COMBINEDARMS
		);
	}
	
	/**
	 * Test Named Item Firm Handshake
	 */
	@Test
	void testNamedItemFirmHandshake() {
		String itemName = Equipment.FIRMHANDSHAKE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.SOKOLOV
			&& item.getSlot() == InventorySlot.GLOVE			
		);
	}
	
	/**
	 * Test Named Item Everyday Carrier
	 */
	@Test
	void testNamedItemFerociousCalm() {
		String itemName = Equipment.FEROCIOUSCALM;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.FENRIS
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.OVERWATCH
		);
	}
	
	/**
	 * Test Named Item Everyday Carrier
	 */
	@Test
	void testNamedItemEverydayCarrier() {
		String itemName = Equipment.EVERYDAYCARRIER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.BELSTONE
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.EFFICIENT
		);
	}
	
	/**
	 * Test Named Item Death Grips
	 */
	@Test
	void testNamedItemEmperorsGuard() {
		String itemName = Equipment.EMPERORSGUARD;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.MURAKAMI
			&& item.getSlot() == InventorySlot.KNEEPAD
		);
	}
	
	/**
	 * Test Named Item Door-Kicker's Knock
	 */
	@Test
	void testNamedItemDoorKickersKnock() {
		String itemName = Equipment.DOORKICKERSKNOCK;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.GRUPO
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.SPARK
		);
	}
	
	/**
	 * Test Named Item Devil's Due
	 */
	@Test
	void testNamedItemDevilsDue() {
		String itemName = Equipment.DEVILSDUE;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.CESKA
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.CLUTCH
		);
	}
	
	/**
	 * Test Named Item Death Grips
	 */
	@Test
	void testNamedItemDeathGrips() {
		String itemName = Equipment.DEATHGRIPS;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.FIVEELEVEN
			&& item.getSlot() == InventorySlot.GLOVE
		);
	}
	
	
	/**
	 * Test Named Item Claws Out
	 */
	@Test
	void testNamedItemClawsOut() {
		String itemName = Equipment.CLAWSOUT;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.WYVERN
			&& item.getSlot() == InventorySlot.HOLSTER
		);
	}
	
	/**
	 * Test Named Item Contractor's Gloves
	 */
	@Test
	void testNamedItemContractorsGlove() {
		String itemName = Equipment.CONTRACTORSGLOVES;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.PETROV
			&& item.getSlot() == InventorySlot.GLOVE
		);
	}
	
	
	/**
	 * Test Named Item Chainkiller
	 */
	@Test
	void testNamedItemChainkiller() {
		String itemName = Equipment.CHAINKILLER;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.WALKER
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.HEADHUNTER
		);
	}
	
	/**
	 * Test Named Item Caesars Guard
	 */
	@Test
	void testNamedItemCaesarsGuard() {
		String itemName = Equipment.CAESARSGUARD;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.EMPRESS
			&& item.getSlot() == InventorySlot.ARMOR
			&& item.getTalent() == Talent.SKILLED
		);
	}
	
	/**
	 * Test Named Item Battery Pack
	 */
	@Test
	void testNamedItemBatteryPack() {
		String itemName = Equipment.BATTERYPACK;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.EMPRESS
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.CALCULATED
		);
	}
	
	/**
	 * Test Named Item Anarchist's Cookbook
	 */
	@Test
	void testNamedItemAnarchistsCookbook() {
		String itemName = Equipment.ANARCHISTSCOOKBOOK;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.GOLAN
			&& item.getSlot() == InventorySlot.BACKPACK
			&& item.getTalent() == Talent.WICKED
		);
	}	
	
	/**
	 * Test Named Item Ammo dump
	 */
	@Test
	void testNamedItemAmmoDump() {
		String itemName = Equipment.AMMODUMP;
		Equipment item = (Equipment) new Equipment.Builder()
						.setName(itemName)
						.build();
		
		assertTrue(
			item.getName() == itemName
			&& item.getManufacturer().getShortname() == Manufacturer.BADGER
			&& item.getSlot() == InventorySlot.HOLSTER
		);
	}
	
	/**
	 * Test if a talent can be changed on a a named BACKPACK item
	 */
	@Test
	void testEquipmentChangeTalentFail2() {
		
		try {
			Equipment item = (Equipment) new Equipment.Builder()
							.setName(Equipment.THEGIFT)
							.build();
			item.setTalent(Talent.ADRENALINRUSH);
		
		} catch(InventoryException e) {
			assertTrue(e.getMessage().contains("Talent can't be changed due item is a named backpack/armor item"));
		}
	}
	
	/**
	 * Test if a talent can be changed on a non BACKBACK / ARMOR
	 */
	@Test
	void testEquipmentChangeTalentFail() {
		
		try {
			Equipment item = (Equipment) new Equipment.Builder()
					.setSlot(InventorySlot.KNEEPAD)
					.setManufacturer(Manufacturer.PROVIDENCE)
					.build();
			
			item.setTalent(Talent.ADRENALINRUSH);
		
		} catch(InventoryException e) {
			assertTrue(e.getMessage().contains("Talent can't be changed due to item isn't a backpack or armor chest!"));
		}
	}
	
	/**
	 * Test if a talent can be changed on a BACKBACK / ARMOR
	 */
	@Test
	void testEquipmentChangeTalentSuccess() {
		
		try {
			Equipment item = (Equipment) new Equipment.Builder()
					.setSlot(InventorySlot.BACKPACK)
					.setManufacturer(Manufacturer.PROVIDENCE)
					.setTalent(Talent.BLOODSUCKER)
					.build();
			
			item.setTalent(Talent.ADRENALINRUSH);
			assertTrue(item.getTalent() == Talent.ADRENALINRUSH);			
		} catch(InventoryException e) {
		}
	}
	
	/**
	 * Test if a named item can be created
	 * Check if Attribute isNamedItem is setted correct
	 * Check if manufacturer is setted correct - and its values are correct
	 * Check if 
	 */
	@Test
	void testNamedEquipment() {
		Equipment item = (Equipment) new Equipment.Builder()
				.setName(Equipment.AMMODUMP)
				.build();
		
		assertTrue(
			item.getName() == Equipment.AMMODUMP
			&& item.isNamedItem() == true
			&& item.getManufacturer().getShortname() == Manufacturer.BADGER
			&& item.getManufacturer().getCoreAttributeValue() == Manufacturer.BADGER_CORE_VALUE
		);
	}
	
	/**
	 * Test if an simple normal item can be builded
	 */
	@Test
	void testCreateSimpleEquipmentItem() {
		Equipment item;
		try {
			item = (Equipment) new Equipment.Builder()
					.setSlot(InventorySlot.BACKPACK)
					.setManufacturer(Manufacturer.AIRALDI)
					.setTalent(Talent.VIGILIANCE)
					.build();
						
			
			assertTrue(
					item instanceof Equipment
					&& item.getSlot() == InventorySlot.BACKPACK
					&& item.getManufacturer().getShortname() == Manufacturer.AIRALDI
					&& item.getTalent() == Talent.VIGILIANCE
			);
			
		} catch (InventoryException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Test if an improvised item can't be builded if it's not the correct item slot
	 */
	@Test
	void testCreateEquipmentImprovisedItemFail() {
		try {
			@SuppressWarnings("unused")
			Equipment item = (Equipment) new Equipment.Builder()		
					.setSlot(InventorySlot.ARMOR)
					.setImprovisedItem(true)
					.build();
		} catch(InventoryException e) {
			assertTrue(e.getMessage().contains("Can't create an improsived item on"));			
		}
	}
	
	/**
	 * Test if an improvised item can be builded
	 */
	@Test
	void testCreateEquipmentImprovisedItem() {
		try {
			Equipment item = (Equipment) new Equipment.Builder()
													.setImprovisedItem(true)
													.setSlot(InventorySlot.KNEEPAD)											
													.build();
			assertTrue(
				item instanceof Equipment
				&& item.isImprovisedItem() == true
				&& item.getSlot() == InventorySlot.KNEEPAD
			);
		} catch(InventoryException e) {
			
		}
	}
	
	/**
	 * Test if a simple weapon can be builded 
	 */
	@Test
	void testCreateSimpleWeapon() {
		Weapon item = (Weapon) new Weapon.Builder()
										.setName("Police M4")
										.setRpm(850)
										.setBaseDamage(10000)
										.setMagSize(30)
										.setTalent(TalentWeapon.FASTHANDS)
										.setReloadSpeed(2.4)											
										.build();
		assertTrue(
			item instanceof Weapon
			&& item.getName() == "Police M4"
			&& item.getRpm() == 850
			&& item.getMagSize() == 30
			&& item.getTalent() == TalentWeapon.FASTHANDS
			&& Double.compare(item.getReloadSpeed(), 2.4) == 0
		);
	}
}
