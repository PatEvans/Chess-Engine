package chessengine;

import java.util.ArrayList;
import java.util.HashMap;

import chessengine.Pieces.Bishop;
import chessengine.Pieces.King;
import chessengine.Pieces.Knight;
import chessengine.Pieces.Pawn;
import chessengine.Pieces.Piece;
import chessengine.Pieces.Queen;
import chessengine.Pieces.Rook;

public class Mechanics {
	static HashMap<String,Piece> pieces;
	static boolean isWhiteToMove;
	
	static void initialisePieces(boolean whiteToMove) {
		  isWhiteToMove = whiteToMove;
		  pieces = new HashMap<String,Piece>();;
		  //add player's pieces, then computer's
		  int side =1;
		  for(int i=0;i<8;i++) {
			  pieces.put(i+"1",(Piece) new Pawn(i,1,side,whiteToMove));
		  }
		  pieces.put("00", (Piece) new Rook(0,0,side,whiteToMove));
		  pieces.put("70",(Piece) new Rook(7,0,side,whiteToMove));
		  pieces.put("10",(Piece) new Knight(1,0,side,whiteToMove));
		  pieces.put("60",(Piece) new Knight(6,0,side,whiteToMove));
		  pieces.put("20",(Piece) new Bishop(2,0,side,whiteToMove));
		  pieces.put("50",(Piece) new Bishop(5,0,side,whiteToMove));
		  pieces.put("30",(Piece) new Queen(3,0,side,whiteToMove));
		  pieces.put("40",(Piece) new King(4,0,side,whiteToMove));
		  
		  side =-side;
		  whiteToMove=!whiteToMove;
		  
		  for(int i=16;i<24;i++) {
			  pieces.put((i-16)+"6",(Piece) new Pawn(i-16,6,side,whiteToMove));
		  }
		  pieces.put("07",(Piece) new Rook(0,7,side,whiteToMove));
		  pieces.put("77",(Piece) new Rook(7,7,side,whiteToMove));
		  pieces.put("17",(Piece) new Knight(1,7,side,whiteToMove));
		  pieces.put("67",(Piece) new Knight(6,7,side,whiteToMove));
		  pieces.put("27",(Piece) new Bishop(2,7,side,whiteToMove));
		  pieces.put("57",(Piece) new Bishop(5,7,side,whiteToMove));
		  pieces.put("37",(Piece) new Queen(3,7,side,whiteToMove));
		  pieces.put("47",(Piece) new King(4,7,side,whiteToMove));
		  
		  
	  }
	  
	
	  static void calculatePossibleMoves() {
		  //for(int i=0;i<pieces.size();i++) {
			//  pieces.get(i).possibleMoves();
		  //}
		  for (Piece piece : pieces.values()) {
			    piece.possibleMoves();
			}
	  }
	  static void printPieces() {
		  for (Piece piece : pieces.values()) {
			  System.out.println(piece);
			}
	  }
	  public static Piece occupied(int x,int y) {
		  
		  return pieces.get(x+""+y);
			  
	  }
	  
	  public static Integer checkCheck() {
		  //if no check, return null,
		  //if a check produced on the opponent and not on the current player's team
		  //return 1
		  //Otherwise, if a check produced on the current player's team, return 2
		  String myKingLocation=getKing(isWhiteToMove);
		  String theirKingLocation=getKing(!isWhiteToMove);
		  calculatePossibleMoves();
		  
		  ArrayList<String> piecePossibleLocations;
		  for (Piece piece : pieces.values()) {
			  piecePossibleLocations=piece.getPossibleLocations();
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
		  for (Piece piece : pieces.values()) {
			  if(piece.getColour()==colour && piece.getName().equals("King")) {
				  return  piece.getX()+""+piece.getY();
			  }
		  }
		  return null;
	  }

	 public static boolean makeMove(String startPos,String endPos) {
		Integer startX = Integer.parseInt(startPos.substring(0,1));
		Integer startY = Integer.parseInt(startPos.substring(1));
		
		Piece piece=occupied(startX,startY);
	    if(piece==null || piece.getColour()!= isWhiteToMove) return false;
				 
		    System.out.println(piece);
			ArrayList<String> piecePossibleLocations=piece.getPossibleLocations();
		    for(int j=0;j<piecePossibleLocations.size();j++) {
			    if(piecePossibleLocations.get(j).equals(endPos)){
				   return parseAndMoveToLocation(piece,endPos);
			    }
		    }	  
		
		return false;
	}

	private static boolean parseAndMoveToLocation(Piece piece, String endPos) {
		Integer oldXPos=piece.getX();
		Integer oldYPos=piece.getY();
		if(endPos.substring(0,1).equals("x")) {
			Integer newXPos = Integer.parseInt(endPos.substring(1,2));
			Integer newYPos = Integer.parseInt(endPos.substring(2));
			Piece removedPiece = pieces.remove(newXPos+""+newYPos);
			piece.setX(newXPos);
			piece.setY(newYPos);
			pieces.remove(oldXPos+""+oldYPos);
			pieces.put(newXPos+""+newYPos,piece);
			if(checkCheck()!=2) {
				//move is confirmed good :)
				//so other person gets to move
				
				//we ensure that pawns can't indefinetly move 2 squares
				if(piece.getName().equals("Pawn")) {
					((Pawn) piece).setMoved();
				}
			
			    isWhiteToMove=!isWhiteToMove;
				return true;
			}
			else {
				piece.setX(oldXPos);
				piece.setY(oldYPos);
				pieces.remove(newXPos+""+newYPos);
				pieces.put(oldXPos+""+oldYPos,piece);
				pieces.put(newXPos+""+newYPos,removedPiece);
				return false;
			}
		}else {
			
			//what we do is set tentative values of x and y, calculate if a check
			//on our king occurs, then if none, we return true
			//Otherwise, reset and move fails
			
			Integer newXPos = Integer.parseInt(endPos.substring(0,1));
			Integer newYPos = Integer.parseInt(endPos.substring(1));
			piece.setX(newXPos);
			piece.setY(newYPos);
			pieces.remove(oldXPos+""+oldYPos);
			pieces.put(newXPos+""+newYPos,piece);
			if(checkCheck()!=2) {
				//move is confirmed good :)
				//so other person gets to move
				
				//we ensure that pawns can't indefinetly move 2 squares
				if(piece.getName().equals("Pawn")) {
					((Pawn) piece).setMoved();
				}
				
				isWhiteToMove=!isWhiteToMove;
				return true;
			}else {
				piece.setX(oldXPos);
				piece.setY(oldYPos);
				pieces.remove(newXPos+""+newYPos);
				pieces.put(oldXPos+""+oldYPos,piece);
				return false;
			}
		}
	}
}
