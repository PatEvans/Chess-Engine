package chessengine;

public class Main {
  
  public static void main(String[] args) {
	  //true corresponds to white to move, false to black
	  Mechanics.initialisePieces(true);
	  Mechanics.calculatePossibleMoves();
	  Mechanics.printPieces();
	  
  }
  
}