package lsg.bags;

import java.util.HashSet;
import java.util.Iterator;

import consumables.food.Hamburger;
import lsg.armor.DragonSlayerLeggings;
import lsg.weapons.Sword;


public class Bag {

	private int capacity;
	private int weight;
	private HashSet<Collectible> items;

	public Bag(int capacity){
		this.capacity =capacity;
		this.weight = 0;
		this.items = new HashSet<Collectible>();
	}

	public int getCapacity() {
		return capacity;
	}
	public int getWeight() {
		return weight;
	}
	public void push(Collectible item){
		if(item.getWeight() + getWeight()> getCapacity()){
			System.out.println("Sac trop plein");
			return;
		}else{
		this.items.add(item);
		this.weight += item.getWeight();
		}

	}
	public Collectible pop(Collectible item){
		if(this.items.contains(item)){
		this.items.remove(item);
		this.weight -= item.getWeight();
		return item;
		}else{
			return null;
		}
	}
	public boolean contains(Collectible item){
		if(this.items.contains(item)){
			return true;
		}else{
			return false;
		}
	}
	public Collectible[] getItems(){
		Collectible[] itemStock = new Collectible[this.items.size()];
		Iterator<Collectible> i= this.items.iterator();
		int j =0;
		while(i.hasNext()){

			itemStock[j]=i.next();
			j++;

		}
		return itemStock;

	}
	@Override
	public String toString(){
		String stock=new String ();
        for (int i=0 ; i < getItems().length ; i++){

	    stock += "  •"+getItems()[i].toString() + "\n";
        }

		return String.format("  %-1s %-1s %-1s   ", getClass().getSimpleName(),"["+getItems().length +" items"," | "+ getWeight() +"/"+ getCapacity()+" kg ] \n"+  (getItems().length > 0 ? stock : "   •(Empty)" ));
	}
	public static void transfer(Bag from, Bag into){
		 for (int i=0 ; i < from.getItems().length ; i++){
			if(into.getWeight() + from.getItems()[i].getWeight()  <= into.getCapacity()){
			 into.push(from.getItems()[i]);
			 from.pop(from.getItems()[i]);
			 i =- 1;
		 }else{
			 System.out.println("Sac into Full");
			 i=+ 1;
		 }
		 }

	}
	public static void main(String[] args) {
		Bag bag = new Bag(10);
		MediumBag Medbag = new MediumBag(10);
		SmallBag smallbag = new SmallBag(10);
		Bag bagInto = new Bag(5);
		DragonSlayerLeggings dragonSlayerLeggings = new DragonSlayerLeggings();
		DragonSlayerLeggings ddragonSlayerLeggings = new DragonSlayerLeggings();
		Hamburger hamburger = new Hamburger();
		Sword sword = new Sword();
		bag.push(dragonSlayerLeggings);
		bag.push(hamburger.hamburger);
		bag.push(sword);

		Medbag.push(dragonSlayerLeggings);
		Medbag.push(hamburger.hamburger);

		smallbag.push(hamburger.hamburger);


		System.out.println(bag.toString());
		System.out.println(bagInto.toString());
		System.out.println(Medbag.toString());
		System.out.println(smallbag.toString());
		transfer(bag, bagInto);
		transfer(bagInto, smallbag);
		transfer(smallbag, Medbag);
		transfer(bagInto, Medbag);
		transfer(bag, Medbag);
		System.out.println(bag.toString());
		System.out.println(bagInto.toString());
		System.out.println(Medbag.toString());
		System.out.println(smallbag.toString());


		//System.out.println("bag.pop le DragonSlayer");
		//bag.pop(dragonSlayerLeggings);
		//System.out.println(bag.toString());
	}


}
