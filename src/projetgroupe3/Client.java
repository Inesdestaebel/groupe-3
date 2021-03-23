package projetgroupe3;

import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[]args)throws IOException{
		Socket s = new Socket("localhost", 4999);
		System.out.println("Dans le fichier");
	}
}
