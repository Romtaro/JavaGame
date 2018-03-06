package lsg;

public class Hero {

	private String name;
	private int life = 100;
	private int maxLife;
	private int stamina = 50;
	private int maxStamina;

	public Hero(){
		this.name = "Ynovator";
	}

	public Hero(String name){
		this.name = name;
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
		System.out.println(getName() +"\t"+getLife().toString()+"\t"+ getStamina().toString()+"\t"+ isAlive());
	}
	 protected String isAlive(){
		String alive;
		boolean dead;
		dead = getLife().equals(0);
		if(dead == false){
			alive = "(ALIVE)";
		}
		else{
			alive = "(DEAD)";
		}
		return alive;
	}
}
