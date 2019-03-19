package chessengine.Pieces;
import java.util.ArrayList;
import chessengine.*;

public class Piece {
  //these are represented as cartesian coords
  // in which x and y are represented 
  // are 0-7
  int xPosition;
  int yPosition;
  ArrayList<String> possibleLocations = new ArrayList<String>();
  int side;
  boolean colour;
  boolean checkDelivered;
  public void possibleMoves() {}
  public void addToPossibleLocations(int x,int y) {
	  
	  if(x>7 || y>7 || x<0 || y<0 ||
			  Mechanics.occupied(x,y)!=null) {
		  return;
	  }
	  
	  possibleLocations.add(x+""+y);
  }
  
  public void addToPossibleTakes(int x,int y) {
	  if(Mechanics.occupied(x,y).getName().equals("King")) {
		  checkDelivered=true;
	  }
	  possibleLocations.add("x"+x+""+y);
  }
  
  public void addToPossibleEnPassant(int x,int y) {
	  possibleLocations.add("e"+x+""+y);
  }
  
  public String toString() {
	  return xPosition + " " + yPosition + " " + side + " "+colour+"   " +possibleLocations;
  }
  public ArrayList<String> getPossibleLocations(){
	  return possibleLocations;
  }
  public boolean getColour() {
	  return colour;
  }
  public String getName() {
	  return"piece";
  }
  
  public boolean getCheck() {
	  return checkDelivered;
  }
  public void setX(int xPos) {
	  xPosition=xPos;
  }
  public void setY(int yPos) {
	  yPosition=yPos;
  }
  
  public int getX() {
	  return xPosition;
  }
  public int getY() {
	  return yPosition;
  }
  public int getSide() {
	  return side;
  }
}
