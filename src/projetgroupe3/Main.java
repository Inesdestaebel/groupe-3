package projetgroupe3;

public class Main {

	public static void main(String[] args) {
		int X = 9;
		int Y = 15;
		int vides = 60;
		int murs = 44;
		int pieges = 15;
		int potion = 15;
		Plateaudejeu plateau = new Plateaudejeu(X,Y,vides,murs,pieges,potion);
		if(X*Y!=vides+murs+pieges+potion+1) {
			System.out.println("Certaines cases ne sont pas attribuées.");
		}
		//Pour afficher le plateau mais à supprimer dans le jeu car le joueur ne doit pas le voir au début.
		//plateau.afficher();
		
		//Ajout du joueur.
		plateau.addPlayer();
		
	
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
}
}


