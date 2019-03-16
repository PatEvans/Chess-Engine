package chessengine.Pieces;

import chessengine.*;

public class Rook extends Piece{

	public Rook(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		possibleLocations.clear();
		//These are the up down possible moves
		for(int i=yPosition+1;i<8;i++) {
			//add takes first, then check for obstruction
			if(Mechanics.occupied(xPosition,i)!=null && 
					Mechanics.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			
			if(Mechanics.occupied(xPosition,i)!=null) break;
			this.addToPossibleLocations(xPosition,i);
		}
		for(int i=yPosition-1;i>=0;i--) {
			if(Mechanics.occupied(xPosition,i)!=null && 
					Mechanics.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			if(Mechanics.occupied(xPosition,i)!=null) break;
			this.addToPossibleLocations(xPosition,i);
		}
		
		//These are the left right possible moves
		for(int i=xPosition+1;i<8;i++) {
			if(Mechanics.occupied(i,yPosition)!=null && 
					Mechanics.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Mechanics.occupied(i,yPosition)!=null) break;
	    	this.addToPossibleLocations(i,yPosition);
		}
		for(int i=xPosition-1;i>=0;i--) {
			if(Mechanics.occupied(i,yPosition)!=null && 
					Mechanics.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Mechanics.occupied(i,yPosition)!=null) break;
	    	this.addToPossibleLocations(i,yPosition);
		}
		 	
    }
	public String toString() {
		return "Rook " + super.toString();
	}
	 public String getName() {
		  return"Rook";
	  }
}
