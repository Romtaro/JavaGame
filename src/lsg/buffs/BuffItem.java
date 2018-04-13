package lsg.buffs;

import java.util.Locale;
/**
 *
 * @see Class Abstract
 *
 */
public abstract class BuffItem {

	private String name ;
	/**
	 * @see #constructeur(String name)
	 * {@value name = name}
	 */
	public BuffItem(String name) {
		this.name = name ;
	}
	/**
	 *
	 * @see computeBuffValue() est une méthode abstract que nous utilison en Override dans nos classe pour l'implémenter
	 *
	 */
	public abstract float computeBuffValue() ;

	/**
	 * see getName()
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @see toString
	 * @return le nom et le buff de l'item sous format Local.US
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}

}
