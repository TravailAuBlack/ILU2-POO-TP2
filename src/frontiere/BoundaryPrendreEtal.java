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
		String nomVendeurConnu;
		StringBuilder reponse = new StringBuilder();
		if(controlPrendreEtal.verifierIdentite(nomVendeur)) {
			nomVendeurConnu = nomVendeur;
			reponse.append("Bonjour " +nomVendeur + " Je vais regarder si je peut vous trouver un etal \n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				reponse.append("Desole " + nomVendeur + " je n'ai plus d'etal qui ne soit pas occupé \n" );
			}else {
				
			}
		}else {
			reponse.append("Je suis desole " + nomVendeur + " mais il faut etre résident de notre village pour commercer \n");
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder reponse = new StringBuilder();
		
		reponse.append("C'est parfait, il me reste un etal pour vous ! \n");
		reponse.append("Il me faudrait quelques renseignement : \n");
		reponse.append("Quel produit souhaitez vous vendre ?\n");
		String produit = scan.nextLine();
		reponse.append("Combien souhaitez-vous en vendre ? \n");
		int nbProduit = scan.nextInt();
		int numeroEtal;
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1)
			reponse.append("Le vendeur " +nomVendeur + "s'est installe a l'etal n°"+ numeroEtal +".\n");
		
		
		
		
	}
}
