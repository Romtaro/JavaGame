package consumables;

import consumables.drinks.Coffe;
import consumables.drinks.Whisky;
import consumables.drinks.Wine;
import consumables.food.Americain;
import consumables.food.Hamburger;

public class MenuBestOfV1 {
	public Consumable[] menu;

	public MenuBestOfV1(){
		Hamburger hamburger = new Hamburger();
		Wine wine = new Wine();
		Americain americain = new Americain();
		Coffe coffe = new Coffe();
		Whisky whisky = new Whisky();
		this.menu = new Consumable[5];
		this.menu[0] = hamburger.hamburger;
		this.menu[1] = wine.wine;
		this.menu[2] = americain.americain;
		this.menu[3] = coffe.coffe;
		this.menu[4] = whisky.whisky;

	}
	public static void main(String[] args) {
		MenuBestOfV1 menuBestOfV1 = new MenuBestOfV1();
		System.out.println(menuBestOfV1.getClass().getSimpleName()+" :");
			for(int i=0; i<menuBestOfV1.menu.length;i++){
			System.out.println( i+1 +" : "+menuBestOfV1.menu[i]);
			}

	}

}
