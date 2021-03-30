package projetgroupe3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {  
	    private String name;
	    private Boolean ready=false;
	    private Socket s;
	    
	    public Client() {
	       
	    }
	    
	    public void send_message(String i) {
				
	    }
	   
	    public void setName(String n) {
	    	this.name = n;
	    }
	    
	    public String getName() {
	    	return name;
	    }
	    
	    public void Ready(boolean a) {
	    	this.ready=a;
	    }
	    
	    public boolean isReady() {
	    	return ready;
	    }
	    
	   // public void loop() {
	    //    Scanner sc = new Scanner(System.in);

	      //  while(true) {
	      //      String line = sc.next();
	      //      out.println(line);
	      //      String reponse;
	      //      try {
	      //         reponse = in.readLine();
	       //         System.out.println("Reponse serveur : "+reponse);
//
	        //    } catch (IOException e) {
	         //       System.out.println("La connexion est perdue !");
	         //       System.exit(1);
	         //   }
	       // }
	   // }

	    public static void main(String argv[]) throws IOException {
	    	Socket socket = new Socket("localhost", 5112);
            PrintStream out= new PrintStream( socket.getOutputStream() );
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Bonjour, veuillez entrer un nom!");
	        String n = sc.next();
	        out.println(n);
	        out.flush();
	        
	        System.out.println("Entrez un A si vous êtes prêts.");
	        String r = sc.next();
	        while(r.equals("A")==false) {
	        	System.out.println("Un A...");
	        	r = sc.next();
	        }
	        out.println(r);
	        out.flush();
	    }
	        
	        
	        //si.close();
		   
		 // c.loop();
	    
	    
}