package projetgroupe3;

import java.util.Random;
import java.util.Scanner;

public class Plateaudejeu {
		private int X;
		private int Y;
		private char[][] plateau;
		
		//Constructeur
		public Plateaudejeu(int X, int Y, int vides, int murs, int pieges, int potion) {
			setX(X);
			setY(Y);
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
			
			//placement des cases vides
			while(vides>0) {
				int a = r.nextInt(X);
				int b = r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]=' ';	
					vides = vides-1;
				}
			}
			
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
	}
		
		public int getX() {
			return X;
		}
		
		public void setX(int X) {
			this.X=X;	
		}
		
		public int getY() {
			return Y;
		}
		
		public void setY(int Y) {
				this.Y=Y;	
		}
		
		
		public void afficher() {

			for ( int x = 0 ; x<X; x++ ) {
				for ( int y = 0 ; y<Y; y++ ) {
					System.out.print(plateau[x][y]);
				}
			System.out.println();
			}
		}

		public Personnage addPlayer() {
			Scanner sc= new Scanner(System.in);
			Random r = new Random();
			int x=r.nextInt(this.X);
			int y=r.nextInt(this.Y);
			while (plateau[x][y]!=' ') {
				 x=r.nextInt(this.X);
				 y=r.nextInt(this.Y);	
			}
			int[]pos= {x,y};
			System.out.println("Entrez votre nom de Personnage :");
			String name=sc.next();
			Personnage player=new Personnage(name,pos);
			this.plateau[x][y]='H'; //H designera le personnage lors de l'affichage du plateau.
			sc.close();
			return player;
		}
		
		public char valeurcase (int x, int y) {
			return plateau[x][y];
		}
		
}
