package lsg.buffs.rings;

import characters.Hero;
import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring{
		Hero hero;
		/**
		 * @see #constructeur (String name, int power)
		 * {@value name = Dragon Slayer Ring}
		 * {@value power = 14}
		 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}
	/**
	 * @see #computeBuffValue()
	 * fonction dans la class extends que l'on override pour l'adapter à notre anneau
	 * la fonction à pour but de voir si le hero est équiper de l'anneau DragonSlayerRing
	 * @return power de l'anneau si le hero est équiper de l'anneau
	 * @return 0 si le hero n'est pas équiper de l'anneau
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	/**
	 * @see #hasDragonsSlayerItem()
	 * fonction qui check si le hero est équiper de l'anneau
	 * il parcour les slot d'item
	 * @return true si l'anneau est équipé
	 * @return false si il n'est pas équipé
	 */
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItems();
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ;
		}
		return false ;
	}

}
