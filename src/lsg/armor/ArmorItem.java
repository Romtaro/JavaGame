package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{
	private String name;
	private float armorValue;

	public ArmorItem(String name, float armorValue){

		this.name = name;
		this.armorValue =(float)armorValue;

	}
	public String toString(){
		return String.format(getName()+"("+getArmorValue() + ")");
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public float getArmorValue() {
		return armorValue;
	}
	private void setArmorValue(float armorValue) {
		this.armorValue = armorValue;
	}
	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 4;
	}

}

