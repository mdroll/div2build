package at.droll.div2builder.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.mod.Mod;
import at.droll.div2builder.core.mod.ModException;
import at.droll.div2builder.core.mod.Modslot;

@TestInstance(Lifecycle.PER_CLASS)
class ModTests {

	World world;	
	
	@BeforeEach
	void setUp() throws Exception {
		world = new World();
		world.bootstrap("Test", true);		
	}	

	@Test
	void testAddCorrectWeaponMod() {
		Weapon weapon = (Weapon) World.Registry.get("weapon", "Police M4");
		Mod correctMod = (Mod) World.Registry.get("mod", "28");
		
		try {
			weapon.addMod(Modslot.MAG, correctMod);
			Mod expectedMod = weapon.getModMag();
			assertTrue(correctMod.getId() == expectedMod.getId());
			
		} catch (ModException e) {
			System.err.println(e.getMessage());			
		}
	}
	
	@Test
	void testAddWrongWeaponMod2() {
		Weapon weapon = (Weapon) World.Registry.get("weapon", "Police M4");
		Mod wrongMod = (Mod) World.Registry.get("mod", "32");
		
		try {
			weapon.addMod(Modslot.MAG, wrongMod);
		} catch (ModException e) {
			System.err.println(e.getMessage());
			assertTrue(e.getMessage().contains("Mod isn't applicable to specific mod slot!"));
		}
	}

	
	@Test
	void testAddWrongWeaponMod() {
		Weapon weapon = (Weapon) World.Registry.get("weapon", "Police M4");
		Mod wrongMod = (Mod) World.Registry.get("mod", "32");
		
		try {
			weapon.addMod(Modslot.OPTICS, wrongMod);
		} catch (ModException e) {
			assertTrue(e.getMessage().contains("Mod isn't applicable to specific mod slot!"));
		}
	}

	@Test
	void testCreateWeaponMod() {
		Mod mod = new Mod(
			"1",
			Modslot.MAG,
			"Sturdy Extended 5.56 Mag",
			Attribute.ROUNDS,
			20,
			Attribute.RELOADSPEED,
			-10,
			"",
			0
		);
		assertTrue(
			mod.getName() == "Sturdy Extended 5.56 Mag"
			&& mod.getFirstAttribute() == Attribute.ROUNDS
			&& mod.getSecondAttribute() == Attribute.RELOADSPEED
		);
	}
	
	@Test
	void testCreateSimpleEquipmentMod() {
		Mod mod = new Mod("CRITICALHITDAMAGE", "Critical Hit Damage", Attribute.CRITICALHITDAMAGE, 12);
		
		System.out.println(mod);
		
		assertTrue(mod.getId() == "CRITICALHITDAMAGE");
	}
}
