package boardgame;

public class Board {

	private int rows;
	private int columns;
	//Cria um tabuleiro, os valores são postos quando se cria um "new piece"
	
	//Explicando o nome: É uma matriz de peça que pode alocar várias peças. Não confunda lugar da peça com a peça.
	private Piece[][] pieces;
	
	//Construtores
	
	public Board(int rows, int columns) {
		
		//Exception
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating the board: there must be at least 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		//Diz quantos quadrados terá a matriz do tabuleiro
		pieces = new Piece[rows][columns];
	}

	//Getters and Setters
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	//Métodos
	
	public Piece piece (int row, int column) {
		
		//Exception
		if(!positionExist(row, column)) {
			throw new BoardException("Position not on the Board");
		}
		
		return pieces[row][column];
	}
	public Piece piece (Position position) {
		
		//Exception
		if(!positionExist(position)) {
			throw new BoardException("Position not on the Board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece (Piece piece, Position position) {
		
		//Exception
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position: " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Testa posição válida dentro do tabuleiro
	public boolean positionExist(int row, int column) {
		
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExist(Position position) {
		
		return positionExist(position.getRow(), position.getColumn());
	}
	
	//Testa se já existe uma peça naquela posição
	public boolean thereIsAPiece(Position position) {
		
		//Exception
		if(!positionExist(position)) {
			throw new BoardException("Position not on the Board");
		}
		
		return piece(position) != null;
	}
	
	//Remover peça
	public Piece removePiece(Position position) {
		
		if(!positionExist(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
}
