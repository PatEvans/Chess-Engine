package chessengine;

public class Queen extends Piece{

	public Queen(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		//Has a combination of the Rook's moves and the bishop's
		
		//These are the up down possible moves
		for(int i=yPosition;i<8;i++) {
			if(Main.occupied(xPosition,i)) break;
			this.addToPossibleLocations(xPosition,i);
		}
		for(int i=yPosition;i>=0;i--) {
			if(Main.occupied(xPosition,i)) break;
			this.addToPossibleLocations(xPosition,i);
		}
		
		//These are the left right possible moves
		for(int i=xPosition;i<8;i++) {
			if(Main.occupied(i,yPosition)) break;
	    	this.addToPossibleLocations(i,yPosition);
		}
		for(int i=xPosition;i>=0;i--) {
			if(Main.occupied(i,yPosition)) break;
	    	this.addToPossibleLocations(i,yPosition);
		}//These are the y=x possible moves
		for(int i=yPosition;i<8;i++) {
			if(Main.occupied(xPosition+i,yPosition+i)) break;
			this.addToPossibleLocations(xPosition+i,yPosition+i);
		}
		for(int i=yPosition;i>=0;i--) {
			if(Main.occupied(xPosition,i)) break;
			this.addToPossibleLocations(xPosition-i,yPosition-i);
		}
		
		//These are the y=-x possible moves
		for(int i=xPosition;i<8;i++) {
			if(Main.occupied(i,yPosition)) break;
	    	this.addToPossibleLocations(xPosition+i,yPosition-i);
		}
		for(int i=xPosition;i>=0;i--) {
			if(Main.occupied(i,yPosition)) break;
	    	this.addToPossibleLocations(xPosition-i,yPosition+i);
		}
		
		 	
    }
	public String toString() {
		return "Queen " + super.toString();
	}
}
