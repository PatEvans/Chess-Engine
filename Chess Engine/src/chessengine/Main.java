package chessengine;

public class Main {
	
  static Piece[] pieces;
  static void initialisePieces(int whiteToMove) {
	  pieces = new Piece[32];
	  //add player's pieces, then computer's
	  
	  int colour=whiteToMove;
	  for(int i=0;i<8;i++) {
		  pieces[i]= (Piece) new Pawn(i,1,colour);
	  }
	  pieces[8]= (Piece) new Rook(0,0,colour);
	  pieces[9]= (Piece) new Rook(7,0,colour);
	  pieces[10]= (Piece) new Knight(1,0,colour);
	  pieces[11]= (Piece) new Knight(6,0,colour);
	  pieces[12]= (Piece) new Bishop(2,0,colour);
	  pieces[13]= (Piece) new Bishop(5,0,colour);
	  pieces[14]= (Piece) new Queen(3,0,colour);
	  pieces[15]= (Piece) new King(4,0,colour);
	  
	  colour =-colour;
	  
	  for(int i=16;i<24;i++) {
		  pieces[i]= (Piece) new Pawn(i-16,7,colour);
	  }
	  pieces[24]= (Piece) new Rook(0,8,colour);
	  pieces[25]= (Piece) new Rook(7,8,colour);
	  pieces[26]= (Piece) new Knight(1,8,colour);
	  pieces[27]= (Piece) new Knight(6,8,colour);
	  pieces[28]= (Piece) new Bishop(2,8,colour);
	  pieces[29]= (Piece) new Bishop(5,8,colour);
	  pieces[30]= (Piece) new Queen(3,8,colour);
	  pieces[31]= (Piece) new King(4,8,colour);
	  
  }
  static void printPieces() {
	  for(int i=0;i<32;i++) {
		  System.out.println(pieces[i]);
	  }
  }
  
  public static void main(String[] args) {
	  //1 corresponds to white, -1 to black
	  initialisePieces(1);
	  printPieces();
  }
}