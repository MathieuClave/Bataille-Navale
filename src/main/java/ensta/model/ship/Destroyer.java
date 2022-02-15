package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip {
	
	public Destroyer() {
		this.setLabel('D');
		this.setLength(2);
	}

	public Destroyer(String name, Orientation orientation) {
		super ('D', name, orientation, 2);
	}

}
