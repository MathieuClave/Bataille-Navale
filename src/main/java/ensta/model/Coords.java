package ensta.model;

import java.util.Random;

public class Coords {
	
	private int x;
    private int y;

	public Coords(Coords coords) {
		this.x = coords.getX();
        this.y = coords.getY();
    }

	public Coords() {
		this.x = 0;
		this.y = 0;
	}

	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int i) {
		this.x = i;
		
	}

	public void setY(int i) {
		this.y = i;
		
	}

	public void setCoords(Coords res) {
		this.x = res.getX();
		this.y = res.getY();
		
	}

	public boolean isInBoard(int size) {
	    return(this.x < size && this.y < size);
	}

	public static Coords randomCoords(int size) {
        Random rand =  new Random();
        return(new Coords(rand.nextInt(size),rand.nextInt(size)));
    }

	public void setCoords(int x, int y) {
		this.setX(x);
		this.setY(y);	
	}

}
