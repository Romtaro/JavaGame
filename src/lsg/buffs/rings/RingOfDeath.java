package lsg.buffs.rings;

import characters.Hero;
import lsg.weapons.Weapon;

public class RingOfDeath extends Ring{

	private static float LIMIT = 0.5f ;
	/**
	 * @see #constructeur(String name, int power)
	 * {@value name = "Ring of Death"}
	 * {@value power = 10000}
	 */
	public RingOfDeath() {
		super("Ring of Death", 10000) ;
	}
	/**
	 * @see #computeBuffValue()
	 * la fonction à pour but de voir si le hero a les point de vie pour activer l'anneau
	 * {@value LIMIT = (float) notre de vie minimum pour activer l'effet}
	 * @return power de l'anneau si le hero posséde 50% ou moins de ça vie
	 * @return 0 si le hero a plus de 50% de ça vie.
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null){
			float gauge = (float)hero.getLife() / (float)hero.getMaxLife() ;
			if(gauge <= LIMIT) return power ;
			else return 0f ;
		}else return 0f ;
	}

	/**
	 * Un test...
	 * @param args non utilisÃ©
	 */
	public static void main(String[] args) {
		Weapon weapon = new Weapon("Le truc", 20, 60, 10, 100, 100);
		Hero hero = new Hero(101, weapon);
		Ring r = new RingOfDeath() ;
		hero.setRing(r, 0);
		hero.getHitWith(60) ; // pour abaisser les PV du hero
		System.out.println(r);
	}

}
