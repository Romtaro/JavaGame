package characters;
import lsg.armor.ArmorItem;
import lsg.buffs.rings.Ring;
import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
public class Hero extends Character{
	ArmorItem[] armor;
	Ring[] ring;
	Hero hero;
	public static final int MAX_ARMOR_PIECES=3;
	public static final int MAX_RING_PIECES=2;
	/**
	 * Constructeur basique sans params
	 */
	public Hero(int f, Weapon weapon){

		this.life = 150;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);
		this.weapon = new Weapon(weapon.getName(), weapon.getMinDamage(), weapon.getMaxDamage(),weapon.getStamCost(), weapon.getDurability());
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
		this.ring = new Ring[MAX_RING_PIECES];

	}
	public Hero(int f, Sword sword){

		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);
		this.sword = new Sword();
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
		this.ring = new Ring[MAX_RING_PIECES];

	}

	public Hero(int f, Sword sword, Ring ring){

		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);
		this.sword = new Sword();
		this.armor = new ArmorItem[MAX_ARMOR_PIECES];
		this.ring = new Ring[MAX_RING_PIECES];

	}

	public Ring[] getRing() {
		return ring;
	}

	public void setRing(Ring ring, int slot) {
		if(!(slot<0) || !(slot>MAX_RING_PIECES)){
			ring.setHero(this.hero);
		this.ring[slot] = ring;

		}else{
			return;
		}
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

	public void setArmorItem(ArmorItem armorItem, int slot){
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
		if(!(item1 == null)){
			totalArmure += item1.getArmorValue();
		}
		if(!(item2 == null)){
			totalArmure += item2.getArmorValue();
		}
		if(!(item3 == null)){
			totalArmure += item3.getArmorValue();
		}
		return totalArmure;
	}

	public void armorToString(){
			System.out.println("Armor" +"\t"+ 1+":"+(this.armor[0] != null ? this.armor[0]:"empty") +"\t"+ 2 +":"+(this.armor[1]!= null ? this.armor[1]:"empty") +"\t \t"+ 3 +":"+(this.armor[2]!= null ? this.armor[2]:"empty \n"+ "Total :"+ getTotalArmor() ));

	}
	public ArmorItem[] getArmorItems(){
		ArmorItem[] item1 = null;
		int j = 1;

		for(int i=0; i<this.armor.length;i++){
			try{
			if(!(this.armor ==null)){
				item1[j] = this.armor[i];
				System.out.println("Item n°"+j +" : "+item1);
				++j;
			}else{

			}}catch(Exception e){
					//Slot Item vide !! héhé
		     }
			}
		return item1;
}
	public Ring[] getRingItems(){
		Ring[] item1 = null;
		int j = 1;

		for(int i=0; i<this.ring.length;i++){
			try{
			if(!(this.ring ==null)){
				item1[j] = this.ring[i];
				System.out.println("Ring n°"+j +" : "+item1);
				++j;
			}else{

			}}catch(Exception e){
					//Slot Item vide !! héhé
		     }
			}
		return item1;
}
	public float getTotalBuff(){
		float totalBuff =0;
		Ring item1 =this.ring[0];
		Ring item2 =this.ring[1];
		if(!(item1 == null)){
			totalBuff += item1.getPower();
		}
		if(!(item2 == null)){
			totalBuff += item2.getPower();
		}

		return totalBuff;
	}

	/*
	 * (Question 4.2)
	 * @see characters.Character#computeProtection()
	 * je n'ai pas eu de problème de mon côté juste; j'ai du ajouter le Override car c'est une méthode abstrait qu'il faut redéfinir dans la classe Hero et dans la classe Monstre
	 */
	@Override
	public float computeProtection(){

		return getTotalArmor();
	}
	@Override
	public float buff(){

		return getTotalBuff();
	}
}