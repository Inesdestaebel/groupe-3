package projetgroupe3;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client extends Thread{  
	    private String name="prenom";
	    private PrintStream out;
	    private BufferedReader in;
	    private Boolean ready=false;
	    private Boolean fin=false;
	    private Socket s;
	    Personnage p = new Personnage (name);
	    Deplacements D = new Deplacements(p);
	    String actions="";
	    
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
	    
	    public void setActions(String a) {
	    	this.actions=a;
	    }
	    
	    public boolean ReadyActions() {
	    	if(actions.length()!=4) {
	    		return false;
	    	}
	    	else {
	    		return true;
	    	}
	    }
	    
	   public void run() {
		   try {
		   name=in.readLine();
		   setNom(name);
		   String r= in.readLine();
		   if(r.equals("A")) {
			   Ready(true);
		   }
		   while(fin==false) {
			   actions=in.readLine();
			   setActions(actions);
			   if(D.getVictoire()==false)
				   setActions("a");
		   }
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
	        
	        while(c.fin==false) {
	        	System.out.println("Z vous permet de monter.");
				System.out.println("S vous permet de descendre.");
				System.out.println("D vous permet d'aller à droite.");
				System.out.println("Q vous permet d'aller à gauche.");
				System.out.println("R vous permet de ramasser un objet.");
				System.out.println("E vous permet d'utiliser une potion.");
				System.out.println("Veuillez entrer vos 4 actions :");
				String move = sc.next();
				while (move.length()!=4) {
					System.out.println("Entrez 4 actions...");
					move = sc.next();
				}
				c.out.println(move);
				c.out.flush();
				
				if(c.D.getVictoire()==true || c.p.isAlive()==false) {
					c.fin=true;
				}
			
	        }
	    }
}


           