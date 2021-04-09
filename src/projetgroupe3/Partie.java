package projetgroupe3;

import java.util.ArrayList;
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
			player.send_message("Bienvenue dans la partie. Vous êtes "+nb_joueurs+" joueurs.");	
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
			
			System.out.println(player.getNom()+" est prêt.");
			player.p = new Personnage(player.getNom());
			}
		
		//MISE EN PLACE DU PLATEAU DU JOUEUR EXACTEMENT COMME LE PLATEAU PRINCIPAL, OKKK FONCTIONNE 
		//P2 PERMET DE PAS AVOIR LA POSITION MODIFIEE DE P AVEC LES BOUCLES
		for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			player.setPlateau(X,Y);
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
			//On met a jour le plateau du joueur en ajoutant le joueur à cette position.
			player.p2.getPlateau().setOnePlateau('H',player.p2.getPosition());
			player.p2.getPlateau().setOnePlateauPerso('H',player.p2.getPosition());
			
			//On ajoute les fonctions de déplacements pour les deux plateaux
			player.D = new Deplacements(player.p,Plateau); 
			player.Djoueurs = new Deplacements(player.p2,player.p2.getPlateau()); 
			
			player.p2.getPlateau().afficher(); //OK JUSTE
			System.out.println("");
			
		}
		Plateau.afficher(); //OK JUSTE
		
		boolean fin=false;
		while(fin==false) {
			for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			
			//ON VERIFIE QUE LE PERSONNAGE N'EST PAS MORT
			if(player.p.isAlive()==false) {
				System.out.println("Le joueur "+player.getNom()+" a perdu.");
				player.send_message("Un joueur a perdu...");
				player.send_message(player.getNom()+" a perdu!");
				Plateau.setOnePlateau('~',player.p2.getPosition());
				joueurs.remove(i);
				if(joueurs.isEmpty()) {
					System.out.println("Il n'y a plus de joueurs, la partie se termine...");
					break;
				}
			}
			}
			
			
			for (int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
			//ICI ON RENVOIE SON PLATEAU AU JOUEUR AVEC LE PERSO ET LES CONSIGNES
			System.out.println("En attente des actions des joueurs...");
				VisionJoueur v = new VisionJoueur(player);
				player.send_message(v.showplateau(player));
				player.send_message("fin plateau.");
				player.send_message(v.showperso(player));
				player.send_message(v.demandeactions(player));
				player.send_message("fin demande.");


			}
			
			for (int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				while(player.ReadyActions()==false && player.p.isAlive()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(player.getNom()+" est prêt.");
				//ICI ON ATTEND LA CHAINE DE 4 CARACTERES ACTIONS DU JOUEUR
			}
			for(int i=0;i<joueurs.size();i++) {
				if(fin==false) {
				Client player = joueurs.get(i);
				System.out.println(player.actions);
				System.out.println(player.p2);
				player.p2.getPlateau().afficher();
				player.send_message(player.Djoueurs.MoveClient(player.actions, player.p2 , player.p2.getPlateau()));//Je mets
				player.send_message("fin actions.");
				//à jour le plateau personnel du joueur afin qu'il ai un plateau perso correct
				
				player.p2.getPlateau().afficher();
				player.D.Move(player.actions, player.p ,Plateau);//Je mets a jour le plateau
				//de la partie lorsqu'un joueur joue.
				
				Plateau.afficher();
				player.setActions("a"); //Pour que players.ReadyActions() passe à faux
				System.out.println("");
				
				if(player.D.getVictoire()) {
					fin=true;
					gagnant = player.getNom();
					System.out.println(gagnant+" a gagné!!!");
				}
				
				if(fin==true) {
					player.send_message(gagnant+" a gagné!!!");
				}
			}
		}
			
	}		
}
}


	

