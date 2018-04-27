package characters;
import lsg.weapons.Weapon;
import lsg.buffs.rings.Ring;
import lsg.buffs.talismans.Talisman;
import lsg.helpers.Dice;


public class Monster extends Character{
	private static int instances = 0;
	protected float skinThickness;
	Talisman talismans;
	/**
	 * on utilise la value instances pour nommer les monstre
	 */
	public Monster(int i, Weapon weapon){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s", "YMonster","n°"+instances);
		this.life = 100;
		setMaxLife(100);
		this.stamina = 10;
		this.dee = new Dice(i);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability(),  weapon.getMaxDurability());
		this.skinThickness = 20;
		setWeapon(this.weapon);
	}

	public Monster(String name, int i, Weapon weapon){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s",name , "n°"+instances);
		this.life = 100;
		setMaxLife(100);
		this.stamina = 10;
		this.dee = new Dice(i);
		this.skinThickness = 10;
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability(),  weapon.getMaxDurability());
		setWeapon(this.weapon);
	}

	public Monster(String name, int i, Weapon weapon, Talisman talisman){
		INSTANCES_COUNT();
		this.name = String.format("%-6s %-1s",name , "n°"+instances);
		this.life = 100;
		setMaxLife(100);
		this.stamina = 10;
		this.dee = new Dice(i);
		this.skinThickness = 10;
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability(), weapon.getMaxDurability());
		this.talismans = talisman;

		setWeapon(this.weapon);
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
	@Override
	public float computeProtection(){

		return getSkinThickness();
	}
	public float buff(){

		return getTotalBuff();
	}
	public Talisman setTalismanItems(Talisman talisman){
		Talisman item1 = talisman;
				this.talismans = item1;
				//System.out.println("Talisman :" + item1.getName());
		return this.talismans;
}
	public float getTotalBuff(){
		float totalBuff =0;
		Talisman item1 =this.talismans;
		if(!(item1 == null)){
			totalBuff += item1.computeBuffValue();
		}else {
			totalBuff += 0;
		}
		return totalBuff;
	}
}
