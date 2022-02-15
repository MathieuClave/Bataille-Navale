package ensta.model;

import java.util.Iterator;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private String name;
	private int size;
	private char[][] flotte;
	private boolean[][] frappes;
	
	
	public Board(String nom, int taille) {
		this.name = nom;
		this.size = taille;
		this.flotte = new char[taille][taille];
		this.frappes = new boolean[taille][taille];
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
				if (flotte[i-1][j-1] =='D' || flotte[i-1][j-1] == 'S' ||flotte[i-1][j-1] == 'B' ||flotte[i-1][j-1] == 'C'){
						affichage_case = flotte[i-1][j-1];
				}
				else { affichage_case = '.';}
				System.out.print(affichage_case + "  ");
			}
			System.out.print("  " + i + " ");
			if (i<10) {System.out.print(" ");}
			for(int j=1; j<size+1; j++) {
				if (frappes[i-1][j-1]){
					affichage_case = 'x';
				}
				else { affichage_case = '.';}
				System.out.print(affichage_case + "  ");
			}
			System.out.print(System.lineSeparator());
		}
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasShip(Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getHit(Coords coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
}
