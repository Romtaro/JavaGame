package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import characters.Hero;

public abstract class Ring extends BuffItem {

	protected int power ;
	protected Hero hero ;
	/**
	 * @see #constructeur anneau(String name, int power)
	 * {@value name = name}
	 * {@value power = power}
	 */
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}
	/**
	 * @see setHero()
	 * ajout l'instance d'un hero
	 * {@value this.hero = hero}
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	/**
	 * @see getHero()
	 * renvois l'instance de notre hero
	 * @return le hero
	 */
	public Hero getHero() {
		return hero;
	}
	public int getPower(){
		return this.power;
	}

}
