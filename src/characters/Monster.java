package characters;
import lsg.weapons.Weapon;
import lsg.helpers.Dice;


public class Monster extends Character{
	private static int instances = 0;
	private float skinThickness;

	/**
	 * on utilise la value instances pour nommer les monstre
	 */
	public Monster(int i, Weapon weapon){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s", "YMonster","n°"+instances);
		this.life = 10;
		this.stamina = 10;
		this.dee = new Dice(i);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());
		this.skinThickness = 20;
	}

	public Monster(String name, int i, Weapon weapon){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s",name , "n°"+instances);
		this.life = 10;
		this.stamina = 10;
		this.dee = new Dice(i);
		this.skinThickness = 20;
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());

	}


	 public float getSkinThickness() {
		return skinThickness;
	}

	public void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}

	/**
	  * on incrémente une variable pour compter les monstres créer.
	  */
	private static void INSTANCES_COUNT(){
		instances = ++instances;
	}


}
