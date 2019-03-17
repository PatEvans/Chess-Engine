package chessengine.Pieces;

import chessengine.*;

public class Pawn extends Piece{
	boolean unmoved=true;
	
	public Pawn(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override           
    public void possibleMoves() {
		possibleLocations.clear();
    	this.addToPossibleLocations(xPosition,(yPosition+(1*side)));
    	if(unmoved && Mechanics.occupied(xPosition,(yPosition+(1*side)))==null ) {
    		 this.addToPossibleLocations(xPosition,(yPosition+(2*side)));
    	}
    	
    	//add the pawn's possible diagonal takes
    	if(Mechanics.occupied(xPosition+1,yPosition+1)!=null && 
    			Mechanics.occupied(xPosition+1,yPosition+1).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition+1,yPosition+1);
    	}
    	if(Mechanics.occupied(xPosition-1,yPosition+1)!=null && 
    			Mechanics.occupied(xPosition-1,yPosition+1).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition-1,yPosition+1);
    	}
    }
	public void setMoved() {
		unmoved=false;
	}
	
	public String toString() {
		return "Pawn " + super.toString();
	}
	 public String getName() {
		  return"Pawn";
	  }
}
