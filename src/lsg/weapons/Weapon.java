package lsg.weapons;

public class Weapon {

	private String name;
	private int minDamage;
	private int maxDamage;
	private int stamCost;
	private int durability;

	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability){

		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;
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

	private void setDurability(int durability) {
		this.durability = durability;
	}

	protected void use(){
		this.durability = getDurability()-1;
	}

	protected int isBroken(){
		int dura;
		dura = Integer.compare(getDurability(), 0);
		return dura;
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
	public String toString(){
		return String.format("%-8s %-10s %-10s %-10s %-20s %-10s","["+getClass().getSimpleName()+"]","[" +isBroken()+"]", getName(),getMinDamage() , getMaxDamage(), getStamCost(), getDurability());
	}

}
