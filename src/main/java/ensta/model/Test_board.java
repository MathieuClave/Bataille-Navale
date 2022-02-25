package ensta.model;

import java.util.Iterator;

import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.util.Orientation;
import ensta.model.Board;

public class Test_board {
	
	public Test_board () {
		Board board = new Board ("test board", 12);
		
		
		BattleShip bs = new BattleShip();
		Carrier ca = new Carrier("ca", Orientation.WEST);
		board.putShip(bs, new Coords(1,1));
		board.putShip(ca, new Coords(6,6));
		board.print();
		}
}
 