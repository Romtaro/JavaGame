package model;

public class Hero {

	protected String name;
	protected int life = 100;
	protected int maxLife;
	protected int stamina = 50;
	protected int maxStamina;

	public Hero(){
		this.name = "Ynovator";
		this.life = 100;
	}

	public Hero(String name){
		this.life = 100;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Number getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public Number getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public Number getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public Number getMaxStamina() {
		return maxStamina;
	}
	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public void printStats(){

	}
}
