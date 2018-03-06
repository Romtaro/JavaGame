package lsg;

import java.io.IOException;
public class LearningSoulsGame {

	 public LearningSoulsGame() throws IOException {
	    }

	public static void main(String[] args) {
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
		 * private ne permet de l'appeler directement ici,
		 * public permet de l'appeler ici mais aussi dans les autres packtages
		 * friendly permet de l'appeler ici mais pas dans les autres packtages
		 * protected permet de l'appeler ici
		 */
		//System.out.println(rodz.isAlive());
	}
}
