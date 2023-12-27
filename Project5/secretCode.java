package game;

public class secretCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String getSecretCode() {
		return "secret code";
	}

}

//package SocketProgramming;
//
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Client2 extends ClientMain{
//
//	String clientName = "Client1";
//	
//	public Client2( String clientName, String address, int port) {
//		super(address, port, clientName);		
//	}
//
//	public void setClientName(String clientName) {
//		this.clientName = clientName;
//	}
//
//	public String getClientName() {
//		return clientName;
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		Client2 client = new Client2("127.0.0.1", 5000, "Client2");
//		Socket s1 = null;
//		String line = null;
//		DataInputStream br = null;
//		DataInputStream is = null;
//		PrintWriter os = null;
//		try {
//			s1 = new Socket("127.0.0.1", 5000);
//			br = new DataInputStream(System.in);
//			is = new DataInputStream(s1.getInputStream());
//			os = new PrintWriter(s1.getOutputStream());
//
//		} catch (IOException e) {
//			System.err.print("IO Exception");
//
//		}
//		System.out.println("Enter data to echo server (enter QUIT to end) :-> ");
//		String res = null;
//		try {
//			line = br.readLine();
//			while (line.compareTo("QUIT") != 0) {
//				os.println(line);
//				os.flush();
//				res = is.readLine();
//				System.out.println("server response :-> " + res);
//				line = br.readLine();
//			}
//			is.close();
//			os.close();
//			br.close();
//			s1.close();
//			System.out.println("close connection ");
//		} catch (IOException e) {
//			System.out.println("socket read error");
//		}
//	}
//
//
//
//}
//
