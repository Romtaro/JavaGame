package lsg.buffs.rings;

import characters.Hero;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;

public class RingOfSwords extends Ring{
	/**
	 * @see #constructeur(String name, int power)
	 * {@value name = "Ring of Swords"}
	 * {@value power = 10}
	 */
	public RingOfSwords() {
		super("Ring of Swords", 10) ;
	}
	/**
	 * @see #computeBuffValue()
	 * la fonction à pour but de voir si le hero est équiper d'une sword
	 * @return power de l'anneau si le hero posséde une sword
	 * @return 0 si le hero n'est pas équiper de sword
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null && (hero.getSword() instanceof Sword) )  return power ;
		else return 0f ;

	}

	/**
	 * Un test...
	 * @param args non utilisÃ©
	 */
	public static void main(String[] args) {
		Sword sword = new Sword();
		Sword weapon = new Sword();
		Hero hero = new Hero(101, weapon) ;
		RingOfSwords r = new RingOfSwords() ;
		hero.setRing(r, 1);
		r.setHero(hero);
		System.out.println(r);
	}
}
