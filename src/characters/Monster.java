package characters;

public class Monster extends Character{
	private static int instances = 0;

	/**
	 * on utilise la value instances pour nommer les monstre
	 */
	public Monster(){
		INSTANCES_COUNT();
		this.name = String.format("%-16s %-1s", "YMonster","n°"+instances);
		this.life = 10;
		this.stamina = 10;
	}

	public Monster(String name){
		INSTANCES_COUNT();
		this.name = String.format("%-15s %-1s",name, " n°"+instances);
		this.life = 10;
		this.stamina = 10;

	}


	 /**
	  * on incrémente une variable pour compter les monstres créer.
	  */
	private static void INSTANCES_COUNT(){
		instances = ++instances;
	}

}
