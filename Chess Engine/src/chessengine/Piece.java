package chessengine;
import java.util.ArrayList;
public class Piece {
  //these are represented as cartesian coords
  // in which x and y are represented 
  // are 0-7
  int xPosition;
  int yPosition;
  ArrayList<String> possibleLocations = new ArrayList<String>();
  int side;
  boolean colour;
  void possibleMoves() {}
  public void addToPossibleLocations(int x,int y) {
	  
	  if(x>7 || y>7 || x<0 || y<0 ||
			  Main.occupied(x,y)!=null) {
		  return;
	  }
	  
	  possibleLocations.add(x+""+y);
  }
  
  public void addToPossibleTakes(int x,int y) {
	  possibleLocations.add("x"+x+""+y);
  }
  
  public String toString() {
	  return xPosition + " " + yPosition + " " + side + " "+colour+"   " +possibleLocations;
  }
  public int getX() {
	  return xPosition;
  }
  public int getY() {
	  return yPosition;
  }
}
