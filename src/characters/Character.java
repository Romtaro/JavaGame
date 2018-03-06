package characters;

public class Character {
	/**
	 * Pour le moment nous devons passer name life et stamine et protected pour les modifier dans la classe fille
	 * Sans ça nous ne pouvons pas faire de la vie et de la force personnalisé pour chaque race
	 */
	protected String name;
	protected int life;
	private int maxLife;
	protected int stamina;
	private int maxStamina;


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
		/**
		 * getClass().getSimpleName() va permettre de récuperer le nom de la class mère si un Hero et créer alors il écrira Hero. Si Monster créer alors il affichera Monster
		 * getClass().getName() récupére "characters.Monster" et pas seulement Monster
		 */
		public void printStats(){
		System.out.println(String.format("%-20s %-20s  %-20s %-20s %-20s ", "["+getClass().getSimpleName()+"]", getName(), getLife(), getStamina(),isAlive()));
	}
		public String toString(){
			return String.format("%-20s %-20s  %-20s %-20s %-20s ", "["+getClass().getSimpleName()+"]", getName(), getLife(), getStamina(),isAlive());
		}
	/**
	 * On va regarder si un joueur est en vie suivant le boolean on return un string alive ou dead
	 * @return alive
	 */
	public String isAlive(){
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
