package projetgroupe3;

public class Deplacements{
	private Personnage H;
	private Plateaudejeu P;
	// on va partir sur une base Z Q S D avec Z = devant Q = gauche S= derrière et D = droite (ce qui est le plus fréquemment utilisé dans les jeux)
	// on se base sur un axe X Y donc pour se déplacer horizontalement, le x varie & verticalement le y varie
	
	public Deplacements(Personnage H, Plateaudejeu P) {

	}
	
	public void Dep(Personnage H, Plateaudejeu P, String dep, char[][] plateau2) {
		int[] pos = H.getPosition();
		int x = pos[0];
		int y = pos[1];
		if(dep.equals("Z")) {
			System.out.println("Je descend.");
			if (P.valeurcase(x+1, y)!='#') {
				int[] pos2 = {x+1,y};
				H.setPosition(pos2);
				plateau2[x][y]=P.valeurcase(x, y);
			}
		}
		else if(dep.equals("S")) {
			System.out.println("Je monte.");
			if (P.valeurcase(x-1, y)!='#') {
				int[] pos2 = {x-1,y};
				H.setPosition(pos2);
				plateau2[x][y]=P.valeurcase(x, y);
			} 
		}
		else if(dep.equals("Q")) {
			System.out.println("A gauche.");
				if (P.valeurcase(x, y-1)!='#') {
					int[] pos2 = {x,y-1};
					H.setPosition(pos2);
					plateau2[x][y]=P.valeurcase(x, y);
				} 
		}
		else if (dep.equals("D")){
			System.out.println("A droite.");
			if (P.valeurcase(x, y+1)!='#') {
			int[] pos2 = {x,y+1};
			H.setPosition(pos2);
			plateau2[x][y]=P.valeurcase(x, y);
		}
		}
		}	


	public void Move(String S, Personnage H, Plateaudejeu P, char[][] plateau2) {
		for(int i=0; i<S.length();i++) {
			String x = S.substring(i,i+1);
			System.out.println("Déplacement:"+x);
			Dep(H,P,x,plateau2);
			H.getPosition();
		}
		}
			
	
	}

	// Pour la fonction main il faudrait faire un scanner qui selon ce que l'on rentre Z Q S D, Haut Bas Droite ou gauche s'exécute.

	// donc en gros, la fonction va créer une variable  pos qui va prendre ce qui se trouve à la position actuelle du joueur (donc ce qu'on a choisi comme lettre pour le joueur)
	// ensuite la position actuelle du joueur va devenir "" donc un espace vide
	// puis la position selon ce que le joueur a rentré deviendra pos soit comment on a appelé le joueur sur le plateau
	// la seule chose qu'il faut bouger c'est le plateau [x][y] il faudrait remplacer par les coordonnés des joueurs mais je sais pas comment les récupérer.



