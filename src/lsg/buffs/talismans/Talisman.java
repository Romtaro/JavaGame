package lsg.buffs.talismans;

import java.util.Calendar;

import lsg.buffs.BuffItem;

public class Talisman extends BuffItem {

	private float buff ;
	private int start, end ;
	/**
	 * @see #constructeur (String name, float buff, int start, int end)
	 * {@value buff = buff} le power en plus
	 * {@value start = start} l'heur a laquelle s'active l'effet
	 * {@value end = end } l'heur a laquelle fini l'effet
	 */
	public Talisman(String name, float buff, int start, int end) {
		super(name) ;
		this.buff = buff ;
		this.start = start ;
		this.end = end ;
	}
	/**
	 * @see #computeBuffValue()
	 * la fonction à pour but de voir si le le talisment et dans son intervalle de temps pour activation du buff
	 * @return power du talisment si l'heur actuel est compris dans l'heur d'activation du talisment
	 * @return 0 si l'heur actuel est en dehor des plage d'horraire d'activation
	 */
	@Override
	public float computeBuffValue() {
		int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(start <= end){
			if(now >= start && now < end) return buff ;
			else return 0f ;
		}else{
			if( (now <= 23 && now >= start) || (now >=0 && now < end)) return buff ;
			else return 0f ;
		}
	}

}
