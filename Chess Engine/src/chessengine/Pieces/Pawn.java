package chessengine.Pieces;

import chessengine.*;

public class Pawn extends Piece{
	boolean unmoved=true;
	boolean canBeTakenEnPassant=false;
	public Pawn(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override           
    public void possibleMoves() {
		possibleLocations.clear();
		checkDelivered=false;
    	this.addToPossibleLocations(xPosition,(yPosition+(1*side)));
    	if(unmoved && Mechanics.occupied(xPosition,(yPosition+(1*side)))==null ) {
    		 this.addToPossibleLocations(xPosition,(yPosition+(2*side)));
    	}
    	
    	//add the pawn's possible diagonal takes
    	if(Mechanics.occupied(xPosition+(1*side),yPosition+(1*side))!=null && 
    			Mechanics.occupied(xPosition+(1*side),yPosition+(1*side)).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition+(1*side),yPosition+(1*side));
    	}
    	if(Mechanics.occupied(xPosition-(1*side),yPosition+(1*side))!=null && 
    			Mechanics.occupied(xPosition-(1*side),yPosition+(1*side)).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition-(1*side),yPosition+(1*side));
    	}
    	
    	
    	//En Passant
    	if(side==1 && yPosition==4 || side==-1 && yPosition==3)
    	  if(Mechanics.occupied(xPosition-1,yPosition)!=null && 
    			Mechanics.occupied(xPosition-1,yPosition).colour!=this.colour) { 
    		  if(Mechanics.occupied(xPosition-1,yPosition).getName()=="Pawn" &&
    				  ((Pawn) Mechanics.occupied(xPosition-1,yPosition)).getEnPassant()) {
    			  this.addToPossibleEnPassant(xPosition-1,yPosition);
    		  }
    		  
    	  }
    	  if(Mechanics.occupied(xPosition+1,yPosition)!=null && 
    			Mechanics.occupied(xPosition+1,yPosition).colour!=this.colour) { 
    		    
    	  }
    	
    	
    }
	public void setEnPassant(boolean passant) {
		canBeTakenEnPassant=passant;
	}
	public boolean getEnPassant() {
		return(canBeTakenEnPassant);
	}
	
	public void setMoved() {
		unmoved=false;
	}
	public boolean getUnmoved() {
		return unmoved;
	}
	public String toString() {
		return "Pawn " + super.toString() + " "+canBeTakenEnPassant;
	}
	 public String getName() {
		  return"Pawn";
	  }
}
