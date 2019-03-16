package chessengine;

import java.util.ArrayList;

import chessengine.Pieces.Bishop;
import chessengine.Pieces.King;
import chessengine.Pieces.Knight;
import chessengine.Pieces.Pawn;
import chessengine.Pieces.Piece;
import chessengine.Pieces.Queen;
import chessengine.Pieces.Rook;

public class Mechanics {
	static ArrayList<Piece> pieces;
	static boolean isWhiteToMove;
	
	static void initialisePieces(boolean whiteToMove) {
		  isWhiteToMove = whiteToMove;
		  pieces = new ArrayList<Piece>();;
		  //add player's pieces, then computer's
		  int side =1;
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
	  public static Piece occupied(int x,int y) {
		  for(int i=0;i<pieces.size();i++) {
			  if(pieces.get(i).getX()==x && pieces.get(i).getY()==y) {
				  return pieces.get(i);
			  }
		  }
		  return null;
	  }
	  
	  public static Integer checkCheck() {
		  //if no check, return null,
		  //if a check produced on the opponent and not on the current player's team
		  //return 1
		  //Otherwise, if a check produced on the current player's team, return 2
		  String myKingLocation=getKing(isWhiteToMove);
		  String theirKingLocation=getKing(!isWhiteToMove);
		  
		  
		  ArrayList<String> piecePossibleLocations;
		  for(int i=0;i<pieces.size();i++) {
			  piecePossibleLocations=pieces.get(i).getPossibleLocations();
			  for(int j=0;j<piecePossibleLocations.size();j++) {
				  if(piecePossibleLocations.get(j).equals("x"+myKingLocation)) {
					  return 2;
				  }
				  if(piecePossibleLocations.get(j).equals("x"+theirKingLocation)) {
					  return 1;
				  }
				  
			  }
		  }
		  return 0;
	  }
	  static String getKing(boolean colour) {
		  for(int i=0;i<pieces.size();i++) {
			  if(pieces.get(i).getColour()==colour && pieces.get(i).getName().equals("King")) {
				  return  pieces.get(i).getX()+""+pieces.get(i).getY();
			  }
		  }
		  return null;
	  }

	 public static boolean makeMove(String startPos,String endPos) {
		Integer startX = Integer.parseInt(startPos.substring(0,1));
		Integer startY = Integer.parseInt(startPos.substring(1));
		for(int i=0;i<pieces.size();i++) {
			 if(pieces.get(i).getX()==startX && pieces.get(i).getY()==startY) {
				  if(pieces.get(i).getColour()!= isWhiteToMove) return false;
				 
				  System.out.println(pieces.get(i));
				  ArrayList<String> piecePossibleLocations=pieces.get(i).getPossibleLocations();
				  for(int j=0;j<piecePossibleLocations.size();j++) {
					  if(piecePossibleLocations.get(j).equals(endPos)){
						  return parseAndMoveToLocation(pieces.get(i),endPos);
					  }
				  }
				  break;
			  }
		}
		
		return false;
	}

	private static boolean parseAndMoveToLocation(Piece piece, String endPos) {
		if(endPos.substring(0,1).equals("x")) {
			
		}else {
			
			//what we do is set tentative values of x and y, calculate if a check
			//on our king occurs, then if none, we return true
			//Otherwise, reset and move fails
			Integer oldXPos=piece.getX();
			Integer oldYPos=piece.getY();
			Integer newXPos = Integer.parseInt(endPos.substring(0,1));
			Integer newYPos = Integer.parseInt(endPos.substring(1));
			piece.setX(newXPos);
			piece.setY(newYPos);
			
			if(checkCheck()!=2) {
				//move is confirmed good :)
				//so other person gets to move
				isWhiteToMove=!isWhiteToMove;
				return true;
			}else {
				piece.setX(oldXPos);
				piece.setY(oldYPos);
				return false;
			}
		}
		return false;
	}
}
