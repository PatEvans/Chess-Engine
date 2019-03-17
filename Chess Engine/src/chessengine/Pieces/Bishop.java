package chessengine.Pieces;

import chessengine.*;

public class Bishop extends Piece{

	public Bishop(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		possibleLocations.clear();
		//These are the y=x possible moves
		checkDelivered=false;
		for(int i=1;i<8;i++) {
			//add takes first, then check for obstruction
			if(Mechanics.occupied(xPosition+i,yPosition+i)!=null && 
					Mechanics.occupied(xPosition+i,yPosition+i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition+i);
	    	}
			
			if(Mechanics.occupied(xPosition+i,yPosition+i)!=null) { break;}
			this.addToPossibleLocations(xPosition+i,yPosition+i);
		}
		for(int i=1;i<8;i++) {
			if(Mechanics.occupied(xPosition-i,yPosition-i)!=null && 
					Mechanics.occupied(xPosition-i,yPosition-i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition-i,yPosition-i);
	    	}
			if(Mechanics.occupied(xPosition-i,yPosition-i)!=null) {break;}
			this.addToPossibleLocations(xPosition-i,yPosition-i);
		}
		
		//These are the y=-x possible moves
		for(int i=1;i<8;i++) {
			if(Mechanics.occupied(xPosition+i,yPosition-i)!=null && 
					Mechanics.occupied(xPosition+i,yPosition-i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition-i);
	    	}
			if(Mechanics.occupied(xPosition+i,yPosition-i)!=null) {break;}
	    	this.addToPossibleLocations(xPosition+i,yPosition-i);
		}
		for(int i=1;i<8;i++) {
			if(Mechanics.occupied(xPosition-i,yPosition+i)!=null && 
					Mechanics.occupied(xPosition-i,yPosition+i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition-i);
	    	}
			if(Mechanics.occupied(xPosition-i,yPosition+i)!=null) {break;}
	    	this.addToPossibleLocations(xPosition-i,yPosition+i);
		}
		 	
    }
	public String toString() {
		return "Bishop " + super.toString();
	}
	public String getName() {
		  return"Bishop";
	}
}
