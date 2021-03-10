package projetgroupe3;

import java.util.Scanner;
import projetgroupe3.Deplacements;

public class Main {

	public static void main(String[] args) {
		int X = 9;
		int Y = 15;
		int murs = 44;
		int pieges = 15;
		int potion = 15;
		Plateaudejeu plateau = new Plateaudejeu(X,Y,murs,pieges,potion);
		
		//Pour afficher le plateau mais à supprimer dans le jeu car le joueur ne doit pas le voir au début.
		//plateau.afficher();
		
		//Ajout du joueur.
		Scanner s = new Scanner(System.in);
		System.out.println("Veuillez entrer votre nom :");
		String name =s.next();
		//plateau.addPlayer(name);
		Personnage H = plateau.addPlayer(name);
		

		//plateau.afficher();
		
		//Plateau que le joueur verra, on changera les valeurs en introduisant les valeurs 
		//DOIS JE METTRE CA DANS UNE AUTRE CLASSE?
		char[][] plateaujoueur = new char[X][Y];
		for ( int x = 0 ; x<X; x++ ) {
			for ( int y = 0 ; y<Y; y++ ) {
				if (plateau.valeurcase(x, y)=='H') {
					plateaujoueur[x][y]='H';
				}
				else {
				plateaujoueur[x][y]= '?';
				}
				System.out.print(plateaujoueur[x][y]);
			}
			System.out.println();
		}
	
			
			//Déplacements du joueur
			System.out.println("Veuillez entrer vos déplacements");
			String move = s.next();
			while (move.length()!=4) {
				System.out.println("Entrez 4 mouvements");
				move = s.next();
			}
			//Utilisation des fonctions de déplacement
			Deplacements D = new Deplacements(H,plateau);
			D.Move(move, H, plateau,plateaujoueur);
			for ( int x = 0 ; x<X; x++ ) {
				for ( int y = 0 ; y<Y; y++ ) {
					System.out.print(plateaujoueur[x][y]);
				}
				System.out.println();
			}
			}
		}





