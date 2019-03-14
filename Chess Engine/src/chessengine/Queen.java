package chessengine;

public class Queen extends Piece{

	public Queen(int startX,int startY,int side,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.side=side;
		this.colour=colour;
	}
	@Override
    public void possibleMoves() {
		//Has a combination of the Rook's moves and the bishop's
		
		//These are the up down possible moves
		for(int i=yPosition;i<8;i++) {
			//add takes first, then check for obstruction
			if(Main.occupied(xPosition,i)!=null && 
	    			Main.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			if(Main.occupied(xPosition,i)!=null) break;
			
			this.addToPossibleLocations(xPosition,i);
		}
		for(int i=yPosition;i>=0;i--) {
			if(Main.occupied(xPosition,i)!=null && 
	    			Main.occupied(xPosition,i).colour!=this.colour) {
	    		this.addToPossibleTakes(xPosition,i);
	    	}
			if(Main.occupied(xPosition,i)!=null) break;
			
			this.addToPossibleLocations(xPosition,i);
		}
		
		//These are the left right possible moves
		for(int i=xPosition;i<8;i++) {
			if(Main.occupied(i,yPosition)!=null && 
	    			Main.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Main.occupied(i,yPosition)!=null) break;
			
	    	this.addToPossibleLocations(i,yPosition);
		}
		for(int i=xPosition;i>=0;i--) {
			if(Main.occupied(i,yPosition)!=null && 
	    			Main.occupied(i,yPosition).colour!=this.colour) {
	    		this.addToPossibleTakes(i,yPosition);
	    	}
			if(Main.occupied(i,yPosition)!=null) break;
			
	    	this.addToPossibleLocations(i,yPosition);
		}
		
		//These are the y=x possible moves
		for(int i=0;i<8;i++) {
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
		return "Queen " + super.toString();
	}
}
