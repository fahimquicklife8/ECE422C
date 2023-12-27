package assignment5;

import java.util.*;
import java.net.*;
import java.io.*;

public class ServerMain {
	static String secretcode = "";

	public static void main(String[] args) {
		Socket sa;
		ServerSocket ss2;
		System.out.println("Welcome to Mastermind. The game has started");
		secretcode = SecretCodeGenerator.getInstance().getNewSecretCode();
		System.out.println("The secret code is " + secretcode);

		try {
			ss2 = new ServerSocket(5000); // Server socket listens at a specific port.
			while (true) {
				try {
					sa = ss2.accept();
					System.out.println("Connection established");
					ServerThread st = new ServerThread(sa);
					st.start();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Connection error");
					if (ss2 != null && !ss2.isClosed()) {
						ss2.close();
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server error");
		}
	}

	static class ServerThread extends Thread {
		String line;
		DataInputStream is;
		PrintWriter od;
		Socket s1;

		public ServerThread(Socket s) {
			s1 = s;
		}

		public void run() {
			try {
				is = new DataInputStream(s1.getInputStream());
				od = new PrintWriter(s1.getOutputStream());

				line = is.readLine();
				Game game = new Game(true);
				while (line != null) {
					boolean check = game.guesscheck(line, secretcode);
					if (check) {
						od.println(line + " is correct. Congratulations you win!");
						System.out.println("Correct answer is " + secretcode + ". Game over.");
					} else {
						od.println("Your guess is wrong. Try again");
					}
					od.flush();
					line = is.readLine();
				}

				is.close();
				od.close();
				s1.close();
			} catch (IOException ie) {
				ie.printStackTrace();
				System.out.println("Socket close error");
			}
		}
	}
}
