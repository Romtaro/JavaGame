package characters;
import lsg.armor.ArmorItem;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;
public class Hero extends Character{
	ArmorItem [] armor;
	public static final int MAX_ARMOR_PIECES=2;
	/**
	 * Constructeur basique sans params
	 */
	public Hero(int f, Weapon weapon){
		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
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
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
	}

	private void setArmorItem(ArmorItem armorItem, int slot){
		if(!(slot<0) || !(slot>MAX_ARMOR_PIECES)){
			this.armor[slot]= armorItem;
		}else{
			return;
		}
	}
//////10.04.2018 fin de journée : next a faire armorToString suite du 3.1
	public float getTotalArmor(){
		float totalArmure =0;
		ArmorItem item1 =this.armor[0];
		ArmorItem item2 =this.armor[1];
		ArmorItem item3 =this.armor[2];
		if(!(item1.equals(null))){
			totalArmure = +item1.getArmorValue();
		}
		if(!(item2.equals(null))){
			totalArmure = +item2.getArmorValue();
		}
		if(!(item3.equals(null))){
			totalArmure = +item3.getArmorValue();
		}
		return totalArmure;
	}


}
