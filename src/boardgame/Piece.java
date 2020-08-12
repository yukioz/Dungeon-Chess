package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	//Construtores
	
	public Piece(Board board) {
		super();
		this.board = board;
		position = null;
	}

	//Getters and Setters
	
	protected Board getBoard() {
		return board;
	}

	
	
	
	
	
}
