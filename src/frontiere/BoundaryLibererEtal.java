package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurConnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurConnu) {
			System.out.println("Mais vous n'etes pas inscrit sur le marche aujourd'hui !");

		}else {
			controlLibererEtal.libererEtal(nomVendeur);
			
		}
	}

}
