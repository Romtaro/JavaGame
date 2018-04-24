package consumables;

import consumables.drinks.Coffe;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;
import java.util.HashSet;
import java.util.Iterator;

public class MenuBestOfV3 extends MenuBestOfV2{

	public MenuBestOfV3(){
		Hamburger hamburger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffe coffe = new Coffe();
		Whisky whisky = new Whisky();
		this.menu = new HashSet<>(5);
		this.menu.add(hamburger.hamburger);
		this.menu.add(wine.wine);
		this.menu.add(americain.americain);
		this.menu.add(coffe.coffe);
		this.menu.add( whisky.whisky);

	}
	public static void main(String[] args) {
		MenuBestOfV3 MenuBestOfV3 = new MenuBestOfV3();
		System.out.println(MenuBestOfV3.getClass().getSimpleName()+" :");
		/**
		 * Question TP 4 3.3 : il faut préciser sur quel tableau nous travaillons et comment il doit agir,
		 * mon itérator passer dans mon while a chaque fois qu'i change d'élement.
		 */
		Iterator i = MenuBestOfV3.menu.iterator();
		int j = 0;
		while(i.hasNext()){
			++j;
			System.out.println(j +" : "+ i.next());
		}
	}
}
