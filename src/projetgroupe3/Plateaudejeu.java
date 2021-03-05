package projetgroupe3;


import java.util.Random;

public class Plateaudejeu {
		public static void main(String[] args) {
			
		int X = 15;
		int Y = 9;
			
		//cr�ation plateau
		char[][] plateau = new char[X][Y];
			
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
			
			//placement des cases pi�ge
			int pi�ge = 15;
			while(pi�ge>0) {
				int a=r.nextInt(15);
				int b=r.nextInt(9);
				if(plateau[a][b]=='?') {
					plateau[a][b]= '~';
					pi�ge = pi�ge-1;
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
			
			//affichage du plateau
			for ( int y = 0 ; y<Y; y++ ) {
				for ( int x = 0 ; x<X; x++ ) {
					System.out.print(plateau[x][y]);
			}
			System.out.println();
			}
			
			//mise en place du plateau que verra l'utilisateur
			//char[][] plateaucach� = new char[X][Y];
			
			
			
			
			//boolean actions = false;
			//while(!actions) {
				//String ligne = scanner.nextLine(); 
	//faire un test pour v�rifier qu'il s'agit d'une string de 4 caract�res
	// ressortir un affichage en fonction des actions
		
			
		}
		
	//QUESTIONS
	//quand s'arr�te le jeu, et ou sont situ�s les joueurs au d�but
	//comment provoquer des cases al�atoires ( et les cacher avec des points d'interrogation )
	//135 cases : 60 vides, 44 murs, 1 objectif, 15 potions, 15 pi�ges, 
	//d pour d�placement � droite g pour d�placement � gauche et s�rie de 4 actions



}
