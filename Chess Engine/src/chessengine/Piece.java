package chessengine;
import java.util.ArrayList;
public class Piece {
  //these are represented as cartesian coords
  // in which x and y are represented 
  // are 0-7
  int xPosition;
  int yPosition;
  ArrayList<String> possibleLocations = new ArrayList<String>();;
  int colour;
  
  public String toString() {
	  return xPosition + " " + yPosition + " " + colour + "   " +possibleLocations;
  }
  
}
