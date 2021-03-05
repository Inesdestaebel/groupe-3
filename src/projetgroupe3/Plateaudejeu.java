package projetgroupe3;


import java.util.Random;

public class Plateaudejeu {
		private int X;
		private int Y;
		private char[][] plateau = new char[X][Y];
		
		public Plateaudejeu(int X, int Y) {
			setPlateau(plateau);
		}
		
		public char[][] getPlateau() {
			return plateau;
		}
		
		public void setPlateau(char[][] plateau ) {
			for ( int x = 0 ; x<X; x++ )
				for ( int y = 0 ; y<Y; y++ )
					plateau[x][y]= '?';
		
		//mise en place des cases sur le plateau 
		
		Random r = new Random();
		
		//placement de la case objectif
		int v1 = r.nextInt(15); 
		int v2 = r.nextInt(9);
		plateau[v1][v2]='V';
		
		//placement des cases vides
		int vides = 60;
		while(vides>0) {
			int a = r.nextInt(15);
			int b = r.nextInt(9);
			if(plateau[a][b]=='?') {
				plateau[a][b]=' ';	
				vides = vides-1;
			}
		}
		
		//placement des cases murs
		int murs = 44;
		while(murs>0) {
			int a=r.nextInt(15);
			int b=r.nextInt(9);
			if(plateau[a][b]=='?') {
				plateau[a][b]= '#';
				murs = murs-1;
			}
		}
		
		//placement des cases piège
		int piège = 15;
		while(piège>0) {
			int a=r.nextInt(15);
			int b=r.nextInt(9);
			if(plateau[a][b]=='?') {
				plateau[a][b]= '~';
				piège = piège-1;
			}
		}
		
		//placement des cases potion
		int potion = 15;
		while(potion>0) {
			int a=r.nextInt(15);
			int b=r.nextInt(9);
			if(plateau[a][b]=='?') {
				plateau[a][b]= 'P';
				potion = potion-1;
			}
		}
}
}