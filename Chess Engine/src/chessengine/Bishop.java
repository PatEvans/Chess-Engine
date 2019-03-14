package chessengine;

public class Bishop extends Piece{

	public Bishop(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		
		//These are the y=x possible moves
		for(int i=yPosition;i<8;i++) {
			if(Main.occupied(xPosition+i,yPosition+i)) break;
			this.addToPossibleLocations(xPosition+i,yPosition+i);
		}
		for(int i=yPosition;i>=0;i--) {
			if(Main.occupied(xPosition-i,yPosition-i)) break;
			this.addToPossibleLocations(xPosition-i,yPosition-i);
		}
		
		//These are the y=-x possible moves
		for(int i=xPosition;i<8;i++) {
			if(Main.occupied(xPosition+i,yPosition-i)) break;
	    	this.addToPossibleLocations(xPosition+i,yPosition-i);
		}
		for(int i=xPosition;i>=0;i--) {
			if(Main.occupied(xPosition-i,yPosition+i)) break;
	    	this.addToPossibleLocations(xPosition-i,yPosition+i);
		}
		 	
    }
	public String toString() {
		return "Bishop " + super.toString();
	}
}
