package lsg.buffs.talismans;

public class MoonStone extends Talisman {

	/**
	 * @see #constructeur(String name, float buff, int start, int end)
	 * {@value name = "Moon Stone"}
	 * {@value buff = 20}
	 * {@value start = 21}
	 * {@value end = 3}
	 * il s'active entre 21h et 3h
	 */
	public MoonStone() {
		super("Moon Stone", 20f, 21, 3);
	}

}
