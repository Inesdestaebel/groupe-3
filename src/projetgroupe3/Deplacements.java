package projetgroupe3;

public class Deplacements{
	private Personnage H;
	private Plateaudejeu P;
	private boolean victoire=false;
	// on va partir sur une base Z Q S D avec Z = devant Q = gauche S= derrière et D = droite (ce qui est le plus fréquemment utilisé dans les jeux)
	// on se base sur un axe X Y donc pour se déplacer horizontalement, le x varie & verticalement le y varie
	

	public Deplacements(Personnage H, Plateaudejeu P) {

	}
	
	public void Dep(Personnage H, Plateaudejeu P, String dep) {
		
		int[] pos = H.getPosition();
		int x = pos[0];
		int y = pos[1];
		if(dep.equals("Z")) {
			System.out.println("Je descend.");
			int[] pos2 = {x+1,y};
			P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
			if (P.valeurcase(x+1, y)==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
					victoire=true;
				}
			else if (P.valeurcase(x+1, y)!='#') {
				P.setOnePlateau(' ',pos);
				H.setPosition(pos2);
				P.setOnePlateau('H',pos2);
				P.setOnePlateauPerso('H', pos2);
				P.setOnePlateauPerso(' ',pos);
				
			}
		}
		else if(dep.equals("S")) {
			System.out.println("Je monte.");
			int[] pos2 = {x-1,y};
			P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
			if (P.valeurcase(x-1, y)==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
				victoire=true;
			}
			else if (P.valeurcase(x-1, y)!='#') {
				P.setOnePlateau(' ',pos);
				H.setPosition(pos2);
				P.setOnePlateau('H',pos2);
				P.setOnePlateauPerso('H', pos2);
				P.setOnePlateauPerso(' ',pos);
		}
		}
		else if(dep.equals("Q")) {
			System.out.println("A gauche.");
			int[] pos2 = {x,y-1};
			P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);	
			if (P.valeurcase(x, y-1)==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
				victoire=true;
			}
			else if (P.valeurcase(x, y-1)!='#') {
					P.setOnePlateau(' ',pos);
					H.setPosition(pos2);
					P.setOnePlateau('H',pos2);
					P.setOnePlateauPerso('H', pos2);
					P.setOnePlateauPerso(' ',pos);
		}
		}
		else if (dep.equals("D")){
			System.out.println("A droite.");
			int[] pos2 = {x,y+1};
			P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
			if (P.valeurcase(x, y+1)==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
				victoire=true;
			}
			else if (P.valeurcase(x, y+1)!='#') {
				P.setOnePlateau(' ',pos);
				H.setPosition(pos2);
				P.setOnePlateau('H',pos2);
				P.setOnePlateauPerso('H', pos2);
				P.setOnePlateauPerso(' ',pos);
				}
		}
		}	


	public void Move(String S, Personnage H, Plateaudejeu P) {
		int i=0;
		while((i<S.length())&&(!victoire)) {
			String x = S.substring(i,i+1);
			System.out.println("Déplacement:"+x);
			Dep(H,P,x);
			H.getPosition();
			i++;
		}
		}
	
	public boolean getVictoire() {
		return victoire;
	}
			
	
	}


	// Pour la fonction main il faudrait faire un scanner qui selon ce que l'on rentre Z Q S D, Haut Bas Droite ou gauche s'exécute.

	// donc en gros, la fonction va créer une variable  pos qui va prendre ce qui se trouve à la position actuelle du joueur (donc ce qu'on a choisi comme lettre pour le joueur)
	// ensuite la position actuelle du joueur va devenir "" donc un espace vide
	// puis la position selon ce que le joueur a rentré deviendra pos soit comment on a appelé le joueur sur le plateau
	// la seule chose qu'il faut bouger c'est le plateau [x][y] il faudrait remplacer par les coordonnés des joueurs mais je sais pas comment les récupérer.



