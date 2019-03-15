package chessengine;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  
	  //true corresponds to white to move, false to black
	  Mechanics.initialisePieces(true);
	  Mechanics.calculatePossibleMoves();
	  Mechanics.printPieces();
	  String move;
	  while(true) {
		  System.out.println("Enter moves in form xy ('x')xy");
		  move= input.nextLine();
		  Mechanics.makeMove();
	  }
  }
  
}