package ensta.model;

import java.util.Iterator;

import ensta.model.ship.AbstractShip;
import ensta.model.ship.NoShip;
import ensta.util.ColorUtil;
import ensta.util.Orientation;
import ensta.model.Tile;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private String name;
	private int size;
	private Tile[][] flotte;
	private boolean[][] frappes;
	
	
	public Board(String nom, int taille) {
		this.name = nom;
		this.size = taille;
		this.flotte = new Tile[taille][taille];
		this.frappes = new boolean[taille][taille];
		for (int i = 0; i<size; i++){
			for (int j = 0; j<size; j++){
				flotte[i][j]= new Tile(new Coords(i,j), new NoShip(), false);
				frappes[i][j]=false;
			}
		}
	}
	
	public Board(String nom) {
		this(nom, DEFAULT_SIZE);
	}
	
	public void print() {
		System.out.println(" Navires :                                Frappes :"); 
		
		System.out.print("   ");
		for(int j=1; j<size+1; j++) {System.out.print(String.valueOf((char)(j + 'A' - 1)) + "  ");}
		System.out.print("     ");
		for(int j=1; j<size+1; j++) {System.out.print(String.valueOf((char)(j + 'A' - 1)) + "  ");}
		System.out.print("\n");
		
		for (int i=1; i<size+1; i++) {
			System.out.print(i + " ");
			if (i<10) {System.out.print(" ");}
			
			char affichage_case ;
			for(int j=1; j<size+1; j++) {
				if (flotte[i-1][j-1].getShip().getLabel() =='D' || flotte[i-1][j-1].getShip().getLabel() == 'S' ||flotte[i-1][j-1].getShip().getLabel() == 'B' ||flotte[i-1][j-1].getShip().getLabel() == 'C'){
						affichage_case = flotte[i-1][j-1].getShip().getLabel();
				}
				else { affichage_case = '.';}
				System.out.print(affichage_case + "  ");
			}
			System.out.print("  " + i + " ");
			if (i<10) {System.out.print(" ");}
			for(int j=1; j<size+1; j++) {
				if(frappes[i-1][j-1] == false){System.out.print(".");}
				else if (frappes[i-1][j-1] == true) {System.out.print("X");}
				System.out.print("  ");
			}
			System.out.print(System.lineSeparator());
		}
		
	}
	

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation ori = ship.getOrientation();
		int dx = 0, dy = 0;
		if (ori == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (ori == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (ori == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (ori == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords shipCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(shipCoords)) {
				return false;
			}
			shipCoords.setX(shipCoords.getX() + dx);
			shipCoords.setY(shipCoords.getY() + dy);
		}

		return true;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		if(canPutShip(ship, coords)){
			Orientation ori = ship.getOrientation();
			int dx = 0, dy = 0;
			if (ori == Orientation.EAST) { dx = 1;}
			else if (ori == Orientation.NORTH) { dy = -1;}
			else if (ori == Orientation.WEST) { dx = -1; }
			else if (ori == Orientation.SOUTH){ dy = 1; }

			Coords shipCoords = new Coords(coords);
			for (int i = 0; i < ship.getLength(); ++i) {
				flotte[shipCoords.getX()][shipCoords.getY()]= new Tile(coords, ship, false);  
				shipCoords.setX(shipCoords.getX() + dx);
				shipCoords.setY(shipCoords.getY() + dy);
			}
			return(true);
		}
		else{return(false);}
	}

	@Override
	public boolean hasShip(Coords coords) {
		if (flotte[coords.getX()][coords.getY()].getShip().getLabel() == 'N' ) {
			return false;
		}
		return true;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		flotte[coords.getX()][coords.getY()].setHit(hit);
	}

	@Override
	public boolean getHit(Coords coords) {
		return (this.flotte[coords.getX()][coords.getY()].getHit());
	}

	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
}
