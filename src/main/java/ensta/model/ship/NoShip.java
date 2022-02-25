package ensta.model.ship;

import ensta.util.Orientation;

public class NoShip extends AbstractShip {
	
	public NoShip() {
		this.setLabel('N');
		this.setLength(0);
	}
	
	public NoShip(String name, Orientation orientation) {
		super ('N', name, orientation, 0);
	}

}
