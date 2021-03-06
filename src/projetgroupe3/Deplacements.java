package projetgroupe3;

import java.util.Random;


public class Deplacements{
	private boolean victoire=false;
	private char caseActu;
	private Personnage H;
	private Plateaudejeu P;
	// on va partir sur une base Z Q S D avec Z = avancer Q = gauche S= reculer et D = droite (ce qui est le plus fr�quemment utilis� dans les jeux)
	// on fait varier X les lignes et Y les colonnes pour se d�placer
	

	public Deplacements(Personnage H, Plateaudejeu P) {
		setPersonnage(H);
		setPlateaudejeu(P);
	}
	
	public Deplacements(Personnage H) {
		setPersonnage(H);
	}
	
	public void setPersonnage(Personnage H) {
		this.H=H;
	}
	
	public void setPlateaudejeu(Plateaudejeu P) {
		this.P=P;
	}
	//Fonction qui permet de retourner la case sur laquelle on se trouve.
	public char getCaseActu(){
		return caseActu;
	}
	
	//Fonction qui permet de modifier la case sur laquelle on se trouve.
	public void setCaseActu(char c) {
		this.caseActu=c;
	}
	
	//D�placements gauche, droite, en haut, en bas et actions ( Ramasser, utiliser une potion... )
	public void Dep(String dep) {
		
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
				System.out.println("Vous allez sortir du plateau, d�placement annul�.");
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
				System.out.println("Vous allez sortir du plateau, d�placement annul�.");
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
				System.out.println("Vous allez sortir du plateau, d�placement annul�.");
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
				System.out.println("Vous allez sortir du plateau, d�placement annul�.");
				pos2=pos;
			}
		}
		
		//Ramasser une potion
		else if (dep.equals("R")) {
			pos2= pos;
			if (getCaseActu()=='P') {
				H.addPotion();
				setCaseActu(' ');
				System.out.println("Vous ramassez une potion, 'E' pour utiliser");
				Random r = new Random();
				int a = r.nextInt(P.getX());
				int b = r.nextInt(P.getY());
				while(P.valeurcase(a, b)!=' ' || P.valeurcaseperso(a, b)!='?') {
					a = r.nextInt(P.getX());
					b = r.nextInt(P.getY());
				}
				int[] pl ={a,b};
				P.setOnePlateau('P',pl);
			}
			else {
				System.out.println("Vous essayez de ramasser une potion mais il n'y a rien par terre...");
			}
		
		}
		else if (dep.equals("E")) {
			H.usePotion();
			pos2= pos;
			
		}
		else if (dep.equals("B")) {
			H.useBomb(P);
			pos2= pos;
			
		}
		else {
			pos2= pos;
			System.out.println("Ceci n'est pas une action valide.");
			}
		
		
		P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
		
		//Victoire
		if (P.valeurcase(pos2[0], pos2[1])==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
			cestGagne();
		}
		
		//Reactualisation du plateau lors des deplacements
		else if ((P.valeurcase(pos2[0], pos2[1])!='#')) {
			P.setOnePlateau(getCaseActu(),pos);
			P.setOnePlateauPerso(getCaseActu(),pos);
			setCaseActu(P.valeurcase(pos2[0],pos2[1]));
			H.setPosition(pos2);
			P.setOnePlateau('H',pos2);
			P.setOnePlateauPerso('H', pos2);
			
			}
		
		//Annulation du d�placement lorsqu'il y a un mur.
		else {
			System.out.println("Il y a un mur, le d�placement est annul�.");
		}
		
		//Cases potions et pi�ge
		if (getCaseActu()=='P'){
				System.out.println("Vous marchez sur une potion.");
		}
		else if (getCaseActu()=='~') {
			System.out.println("Vous marchez sur un piege!! -2PV !!");
			H.trap();

		}
		
		else if(getCaseActu()=='H') {
			System.out.println("Vous marchez sur la m�me case qu'un autre joueur, -2PV.");
			H.trap();
		}
		
		//Plus de vie...
		if (H.getPV()<1) {
			System.out.println("Vous etes mort\n GAME OVER");
			H.dead();
		}
		}
		

	//Application de la fonction de d�placement pour les 4 actions
	public void Move(String S) {
		int i=0;
		while((i<S.length())&&(!getVictoire())&&(H.isAlive())) {
			String x = S.substring(i,i+1);
			System.out.println("D�placement:"+x);
			Dep(x);
			//H.getPosition();
			i++;
		}
		}
	
	
	public String MoveClient(String S, Plateaudejeu plateaugeneral) {
		String str="";
		int i=0;
		while((i<S.length())&&(!getVictoire())&&(H.isAlive())) {
			String x = S.substring(i,i+1);
			str+="D�placement:"+x+"  ";
			str+=DepClient(x,plateaugeneral);
			i++;
			}
		return str;
		
		
	}
	//Boolean victoire qui passe � vrai lorsque le joueur gagne.
	public boolean getVictoire() {
		return victoire;
	}
	public void cestGagne() {
		victoire=true;
	}
	
	//D�placements gauche, droite, en haut, en bas et actions ( Ramasser, utiliser une potion... )
		public String DepClient(String dep, Plateaudejeu plateaugeneral) {
			String str="";
			int[] pos = H.getPosition();
			int x = pos[0];
			int y = pos[1];
			int[] pos2=new int[2];
			if(dep.equals("S")) {
				str+="Je descend.\n";
				if(P.getX()>x+1) {
					pos2[0] =x+1;
					pos2[1]=y;
				}
				else {
					str+="Vous allez sortir du plateau, d�placement annul�.\n";
					pos2=pos;
				}
			}
			
			else if(dep.equals("Z")) {
				str+="Je monte.\n";
				if(x-1>=0) {
					pos2[0] = x-1;
					pos2[1]=y;
				}
				else {
					str+="Vous allez sortir du plateau, d�placement annul�.\n";
					pos2=pos;
				}
			
			}
			else if(dep.equals("Q")) {
				str+="A gauche.\n";
				if(y-1>=0) {
					pos2[0] = x;
					pos2[1]=y-1;
				}
				else {
					str+="Vous allez sortir du plateau, d�placement annul�.\n";
					pos2=pos;
				}
			}
			
			else if (dep.equals("D")){
				str+="A droite.\n";
				if(P.getY()>y+1) {
				pos2[0] = x;
				pos2[1]=y+1;	
			}
				else {
					str+="Vous allez sortir du plateau, d�placement annul�.\n";
					pos2=pos;
				}
			}
			
			//Ramasser une potion
			else if (dep.equals("R")) {
				pos2= pos;
				if (getCaseActu()=='P') {
					H.addPotion();
					setCaseActu(' ');
					str+="Vous ramassez une potion, 'E' pour utiliser\n";
					Random r = new Random();
					int a = r.nextInt(P.getX());
					int b = r.nextInt(P.getY());
					while(P.valeurcase(a, b)!=' ' || P.valeurcaseperso(a, b)!='?') {
						a = r.nextInt(P.getX());
						b = r.nextInt(P.getY());
					}
					int[] pl ={a,b};
					P.setOnePlateau('P',pl);
				}
				else {
					str+="Vous essayez de ramasser une potion mais il n'y a rien par terre...\n";
				}
			
			}
			else if (dep.equals("E")) {
				str+=H.usePotionClient();
				pos2= pos;
				
			}
			else if (dep.equals("B")) {
				str+=H.useBombClient(P);
				pos2= pos;
				
			}
			else {
				pos2= pos;
				str+="Ceci n'est pas une action valide.\n";
				}
			
			//Victoire
			P.setOnePlateauPerso(P.valeurcase(pos2[0],pos2[1]), pos2);
			if (P.valeurcase(pos2[0], pos2[1])==P.valeurcase(P.getObj()[0],P.getObj()[1])) {
				cestGagne();
			}
			
			//Reactualisation du plateau lors des deplacements
			else if ((P.valeurcase(pos2[0], pos2[1])!='#')) {
				P.setOnePlateau(getCaseActu(),pos);
				P.setOnePlateauPerso(getCaseActu(),pos);
				setCaseActu(P.valeurcase(pos2[0],pos2[1]));
				H.setPosition(pos2);
				P.setOnePlateau('H',pos2);
				P.setOnePlateauPerso('H', pos2);
				
				}
			
			//Annulation du d�placement lorsqu'il y a un mur.
			else {
				str+="Il y a un mur, le d�placement est annul�.\n";
			}
			
			//Cases potions et pi�ge
			if (getCaseActu()=='P'){
				str+="Vous marchez sur une potion.\n";
			}
			else if (getCaseActu()=='~') {
				str+="Vous marchez sur un piege!! -2PV !!\n";
				H.trap();

			}
			else if(plateaugeneral.valeurcase(pos2[0],pos2[1])=='H') {
				if(pos2!=pos) {
				str+="Vous marchez sur la m�me case qu'un autre joueur, -2PV.\n";
				H.trap();
			}
			}
			
			
			//Plus de vie...
			if (H.getPV()<1) {
				str+="Vous etes mort\n GAME OVER\n";
				H.dead();
			}
			return str;
			}
		
	
	}