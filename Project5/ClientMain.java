package assignment5;

import java.util.*;
import java.net.*;
import java.io.*;

public class ClientMain {

	String clientName;
	int numberOfChances = 12;
	String ipAddress;
	int port;

	ClientMain(String ipAddress, int port, String clientName) {
		this.clientName = clientName;
		this.ipAddress = ipAddress;
		this.port = port;

		runClient();
	}

	public void runClient() {
		Socket s1 = null;
		BufferedReader br = null;
		BufferedReader is = null;
		PrintWriter os = null;
		try {
			s1 = new Socket(this.ipAddress, this.port);
			br = new BufferedReader(new InputStreamReader(System.in));
			is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			os = new PrintWriter(s1.getOutputStream());

			System.out.println("Enter data to echo server (enter QUIT to end) :-> ");
			String res;
			String line = br.readLine();
			while (this.numberOfChances > 0) {
				os.println(line);
				os.flush();
				res = is.readLine();
				System.out.println("Server response: " + res);

				if (res.contains("Congratulations")) {
					System.out.println("You have guessed the secret code correctly.");
					break;
				}

				this.numberOfChances--;
				if (this.numberOfChances == 0) {
					System.out.println("You have exhausted your attempts. Join the next game.");
					break;
				}

				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception");
		} finally {
			try {
				if (is != null) is.close();
				if (os != null) os.close();
				if (br != null) br.close();
				if (s1 != null) s1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Closing the game connection.");
	}


	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAdderss(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumberOfChances() {
		return numberOfChances;
	}

	public void setNumberOfChances(int numberOfChances) {
		this.numberOfChances = numberOfChances;
	}

	public static void main(String s[]) throws Exception {
	}
}