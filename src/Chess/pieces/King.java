package Chess.pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	//Construtores

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	private boolean testRookCasteling(Position position) {
		
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// NW
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// NE
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// SW
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// SE
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExist(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// Roque
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {

			// Esquerda
			Position t1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCasteling(t1)) {
				Position aux = new Position(position.getRow(), position.getColumn() + 1);
				Position aux2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(aux) == null && getBoard().piece(aux2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// Direita
			Position t2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCasteling(t2)) {
				Position aux = new Position(position.getRow(), position.getColumn() - 1);
				Position aux2 = new Position(position.getRow(), position.getColumn() - 2);
				Position aux3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(aux) == null && getBoard().piece(aux2) == null && getBoard().piece(aux3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}

		}

		return mat;
	}

}
