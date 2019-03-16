package chessengine.Pieces;

import chessengine.Mechanics;

public class King extends Piece{

	public King(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		 possibleLocations.clear();
		
    	 this.addToPossibleLocations(xPosition,yPosition+1);
    	 if(Mechanics.occupied(xPosition,yPosition+1)!=null && 
 				Mechanics.occupied(xPosition,yPosition+1).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+1,yPosition+1);
	    	}
    	 
    	 
    	 this.addToPossibleLocations(xPosition,yPosition-1);
    	 if(Mechanics.occupied(xPosition,yPosition-1)!=null && 
 				Mechanics.occupied(xPosition,yPosition-1).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,yPosition-1);
	    	}
    	 this.addToPossibleLocations(xPosition-1,yPosition);
    	 if(Mechanics.occupied(xPosition-1,yPosition)!=null && 
 				Mechanics.occupied(xPosition-1,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition-1,yPosition);
	    	}
    	 
    	 this.addToPossibleLocations(xPosition+1,yPosition);
    	 if(Mechanics.occupied(xPosition+1,yPosition)!=null && 
 				Mechanics.occupied(xPosition+1,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+1,yPosition);
	    	}
    	 
    	 for(int i=-1;i<=1;i=i+2) {
 	    	for(int j=-1;j<=1;j=j+2) {
 	    		if(Mechanics.occupied(xPosition+i,yPosition+j)!=null && 
	    				Mechanics.occupied(xPosition+i,yPosition+j).colour!=this.colour) {
		    		this.addToPossibleTakes(xPosition+i,yPosition+j);
		    	}
 	    		this.addToPossibleLocations(xPosition+i,yPosition+j);
 	    	}
 	    }
	
    }
	public String toString() {
		return "King " + super.toString();
	}
	 public String getName() {
		  return"King";
	  }
}
