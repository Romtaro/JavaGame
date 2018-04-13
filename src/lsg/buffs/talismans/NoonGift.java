package lsg.buffs.talismans;

public class NoonGift extends Talisman {
	/**
	 * @see #constructeur(String name, float buff, int start, int end)
	 * {@value name = "Noon Gift"}
	 * {@value buff = 10.5}
	 * {@value start = 12}
	 * {@value end = 14}
	 * il s'active entre 12h et 14h
	 */
	public NoonGift() {
		super("Noon Gift", 10.5f, 12, 14);
	}

}
