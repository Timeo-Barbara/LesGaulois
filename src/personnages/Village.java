package personnages;

public class Village {
	private String nom;
	private Gaulois chef;
	private int NB_VILLAGEOIS_MAX;
	int NB_VILLAGEOIS = 0;
	Gaulois[] villageois;

	public Village(String nom, Gaulois chef, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		this.NB_VILLAGEOIS_MAX = NB_VILLAGEOIS_MAX;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[NB_VILLAGEOIS] = gaulois;
		NB_VILLAGEOIS++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= NB_VILLAGEOIS) {
			return villageois[numVillageois - 1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillage() {
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < NB_VILLAGEOIS; i++) {
			System.out.println("- " + villageois[i].getNom());

		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		abraracourcix.setVillage(village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillage();
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
}
