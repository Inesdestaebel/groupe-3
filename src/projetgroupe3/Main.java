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
		System.out.println(H);
		System.out.println("Z vous permet de monter.");
		System.out.println("S vous permet de descendre.");
		System.out.println("D vous permet d'aller à droite.");
		System.out.println("Q vous permet d'aller à gauche.");
		System.out.println("R vous permet de ramasser un objet.");
		System.out.println("E vous permet d'utiliser une potion.");
		//plateau.afficher();
		
		//Plateau que le joueur verra, on changera les valeurs en introduisant les valeurs 
		//DOIS JE METTRE CA DANS UNE AUTRE CLASSE?
		
		
		
		
			
			//Déplacements du joueur

		Deplacements D = new Deplacements(H,plateau);
			while(!D.getVictoire() && H.isAlive()) {
				System.out.println("Veuillez entrer vos 4 actions :");
				String move = s.next();
				while (move.length()!=4) {
					System.out.println("Entrez 4 actions...");
					move = s.next();
				}
				//Utilisation des fonctions de déplacement
				
				D.Move(move, H, plateau);
				plateau.afficherPlateauPerso();
				System.out.println(H);
				//plateau.afficher();
			}
			
			if (H.isAlive()) {
				System.out.println("Victoire!");
				plateau.afficher();
			}
			}
		}

	



