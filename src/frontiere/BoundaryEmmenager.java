package frontiere;

import controleur.ControlEmmenager;
import personnages.Druide;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier("Etes-vous : \n 1 - un druide \n 2 - un gaulois \n");
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					
					break;

				case 2:
					System.out.println(" Bienvenue villageois " + nomVisiteur + " .\n");
					question.append("Quelle est votre force ?\n");
					int force = Clavier.entrerEntier(question.toString());
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int effetPotionMin =-1;
		int effetPotionMax =-1;
		int force =-1;
		StringBuilder question = new StringBuilder();
		System.out.println(" Bienvenue Druide " + nomVisiteur + " .\n");
		question.append("Quelle est votre force ?\n");
		force = Clavier.entrerEntier(question.toString());
		do {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ? \n");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ? \n");
			if(effetPotionMax<effetPotionMin)
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			Druide nomVisteur = new Druide(nomVisiteur, force, effetPotionMin,effetPotionMax);
		}while(effetPotionMin>effetPotionMax);
		
		
	}
}
