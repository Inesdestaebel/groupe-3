package projetgroupe3;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.io.*;

public class Partie extends Thread{
	private int X;
	private int Y;
	private int murs;
	private int pieges;
	private int potions;
	private int nb_joueurs;
	private Plateaudejeu Plateau;
	private ArrayList<Client> joueurs = new ArrayList<>();
	private String gagnant="";
	
	public Partie(int X, int Y, int murs, int pieges, int potions, int nb_joueurs) {
		this.nb_joueurs=nb_joueurs;
		this.X=X;
		this.Y=Y;
		this.murs=murs;
		this.pieges=pieges;
		this.potions=potions;
		this.Plateau = new Plateaudejeu(X,Y,murs,pieges,potions);
	}
	
	public Plateaudejeu getPlateau() {
		return Plateau;
	}
	public boolean ready() {
		return joueurs.size()==this.nb_joueurs;
	}
	
	public void addPlayer(Client player) {
		joueurs.add(player);
	}
	
	public ArrayList<Client> getJoueurs(){
		return joueurs;
	}
	
	public void run() {
		for(Client player : joueurs) {
			player.send_message("Bienvenue dans la partie, nous attendons les joueurs pour commencer.");	
		}
		
		System.out.println("En attente des joueurs pour que la partie commence...");
		for(Client player : joueurs) {
			while(player.isReady()==false) {  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
			System.out.println(player.getNom()+" est pr�t.");
			player.p = new Personnage(player.getNom());
			player.p2 = new Personnage(player.getNom());
			}
		
		//MISE EN PLACE DU PLATEAU DU JOUEUR EXACTEMENT COMME LE PLATEAU PRINCIPAL, OKKK FONCTIONNE 
		//P2 PERMET DE PAS AVOIR LA POSITION MODIFIEE DE P AVEC LES BOUCLES
		for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			player.p2.setPlateau(X, Y);
			for(int x=0;x<X;x++) {
				for(int y=0;y<Y;y++) {
					int[] pos= {x,y};
					char a = Plateau.valeurcase(x, y);
					player.p2.getPlateau().setOnePlateau(a,pos);
					if(a=='V') {
						player.p2.getPlateau().setObj(pos);
					}
				}
			}
		}
		for(int i=0;i<joueurs.size();i++) {
			Client player=joueurs.get(i);
			
			//Ajout du joueur sur le plateau et on associe la position au joueur.
			player.p.setPosition(Plateau.addPlayerServeur(player.p));
			player.p2.setPosition(player.p.getPosition());
			//On met a jour le plateau du joueur en ajoutant le joueur � cette position.
			player.p2.getPlateau().setOnePlateau('H',player.p2.getPosition());
			player.p2.getPlateau().setOnePlateauPerso('H',player.p2.getPosition());
			
			//On ajoute les fonctions de d�placements pour les deux plateaux
			player.D = new Deplacements(player.p,Plateau); 
			player.Djoueurs = new Deplacements(player.p2,player.p2.getPlateau()); 
			
			player.p2.getPlateau().afficher(); //OK JUSTE
			System.out.println("");
			
		}
		Plateau.afficher(); //OK JUSTE
		
		boolean fin=false;
		while(fin==false) {
			for (Client player : joueurs) {
				if(player.isAlive()==false) {
					System.out.println("heho");
					player.Ready(true);
					joueurs.remove(player);
					continue;
				}
				
				//ICI ON RENVOIE SON PLATEAU AU JOUEUR AVEC LE PERSO ET LES CONSIGNES
				VisionJoueur v = new VisionJoueur(player);
				player.send_message("Vous �tes actuellement "+joueurs.size()+" joueurs sur cette partie.");
				player.send_message(v.showplateau(player));
				player.send_message("fin plateau.");
				player.send_message(v.showperso(player));
				player.send_message(v.demandeactions(player));
				player.send_message("fin demande.");
				
			}
			
			System.out.println("En attente des actions des joueurs...");
			try {
			for (Client player : joueurs) {
				while(player.ReadyActions()==false && player.p.isAlive()) {
					try {
						Thread.sleep(10);
						if(player.isAlive()==false) {
							System.out.println(player.getNom()+" a �t� d�connect�.");
							Plateau.setOnePlateau(' ',player.p2.getPosition());
							player.setActions("DDDD");
						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(player.isAlive()==true) {
				System.out.println(player.getNom()+" est pr�t.");
				}
				else {
					joueurs.remove(player);
				}
			}
			}catch(ConcurrentModificationException e) {
		}
			
			//ICI ON ATTEND LA CHAINE DE 4 CARACTERES ACTIONS DU JOUEUR
			for(int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				System.out.println(player.p);
				System.out.println(player.actions);
				player.p2.getPlateau().afficher();
				System.out.println(" ");
				player.send_message(player.Djoueurs.MoveClient(player.actions,Plateau));
				player.send_message("fin actions.");
				//Je mets � jour le plateau personnel du joueur afin qu'il ai un plateau perso correct
				
				player.p2.getPlateau().afficher();
				player.D.Move(player.actions);//Je mets a jour le plateau
				//de la partie lorsqu'un joueur joue.
				
				Plateau.afficher();
				player.setActions("a"); //Pour que players.ReadyActions() passe � faux
				System.out.println("");
				
				if(player.D.getVictoire()) {
					fin=true;
					gagnant = player.getNom();
					
				}
			}
		
			for (int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				//ON VERIFIE QUE LE PERSONNAGE N'EST PAS MORT
				if(player.p.isAlive()==false || player.isAlive()==false) {
					System.out.println("Le joueur "+player.getNom()+" a perdu.");
					player.send_message("Vous avez perdu!");
					Plateau.setOnePlateau('~',player.p2.getPosition());
					joueurs.remove(i);
				}
			}
			if(joueurs.isEmpty()) {
				fin=true;
			}
				}
			
	
	if(fin==true) {
		if(joueurs.isEmpty()) {
			System.out.println("Il n'y a plus de joueurs, la partie se termine...");
		}
		else {
		System.out.println("La partie est termin�e, "+gagnant+" a gagn�!");
		for (int i=0;i<joueurs.size();i++) {
		Client player = joueurs.get(i);
		player.send_message("La partie est termin�e!");
		player.send_message(gagnant+" a gagn�!");
		player.interrupt();
		}
	   }
      }
	}
}


	

