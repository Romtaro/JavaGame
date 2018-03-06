package characters;

public class Hero extends Character{


	/**
	 * Constructeur basique sans params
	 */
	public Hero(){
		this.life = 100;
		this.stamina = 50;
		this.name = "Ynovator";

	}
	/**
	 * Constructeur Hero
	 * @param name
	 */
	public Hero(String name){
		this.name = name;
		this.life = 100;
		this.stamina = 50;
	}


}
