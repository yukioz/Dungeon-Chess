package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
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
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
