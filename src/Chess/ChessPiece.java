package Chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {

	private Color color;
	
	//Construtores

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	//Getters and Setters

	public Color getColor() {
		return color;
	}

	// 
	 
	
}
