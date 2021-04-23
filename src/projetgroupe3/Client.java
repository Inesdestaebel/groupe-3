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
	    Personnage p2 = new Personnage (name);
	    Deplacements D = new Deplacements(p);
	    Deplacements Djoueurs = new Deplacements(p);
	    String actions="";
	    
	    public Client(Socket s) {
	    	try {
	    		setSocket(s);
	    		out = new PrintStream( s.getOutputStream() );
	    		in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    }
	    	
	    }
	    
	  public void setSocket(Socket s) {
		  this.s=s;
	  }
	  
	  public Socket getSocket() {
		  return s;
	  }
	   
	  public void send_message(String i) {
	    	out.println(i);
	    	out.flush();
	    }
	   
	   public void setNom(String n) {
	    	this.name = n;
	   }
	    
	   public String getNom() {
	   		return name;
	   }
	   
	   public void setFin(Boolean n) {
		   this.fin=n;
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
	    
	    public String getActions() {
	    	return actions;
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
			   try {
			   String action =in.readLine();
			   setActions(action);
			   } catch (SocketException e) {
				   send_message("La connexion est perdue!");
				   fin=true;
			   }
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
	    	while(n.length()>10 || n.length()<=0) {
	    		System.out.println("Votre nom doit faire au moins 1 caractère et au maximum 10!");
	    		n=sc.next();
	    	}
	    	c.p.setName(n);
	    	c.p2.setName(n);
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
	      
	      String messageentree = c.in.readLine();
	      System.out.println(messageentree);
	      System.out.println("");
	      
	       while(c.fin==false) {
	    	   
	    	   String nbjoueurs = c.in.readLine();
	    	   System.out.println(nbjoueurs);
	    	   System.out.println("");
	    	   
	    	   if (nbjoueurs.equals("Vous avez perdu!")){
	    		   break;
	    	   }
	    	   
	    	  if(nbjoueurs.equals("La partie est terminée!")){
	    		   nbjoueurs = c.in.readLine();
	    		   System.out.println(nbjoueurs);
	    		   break;
	    	   }
	    			   
	    			   
	    	   String plateau = c.in.readLine();
			   while(plateau.equals("fin plateau.")==false) {
			   System.out.println(plateau);
			   plateau = c.in.readLine();
			   }
			   
			   String personnage = c.in.readLine();
			   System.out.println(personnage);
			   System.out.println("");
			   
			   String demandeactions = c.in.readLine();
			   while(demandeactions.equals("fin demande.")==false) {
				   System.out.println(demandeactions);
				   demandeactions = c.in.readLine();
				   
			   }
	        	
				String move = sc.next();
				while (move.length()!=4) {
					System.out.println("Entrez 4 actions...");
					move = sc.next();
				}
				c.out.println(move);
				c.out.flush();
				
				
				String resultatactions = c.in.readLine();
				while(resultatactions.equals("fin actions.")==false) {
					System.out.println(resultatactions);
					resultatactions = c.in.readLine();
					
				}
	        }
	       socket.close();
	       sc.close();
	    }
}


           