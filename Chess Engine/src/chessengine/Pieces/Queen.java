package chessengine.Pieces;

import chessengine.*;

public class Queen extends Piece{

	public Queen(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		//Has a combination of the Rook's moves and the bishop's
		possibleLocations.clear();
		checkDelivered=false;
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
		
		//These are the y=x possible moves
		for(int i=1;i<8;i++) {
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
		return "Queen " + super.toString();
	}
	public String getName() {
		return"Queen";
	}
}
