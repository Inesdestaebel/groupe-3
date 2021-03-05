package projetgroupe3;


import java.util.Random;

public class Plateaudejeu {
		public static void main(String[] args) {
			
		int X = 15;
		int Y = 9;
			
		//création plateau
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
			
			//affichage du plateau
			for ( int y = 0 ; y<Y; y++ ) {
				for ( int x = 0 ; x<X; x++ ) {
					System.out.print(plateau[x][y]);
			}
			System.out.println();
			}
			
			//mise en place du plateau que verra l'utilisateur
			//char[][] plateaucaché = new char[X][Y];
			
			
			
			
			//boolean actions = false;
			//while(!actions) {
				//String ligne = scanner.nextLine(); 
	//faire un test pour vérifier qu'il s'agit d'une string de 4 caractères
	// ressortir un affichage en fonction des actions
		
			
		}
		
	//QUESTIONS
	//quand s'arrête le jeu, et ou sont situés les joueurs au début
	//comment provoquer des cases aléatoires ( et les cacher avec des points d'interrogation )
	//135 cases : 60 vides, 44 murs, 1 objectif, 15 potions, 15 pièges, 
	//d pour déplacement à droite g pour déplacement à gauche et série de 4 actions



}
