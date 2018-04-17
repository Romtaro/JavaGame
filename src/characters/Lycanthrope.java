package characters;

import lsg.helpers.Dice;
import lsg.weapons.Claw;
import lsg.weapons.Weapon;

public class Lycanthrope extends Monster{
	public Lycanthrope(int i, Weapon weapon){
		super(i, weapon);
		this.name = "Lycanthrope";
		this.skinThickness = 50;
	}

	public Lycanthrope() {
		super(101, new Claw());
		this.name = "Lycanthrope";
		this.skinThickness = 50;
		this.life = 40;
	}

}
