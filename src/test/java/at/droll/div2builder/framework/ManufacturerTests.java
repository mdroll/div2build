package at.droll.div2builder.framework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import at.droll.div2builder.framework.attribute.Attribute;
import static at.droll.div2builder.framework.Manufacturer.*;

@TestInstance(Lifecycle.PER_CLASS)
class ManufacturerTests {
	
	World world;
	
	@BeforeEach
	void setUp() throws Exception {
		world = new World();
		world.bootstrap("Test", true);		
	}

	@Test
	void testAiraldi() {	
		String manuname = "Airaldi";
		Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
		
		assertTrue(
			manu.getShortname() == manuname
			&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
			&& manu.getFirstAttribute() == Attribute.MARKSMANRIFLEDAMAGE
			&& manu.getSecondAttribute() == Attribute.HEADSHOTDAMAGE
			&& manu.getThirdAttribute() == Attribute.DAMAGETOHEALTH
			&& Double.compare((double)manu.getCoreAttributeValue(), (double) AIRALDI_CORE_VALUE) == 0
			&& Double.compare((double)manu.getCoreAttributeValue(), (double) AIRALDI_CORE_VALUE) == 0
			&& Double.compare((double)manu.getFirstAttributeValue(), (double) AIRALDI_FIRST_VALUE) == 0
			&& Double.compare((double)manu.getSecondAttributeValue(), (double) AIRALDI_SECOND_VALUE) == 0
			&& Double.compare((double)manu.getThirdAttributeValue(), (double) AIRALDI_THIRD_VALUE) == 0
		);
	}	

	@Test
	void testAlps() {					
		String manuname = "Alps";
		Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
		
		assertTrue(
			manu.getShortname() == manuname
			&& manu.getCoreAttribute() == Attribute.SKILLTIER
			&& manu.getFirstAttribute() == Attribute.REPAIRSKILLS
			&& manu.getSecondAttribute() == Attribute.SKILLDURATION
			&& manu.getThirdAttribute() == Attribute.SKILLHASTE
			&& Double.compare((double)manu.getCoreAttributeValue(), (double) ALPS_CORE_VALUE) == 0
			&& Double.compare((double)manu.getFirstAttributeValue(), (double) ALPS_FIRST_VALUE) == 0
			&& Double.compare((double)manu.getSecondAttributeValue(), (double) ALPS_SECOND_VALUE) == 0
			&& Double.compare((double)manu.getThirdAttributeValue(), (double) ALPS_THIRD_VALUE) == 0
		);		
	}
	
