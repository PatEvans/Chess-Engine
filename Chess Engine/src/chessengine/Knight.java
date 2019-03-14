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
	    for(int i=-1;i<=1;i=i+2) {
	    	for(int j=-1;j<=1;j=j+2) {
	    		
	    		//add moves
	    		this.addToPossibleLocations((xPosition+(2*i)), (yPosition+(1*j)));
	    		this.addToPossibleLocations((xPosition+(1*i)), (yPosition+(2*j)));
	    		
	    		//add to takes
	    		if(Main.occupied((xPosition+(2*i)), (yPosition+(1*j)))!=null && 
		    			Main.occupied((xPosition+(2*i)), (yPosition+(1*j))).colour!=this.colour) {
		    		this.addToPossibleTakes((xPosition+(2*i)), (yPosition+(1*j)));
		    	}
	    		
	    		if(Main.occupied((xPosition+(1*i)), (yPosition+(2*j)))!=null && 
		    			Main.occupied((xPosition+(1*i)), (yPosition+(2*j))).colour!=this.colour) {
		    		this.addToPossibleTakes((xPosition+(1*i)), (yPosition+(2*j)));
		    	}
	    	}
	    }
	   
	}
	public String toString() {
		return "Knight " + super.toString();
	}
}
