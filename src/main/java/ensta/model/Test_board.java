package ensta.model;

import java.util.Iterator;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.model.Board;

public class Test_board {
	
	public Test_board () {
		Board board = new Board ("test board", 12);
		board.print();
		}
}
 