	@Test
	void testBadger() {
		
			String manuname = "Badger";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);			
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.ARMOR
				&& manu.getFirstAttribute() == Attribute.SHOTGUNDAMAGE
				&& manu.getSecondAttribute() == Attribute.TOTALARMOR
				&& manu.getThirdAttribute() == Attribute.ARMORONKILL
				&& Integer.compare((int)manu.getCoreAttributeValue(), (int) BADGER_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) BADGER_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) BADGER_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) BADGER_THIRD_VALUE) == 0
			);
			
		
		
	}
	
	@Test
	void testBelstone() {
		
			String manuname = "Belstone";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);			
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.ARMOR
				&& manu.getFirstAttribute() == Attribute.ARMORREGEN
				&& manu.getSecondAttribute() == Attribute.ARMORONKILL
				&& manu.getThirdAttribute() == Attribute.INCOMINGREPAIRS
				&& Integer.compare((int)manu.getCoreAttributeValue(), (int) BELSTONE_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) BELSTONE_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) BELSTONE_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) BELSTONE_THIRD_VALUE) == 0
			);
			
		
	}
	
	@Test
	void testCeska() {
					
			String manuname = "Ceska";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.CRITICALHITCHANCE
				&& manu.getSecondAttribute() == Attribute.HAZARDPROTECTION
				&& manu.getThirdAttribute() == Attribute.HEALTH
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) CESKA_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) CESKA_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) CESKA_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) CESKA_THIRD_VALUE) == 0
			);
			
		
	}	
	
	@Test
	void testChina() {
					
			String manuname = "China";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.EXPLOSIVESDAMAGE
				&& manu.getSecondAttribute() == Attribute.SKILLHASTE
				&& manu.getThirdAttribute() == Attribute.STATUSEFFECTS
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) CHINA_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) CHINA_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) CHINA_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) CHINA_THIRD_VALUE) == 0
			);
			
		
	}	
	
	@Test
	void testDouglas() {
					
			String manuname = "Douglas";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.PISTOLDAMAGE
				&& manu.getSecondAttribute() == Attribute.STABILITY
				&& manu.getThirdAttribute() == Attribute.ACCURACY
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) DOUGLAS_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) DOUGLAS_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) DOUGLAS_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) DOUGLAS_THIRD_VALUE) == 0
			);
		
	}
	
	@Test
	void testEmpress() {
					
			String manuname = "Empress";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.SKILLHEALTH
				&& manu.getSecondAttribute() == Attribute.SKILLDAMAGE
				&& manu.getThirdAttribute() == Attribute.SKILLEFFICIENCY
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) EMPRESS_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) EMPRESS_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) EMPRESS_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) EMPRESS_THIRD_VALUE) == 0
			);
			
		
	}	
	
	@Test
	void testFenris() {
					
			String manuname = "Fenris";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.ASSAULTRIFLEDAMAGE
				&& manu.getSecondAttribute() == Attribute.RELOADSPEED
				&& manu.getThirdAttribute() == Attribute.STABILITY
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) FENRIS_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) FENRIS_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) FENRIS_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) FENRIS_THIRD_VALUE) == 0
			);
			
		
	}	
	
	@Test
	void testFiveeleven() {
		
			String manuname = "Fiveeleven";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);			
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.ARMOR
				&& manu.getFirstAttribute() == Attribute.HEALTH
				&& manu.getSecondAttribute() == Attribute.INCOMINGREPAIRS
				&& manu.getThirdAttribute() == Attribute.HAZARDPROTECTION
				&& Integer.compare((int)manu.getCoreAttributeValue(), (int) FIVEELEVEN_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) FIVEELEVEN_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) FIVEELEVEN_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) FIVEELEVEN_THIRD_VALUE) == 0
			);
		
	}
	
	@Test
	void testGila() {
		
			String manuname = "Gila";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);			
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.ARMOR
				&& manu.getFirstAttribute() == Attribute.TOTALARMOR
				&& manu.getSecondAttribute() == Attribute.HEALTH
				&& manu.getThirdAttribute() == Attribute.ARMORREGEN
				&& Integer.compare((int)manu.getCoreAttributeValue(), (int) GILA_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) GILA_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) GILA_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) GILA_THIRD_VALUE) == 0
			);
			
		
	}
	
	
	@Test
	void testGolan() {
					
			String manuname = "Golan";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.STATUSEFFECTS
				&& manu.getSecondAttribute() == Attribute.ARMORREGEN
				&& manu.getThirdAttribute() == Attribute.TOTALARMOR
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) GOLAN_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) GOLAN_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) GOLAN_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) GOLAN_THIRD_VALUE) == 0
			);
			
		
	}
	
	@Test
	void testGrupo() {
					
			String manuname = "Grupo";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.CRITICALHITDAMAGE
				&& manu.getSecondAttribute() == Attribute.EXPLOSIVESDAMAGE
				&& manu.getThirdAttribute() == Attribute.HEADSHOTDAMAGE
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) GRUPO_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) GRUPO_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) GRUPO_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) GRUPO_THIRD_VALUE) == 0
			);
			
		
	}
	
	@Test
	void testHana() {
					
			String manuname = "Hana";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.SKILLHASTE
				&& manu.getSecondAttribute() == Attribute.SKILLDAMAGE
				&& manu.getThirdAttribute() == Attribute.WEAPONDAMAGE
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) HANA_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) HANA_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) HANA_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) HANA_THIRD_VALUE) == 0
			);
			
		
		
	}

	@Test
	void testMurakami() {
					
			String manuname = "Murakami";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.SKILLDURATION
				&& manu.getSecondAttribute() == Attribute.REPAIRSKILLS
				&& manu.getThirdAttribute() == Attribute.SKILLDAMAGE
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) MURAKAMI_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) MURAKAMI_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) MURAKAMI_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) MURAKAMI_THIRD_VALUE) == 0
			);
			
		
	}
	
	@Test
	void testOverlord() {
					
			String manuname = "Overlord";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.RIFLEDAMAGE
				&& manu.getSecondAttribute() == Attribute.ACCURACY
				&& manu.getThirdAttribute() == Attribute.WEAPONHANDLING
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) OVERLORD_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) OVERLORD_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) OVERLORD_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) OVERLORD_THIRD_VALUE) == 0
			);
		
	}	
	
	@Test
	void testPetrov() {
					
			String manuname = "Petrov";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.LMGDAMAGE
				&& manu.getSecondAttribute() == Attribute.WEAPONHANDLING
				&& manu.getThirdAttribute() == Attribute.AMMOCAPACITY
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) PETROV_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) PETROV_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) PETROV_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) PETROV_THIRD_VALUE) == 0
			);
			
		
	}
	
	@Test
	void testProvidence() {
					
			String manuname = "Providence";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.HEADSHOTDAMAGE
				&& manu.getSecondAttribute() == Attribute.CRITICALHITCHANCE
				&& manu.getThirdAttribute() == Attribute.CRITICALHITDAMAGE
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) PROVIDENCE_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) PROVIDENCE_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) PROVIDENCE_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) PROVIDENCE_THIRD_VALUE) == 0
			);
			
		
	}	
	
	@Test
	void testRichter() {
					
			String manuname = "Richter";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.INCOMINGREPAIRS
				&& manu.getSecondAttribute() == Attribute.EXPLOSIVERESISTANCE
				&& manu.getThirdAttribute() == Attribute.REPAIRSKILLS
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) RICHTER_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) RICHTER_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) RICHTER_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) RICHTER_THIRD_VALUE) == 0
			);
			
	}	
	
	@Test
	void testSokokolv() {
					
			String manuname = "Sokolov";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.SMGDAMAGE
				&& manu.getSecondAttribute() == Attribute.CRITICALHITDAMAGE
				&& manu.getThirdAttribute() == Attribute.CRITICALHITCHANCE
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) SOKOLOV_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) SOKOLOV_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) SOKOLOV_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) SOKOLOV_THIRD_VALUE) == 0
			);		
		
	}
	
	@Test
	void testWalker() {
					
			String manuname = "Walker";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getFirstAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getSecondAttribute() == Attribute.DAMAGETOARMOR
				&& manu.getThirdAttribute() == Attribute.DAMAGETOHEALTH
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) WALKER_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) WALKER_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) WALKER_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) WALKER_THIRD_VALUE) == 0
			);
	}
	
	@Test
	void testWyvern() {
					
			String manuname = "Wyvern";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.SKILLTIER
				&& manu.getFirstAttribute() == Attribute.SKILLDAMAGE
				&& manu.getSecondAttribute() == Attribute.STATUSEFFECTS
				&& manu.getThirdAttribute() == Attribute.SKILLDURATION
				&& Double.compare((double)manu.getCoreAttributeValue(), (double) WYVERN_CORE_VALUE) == 0
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) WYVERN_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) WYVERN_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) WYVERN_THIRD_VALUE) == 0
			);
	}
	
	@Test
	void testYaahl() {
					
			String manuname = "Yaahl";
			Manufacturer manu = (Manufacturer) World.Registry.get("manufacturer", manuname);
			
			assertTrue(
				manu.getShortname() == manuname
				&& manu.getCoreAttribute() == Attribute.ARMOR
				&& manu.getFirstAttribute() == Attribute.HAZARDPROTECTION
				&& manu.getSecondAttribute() == Attribute.WEAPONDAMAGE
				&& manu.getThirdAttribute() == Attribute.RESISTANCEPULSE
				&& Integer.compare((int)manu.getCoreAttributeValue(), (int) YAAHL_CORE_VALUE) == 0				
				&& Double.compare((double)manu.getFirstAttributeValue(), (double) YAAHL_FIRST_VALUE) == 0
				&& Double.compare((double)manu.getSecondAttributeValue(), (double) YAAHL_SECOND_VALUE) == 0
				&& Double.compare((double)manu.getThirdAttributeValue(), (double) YAAHL_THIRD_VALUE) == 0
			);
	}
}
