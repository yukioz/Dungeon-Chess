package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Bishop extends ChessPiece {
	
	//Construtores

	public Bishop(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	//Métodos
	
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		//NW
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//reseta 'p' e calcula NE
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//reseta 'p' e calcula SW
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//reseta 'p' e calcula SE
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if(getBoard().positionExist(p) && isThereOpponentPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
