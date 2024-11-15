package frontiere;

import java.util.Scanner;
import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;


public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurReconnu = controlAcheterProduit.isHabitant(nomAcheteur);
		if (!acheteurReconnu) System.out.println("Je suis desole " + nomAcheteur + " mais il faut etre un habitant de notre village pour acheter un produit.\n");
		else {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.next();
			Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeurs==null) System.out.println("desole, personne ne vend ce produit au marche.\n");
			else {
				System.out.println("Chez quel commercant voulez-vous acheter des fleurs ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println((i+1) + " - " + vendeurs[i].getNom() + "\n");
				}
				int vendeur = Clavier.entrerEntier("");
				Etal etalVendeur = controlAcheterProduit.trouverEtalVendeur(vendeurs[vendeur-1].getNom());
				System.out.println(nomAcheteur + " se deplace jusqu'Ã  l'etal du vendeur " + etalVendeur.getVendeur().getNom());
				System.out.println("Bonjour " + nomAcheteur);
				
				int nbProduit = Clavier.entrerEntier("Combien de " + etalVendeur.getProduit() + " voulez-vous acheter ?");
				if (etalVendeur.getQuantite()==0) System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement il n'y en a plus !\n");
				else if (nbProduit>etalVendeur.getQuantite()) {
					System.out.println(nomAcheteur + " veut acheter " + nbProduit + " " + produit + ", malheureusement " + etalVendeur.getVendeur().getNom() + " en a plus que " + etalVendeur.getQuantite() + ". " + nomAcheteur + " achete tout le stock de " + etalVendeur.getVendeur().getNom() + ".\n");
					etalVendeur.acheterProduit(etalVendeur.getQuantite());
				}
				else {
					System.out.println(nomAcheteur + " achete " + nbProduit + " " + produit + " a  " + etalVendeur.getVendeur().getNom() + ".\n");
					etalVendeur.acheterProduit(nbProduit);
				}
			}
		}
	}
}
