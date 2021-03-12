package projetgroupe3;

public class TestPlateaudejeu {

	public static void main(String[] args) {
		int X = 10;
		int Y = 10;
		int murs = 1;
		int pieges = 1;
		int potion = 1;
		Plateaudejeu plateau = new Plateaudejeu(X,Y,murs,pieges,potion);
		System.out.println("constructeur OK");
		
		plateau.afficher();
		System.out.println("afficher() OK");
		
		plateau.afficherPlateauPerso();
		System.out.println("afficherPlateauPerso() OK");
		
		int[] pos= {1,1};
		plateau.setOnePlateau('T', pos);
		plateau.afficher();
		System.out.println("Valeure de la case [1,1]: "+plateau.valeurcase(pos[0], pos[1]));
		
		plateau.setOnePlateauPerso('B', pos);
		plateau.valeurcaseperso(pos[0], pos[1]);
		plateau.afficherPlateauPerso();
		System.out.println("Valeure de la case [1,1]: "+plateau.valeurcaseperso(pos[0], pos[1]));
		// TODO Auto-generated method stub

	}

}
