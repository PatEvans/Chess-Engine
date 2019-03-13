package chessengine;

public class Bishop extends Piece{

	public Bishop(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	public String toString() {
		return "Bishop " + super.toString();
	}
}
