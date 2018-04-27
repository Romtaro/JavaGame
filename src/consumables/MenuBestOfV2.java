package consumables;

import consumables.drinks.Coffe;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;
import java.util.HashSet;

public class MenuBestOfV2 {
	public HashSet<Consumable> menu;

	public MenuBestOfV2(){
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
		MenuBestOfV2 menuBestOfV2 = new MenuBestOfV2();
		System.out.println(menuBestOfV2.getClass().getSimpleName()+" :");
			System.out.println( menuBestOfV2.menu);

	}

}
