package villagegaulois;

import objet.Equipement;
import personnages.Gaulois;

public class Musee {
	private int nbTrophee = 0;
	private Trophee[] trophees = new Trophee[20];
	
	public void donnerTrophees (Gaulois gaulois, Equipement equipement) {
		Trophee tropheeGaulois = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = tropheeGaulois;
		nbTrophee++;
	}

}
