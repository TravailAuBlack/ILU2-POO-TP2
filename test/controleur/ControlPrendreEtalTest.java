package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import personnages.Chef;
import villagegaulois.Village;

public class ControlPrendreEtalTest {
	private Village village;
	private Chef abracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;

	
	
	
	@BeforeEach
	void initialiserVillage() {
		System.out.println("Initialisation");
		village = new Village("Village des Irreductible",10,1);
		abracourcix = new Chef("Abracourcix",10,village);
		village.setChef(abracourcix);
		
		

	}
	
	
	@Test
	void testResteEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
		String produit = "fleurs";
		int quantite = 10;
		controlPrendreEtal.prendreEtal("Bonemine", produit, quantite);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}
	
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		int numEtal =0;
		String produit = "fleurs";
		int quantite = 10;
		numEtal = (controlPrendreEtal.prendreEtal("Bonemine", produit, quantite) +1);
		assertEquals(numEtal,1);
	}
	

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal,"Le constructeur ne doit pas etre null");
		
	}

}
