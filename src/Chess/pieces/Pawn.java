package Chess.pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Primeira vez andando
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExist(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Tomar uma pe�a 1� diagonal
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Tomar uma pe�a 2� diagonal
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Enpassant White
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExist(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassant()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExist(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassant()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Primeira vez andando
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExist(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Tomar uma pe�a 1� diagonal
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//Tomar uma pe�a 2� diagonal
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}	
			
			//Enpassant Black
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExist(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassant()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExist(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassant()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
