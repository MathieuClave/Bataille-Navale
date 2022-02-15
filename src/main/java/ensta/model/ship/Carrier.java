package ensta.model.ship;

import ensta.util.Orientation;

public class Carrier extends AbstractShip{
	
	public Carrier() {
		this.setLabel('C');
		this.setLength(5);
	}
	public Carrier(String name, Orientation orientation) {
		super ('C', name, orientation, 5);
	}
}
