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
	protected void setName(String name) {
		this.name = name;
	}
	public Number getLife() {
		return life;
	}
	protected void setLife(int life) {
		this.life = life;
	}
	public Number getMaxLife() {
		return maxLife;
	}
	protected void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public Number getStamina() {
		return stamina;
	}
	protected void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public Number getMaxStamina() {
		return maxStamina;
	}
	protected void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public void printStats(){
		System.out.print(getName() +"/t"+getLife().toString()+"/t"+ getStamina().toString());
	}
}
