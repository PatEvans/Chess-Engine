package chessengine;

public class Pawn extends Piece{
	boolean unmoved=true;
	
	public Pawn(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override           
    public void possibleMoves() {
    	 this.addToPossibleLocations(xPosition,(yPosition+(1*side)));
    	if(unmoved) {
    		 this.addToPossibleLocations(xPosition,(yPosition+(2*side)));
    	}
    }
	public String toString() {
		return "Pawn " + super.toString();
	}
}
