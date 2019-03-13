package chessengine;

public class Knight extends Piece{

	public Knight(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	 void calcPossibleMove() {
	    this.possibleLocations.add(xPosition+""+(yPosition+1));
	    	
	}
	public String toString() {
		return "Knight " + super.toString();
	}
}
