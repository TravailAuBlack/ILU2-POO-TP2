package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis desole " + nomVendeur + " mais il faut etre résident de notre village pour commercer \n");
		}else {
			System.out.println("Bonjour " +nomVendeur + " Je vais regarder si je peut vous trouver un etal \n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas occupé \n" );
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		System.out.println("C'est parfait, il me reste un etal pour vous ! \n");
		System.out.println("Il me faudrait quelques renseignement : \n");
		System.out.println("Quel produit souhaitez vous vendre ?\n");
		String produit = scan.nextLine();
		System.out.println("Combien souhaitez-vous en vendre ? \n");
		int nbProduit = scan.nextInt();
		int numeroEtal;
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1)
			System.out.println("Le vendeur " +nomVendeur + "s'est installe a l'etal n°"+ numeroEtal +".\n");
		
		
		
		
	}
}
