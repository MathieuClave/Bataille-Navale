package ensta;

import ensta.controller.Game;
import ensta.model.Board;

public class Main {

	public static void main(String args[]) {
        Board board = new Board ("test board", 12);
        board.print();
    }

}
