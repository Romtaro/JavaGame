package lsg.weapons;

import characters.Hero;
import consumables.reapir.RepairKit;
import lsg.bags.*;
public class Weapon implements Collectible {
	Hero hero;
	private String name;
	private int minDamage;
	private int maxDamage;
	private int stamCost;
	private int durability;
	private int maxDurability;
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability, int maxDurability){

		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;
		this.maxDurability = maxDurability;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	protected void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	protected void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	protected void setStamCost(int stamCost) {
		this.stamCost = stamCost;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	protected void use(){
		this.durability = getDurability()-1;
	}

	public int isBroken(){
		int dura;
		dura = Integer.compare(getDurability(), 0);
		return dura;
	}
	public int getMaxDurability() {
		return maxDurability;
	}
	public void setMaxDurability(int durability) {
		this.maxDurability = maxDurability;
	}
	/*
	 * Test Weapon affichage
	 */
	/*
	public static void main(String[] args) {
		Weapon d = new Weapon("cac noob",5,6,4,0);
		Weapon c = new Weapon("Gros cac",5,6,4,2);
		System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s",d.isBroken(), d.getName(), d.getStamCost(), d.getMinDamage(), d.getMaxDamage(), d.getDurability()));
		System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s",c.isBroken(), c.getName(), c.getStamCost(), c.getMinDamage(), c.getMaxDamage(), c.getDurability()));
	}*/
	@Override
	public String toString(){
		return String.format("%-1s %-1s %-1s %-1s %-1s %-1s","["+getClass().getSimpleName()+"]", getName(),"(min:"+getMinDamage() , "max:"+getMaxDamage(), "Stam: "+getStamCost()+" ", DURABILITY_STAT_STRING() +" "+"[" +isBroken()+"]"+")");
	}
	public String DURABILITY_STAT_STRING(){
		return  String.format("%-20s","Durability : " +this.durability+"/"+this.maxDurability );
	}
	public String ARMOR_STAT_STRING(){
		return  String.format("%-20s","Durability : " +this.hero.MAX_ARMOR_PIECES);
	}
	public String BUFF_STAT_STRING(){
		return  String.format("%-20s","Durability : " +this.hero.getTotalBuff());
	}
	public void repairWith(RepairKit kit){
		if(kit.getCapacity() > 0){
		setDurability(getDurability()+kit.use());
		}
		else{
			System.out.println("a pu de kit :(");
		}
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 2;
	}



}
