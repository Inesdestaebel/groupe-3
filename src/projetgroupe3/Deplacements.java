package projetgroupe3;


/*public class Deplacements{
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
*/
public class Deplacements{
	private Personnage H;
	private Plateaudejeu P;
	private boolean victoire=false;
	private char caseActu;
	// on va partir sur une base Z Q S D avec Z = devant Q = gauche S= derrière et D = droite (ce qui est le plus fréquemment utilisé dans les jeux)
	// on se base sur un axe X Y donc pour se déplacer horizontalement, le x varie & verticalement le y varie
	

	public Deplacements(Personnage H, Plateaudejeu P) {

	}
	public char getCaseActu(){
		return caseActu;
	}
	public void setCaseActu(char c) {
		this.caseActu=c;
	}
	
	
	public void Dep(Personnage H, Plateaudejeu P, String dep) {
		
		int[] pos = H.getPosition();
		int x = pos[0];
		int y = pos[1];
		int[] pos2=new int[2];
		if(dep.equals("S")) {
			System.out.println("Je descend.");
			if(P.getX()>x+1) {
				pos2[0] =x+1;
				pos2[1]=y;
			}
			else {
				System.out.println("Vous allez sortir du plateau, déplacement annulé.");
				pos2=pos;
			}
		}
		
		else if(dep.equals("Z")) {
			System.out.println("Je monte.");
			if(x-1>=0) {
				pos2[0] = x-1;
				pos2[1]=y;
			}
			else {
				System.out.println("Vous allez sortir du plateau, déplacement annulé.");
				pos2=pos;
			}
		
		}
		else if(dep.equals("Q")) {
			System.out.println("A gauche.");
			if(y-1>=0) {
				pos2[0] = x;
				pos2[1]=y-1;
			}
			else {
				System.out.println("Vous allez sortir du plateau, déplacement annulé.");
				pos2=pos;
			}
		}
		
		else if (dep.equals("D")){
			System.out.println("A droite.");
			if(P.getY()>y+1) {
			pos2[0] = x;
			pos2[1]=y+1;	
		}
			else {
				System.out.println("Vous allez sortir du plateau, déplacement annulé.");
				pos2=pos;
			}
		}
		
		else if (dep.equals("R")) {
			pos2= pos;
			if (getCaseActu()=='P') {
				H.addPotion();
				setCaseActu(' ');
				System.out.println("Vous ramassez une potion, 'E' pour utiliser");

			}
			else {
				System.out.println("Vous essayez de ramasser une potion mais il n'y a rien par terre...");
			}
		
		}
		else if (dep.equals("E")) {
			H.usePotion();
			pos2= pos;
			
		}
		else {
			pos2= pos;
			System.out.println("Ceci n'est pas une action valide.");
			}
		
		
		P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
		if (P.valeurcase(pos2[0], pos2[1])==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
			cestGagne();
		}
		else if (P.valeurcase(pos2[0], pos2[1])!='#') {
			P.setOnePlateau(getCaseActu(),pos);
			P.setOnePlateauPerso(getCaseActu(),pos);
			setCaseActu(P.valeurcase(pos2[0],pos2[1]));
			H.setPosition(pos2);
			P.setOnePlateau('H',pos2);
			P.setOnePlateauPerso('H', pos2);
			
			}
		else {
			System.out.println("Il y a un mur, le déplacement est annulé.");
		}
		
		
		if (getCaseActu()=='P'){
				System.out.println("Vous marchez sur une potion, une fois sur la case, 'R' pour la ramasser");
		}
		else if (getCaseActu()=='~') {
			System.out.println("Vous marchez sur un piege!! -2PV !!");
			H.trap();

		}
		if (H.getPV()<1) {
			System.out.println("Vous etes mort/n GAME OVER");
			H.dead();
		}
		}
		


	public void Move(String S, Personnage H, Plateaudejeu P) {
		int i=0;
		while((i<S.length())&&(!getVictoire())&&(H.isAlive())) {
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
	public void cestGagne() {
		victoire=true;
	}
			
	
	}


