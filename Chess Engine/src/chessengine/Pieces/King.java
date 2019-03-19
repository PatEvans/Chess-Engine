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
		 checkDelivered=false;
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
    	 
    	 //Add standard locations
    	 for(int i=-1;i<=1;i=i+2) {
 	    	for(int j=-1;j<=1;j=j+2) {
 	    		if(Mechanics.occupied(xPosition+i,yPosition+j)!=null && 
	    				Mechanics.occupied(xPosition+i,yPosition+j).colour!=this.colour) {
		    		this.addToPossibleTakes(xPosition+i,yPosition+j);
		    	}
 	    		this.addToPossibleLocations(xPosition+i,yPosition+j);
 	    	}
 	    }
    	 
    	//Add castling - a bit more tricky
    	 if(unmoved) {
    		 //Queenside castle
    		 if(Mechanics.occupied(0,0)!=null &&
    				 Mechanics.occupied(0,0).getUnmoved() && side==1 && 
    				 Mechanics.occupied(1,0)==null && Mechanics.occupied(2,0)==null) {
    			 this.addToPossibleLocations(xPosition-2,0);
    		 }
    		 //Kingside Castle
    		 if(Mechanics.occupied(7,0)!=null &&
    				 Mechanics.occupied(7,0).getUnmoved() && side==1 && 
    				 Mechanics.occupied(5,0)==null && Mechanics.occupied(6,0)==null) {
    			 this.addToPossibleLocations(xPosition+2,0);
    		 }
    		 
    		 //Queenside castle
    		 if(Mechanics.occupied(0,7)!=null &&
    				 Mechanics.occupied(0,7).getUnmoved() && side==-1 && 
    				 Mechanics.occupied(1,7)==null && Mechanics.occupied(2,7)==null) {
    			 this.addToPossibleLocations(xPosition-2,7);
    		 }
    		 //Kingside Castle
    		 if(Mechanics.occupied(7,7)!=null &&
    				 Mechanics.occupied(7,7).getUnmoved() && side==-1 && 
    				 Mechanics.occupied(5,7)==null && Mechanics.occupied(6,7)==null) {
    			 this.addToPossibleLocations(xPosition+2,7);
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
