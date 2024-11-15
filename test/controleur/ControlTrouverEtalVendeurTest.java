package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abracourcix;
	
	
	
	@BeforeEach
	void initialiserVillage() {
		System.out.println("Initialisation");
		village = new Village("Village des Irreductible",10,1);
		abracourcix = new Chef("Abracourcix",10,village);
		village.setChef(abracourcix);
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois bonemine  = new Gaulois("Bonemine",3);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"),bonemine);
	}

}
