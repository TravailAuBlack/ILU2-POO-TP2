package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	
	
	@Test
	void testVerifierIdetite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Le constructeur ne doit pas etre null");
		
	}
	
	@Test
	void testVerifierIdentite() {
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
