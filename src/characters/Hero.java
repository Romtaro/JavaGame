package characters;
import lsg.helpers.Dice;

public class Hero extends Character{


	/**
	 * Constructeur basique sans params
	 */
	public Hero(int f){
		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";
		this.dee = new Dice(f);

	}

	/**
	 * Constructeur Hero
	 * @param name
	 */
	public Hero(String name, int i){
		this.name = name;
		this.life = 100;
		this.stamina = 50;
		this.dee = new Dice(i);

	}



}
