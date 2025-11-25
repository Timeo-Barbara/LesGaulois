package personnages;

import objet.Equipement;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	//private int force;
	private Village village;
	private int effetPotion = 1;
	
	private int force; 
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return nom;
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force * effetPotion) / 3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tabTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tabTrophees != null && i < tabTrophees.length; i++,
		nbTrophees++) {
		this.trophees[nbTrophees] = tabTrophees[i];
		}
	}


	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public boolean contientGaulois(Gaulois gaulois) {
		for (int i = 0; i < village.NB_VILLAGEOIS; i++) {
			if (village.villageois[i] == gaulois) {
				return true;
			}
		}
		return false;
	}
	
	public void faireUneDonnation (Musee musee) {
		if (nbTrophees>=0)
			parler("Je donne au musee tous mes trophees");
		while (nbTrophees>=0) {
			musee.donnerTrophees(this, trophees[nbTrophees]);
			System.out.println("- " + trophees[nbTrophees]);
			trophees[nbTrophees] = null;
			nbTrophees--;
			
		}
	}

	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (this == village.getChef()) {
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village \"" + village.getNom() + "\".");
		} else if (contientGaulois(this)) {
			parler("Bonjour, je m'appelle " + nom + ". J'habite le village \"" + village.getNom() + "\".");
		} else {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		}
	}

}
