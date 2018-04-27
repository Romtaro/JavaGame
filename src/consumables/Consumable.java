package consumables;

import java.text.NumberFormat;
import java.util.Locale;

import consumables.drinks.Whisky;
import consumables.food.Hamburger;

public class Consumable {
	private String name;
	private int capacity;
	private String stat;

	public Consumable(String name, int capacity, String stat){
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

@Override
	public String toString(){

		return String.format("%-1s %-1s  %-1s ", getName(),"["+ getCapacity() ,getStat()+"]");
	}
	public int use(){
		int renvois = this.capacity;
		setCapacity(0);
		return renvois;
	}

	public static void main(String[] args) {
		Consumable consumable = new Consumable("La Grosse Popo", 500, "PDV");
		Hamburger hamburger = new Hamburger();
		Whisky whisky = new Whisky();
		System.out.println(consumable.toString());
		System.out.println(hamburger.hamburger.toString());
		System.out.println(whisky.whisky.toString());

}
}


