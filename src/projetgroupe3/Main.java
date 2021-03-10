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
		plateau.afficherPlateauPerso();
		plateau.afficher();

		//plateau.afficher();
		
		//Plateau que le joueur verra, on changera les valeurs en introduisant les valeurs 
		//DOIS JE METTRE CA DANS UNE AUTRE CLASSE?
		
		
		
		
			
			//Déplacements du joueur
			System.out.println("Veuillez entrer vos déplacements");
			String move = s.next();
			while (move.length()!=4) {
				System.out.println("Entrez 4 mouvements");
				move = s.next();
			}
			//Utilisation des fonctions de déplacement
			Deplacements D = new Deplacements(H,plateau);
			D.Move(move, H, plateau);
			plateau.afficherPlateauPerso();
			plateau.afficher();


			}
		}





