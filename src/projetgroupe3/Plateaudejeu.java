package projetgroupe3;

import java.util.Random;
import java.util.Scanner;

public class Plateaudejeu {
		private int X;
		private int Y;
		private int murs;
		private int pieges;
		private int potions;
		//private int nbjoueur;
		private char[][] plateau;
		private char[][] plateauPerso;
		private int[] obj= new int[2];
		//private Personnage[] listPesronnage;

		
		//Constructeur
		public Plateaudejeu(int X, int Y, int murs, int pieges, int potion) {
			setX(X);
			setY(Y);
			//setNbjoueur(nbjoueur);
			setMursPiegesPotion(murs, pieges, potion);
			setPlateauPerso();
			plateau = new char[X][Y];
			
			
			for ( int x = 0 ; x<X; x++ )
				for ( int y = 0 ; y<Y; y++ )
					plateau[x][y]= '?';
			
			//mise en place des cases sur le plateau 
			
			Random r = new Random();
			
			//placement de la case objectif
			int v1 = r.nextInt(X); 
			int v2 = r.nextInt(Y);
			plateau[v1][v2]='V';
			int[] obj = {v1,v2};
			this.obj=obj;
			

			
			//placement des cases murs
			while(murs>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= '#';
					murs = murs-1;
				}
			}
			
			//placement des cases piège
			while(pieges>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= '~';
					pieges = pieges-1;
				}
			}
			
			//placement des cases potion
			while(potion>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= 'P';
					potion = potion-1;
				}
			}
			
			//placement des cases vides
			for ( int x = 0 ; x<X; x++ ) {
				for ( int y = 0 ; y<Y; y++ ) {
					if(plateau[x][y]=='?') {
						plateau[x][y]=' ';	
					}
				}
			}
		//	setListPersonnage();
		}
		
		public void setOnePlateau(char c, int[]pos) {
			plateau[pos[0]][pos[1]]=c;
		}
		
		public void setPlateauPerso(){
			char[][] plateauPerso= new char[getX()][getY()];
			for (int i=0; i<getX(); i++) {
				for (int j=0; j<getY(); j++) {
					plateauPerso[i][j]='?';
				}
			}
			this.plateauPerso=plateauPerso;
		}
		public void setOnePlateauPerso(char c, int[]pos) {
			plateauPerso[pos[0]][pos[1]]=c;
		}
		
		
		public void afficherPlateauPerso() {

			for ( int x = 0 ; x<X; x++ ) {
				for ( int y = 0 ; y<Y; y++ ) {
					System.out.print(plateauPerso[x][y]);
				}
			System.out.println();
			}

			}
		
		
		public int[] getObj() {
			return obj;
		}
		
		public int getMurs() {
			return murs;
		}

		
		public int getPieges() {
			return pieges;
		}

		public int getPotions() {
			return potions;
		}

		public void setMursPiegesPotion(int murs, int pieges, int potion) {
			if (murs+pieges+potion<X*Y) {
				this.murs = murs;
				this.potions=potion;
				this.pieges=pieges;
				
			}
			else {
				System.err.println(" impossible de creer un plateau car aucune case vide.");

			}
			
		}
		
		public int getX() {
			return X;
		}
		
		public void setX(int X) {
			if (X>0) {
				this.X=X;
			}
			else {
				System.err.println(X+ " <0 impossible de creer un plateau ");
			}
				
		}
		
		public int getY() {
			return Y;
		}
		
		public void setY(int Y) {
			if (Y>0) {
				this.Y=Y;
			}
			else {
				System.err.println(Y+ " <0 impossible de creer un plateau ");
			}
				
		}


		public void afficher() {

			for ( int x = 0 ; x<X; x++ ) {
				for ( int y = 0 ; y<Y; y++ ) {
					System.out.print(plateau[x][y]);
				}
			System.out.println();
			}
			}


		public char valeurcase (int x, int y) {
			return plateau[x][y];
		}
		
		public char valeurcaseperso(int x, int y) {
			return plateauPerso[x][y];
		}
		
		//PLacer un nouveau joueur sur une case vide
		public Personnage addPlayer(String name) {
	
			Random r = new Random();
			int x=r.nextInt(X);
			int y=r.nextInt(Y);
			while (plateau[x][y]!=' ') {
				 x=r.nextInt(X);
				 y=r.nextInt(Y);	
			}
			int[]pos= {x,y};
			Personnage player=new Personnage(name,pos);
			plateau[x][y]='H'; 
			plateauPerso[x][y]='H';			//H designera le personnage lors de l'affichage du plateau.
			return player;
		}
		
		//public void reveal(int[2] coord)
}


