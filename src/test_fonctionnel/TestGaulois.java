package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Chaudron;
import personnages.Druide;

public class TestGaulois {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Romain brutus = new Romain("Brutus", 14);
		Chaudron chaudron = new Chaudron();
		Druide panoramix = new Druide("Panoramix", 2, chaudron);
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		asterix.parler("Bonjour Obélix");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		System.out.println("Dans la forêt " + asterix.getNom() + " et " + obelix.getNom()
				+ " tombent nez à nez sur le romain " + brutus.getNom() + ".");
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}

	}
}
