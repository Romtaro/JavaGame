package characters;

import lsg.helpers.Dice;


public class Monster extends Character{
	private static int instances = 0;

	/**
	 * on utilise la value instances pour nommer les monstre
	 */
	public Monster(int i){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s", "YMonster","n°"+instances);
		this.life = 10;
		this.stamina = 10;
		this.dee = new Dice(i);
	}

	public Monster(String name, int i){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s",name , "n°"+instances);
		this.life = 10;
		this.stamina = 10;
		this.dee = new Dice(i);

	}


	 /**
	  * on incrémente une variable pour compter les monstres créer.
	  */
	private static void INSTANCES_COUNT(){
		instances = ++instances;
	}


}
