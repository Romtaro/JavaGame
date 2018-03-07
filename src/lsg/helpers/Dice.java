package lsg.helpers;

import java.util.Random;

public class Dice {

	private int face;
	public int random;

	public Dice(int face){
		this.face = face;
	}

	/**
	 * La valeurs du optenu avec le lancer est bien compris entre 0 et 49
	 * @param args
	 * @return
	 *
	 */
/*
public static void main(String[] args) {
	Dice d = new Dice(50);

	for(int i=0; i<500; i++){
		d.roll();
		System.out.print(d.random+"\n");
	}

}
*/
public int roll(){
	//System.out.println("oui");
	Random r = new Random();
	this.random = r.nextInt(this.face);
	return this.random;
}
}
