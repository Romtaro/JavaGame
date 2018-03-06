package lsg.helpers;

import java.util.Random;

public class Dice {

	private int face;
	private int random;

	public Dice(int face){
		this.face = face;
	}

	/**
	 * La valeurs du optenu avec le lancer est bien compris entre 0 et 49
	 * @param args
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
private void roll(){
	Random r = new Random();
	this.random = r.nextInt(this.face);

}
}
