package chessengine;

public class Rook extends Piece{

	public Rook(int startX,int startY,int colour){
		this.xPosition=startX;
		this.yPosition=startY;
		this.colour=colour;
	}
	public String toString() {
		return "Rook " + super.toString();
	}
}
