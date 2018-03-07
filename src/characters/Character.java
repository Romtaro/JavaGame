package characters;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;


public class Character {
	public Dice dee;
	public Weapon weapon;
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
	public int getStamina() {
		return stamina;
	}
	protected void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getMaxStamina() {
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
			return String.format("%-20s %-20s  %-20s %-20s %-20s ", "["+getClass().getSimpleName()+"] ", getName(), "Life: "+getLife(),"Stamina: "+ getStamina(),isAlive());
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

	private int attackWith(Weapon weapon){
		double pres =0;
		int minDmg=0;
		int maxDmg=0;
		int total = 0;
		int ecard =0;

		//si l'arme et broken il perd de l'energie ? si l'energie est vide il perd de la résis ?
		if(weapon.isBroken() ==0 || this.getStamina() == 0){

			return 0;
		}

		pres = getDe();
		minDmg = this.weapon.getMinDamage();
		maxDmg = this.weapon.getMaxDamage();
		ecard = maxDmg - minDmg;

		if(pres == 0){
			this.setStamina(this.getStamina()-weapon.getStamCost());
			if(this.getStamina() <0){
				total = this.getStamina();
				this.setStamina(0);
			}
			total = total+minDmg;
			this.weapon.setDurability(weapon.getDurability()-1);
			if(total < 0){
				return 0;
			}else{
				return total;
			}
		}else if(pres == 100){
			this.setStamina(getStamina()-weapon.getStamCost());
			if(getStamina() <0){
				total = this.getStamina();
				this.setStamina(0);
			}
			total = total+maxDmg;
			this.weapon.setDurability(weapon.getDurability()-1);

			return total;
		}else{
			this.setStamina(this.getStamina()-weapon.getStamCost());
			if(this.getStamina() <0){
				total = this.getStamina();

				this.setStamina(0);
			}
			//System.out.println(pres);
			double stock = pres/100*ecard;
			int stock2 = (int) Math.round(stock);
			//System.out.println("total : : " +total);
			total = total+minDmg+stock2 ;

			this.weapon.setDurability(weapon.getDurability()-1);
			if(total < 0){
				return 0;
			}else{
			return total;
			}
		}

		}
	public int getDe(){
		int de = this.dee.roll();
		//System.out.println("recup de value de : "+ de);
		return de;
	}
	public int Attack(){
		return this.attackWith(this.weapon);

	}

}
