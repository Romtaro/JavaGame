package lsg;

import java.io.IOException;
import characters.Hero;
import characters.Monster;
public class LearningSoulsGame {

	 public LearningSoulsGame() throws IOException {

	    }

	public static void main(String[] args) {
		/*
		 * On initialise deux hero et quatre monstre avec les deux méthode de constructeur
		 */
		Hero pseudo = new Hero();
		Hero rodz = new Hero("Le gros Hero");
		Monster a = new Monster();
		Monster b = new Monster();
		Monster c = new Monster("BigBoss");
		Monster d = new Monster("MiniBoss");
		pseudo.printStats();
		rodz.printStats();
		a.printStats();
		b.printStats();
		c.printStats();
		d.printStats();
		/**
		 * N°6
		 * private ne permet de l'appeler directement ici,
		 * public permet de l'appeler ici
		 * friendly permet de l'appeler ici
		 * protected permet de l'appeler ici car on est dans le même package et nous utilisons la class fille il semble le plus optimal à utiliser
		 */

		//System.out.println(rodz.isAlive());
		/**
		 * N°7
		 * Seule la classe public permet d'appeler la fonction en dehors de son packatage, il devra donc être utiliser dans cette configuration
		 * frendly et limité à son package
		 * private accéssible seulement au sein de la class
		 * protected accessible a la class fille dans le package identique
		 */
	}
}
