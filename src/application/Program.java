package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!chessMatch.getCheckmate()) {
			
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
	
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/C/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					
					//Garante o usu�rio q digitar uma entrada correta.
					while(!type.equals("B") && !type.equals("C") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Invalid Value!\n");
						System.out.print("Enter piece for promotion (B/C/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch(ChessException e) {
				
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
			catch(InputMismatchException e) {
				
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
		}
		
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
	}

}
