package chessengine;

public class Rook extends Piece{

	public Rook(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		
		//These are the up down possible moves
		for(int i=yPosition;i<8;i++) {
			//add takes first, then check for obstruction
			if(Main.occupied(xPosition,i)!=null && 
	    			Main.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			
			if(Main.occupied(xPosition,i)!=null) break;
			this.addToPossibleLocations(xPosition,i);
		}
		for(int i=yPosition;i>=0;i--) {
			if(Main.occupied(xPosition,i)!=null && 
	    			Main.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			if(Main.occupied(xPosition,i)!=null) break;
			this.addToPossibleLocations(xPosition,i);
		}
		
		//These are the left right possible moves
		for(int i=xPosition;i<8;i++) {
			if(Main.occupied(i,yPosition)!=null && 
	    			Main.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Main.occupied(i,yPosition)!=null) break;
	    	this.addToPossibleLocations(i,yPosition);
		}
		for(int i=xPosition;i>=0;i--) {
			if(Main.occupied(i,yPosition)!=null && 
	    			Main.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Main.occupied(i,yPosition)!=null) break;
	    	this.addToPossibleLocations(i,yPosition);
		}
		 	
    }
	public String toString() {
		return "Rook " + super.toString();
	}
}
