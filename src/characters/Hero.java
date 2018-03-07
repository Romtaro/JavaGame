package characters;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;
public class Hero extends Character{


	/**
	 * Constructeur basique sans params
	 */
	public Hero(int f, Weapon weapon){
		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());
	}

	/**
	 * Constructeur Hero
	 * @param name
	 */
	public Hero(String name, int i, Weapon weapon){
		this.name = name;
		this.life = 100;
		this.stamina = 50;
		this.dee = new Dice(i);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());
	}



}
