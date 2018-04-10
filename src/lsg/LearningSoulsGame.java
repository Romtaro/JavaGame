package lsg;

import java.io.IOException;

import characters.Character;
import characters.Hero;
import characters.Monster;
import lsg.weapons.Weapon;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
public class LearningSoulsGame {

	private static Monster monstre;
	private static Hero hero;
	public LearningSoulsGame() throws IOException {

	    }

	public static void main(String[] args) {
		init();
		/*
		 * On initialise deux hero et quatre monstre avec les deux méthode de constructeur
		 */
		/*Weapon weapon = new Weapon("Basic Weapon",5,10,10,100);
		ShotGun shotGun = new ShotGun("ShotGun", 6, 20, 5, 100);
		Hero pseudo = new Hero(101,shotGun);
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
		System.out.println(basSword.toString()+"\n");*/
		/*
		 * Test attaque on re marque que le hero et le monstre utilise la même arme ce qui a pour effet de reduire la endurance de l'arme pour chaque coups dans le cbt
		 */


		//play_v1(pseudo, c);

		//System.out.println("-----------Attaque----------\n");

		/*for(int i=0; i< 5; i++){
			System.out.println("-----------Hero----------\n");

		System.out.println(pseudo.toString());
		System.out.println(pseudo.weapon.toString()+ "\n");
		System.out.println(pseudo.getName() +" Reste au monstre : "+ pseudo.attack(c));
		System.out.println("\n");
		System.out.println("-----------Monster----------\n");

		System.out.println(c.toString());
		System.out.println(c.weapon.toString()+"\n");
		System.out.println(c.getName()  +" reste au héro : "+c.attack(pseudo));
		System.out.println("\n");
		}*/
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

	private static void init(){
		System.out.println("--------------------- Bienvenue dans SoualsGame Aventurier ! ---------------------\n");
		ShotGun shotGun = new ShotGun("ShotGun", 6, 20, 5, 100);
		hero = new Hero(101,shotGun);
		Claw claw = new Claw();
		monstre = new Monster("BiggyBoss",101,claw);
		play_v1(hero,monstre);
	}

	private static void play_v1(Character characterHero, Character characterMonster){
		characterHero.combat(characterHero, characterMonster);
	}

}
