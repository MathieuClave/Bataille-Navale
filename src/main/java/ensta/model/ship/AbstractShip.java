package ensta.model.ship;

import ensta.util.Orientation;

public class AbstractShip {
	private char label;
	private String name;
	private Orientation orientation;
	private int length;
	private int recievedHits;
	
	
	public char getLabel () {
		return this.label;
	}
	
	public void setLabel(char lab) {
		this.label = lab;
	}
	
	public Object getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Orientation getOrientation() {
		return this.orientation;
	}
	
	public void setOrientation(Orientation orient) {
		this.orientation = orient;
	}

	public int getLength() {
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public boolean isSunk() {
		if (recievedHits < length) { return false;}		
		return true;
	}
	public AbstractShip() {}
	
	public AbstractShip(char label, String name, Orientation orientation, int length) {
		this.label = label;
		this.name = name;
		this.orientation = orientation;
		this.length = length;
		this.recievedHits = 0;
	}

}
	