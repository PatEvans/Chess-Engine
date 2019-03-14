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
    	
    	//add the pawn's possible diagonal takes
    	if(Main.occupied(xPosition+1,yPosition+1)!=null && 
    			Main.occupied(xPosition+1,yPosition+1).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition+1,yPosition+1);
    	}
    	if(Main.occupied(xPosition-1,yPosition+1)!=null && 
    			Main.occupied(xPosition-1,yPosition+1).colour!=this.colour) {
    		this.addToPossibleTakes(xPosition-1,yPosition+1);
    	}
    }
	public String toString() {
		return "Pawn " + super.toString();
	}
}
