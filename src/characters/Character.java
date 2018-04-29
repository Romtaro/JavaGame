package characters;
import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.buffs.rings.Ring;
import lsg.helpers.Dice;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import characters.Monster;
import consumables.Consumable;
import consumables.MenuBestOfV4;
import consumables.drinks.Drink;
import consumables.drinks.Whisky;
import consumables.food.Americain;
import consumables.food.Food;
import consumables.reapir.RepairKit;

import java.util.Scanner;
import java.nio.Buffer;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;


public abstract class Character {

	public Dice dee;
	public Weapon weapon;
	public Sword sword;





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
	private Consumable consumable;
	private Bag bag = new SmallBag(10);


	public Consumable getConsumable() {
		return consumable;
	}
	public void setConsumable(Consumable consumable) {
		this.consumable = consumable;
	}
	public void pickUp(Collectible item){
		System.out.println(getName() +" picks " + item.toString());
		this.bag.push(item);
	}
	public Collectible pullOut(Collectible item){
		if(this.bag.contains(item)){
			this.bag.pop(item);
			System.out.println(getName() +" pull " + item.toString());
			return item;
		}
		else{
			return null;
		}
	}
	public int getBagCapacity(){
		return this.bag.getCapacity();
	}
	public int getBagWeight(){
		return this.bag.getWeight();
	}
	public Collectible[] getBagItems(){
		return bag.getItems();
	}
	public Bag setBag(Bag bag){
		System.out.println(getName()+ " changes "+ this.bag.getClass().getSimpleName() +  " for "+ bag.getClass().getSimpleName());
		this.bag.transfer(this.bag, bag);
		return this.bag = bag;
	}
	public Weapon equip(Weapon weapon){
		if(this.bag.contains(weapon)){
			System.out.println(getName() + " equipe "+ weapon.toString());
			this.bag.push(getWeapon());
			setWeapon(weapon);
			this.bag.pop(weapon);
			return weapon;
		}else{
			return null;
		}
	}

	public Consumable equip(Consumable consumable){
		if(this.bag.contains(consumable)){
			System.out.println(getName() + " equipe "+ consumable.toString());
			setConsumable(consumable);
			this.bag.pop(consumable);
			return consumable;

		}else{
			return null;
		}
	}

	public String printBag(){
		return this.bag.toString();
	}
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
		@Override
		public String toString(){
			String protect = NumberFormat.getNumberInstance(Locale.US).format(computeProtection());

			return String.format("%-20s %-20s  %-20s %-20s %-20s %-20s %-20s", "["+getClass().getSimpleName()+"] ", getName(), LIFE_STAT_STRING() ,STAM_STAT_STRING(), "PROTECTION: "+ protect, "Buff :"+ buff(), isAlive());
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
		 this.attackWith(getWeapon());

		return this.getHitWith(this.total);

	}

	public int getHitWith(int value){

		float dmg = value;
		//System.out.println("dmg : : " +dmg);
		return (int)dmg;
	}

	public void combat(Hero charactereHero, Monster charactereMonstre){
		///Resum//
		refreshVs(charactereHero, charactereMonstre);

				///////
		while(!(charactereHero.getLife()==0) && !(charactereMonstre.getLife() == 0) && !(charactereHero.getStamina() == 0)){

			int restH = 0;
			int restM = 0;
			int dmg = 0;
			int dmgM = 0;
			//int vieHero = charactereHero.getLife();
			//int vieMonster = charactereMonstre.getLife();
			//int vieBaseHero = charactereHero.getLife();
			//int vieBaseMonster = charactereMonstre.getLife();
			/////Tour Hero////
			int action =refresh(charactereHero, charactereMonstre);

			if(action ==1){


			System.out.println(charactereHero.getConsumable().toString());
			System.out.println(charactereHero.getWeapon().toString());
			System.out.println(charactereHero.getName()+" Attaque "+charactereMonstre.getName()+"\n");
			//on calcul vie en moins///
			float viemoinsh =charactereHero.attack() * charactereMonstre.computeProtection()/100 ;

			//System.out.println(((Hero) charactereHero).getTotalBuff());
			int finaldmgH = charactereHero.total - (int) viemoinsh;
			//ok on enleve la vie//
			if(!(charactereHero.getStamina()==0)){
				restH = (int) (charactereMonstre.getLife() - (finaldmgH+ charactereHero.getTotalBuff()));
				dmg = (int) (finaldmgH+ charactereHero.getTotalBuff());
			}else{
				restH = charactereMonstre.getLife() - finaldmgH;
				dmg = (int) (finaldmgH);
			}
			int resH = (restH>0) ? restH: 0;
			charactereMonstre.setLife(resH);
			////
			dmg = (int) (finaldmgH+ charactereHero.getTotalBuff());
			System.out.println(charactereMonstre.getName()+" prend "+ dmg +" de dommage \n Il ne reste : "+ resH + " PDV\n" );
			}else if(action ==2){
				charactereHero.consume();
				//vieHero =charactereHero.getLife();
			}else{

			}
			////////Tour Monstre//////////
			if(charactereMonstre.getLife()>0){

			float viemoins = charactereMonstre.attack() * charactereHero.computeProtection()/100;
			int finaldmgM = charactereMonstre.total - (int)viemoins;
			if(!(charactereMonstre.getStamina() == 0)){
			 restM = (int) (charactereHero.getLife() - (finaldmgM + charactereMonstre.getTotalBuff()));
			 dmgM = (int) (finaldmgM + charactereMonstre.getTotalBuff());
			}else{
				restM = charactereHero.getLife() - finaldmgM;
				dmgM = (int) (finaldmgM);
			}
			int resM = (restM>0) ? restM: 0;
			charactereHero.setLife(resM);

			System.out.println(charactereHero.getName()+" prend "+ dmgM +" de dommage \n Il ne reste : "+ resM + " PDV\n" );

			}
			else{

				System.out.println(charactereMonstre.getName()+" est mort de ses blessures");

			}

		}if(charactereHero.getLife()==0){

			System.out.println(charactereHero.getName()+" est mort de ses blessures");
		}
		if(charactereHero.getStamina()== 0 && charactereMonstre.getStamina()==0){
			System.out.println("Match null, les deux combattants sont épuissés ");
		}

	}

