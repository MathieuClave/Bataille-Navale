package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip{

	public BattleShip() {
		this.setLabel('B');
		this.setLength(4);
	}
	
	public BattleShip(String name, Orientation orientation) {
		super ('B', name, orientation, 4);
	}
}
