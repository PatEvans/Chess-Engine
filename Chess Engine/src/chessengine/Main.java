package chessengine;

import java.util.ArrayList;

public class Main {
	
  static ArrayList<Piece> pieces;
  
  public static void main(String[] args) {
	  //1 corresponds to white, -1 to black
	  initialisePieces(true);
	  calculatePossibleMoves();
	  printPieces();
	  
  }
  
  static void initialisePieces(boolean whiteToMove) {
	  pieces = new ArrayList<Piece>();;
	  //add player's pieces, then computer's
	  int side =1;
	  System.out.println(whiteToMove);
	  for(int i=0;i<8;i++) {
		  pieces.add((Piece) new Pawn(i,1,side,whiteToMove));
	  }
	  pieces.add( (Piece) new Rook(0,0,side,whiteToMove));
	  pieces.add( (Piece) new Rook(7,0,side,whiteToMove));
	  pieces.add( (Piece) new Knight(1,0,side,whiteToMove));
	  pieces.add( (Piece) new Knight(6,0,side,whiteToMove));
	  pieces.add( (Piece) new Bishop(2,0,side,whiteToMove));
	  pieces.add( (Piece) new Bishop(5,0,side,whiteToMove));
	  pieces.add( (Piece) new Queen(3,0,side,whiteToMove));
	  pieces.add( (Piece) new King(4,0,side,whiteToMove));
	  
	  side =-side;
	  whiteToMove=!whiteToMove;
	  
	  for(int i=16;i<24;i++) {
		  pieces.add( (Piece) new Pawn(i-16,6,side,whiteToMove));
	  }
	  pieces.add( (Piece) new Rook(0,7,side,whiteToMove));
	  pieces.add( (Piece) new Rook(7,7,side,whiteToMove));
	  pieces.add( (Piece) new Knight(1,7,side,whiteToMove));
	  pieces.add( (Piece) new Knight(6,7,side,whiteToMove));
	  pieces.add( (Piece) new Bishop(2,7,side,whiteToMove));
	  pieces.add( (Piece) new Bishop(5,7,side,whiteToMove));
	  pieces.add( (Piece) new Queen(3,7,side,whiteToMove));
	  pieces.add( (Piece) new King(4,7,side,whiteToMove));
	  
	  
  }
  
  static void calculatePossibleMoves() {
	  for(int i=0;i<32;i++) {
		  pieces.get(i).possibleMoves();
	  }
  }
  static void printPieces() {
	  for(int i=0;i<32;i++) {
		  System.out.println(pieces.get(i));
	  }
  }
  static boolean occupied(int x,int y) {
	  for(int i=0;i<32;i++) {
		  if(pieces.get(i).getX()==x && pieces.get(i).getY()==y) {
			  return true;
		  }
	  }
	  return false;
  }
 
}
