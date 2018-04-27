package lsg.weapons;


public class Sword extends Weapon{


	public Sword() {
		super("Basic Sword", 10, 20, 20, 100, 100);

	}


	/*
	 * Test Sword affichage
	 */
/*
	public static void main(String[] args) {
		Sword d = new Sword();
		System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s %-10s",d.isBroken(), d.getName(), d.getStamCost(), d.getMinDamage(), d.getMaxDamage(), d.getDurability()));
	}*/
	@Override
	public String toString(){
		return String.format("%-1s %-1s %-1s %-1s %-1s %-1s","["+getClass().getSimpleName()+"]", getName(),"(min:"+getMinDamage() , "max:"+getMaxDamage(), "Stam:"+getStamCost(), "dur:"+getDurability()+" "+"[" +isBroken()+"]"+")");
	}


}
