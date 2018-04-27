package consumables.reapir;

import consumables.Consumable;

public class RepairKit extends Consumable{

	public RepairKit(String name, int capacity, String stat) {
		super(name = "Repair Kit", capacity=10, stat=" Durability");
		// TODO Auto-generated constructor stub
	}
	@Override
	public int use(){
		int renvois = 1;
		setCapacity(getCapacity()-renvois);
		return renvois;
	}
}
