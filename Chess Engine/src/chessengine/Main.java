package chessengine;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  
	  //true corresponds to white to move, false to black
	  Mechanics.initialisePieces(true);
	  Mechanics.calculatePossibleMoves();
	  Mechanics.printPieces();
	  
	  while(true) {
		  System.out.println("Enter moves in form xy ('x')xy");
		  String move= input.nextLine();
		  String startPos = move.substring(0,2);
		  String endPos = move.substring(3);
		  System.out.println(Mechanics.makeMove(startPos,endPos));
		  Mechanics.calculatePossibleMoves();
		  Mechanics.printPieces();
	  }
  }
}