package chessengine;

public class King extends Piece{

	public King(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
    	 this.addToPossibleLocations(xPosition,yPosition+1);
    	 this.addToPossibleLocations(xPosition,yPosition-1);
    	 this.addToPossibleLocations(xPosition-1,yPosition);
    	 this.addToPossibleLocations(xPosition+1,yPosition);
    	
    	 this.addToPossibleLocations(xPosition+1,yPosition+1);
    	 this.addToPossibleLocations(xPosition-1,yPosition-1);
    	 this.addToPossibleLocations(xPosition+1,yPosition-1);
    	 this.addToPossibleLocations(xPosition-1,yPosition+1);
    }
	public String toString() {
		return "King " + super.toString();
	}
}
