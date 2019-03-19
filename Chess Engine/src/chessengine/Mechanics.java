package chessengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

	//////////////  MOVE MECHANICS //////////////////
	
	public static boolean makeMove(String startPos,String endPos) {
		Integer startX = Integer.parseInt(startPos.substring(0,1));
		Integer startY = Integer.parseInt(startPos.substring(1));
		
		Piece piece=occupied(startX,startY);
	    if(piece==null || piece.getColour()!= isWhiteToMove) return false;
				 
		    System.out.println(piece);
			ArrayList<String> piecePossibleLocations=piece.getPossibleLocations();
			//if castles remove obstruction checks
			if(endPos.substring(0,1).equals("c")) {
				return parseAndMoveToLocation(piece,endPos.substring(1));
			}
			
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
		if(endPos.substring(0,1).equals("x")||endPos.substring(0,1).equals("e")) {
			Piece removedPiece=takePiece(piece,endPos);
			if(checkCheck(0)!=2) {
				//move is confirmed good :)
				//so other person gets to move
				//we ensure that pawns can't indefinitely move 2 squares
				//and ensures that en passant works correctly
				resetEnPassant();
				if(piece.getName().equals("Pawn")) {
					//hacky approach to check if a two move has been made
					if(((Pawn) piece).getUnmoved()==true && (Math.abs(oldYPos-Integer.parseInt(endPos.substring(2)))==2)) {
						((Pawn) piece).setEnPassant(true);
					}
				}
				piece.setMoved();
				isWhiteToMove=!isWhiteToMove;
				return true;
			}
			else {
				takeBack(piece,removedPiece,endPos,oldXPos,oldYPos);
				return false;
			}
		}else {
			
			//what we do is set tentative values of x and y, calculate if a check
			//on our king occurs, then if none, we return true
			//Otherwise, reset and move fails
			
			movePiece(piece,endPos);
			if(checkCheck(0)!=2) {
				//move is confirmed good :)
				//so other person gets to move
				//we ensure that pawns can't indefinitely move 2 squares
				//and ensures that en passant works correctly
				resetEnPassant();
				if(piece.getName().equals("Pawn")) {
					//hacky approach to check if a two move has been made
					if(((Pawn) piece).getUnmoved()==true && (Math.abs(oldYPos-Integer.parseInt(endPos.substring(1)))==2)) {
						((Pawn) piece).setEnPassant(true);
					}
				}
				if(piece.getName().equals("King")) {
					//hacky approach to check if a two move has been made
					if(piece.getUnmoved()==true && (Math.abs(oldXPos-Integer.parseInt(endPos.substring(0,1)))==2)) {
						if(endPos.substring(0,1).contentEquals("6") ) {
							makeMove("7"+ oldYPos,"c5"+oldYPos);
						}
						if(endPos.substring(0,1).contentEquals("1") ) {
							makeMove("0"+ oldYPos,"c3"+oldYPos);
						}
						isWhiteToMove=!isWhiteToMove;
					}
				}
				piece.setMoved();
				isWhiteToMove=!isWhiteToMove;
				return true;
			}else {
				moveBack(piece,endPos,oldXPos,oldYPos);
				System.out.println("MovedBack");
				return false;
			}
		}
	}
	
	
	//////////////  MOVE CALCULATIONS //////////////////
	
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
	  
	  public static Integer checkCheck(int preventRecursion) {
		  //if no check, return null,
		  //if a check produced on the opponent and not on the current player's team
		  //return 1
		  //Otherwise, if a check produced on the current player's team, return 2
		
		  calculatePossibleMoves();
		  
		  for (Piece piece : pieces.values()) {
			  
			  if(piece.getCheck()==true && piece.getColour()!=isWhiteToMove) {
					  return 2;
			  }
			  if(piece.getCheck()==true && piece.getColour()==isWhiteToMove) {
				      if(preventRecursion==0) {
				    	  if(checkMate()) {
				    		  System.out.println("MATE\nMATE\nMATE\nMATE\nMATE\nMATE\nMATE\nMATE");
				    	  }else {
				    		  System.out.println("CHECK\nCHECK\nCHECK\nCHECK\nCHECK\nCHECK\nCHECK\nCHECK");
				    	  }
				      }
					  return 1;
			  }
			  
		  }
		  return 0;
	  }
	
	  private static boolean checkMate() {
		    HashMap<String,Piece> localPieces=new HashMap<String,Piece>(pieces);
		    for (Piece piece : localPieces.values()) {
		    	
				if(piece.getColour()!=isWhiteToMove) {
					ArrayList<String> piecePossibleLocations=piece.getPossibleLocations();
				   calculatePossibleMoves();
				   for(int j=0;j<piecePossibleLocations.size();j++) {
					 
					 String consideredLocation = piecePossibleLocations.get(j);
					 //System.out.println(piece+consideredLocation);
					 Integer oldXPos=piece.getX();
					 Integer oldYPos=piece.getY();
					 
					 if(consideredLocation.substring(0,1).equals("x")||consideredLocation.substring(0,1).equals("e")) {
						 //takes
						 Piece removedPiece=takePiece(piece,consideredLocation);
						 calculatePossibleMoves();
						 if(checkCheck(1)!=1) {
							// System.out.println(piece+consideredLocation);
							 takeBack(piece,removedPiece,consideredLocation,oldXPos,oldYPos);
							 calculatePossibleMoves();
							 return false;
						 }
						 takeBack(piece,removedPiece,consideredLocation,oldXPos,oldYPos);
					 }
					 else {
						 //not takes
						 
						 movePiece(piece,consideredLocation);
						 calculatePossibleMoves();
						 if(checkCheck(1)!=1) {
							 moveBack(piece,consideredLocation,oldXPos,oldYPos);
							 calculatePossibleMoves();
							 return false;
						 }
						 moveBack(piece,consideredLocation,oldXPos,oldYPos);
					 }
					 calculatePossibleMoves();
				  }
				}
			}
			
			
			return true;
		}
	  
	  private static void resetEnPassant() {
		  for(int i=0;i<8;i++) {
			  for(int j  = 3;j<5;j++) {
				  if(occupied(i,j)!=null && occupied(i,j).getName()=="Pawn")
				  ((Pawn) occupied(i,j)).setEnPassant(false);
			  }
		  }
	  }
	
	/////////// Methods to manipulate the pieces hashmap and reset - will be reused so created here ///////////////
	
	private static Piece takePiece(Piece piece, String endPos) {
		Integer oldXPos=piece.getX();
		Integer oldYPos=piece.getY();
		Integer newXPos = Integer.parseInt(endPos.substring(1,2));
		Integer newYPos = Integer.parseInt(endPos.substring(2));
		Piece removedPiece=pieces.remove(newXPos+""+newYPos);
		
		if(endPos.substring(0,1).equals("e")) {
			newYPos = newYPos+piece.getSide();
			piece.setX(newXPos);
			piece.setY(newYPos);
		}else {
			piece.setX(newXPos);
			piece.setY(newYPos);
		}
		pieces.remove(oldXPos+""+oldYPos);
		pieces.put(newXPos+""+newYPos,piece);
		return removedPiece;
		
	}
	private static void takeBack(Piece piece,Piece removedPiece, String endPos,int oldXPos,int oldYPos) {
		Integer newXPos = Integer.parseInt(endPos.substring(1,2));
		Integer newYPos;
		if(endPos.substring(0,1).equals("e")) {
			newYPos = Integer.parseInt(endPos.substring(2))+piece.getSide();
		}else {
			newYPos = Integer.parseInt(endPos.substring(2));
		}
		piece.setX(oldXPos);
		piece.setY(oldYPos);
		pieces.remove(newXPos+""+newYPos);
		pieces.put(oldXPos+""+oldYPos,piece);
		
		if(endPos.substring(0,1).equals("e")) {
			newYPos = Integer.parseInt(endPos.substring(2));
		}
		pieces.put(newXPos+""+newYPos,removedPiece);
	}
	
	
	
	private static void movePiece(Piece piece, String endPos) {
		Integer oldXPos=piece.getX();
		Integer oldYPos=piece.getY();
		Integer newXPos = Integer.parseInt(endPos.substring(0,1));
		Integer newYPos = Integer.parseInt(endPos.substring(1));
		piece.setX(newXPos);
		piece.setY(newYPos);
		pieces.remove(oldXPos+""+oldYPos);
		pieces.put(newXPos+""+newYPos,piece);
	}
	private static void moveBack(Piece piece, String endPos,int oldXPos,int oldYPos) {
		
		Integer newXPos = Integer.parseInt(endPos.substring(0,1));
		Integer newYPos = Integer.parseInt(endPos.substring(1));
		piece.setX(oldXPos);
		piece.setY(oldYPos);
		pieces.remove(newXPos+""+newYPos);
		pieces.put(oldXPos+""+oldYPos,piece);
	}
}
