package ensta.model;

import ensta.model.ship.AbstractShip;

public class Tile {
	private Coords coords;
	private AbstractShip ship;
	private boolean isHit;
	
	public Tile (Coords where, AbstractShip what, boolean how) {
		this.coords = where;
		this.ship = what;
		this.isHit = how;
	}
	
	public Coords getCoords() {return this.coords;}
	public AbstractShip getShip () {return this.ship;}
	public boolean getHit () {return this.isHit;}

}
