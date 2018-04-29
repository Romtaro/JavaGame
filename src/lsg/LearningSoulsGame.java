package lsg;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import characters.Character;
import characters.Hero;
import characters.Lycanthrope;
import characters.Monster;
import consumables.Consumable;
import consumables.MenuBestOfV4;
import consumables.food.Hamburger;
import consumables.reapir.RepairKit;
import lsg.weapons.Weapon;
import lsg.armor.*;
import lsg.bags.MediumBag;
import lsg.buffs.rings.Ring;
import lsg.buffs.rings.RingOfSwords;
import lsg.buffs.talismans.Talisman;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
public class LearningSoulsGame {

	private static Monster monstre;
	private static Hero hero;
	public LearningSoulsGame() throws IOException {

	    }

	public static void main(String[] args) {
		BlackWitchVeil itemB = new BlackWitchVeil();
		RingedKnightArmor itemR = new RingedKnightArmor();
		DragonSlayerLeggings itemD = new DragonSlayerLeggings();
		/*System.out.println(itemB.toString());
		System.out.println(itemR.toString());
		System.out.println(itemD.toString());
*/
		//init();
		testBag();
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

	/*private static void init(){
		System.out.println("-------------------------------- Bienvenue dans SoualsGame Aventurier ! --------------------------------\n");
		ShotGun shotGun = new ShotGun("ShotGun", 6, 20, 5, 100,100);
		hero = new Hero(101,shotGun);
		Claw claw = new Claw();
		monstre = new Monster("BiggyBoss",101,claw);
		monstre.computeProtection();
		Monster meme = new Lycanthrope();
		//play_v1(hero,monstre);
		//play_v2(hero,monstre);

		//play_v4(hero, meme);
		createExhaustedHero();

	}*/
	private static void init(){
		title();
		ShotGun shotGun = new ShotGun("ShotGun", 6, 20, 5, 100,100);
		hero = new Hero(101,shotGun);
		Claw claw = new Claw();
		monstre = new Monster("BiggyBoss",101,claw);
		Hamburger hamburger = new Hamburger();
		hero.setConsumable(hamburger.hamburger);
		play_v4(hero, monstre);

	}
	private static void testBag(){
		title();
		ShotGun shotGun = new ShotGun("ShotGun", 6, 20, 5, 100,100);
		hero = new Hero(101,shotGun);
		Hamburger hamburger = new Hamburger();
		Hamburger hamburgecr = new Hamburger();
		hero.pickUp(hamburger.hamburger);
		Weapon weapon = new Weapon("Grosse Arme", 0, 1, 1000, 100,100);
		hero.pickUp(weapon);
		System.out.println(hero.getBagCapacity());

		System.out.println(hero.getBagWeight());
		MediumBag mediuemBag = new MediumBag(40);
		System.out.println(hero.printBag());
		hero.setBag(mediuemBag);
		System.out.println(hero.printBag());
		hero.pullOut(hamburger.hamburger);
		System.out.println(hero.getWeapon());
		hero.equip(weapon);
		System.out.println(hero.printBag());
		System.out.println(hero.getWeapon());

		hero.equip(hamburger.hamburger);
		hero.pickUp(hamburger.hamburger);
		System.out.println(hero.printBag());
		hero.equip(hamburger.hamburger);
		RingedKnightArmor itemR = new RingedKnightArmor();
		System.out.println(hero.printBag());
		hero.pickUp(itemR);
		System.out.println(hero.getConsumable());
		System.out.println(hero.printBag());
		System.out.println(hero.getArmorItems());
		hero.equip(itemR, 1);
		System.out.println(hero.printBag());
		hero.pickUp(hamburger.hamburger);
		hero.pickUp(hamburgecr.hamburger);
		hero.fastEat();


	}

	final public String BULLET_POINT(){
		return String.format("%-20s", "\u2219");

	}
	private static void play_v1(Hero characterHero, Monster characterMonster){
		characterHero.combat(characterHero, characterMonster);
	}

	private static void play_v2(Hero characterHero, Monster characterMonster){
		RingedKnightArmor itemR = new RingedKnightArmor();
		 characterHero.setArmorItem(itemR, 0);
		characterHero.combat(characterHero, characterMonster);
	}

	private static void play_v3(Hero characterHero, Monster characterMonster){
		RingedKnightArmor itemR = new RingedKnightArmor();
		 characterHero.setArmorItem(itemR, 0);

		characterHero.combat(characterHero, characterMonster);
	}
	private static void play_v4(Hero characterHero, Monster characterMonster){
		RingedKnightArmor itemR = new RingedKnightArmor();
		Ring ring = new RingOfSwords();
		Talisman talisman = new Talisman("Talismans de jour", 15, 12, 17);

		 characterHero.setArmorItem(itemR, 0);
		 characterHero.setRing(ring, 1);
		characterMonster.setTalismanItems(talisman);
		characterHero.combat(characterHero, characterMonster);
	}
	static void createExhaustedHero(){
		Weapon weapon = new Weapon("Grosse Arme", 0, 0, 1000, 100,100);
		Hero Heron = new Hero(100, weapon, 1);
		System.out.println(Heron.toString());
		System.out.println(weapon.toString());
		//RepairKit kit = new RepairKit("df", 10, "sd");
		//Heron.getHitWith(99); ma méthode de touche pas au pdv !
		Heron.attack();
		System.out.println(Heron.toString());
		System.out.println(Heron.getWeapon());
		Object table = aTable();
		Iterator<Consumable> i = ((HashSet<Consumable>) table).iterator();
		while(i.hasNext()){
			Heron.use(i.next());
			System.out.println(Heron.toString()+"\n");


		}



	}
	public static Object aTable(){
		MenuBestOfV4 menuBestOfV4 = new MenuBestOfV4();
		System.out.println(menuBestOfV4);
		return menuBestOfV4.menu;

	}
	public static void title(){
		System.out.println("################################\n#   THE LEARNING SOULS GAME    #\n################################");

	}
}
