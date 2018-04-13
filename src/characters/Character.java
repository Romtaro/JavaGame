package characters;
import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import characters.Monster;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;


public abstract class Character {

	public Dice dee;
	public Weapon weapon;
	public Sword sword;
	public Monster monster;
	Scanner scanner = new Scanner(System.in);

	/**
	 * Pour le moment nous devons passer name life et stamine et protected pour les modifier dans la classe fille
	 * Sans ça nous ne pouvons pas faire de la vie et de la force personnalisé pour chaque race
	 */
	protected String name;
	protected int life;
	private int maxLife;
	protected int stamina;
	private int maxStamina;
	public int total;

	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon ) {
		this.weapon = weapon;
	}
	public Sword getSword() {
		return sword;
	}
	public void setSword(Sword weapon ) {
		this.sword = sword;
	}
	public int getLife() {
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
		System.out.println(String.format("%-20s %-20s  %-20s %-20s %-20s %-20s", "["+getClass().getSimpleName()+"]", getName(), getLife(), getStamina(), computeProtection(), isAlive()));
	}
		public String toString(){
			String protect = NumberFormat.getNumberInstance(Locale.US).format(computeProtection());

			return String.format("%-20s %-20s  %-20s %-20s %-20s %-20s", "["+getClass().getSimpleName()+"] ", getName(), "Life: "+getLife(),"Stamina: "+ getStamina(), "PROTECTION: "+ protect,isAlive());
		}
	/**
	 * On va regarder si un joueur est en vie suivant le boolean on return un string alive ou dead
	 * @return alive
	 */
	public String isAlive(){
		String alive;

		if(getLife() > 0){

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
		this.total = 0;
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
				this.total = this.getStamina();
				this.setStamina(0);
			}
			this.total = this.total+minDmg;
			this.weapon.setDurability(weapon.getDurability()-1);
			if(this.total < 0){
				return 0;
			}else{
				return this.total;
			}
		}else if(pres == 100){
			this.setStamina(getStamina()-weapon.getStamCost());
			if(getStamina() <0){
				this.total = this.getStamina();
				this.setStamina(0);
			}
			this.total = this.total+maxDmg;
			this.weapon.setDurability(weapon.getDurability()-1);

			return this.total;
		}else{
			this.setStamina(this.getStamina()-weapon.getStamCost());
			if(this.getStamina() <0){
				this.total = this.getStamina();

				this.setStamina(0);
			}
			//System.out.println(pres);
			double stock = pres/100*ecard;
			int stock2 = (int) Math.round(stock);
			//System.out.println("total : : " +total);
			this.total = this.total+minDmg+stock2 ;
			//System.out.println("total : : " +total);
			this.weapon.setDurability(weapon.getDurability()-1);
			if(this.total < 0){
				return 0;
			}else{
				//System.out.println("toto: "+this.total);
			return this.total;
			}

		}

		}
	public int getDe(){
		int de = this.dee.roll();
		//System.out.println("recup de value de : "+ de);
		return de;
	}
	public int attack(){
		 this.attackWith(this.weapon);
		return this.getHitWith(this.total);

	}

	public int getHitWith(int value){

		float dmg = value;
		//System.out.println("dmg : : " +dmg);
		return (int)dmg;
	}

	public void combat(Character charactereHero, Character charactereMonstre){
		///Resum//
		refreshVs(charactereHero, charactereMonstre);

				///////
		while(!(charactereHero.getLife()==0) && !(charactereMonstre.getLife() == 0) && !(charactereHero.getStamina() == 0)){

			int vieHero = charactereHero.getLife();
			int vieMonster = charactereMonstre.getLife();
			int vieBaseHero = charactereHero.getLife();
			int vieBaseMonster = charactereMonstre.getLife();
			/////Tour Hero////
			System.out.println(charactereHero.getName()+" Attaque "+charactereMonstre.getName()+"\n");
			//on calcul vie en moins///
			float viemoinsh =charactereHero.attack() * charactereMonstre.computeProtection()/100 ;
			int finaldmgH = charactereHero.total - (int) viemoinsh;
			//ok on enleve la vie//
			int restH = vieMonster - finaldmgH;

			int resH = (restH>0) ? restH: 0;
			charactereMonstre.setLife(resH);
			////
			int dmg = vieBaseMonster - restH;
			System.out.println(charactereMonstre.getName()+" prend "+ dmg +" de dommage \n Il ne reste : "+ resH + " PDV\n" );

			////////Tour Monstre//////////
			if(charactereMonstre.getLife()>0){
			float viemoins = charactereMonstre.attack() * charactereHero.computeProtection()/100;
			int finaldmgM = charactereMonstre.total - (int)viemoins;
			int restM = vieHero - finaldmgM;

			int resM = (restM>0) ? restM: 0;
			charactereHero.setLife(resM);
			int dmgM = vieBaseHero - restM;
			System.out.println(charactereHero.getName()+" prend "+ dmgM +" de dommage \n Il ne reste : "+ resM + " PDV\n" );
			refresh(charactereHero, charactereMonstre);
			}
			else{
				refresh(charactereHero, charactereMonstre);
				System.out.println(charactereMonstre.getName()+" est mort de ses blessures");

			}

		}if(charactereHero.getLife()==0){

			System.out.println(charactereHero.getName()+" est mort de ses blessures");
		}
		if(charactereHero.getStamina()== 0 && charactereMonstre.getStamina()==0){
			System.out.println("Match null, les deux combattants sont épuissés ");
		}

	}

	public void refresh(Character charactereHero, Character charactereMonstre){
		System.out.println("Hit enter --> key for next move :");
		String st = scanner.nextLine();
		///Resum//
		System.out.println(charactereHero.toString());
		System.out.println(charactereMonstre.toString()+("\n"));
		///////
	}
	public void refreshVs(Character charactereHero, Character charactereMonstre){
		System.out.println("Hit enter --> key for next move :");
		String st = scanner.nextLine();
		System.out.println("\t \t \t \t COMBAT START");
		System.out.println(charactereHero.toString());
		System.out.println("\t \t \t VS");
		System.out.println(charactereMonstre.toString()+("\n"));
	}
	public abstract float computeProtection();
}
