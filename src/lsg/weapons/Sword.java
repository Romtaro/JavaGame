package lsg.weapons;


public class Sword {

	private String name;
	private int minDamage;
	private int maxDamage;
	private int stamCost;
	private int durability;

	public Sword(){

		this.name = "Basic Sword";
		this.minDamage = 5;
		this.maxDamage = 10;
		this.stamCost = 20;
		this.durability = 100;
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
	 * Test Sword affichage
	 */
/*
	public static void main(String[] args) {
		Sword d = new Sword();
		System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s",d.isBroken(), d.getName(), d.getStamCost(), d.getMinDamage(), d.getMaxDamage(), d.getDurability()));
	}*/
	public String toString(){
		return String.format("%-8s %-10s %-10s %-10s %-20s %-10s","["+getClass().getSimpleName()+"]","[" +isBroken()+"]", getName(),getMinDamage() , getMaxDamage(), getStamCost(), getDurability());
	}


}
