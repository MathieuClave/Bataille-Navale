package ensta.model.ship;

import ensta.util.Orientation;

public class Submarine extends AbstractShip {
	
	public Submarine() {
		this.setLabel('S');
		this.setLength(3);
	}
	
	public Submarine(String name, Orientation orientation) {
		super ('S', name, orientation, 3);
	}

}
