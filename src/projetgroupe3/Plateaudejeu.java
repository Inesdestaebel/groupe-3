package projetgroupe3;

//test
import java.util.Random;

public class Plateaudejeu {
		private int X;
		private int Y;
		private char[][] plateau = new char[X][Y];
		
		public Plateaudejeu(int X, int Y) {
			setX(X);
			setY(Y);
			setPlateau(X,Y);
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
		
		public char getPlateau(int x, int y) {
				return plateau[x][y];
			
		}
		
		public void setPlateau(int X, int Y) {
			try {
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
			int vides = 60;
			while(vides>0) {
				int a = r.nextInt(X);
				int b = r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]=' ';	
					vides = vides-1;
				}
			}
		
			//placement des cases murs
			int murs = 44;
			while(murs>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= '#';
					murs = murs-1;
				}
			}
		
			//placement des cases piège
			int piège = 15;
			while(piège>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= '~';
					piège = piège-1;
				}
			}
		
			//placement des cases potion
			int potion = 15;
			while(potion>0) {
				int a=r.nextInt(X);
				int b=r.nextInt(Y);
				if(plateau[a][b]=='?') {
					plateau[a][b]= 'P';
					potion = potion-1;
				}
			}
			}catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("Veuillez rentrer un X et un Y positif.");
			}
		}
		
}
