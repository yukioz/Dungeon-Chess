package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {

	
	private Board board;
	
	//Constutores
	
	public ChessMatch () {
		
		board = new Board(8, 8);
		initialSetup();
	}
	
	//M�todos
	
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public void initialSetup() {
		
		board.placePiace(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiace(new King(board, Color.BLACK), new Position(0, 4));
		
	}
	
}
