package assignment5;

import java.util.Scanner;
import java.util.*;
public class Client2 extends ClientMain{

	String clientName = "Client2";
	String IPaddress = "127.0.0.1";
	int port = 5000;
	
	public Client2(String clientName) {
		super("127.0.0.1", 5000, clientName);
		this.clientName = clientName;
	}

	public String getIPaddress() {
		return IPaddress;
	}

	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientName() {
		return clientName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Welcome to Mastermind. Enter your name:");
		System.out.println("Welcome to Mastermind. Here are the rules.\n");
		System.out.println("This is a text version of the classic board game Mastermind.\n");
		System.out.println("The computer will think of a secret code. The code consists of 4 "
				+ "colored pegs. The pegs MUST be one of six colors: blue, green, "
				+ "orange, purple, red, or yellow. A color may appear more than once in "
				+ "the code. You try to guess what colored pegs are in the code and "
				+ "what order they are in. After you make a valid guess the result "
				+ "(feedback) will be displayed.\n");
		System.out.println("The result consists of a black peg for each peg you have guessed "
				+ "exactly correct (color and position) in your guess. For each peg in "
				+ "the guess that is the correct color, but is out of position, you get "
				+ "a white peg. For each peg, which is fully incorrect, you get no "
				+ "feedback.\n");
		System.out.println("Only the first letter of the color is displayed. B for Blue, R for "
				+ "Red, and so forth. When entering guesses you only need to enter the "
				+ "first character of each color as a capital letter.\n");
		
		System.out.println("Enter your name");
		Scanner sc = new Scanner(System.in);
		String Name = sc.next();
		System.out.println("Welcome " + Name + "!");
		ClientMain client = new Client2(Name);
	}


}
