package consumables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import consumables.drinks.Coffe;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

public class MenuBestOfV4 extends LinkedHashSet {
	public LinkedHashSet<Consumable> menu;
		public MenuBestOfV4(){
	Hamburger hamburger = new Hamburger();
	Wine wine = new Wine();
	Americain americain = new Americain();
	Coffe coffe = new Coffe();
	Whisky whisky = new Whisky();
	this.menu = new LinkedHashSet<>(5);
	this.menu.add(hamburger.hamburger);
	this.menu.add(wine.wine);
	this.menu.add(americain.americain);
	this.menu.add(coffe.coffe);
	this.menu.add( whisky.whisky);

}
public static void main(String[] args) {
	MenuBestOfV4 MenuBestOfV4 = new MenuBestOfV4();
	System.out.println(MenuBestOfV4.getClass().getSimpleName()+" :");
	/**
	 * Question TP 4 3.3 : il faut préciser sur quel tableau nous travaillons et comment il doit agir,
	 * mon itérator passer dans mon while a chaque fois qu'i change d'élement.
	 */
	Iterator i = MenuBestOfV4.menu.iterator();
	int j = 0;
	while(i.hasNext()){
		++j;
		System.out.println(j +" : "+ i.next());
	}
}
}

