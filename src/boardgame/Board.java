package boardgame;

public class Board {

	private int rows;
	private int columns;
	//Cria um tabuleiro, os valores s�o postos quando se cria um "new piece"
	
	//Explicando o nome: � uma matriz de pe�a que pode alocar v�rias pe�as. N�o confunda lugar da pe�a com a pe�a.
	private Piece[][] pieces;
	
	//Construtores
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//Diz quantos quadrados ter� a matriz do tabuleiro
		pieces = new Piece[rows][columns];
	}

	//Getters and Setters
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	//M�todos
	
	public Piece piece (int row, int column) {

		return pieces[row][column];
	}
	public Piece piece (Position position) {
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiace (Piece piece, Position position) {
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
}
