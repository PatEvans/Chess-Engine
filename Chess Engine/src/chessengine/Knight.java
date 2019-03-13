package chessengine;

public class Knight extends Piece{

	public Knight(int startX,int startY,boolean colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	public String toString() {
		return "Knight " + super.toString();
	}
}
