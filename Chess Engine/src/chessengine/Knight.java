package chessengine;

public class Knight extends Piece{

	public Knight(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
	 void possibleMoves() {
	    this.addToPossibleLocations((xPosition+1), (yPosition+2));
	    this.addToPossibleLocations((xPosition+2), (yPosition+1));
	    this.addToPossibleLocations((xPosition-1), (yPosition+2));
	    this.addToPossibleLocations((xPosition-2), (yPosition+1));
	    this.addToPossibleLocations((xPosition+1), (yPosition-2));
	    this.addToPossibleLocations((xPosition+2), (yPosition-1));
	    this.addToPossibleLocations((xPosition-1), (yPosition-2));
	    this.addToPossibleLocations((xPosition-2), (yPosition-1));
	   
	}
	public String toString() {
		return "Knight " + super.toString();
	}
}
