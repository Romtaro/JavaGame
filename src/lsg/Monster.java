package lsg;

public class Monster {
	private String name;
	private int life = 10;
	private int maxLife;
	private int stamina = 10;
	private int maxStamina;
	private static int instances = 0;

	public Monster(){
		INSTANCES_COUNT();
		this.name = "YMonster n°"+instances;

	}

	public Monster(String name){
		INSTANCES_COUNT();
		this.name = name +" n°"+instances;

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
	 String isAlive(){
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

	private static void INSTANCES_COUNT(){
		instances = ++instances;
	}

}
