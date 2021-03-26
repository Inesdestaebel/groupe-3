package projetgroupe3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {  
	private Personnage H;
	
	public static void main(String[]args)throws IOException{
	Socket s = new Socket(InetAddress.getByName("localhost"), 4242);
		
	BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	PrintWriter out = new PrintWriter(s.getOutputStream(),true);
	System.out.println(in.readLine());
	System.out.println(in.readLine());
		
	Scanner sc = new Scanner(System.in);
	String name = sc.next();
	while (name.length()<3) {
		System.out.println("Ce pseudo n'est pas valide.");
		name = sc.next();
	}
	out.println(name);
	out.flush();
	while(true) {
	System.out.println(in.readLine());
	}
	
  }
}
