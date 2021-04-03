package projetgroupe3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client extends Thread{  
	    private String name="";
	    private PrintStream out;
	    private BufferedReader in;
	    private Boolean ready=false;
	    private Socket s;
	    private Personnage p;
	    
	    public Client(Socket s) {
	    	try {
	    		this.s=s;
	    		out = new PrintStream( s.getOutputStream() );
	    		in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	    }
	   
	    	
	    
	    
	    public void send_message() {
	    	while(true) {
	            String reponse;
	            try {
	                reponse = in.readLine();
	                System.out.println("Reponse serveur : "+reponse);

	            } catch (IOException e) {
	                System.out.println("La connexion est perdue !");
	                System.exit(1);
	            }
	        }
	    }
	   
	   public void setNom(String n) {
	    	this.name = n;
	   }
	    
	   public String getNom() {
	   		return name;
	   }
	    
	    public void Ready(boolean a) {
	    	this.ready=a;
	    }
	    
	    public boolean isReady() {
	    	return ready;
	    }
	    
	    
	   public void run() {
		   try {
		   name=in.readLine();
		   String r= in.readLine();
		   if(r.equals("A")) {
			   Ready(true);
		   }
		   
		   setNom(name);
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
	}
	

	    public static void main(String argv[]) throws IOException {
	    	Scanner sc = new Scanner(System.in);
	    	Socket socket = new Socket("localhost", 5112);
	    	Client c = new Client(socket);
	    	System.out.println("Bonjour, veuillez entrer un nom!");
	    	String n = sc.next();
		    c.out.println(n);
		    c.out.flush();
	    	System.out.println("Entrez un A si vous êtes prêts.");
	    	String r = sc.next();
	        while(r.equals("A")==false) {
	        	System.out.println("Un A...");
	        	r = sc.next();
	        }
	        c.out.println(r);
	        c.out.flush();
	    }

}
           