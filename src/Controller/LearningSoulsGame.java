package controller;

import java.io.IOException;
import model.Hero;

public class LearningSoulsGame {

	 public LearningSoulsGame() throws IOException {
	    }

	public static void main(String[] args) {
		Hero pseudo = new Hero();
		Hero Rodz = new Hero("Le gros Hero");
		pseudo.printStats();
		Rodz.printStats();
	}
}
