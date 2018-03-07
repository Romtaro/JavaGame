package lsg;

import java.io.IOException;
import characters.Hero;
import characters.Monster;
import lsg.weapons.Weapon;
import lsg.weapons.Sword;
public class LearningSoulsGame {

	 public LearningSoulsGame() throws IOException {

	    }

	public static void main(String[] args) {
		/*
		 * On initialise deux hero et quatre monstre avec les deux méthode de constructeur
		 */
		Weapon weapon = new Weapon("Basic Weapon",5,10,10,100);
		Hero pseudo = new Hero(101,weapon);
		Hero rodz = new Hero("Le gros Hero",101,weapon);
		Monster a = new Monster(101,weapon);
		Monster b = new Monster(101,weapon);
		Monster c = new Monster("BigyBoss",101,weapon);
		Monster d = new Monster("MiniBoss",101,weapon);
		System.out.println(pseudo.toString());
		System.out.println(rodz.toString());
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());

		System.out.println(weapon.toString());
		Sword basSword = new Sword();
		System.out.println(basSword.toString());
		/*
		 * Test attaque on re marque que le hero et le monstre utilise la même arme ce qui a pour effet de reduire la endurance de l'arme pour chaque coups dans le cbt
		 */

		System.out.println("-----------Attaque----------");
		for(int i=0; i< 5; i++){
			System.out.println("-----------Hero----------\n");
		System.out.println(pseudo.getName() +" Attaque du : "+pseudo.Attack());
		System.out.println(pseudo.toString());
		System.out.println(pseudo.weapon.toString());
		System.out.println("\n");
		System.out.println("-----------Monster----------\n");
		System.out.println(c.getName() +" Attaque du : "+c.Attack());
		System.out.println(c.toString());
		System.out.println(c.weapon.toString());
		System.out.println("\n");
		}
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