	public int refresh(Hero charactereHero, Monster charactereMonstre){

		System.out.println("Hero’s action for next move --> (1) attack | (2) consume :");

		int st = scanner.nextInt();
		///Resum//
		if(st==1 || st ==2){
		System.out.println(charactereHero.toString());
		System.out.println(charactereMonstre.toString()+("\n"));
		}
		else{
			refresh(charactereHero,charactereMonstre);
		}
		///////
		return st;
	}
	public void refreshVs(Character charactereHero, Monster charactereMonstre){
		System.out.println("Hit enter --> key for start:");
		String st = scanner.nextLine();
		System.out.println("\t \t \t \t COMBAT START");
		System.out.println(charactereHero.getConsumable().toString());
		System.out.println(charactereHero.getWeapon().toString());
		System.out.println(charactereHero.toString());
		System.out.println("\t \t \t VS");
		System.out.println(charactereMonstre.toString()+("\n"));
	}
	public abstract float computeProtection();
	public abstract float buff();

	public String LIFE_STAT_STRING(){
		return  String.format("%-20s"," life :"+ this.life);
	}

	public String STAM_STAT_STRING(){
		return  String.format("%-20s","Stamina :"+ this.stamina);
	}
	public String ARMOR_STAT_STRING(){
		return  String.format("%-20s","Armor :"+ computeProtection());
	}
	public String BUFF_STAT_STRING(){
		return  String.format("%-20s","BUFF :"+ buff());
	}

	public void use(Consumable consumable){

		String Class = consumable.getClass().getSimpleName().toString();
		if(Class.equals("Drink")){
			drink((Drink)consumable);

		}else if(Class.equals("Food")){
			eat((Food) consumable);
		}else if(Class.equals("RepairKit")){
			repairWeaponWith((RepairKit)consumable);
		}else{
			System.out.println("A sec ! :p ");
		}
	}

	private void drink(Drink drink){
		System.out.println("Avant consommation "+getName()+" " +drink.toString() );
		if(!(this.stamina == this.maxStamina)){
		int boisson = drink.use();
		setStamina(getStamina()+boisson);
		}else{
			System.out.println("Stamina au max !! ");
		}
		if(this.stamina>this.maxStamina){
			setStamina(this.maxStamina);

		}
		System.out.println("Apres consommation "+getName()+" " +drink.toString() );
	}

	private void eat(Food food){
		System.out.println("Avant consommation "+getName()+" " +food.toString() );
		if(!(this.life == this.maxLife)){
		int miam = food.use();
		setLife(getLife()+miam);
		}else{
			System.out.println("PDV déja au max ! ");
		}
		if(this.life>this.maxLife){

			setLife(this.maxLife);
		}
		System.out.println("Apres consommation "+getName()+" " +food.toString() );
	}

	private void repairWeaponWith(RepairKit kit){
		if(kit.getCapacity() > 0){
			if(getWeapon().getDurability() < getWeapon().getMaxDurability()){
				System.out.println(getName()+" "+ getWeapon().toString()+" with " + kit.toString() );
			getWeapon().setDurability(getWeapon().getDurability() + kit.use());
				System.out.println(getName()+" "+ getWeapon().toString()+" with " + kit.toString() );
			}else{
				System.out.println("Durability au max ! ");
			}
		}
			else{
				System.out.println("a pu de kit :'( ");
			}
	}
	public void consume(){
		use(getConsumable());
	}
	private Consumable fastUseFirst(Object type){

		Consumable consumable = null;
		for(int i =0; i< getBagItems().length; i++ ){

		if(this.bag.getItems()[i].getClass().getTypeName() == type){

			System.out.println("ok");
			System.out.println(getName() + " eat " + this.bag.getItems()[i].toString());
		//	System.out.println(this.bag.getItems()[i].toString());
			use((Consumable) this.bag.getItems()[i]);
			consumable = (Consumable) this.bag.getItems()[i];
			pullOut(this.bag.getItems()[i]);
			//return this.bag.getItems()[i];

			return consumable;
		}else{
			System.out.println("nn");

		}

		}
		return consumable;
	}
	public Drink fastDrink(){
		return (Drink) fastUseFirst("consumables.drink.Drink");

	}
	public Food fastEat(){
		return (Food) fastUseFirst("consumables.food.Food");
	}
	public RepairKit fastRepair(){

		return (RepairKit) fastUseFirst("consumables.reapir.RepairKit");
	}
	public static void main(String[] args) {
		Whisky whisky = new Whisky();
		Americain americain = new Americain();
		RepairKit kit = new RepairKit("df", 10, "sd");
		Sword sword = new Sword();
		Hero heros = new Hero(100, sword);
		heros.use(whisky.whisky);
		heros.use(americain.americain);
		heros.use(kit);
		heros.pickUp(americain.americain);
		heros.pickUp(americain.americain);
		heros.pickUp(americain.americain);

		System.out.println(americain.americain.getClass().getTypeName());



	}
}
