package chessengine;

public class Bishop extends Piece{

	public Bishop(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		
		//These are the y=x possible moves
		for(int i=0;i<8;i++) {
			//add takes first, then check for obstruction
			if(Main.occupied(xPosition+i,yPosition+i)!=null && 
	    			Main.occupied(xPosition+i,yPosition+i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition+i);
	    	}
			
			if(Main.occupied(xPosition+i,yPosition+i)!=null) { break;}
			this.addToPossibleLocations(xPosition+i,yPosition+i);
		}
		for(int i=0;i<8;i--) {
			if(Main.occupied(xPosition-i,yPosition-i)!=null && 
	    			Main.occupied(xPosition-i,yPosition-i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition-i,yPosition-i);
	    	}
			if(Main.occupied(xPosition-i,yPosition-i)!=null) {break;}
			this.addToPossibleLocations(xPosition-i,yPosition-i);
		}
		
		//These are the y=-x possible moves
		for(int i=0;i<8;i++) {
			if(Main.occupied(xPosition+i,yPosition-i)!=null && 
	    			Main.occupied(xPosition+i,yPosition-i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition-i);
	    	}
			if(Main.occupied(xPosition+i,yPosition-i)!=null) {break;}
	    	this.addToPossibleLocations(xPosition+i,yPosition-i);
		}
		for(int i=0;i<8;i++) {
			if(Main.occupied(xPosition-i,yPosition+i)!=null && 
	    			Main.occupied(xPosition-i,yPosition+i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition+i,yPosition-i);
	    	}
			if(Main.occupied(xPosition-i,yPosition+i)!=null) {break;}
	    	this.addToPossibleLocations(xPosition-i,yPosition+i);
		}
		 	
    }
	public String toString() {
		return "Bishop " + super.toString();
	}
}
