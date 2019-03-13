package chessengine;

public class Pawn extends Piece{
	boolean unmoved=true;
	
	public Pawn(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
		calcPossibleMove();
	}
    void calcPossibleMove() {
    	this.possibleLocations.add(xPosition+""+(yPosition+(1*colour)));
    	if(unmoved) {
    	this.possibleLocations.add(xPosition+""+(yPosition+(2*colour)));
    	}
    }
	public String toString() {
		return "Pawn " + super.toString();
	}
}
